package main;


import org.jnetpcap.Pcap;
import org.jnetpcap.PcapHeader;
import org.jnetpcap.PcapIf;
import org.jnetpcap.nio.JBuffer;
import org.jnetpcap.nio.JMemory;
import org.jnetpcap.packet.JRegistry;
import org.jnetpcap.packet.Payload;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.packet.format.FormatUtils;
import org.jnetpcap.protocol.lan.Ethernet;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Tcp;

import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ArrayList<PcapIf> allDevs = new ArrayList<PcapIf>();
        StringBuilder errbuf = new StringBuilder();

        int r = Pcap.findAllDevs(allDevs, errbuf);
        if (r == Pcap.NOT_OK || allDevs.isEmpty()) {
            System.out.println("네트워크 장치를 찾을 수 없습니다. " + errbuf.toString());
            return;
        }
        System.out.println("네트워크 장비 탐색 성공");
        int i = 0;
        for (PcapIf dev : allDevs) {
            String description = (dev.getDescription() != null) ? dev.getDescription() : "장비에 대한 설명이 없습니다.";
            System.out.printf("[%d번]: %s [%s]\n", i++, dev.getName(), description);

        }
        PcapIf device = allDevs.get(0);
        System.out.printf("선택한 장치 : %s\n", (device.getDescription() != null ? device.getDescription() : device.getName()));

        int snaplen = 64 * 1024;
        int flags = Pcap.MODE_PROMISCUOUS;
        int timeout = 1;
        Pcap pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout, errbuf);

        if (pcap == null) {
            System.out.println("패킷 캡쳐를 위해 네트워크 장치를 여는데에 실패했습니다. 오류 : " + errbuf.toString());
            return;
        }

        Ethernet eth = new Ethernet();
        Ip4 ip = new Ip4();
        Tcp tcp = new Tcp();
        Payload payload = new Payload();
        PcapHeader header = new PcapHeader(JMemory.POINTER);
        JBuffer buf = new JBuffer(JMemory.POINTER);
        int id = JRegistry.mapDLTToId(pcap.datalink());

        while (true) {
            int result = pcap.nextEx(header, buf);

            if (result == Pcap.NEXT_EX_NOT_OK || result == Pcap.NEXT_EX_EOF) {
                System.out.println("패킷을 읽어오는 중 오류가 발생했거나 패킷 데이터가 없습니다.");
                break;
            }

            if (result == Pcap.NEXT_EX_OK) {
                PcapPacket packet = new PcapPacket(header, buf);
                packet.scan(id);

                System.out.printf("[ #%d ]\n", packet.getFrameNumber());
                if (packet.hasHeader(eth)) {
                    System.out.printf("출발지 MAC 주소 = %s\n도착지 MAC 주소 = %s\n",
                            FormatUtils.mac(eth.source()), FormatUtils.mac(eth.destination()));
                }
                if (packet.hasHeader(ip)) {
                    System.out.printf("출발지 IP 주소 = %s\n도착지 IP 주소 = %s\n",
                            FormatUtils.ip(ip.source()), FormatUtils.ip(ip.destination()));
                }
                if (packet.hasHeader(tcp)) {
                    System.out.printf("출발지 TCP 주소 = %d\n도착지 TCP 주소 = %d\n",
                            tcp.source(), tcp.destination());
                }
                if (packet.hasHeader(payload)) {
                    System.out.printf("페이로드 길이 = %d\n", payload.getLength());
                    System.out.print(payload.toHexdump());
                }
            }
        }
        pcap.close();
    }
}

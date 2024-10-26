package main;

import org.jnetpcap.*;

import java.util.ArrayList;

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

        try {
            for (PcapIf i : allDevs) {
                byte[] mac = i.getHardwareAddress();
                if (mac == null) {
                    continue;
                }
                System.out.printf("장치 주소 : %s\n 맥주소 : %s\n", i.getName(),asString(mac));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String asString(byte[] mac) {
        final StringBuilder buf = new StringBuilder();
        for(byte b : mac) {
            if (buf.length() != 0) {
                buf.append(':');
            }
            if (b>=0 && b<16){
                buf.append('0');
            }
            buf.append(Integer.toHexString((b<0)? b+256 : b).toUpperCase());
        }
        return buf.toString();
    }
}

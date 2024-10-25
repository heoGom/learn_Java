package main;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private PrintWriter writer;
    private Socket socket;

    public void start(){
        try {
            socket = new Socket("localhost", 12345);
            System.out.println("서버에 접속했습니다.");
            writer = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc =new Scanner(System.in);
            while(true){
                writer.println(sc.next());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

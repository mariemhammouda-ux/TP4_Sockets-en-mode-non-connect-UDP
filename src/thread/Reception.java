package thread;

import java.net.*;

public class Reception extends java.lang.Thread {

    DatagramSocket socket;

    public Reception(DatagramSocket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket paquet = new DatagramPacket(buffer, buffer.length);

                socket.receive(paquet);

                String message = new String(
                        paquet.getData(), 0, paquet.getLength()
                );

                System.out.println("\n" + message);
            }
        } catch (Exception e) {
            System.out.println("Reception terminee");
        }
    }
}
package com.example.udpserver;

import java.net.*;
public class UDPServer{
    public static void main(String argv[]) throws Exception
    {

        DatagramSocket serverSocket = new DatagramSocket(9090);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        while(true){
            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData,
                            receiveData.length);
            serverSocket.receive(receivePacket);

            System.out.println("클라이언트가 접속함.");
            String sentence = new String(
                    receivePacket.getData());

            InetAddress IPAddress =
                    receivePacket.getAddress();

            int port = receivePacket.getPort();
            String capitalizedSentence =
                    sentence.toUpperCase();

            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket =
                    new DatagramPacket (sendData,
                            sendData.length, IPAddress, port);

            serverSocket.send(sendPacket);

        }
    }
}
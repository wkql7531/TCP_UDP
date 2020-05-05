package com.example.tcp_udp_client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import android.util.Log;

public class UDPClient {
    private String msg;
    private String modifiedSentence2;

    public UDPClient(String _msg) {
        this.msg = _msg;
    }

    public String run() {

        try {
            String sentence = msg;
            Log.d("TAG" ,"msg:"+msg);
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("192.168.100.137");
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            sendData = sentence.getBytes();

            Log.d("TAG" ,"sentence:"+sentence);
            DatagramPacket sendPacket = new DatagramPacket(sendData,
                    sendData.length, IPAddress, 9090);

            Log.d("TAG" ,"sendPacket:"+sendPacket);
            clientSocket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveData,
                    receiveData.length);

            Log.d("TAG" ,"receivePacket:"+receivePacket);
            clientSocket.receive(receivePacket);

            modifiedSentence2 = new String(receivePacket.getData());

            Log.d("TAG" ,"modifiedSentence:"+modifiedSentence2);
            clientSocket.close();
        } catch (Exception e) {

        }
        return modifiedSentence2;

    }
}

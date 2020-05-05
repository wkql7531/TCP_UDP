package com.example.tcp_udp_client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    private String msg;
    private String modifiedSentence;

    public TCPClient(String _msg) {
        this.msg = _msg;
    }

    public String run() {
        try {
            String sentence = msg;
            Socket clientSocket = new Socket("192.168.100.137", 9090);

            DataOutputStream outToServer = new DataOutputStream(
                    clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            clientSocket.close();
        } catch (Exception e) {

        }
        return modifiedSentence;
    }
}

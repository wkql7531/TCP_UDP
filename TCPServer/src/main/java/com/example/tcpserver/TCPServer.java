package com.example.tcpserver;

import java.io.*;
import java.net.*;

public class TCPServer{
    public static void main(String argv[]) throws Exception
    {
        String clientSentence;

        String capitalizedSentence;

        ServerSocket welcomeSocket = new ServerSocket(9090);

        while(true){
            Socket connectionSocket = welcomeSocket.accept();

            System.out.println("클라이언트와 서버간 connection 성립");

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            System.out.println("클라이언트로부터 데이터 받음.");
            clientSentence = inFromClient.readLine();

            capitalizedSentence = clientSentence.toUpperCase() + '\n';

            outToClient.writeBytes(capitalizedSentence);

        }
    }
}
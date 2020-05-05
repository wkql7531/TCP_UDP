package com.example.tcp_udp_client;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private EditText et;
    private TextView tcpout;
    private TextView udpout;
    private Button tcp;
    private Button udp;
    private String modifiedSentence;
    private String modifiedSentence2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        et = (EditText) findViewById(R.id.et);
        tcp = (Button) findViewById(R.id.tcp);
        udp = (Button) findViewById(R.id.udp);
        tcpout = (TextView) findViewById(R.id.tcpout);
        udpout = (TextView) findViewById(R.id.udpout);

        tcp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                TCPClient tcpclient = new TCPClient(et.getText().toString());
                modifiedSentence = tcpclient.run();

                Toast t = Toast.makeText(getApplicationContext(),
                        modifiedSentence, Toast.LENGTH_LONG);
                t.show();

                tcpout.setText(tcpout.getText() + modifiedSentence);
            }

        });

        udp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                UDPClient udpclient = new UDPClient(et.getText().toString());
                modifiedSentence2 = udpclient.run();
                Log.d("TAG", "modifiedSentence2:" + modifiedSentence2);
                Toast t = Toast.makeText(getApplicationContext(),
                        modifiedSentence2, Toast.LENGTH_LONG);
                t.show();
                udpout.setText(udpout.getText() + modifiedSentence2);
            }

        });
    }


}

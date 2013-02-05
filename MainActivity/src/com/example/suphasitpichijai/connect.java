package com.example.suphasitpichijai;

import java.io.IOException;
import java.util.List;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import android.app.Activity;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.text.format.Formatter;
import android.view.View;
import android.view.View.OnClickListener;

public class connect extends Activity {
	public AQuery aq = new AQuery(this);
	private TextView textip,myIP;
	public static String IPadress;
	private ThreadCheckstart threadCheckstart;
	private Button btnmulti;
	private TextView connect;
	public static String Play_Status = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.connect_ip);
		TextView myIP = (TextView) findViewById(R.id.myIP);
		WifiManager wim= (WifiManager) getSystemService(WIFI_SERVICE);
		List<WifiConfiguration> l =  wim.getConfiguredNetworks(); 
		WifiConfiguration wc = l.get(0); 
		myIP.append(Formatter.formatIpAddress(wim.getConnectionInfo().getIpAddress()));
		Play_Status = "";
		textip = (TextView) findViewById(R.id.txtip);
		connect = (TextView) findViewById(R.id.textView3);
		btnmulti = (Button) findViewById(R.id.submit);
		threadCheckstart = new ThreadCheckstart(this);
		btnmulti.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Play_Status = "PLAY";
				// http://192.168.2.154:7777/?username=sdf
				IPadress = "http://" + textip.getText().toString()
						+ ":7777/?cmd=";
				threadCheckstart.start();
				

			}
		});

	}

	public void threadProcess() {

		aq.ajax(IPadress + "Play_Status", String.class,
				new AjaxCallback<String>() {

					@Override
					public void callback(String url, String html,
							AjaxStatus status) {
						if (html.trim().equals("PLAY")) {
							connect.setText("connect");
							threadCheckstart.requestStop();
							Intent k = new Intent(getApplicationContext(),
									multiactivity.class);
							startActivity(k);
							
						}else{
							connect.setText("not connect");
						}
					}
				});

	}
}

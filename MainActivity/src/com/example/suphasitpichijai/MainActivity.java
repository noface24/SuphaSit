package com.example.suphasitpichijai;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		View btnsingle = findViewById(R.id.button1);
		btnsingle.setOnClickListener(this);

		View btnconnect = findViewById(R.id.button2);
		btnconnect.setOnClickListener(this);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Intent i = new Intent(this, singleactivity.class);
			startActivity(i);
			break;

		case R.id.button2:
			try {
				HelloServer httpd = new HelloServer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Intent j = new Intent(this, connect.class);
			startActivity(j);
			break;

		}
	}

}

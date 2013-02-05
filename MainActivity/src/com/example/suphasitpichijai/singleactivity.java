package com.example.suphasitpichijai;

import java.util.Random;

import com.example.*;
import com.example.suphasitpichijai.R.id;

import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
//import android.app.AlertDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class singleactivity extends Activity {
	public static int countresult,c=19; //cจ.น.ข้อ-1
	private ThreadCountDown threadCountDown;
	private int count = 40;  // countdowntime
	public static int score = 0;
	private TextView txtResult, txtscore;
	private Button ch01, ch02, ch03;
	public final int[] images = new int[] { R.drawable.image1, R.drawable.image2,R.drawable.image3,
			R.drawable.image4,R.drawable.image5,R.drawable.image6,
			R.drawable.image7,R.drawable.image8,R.drawable.image9,
			R.drawable.image10,R.drawable.image11,R.drawable.image12,
			R.drawable.image13,R.drawable.image14,R.drawable.image15,
			R.drawable.image16,R.drawable.image17,R.drawable.image18,
			R.drawable.image19,R.drawable.image20
	}; //เพิ่มรูป

	public String[][] ch = {
			{ "กระต่ายตื่นเต้น", "กระต่ายตื่นตูม", "กระต่ายร่าเริง" },
			{ "นกสองหัว", "นกสองใจ", "นกสองปีก" }, 
			{ "ช้างหลับ", "ช้างตายทั้งตัวเอาใบบัวปิดไม่มิด", "ช้างล้ม" },
			{"ฝากปลาย่างไว้กับแมว","แมวเฝ้าปลาย่าง","แมวกินปลาย่าง"},
			{"หัวล้านได้หวี","หัวล้านใจดี","คุณลุงถือหวี"},
			{"กาคาบพริก","นกดำกินพริก","กาได้พริก"},
			{"ไก่เห็นตีนงู งูเห็นนมไก่","ไก่เล่นกับงู","ไก่ตาโต กับ งูหางยาว"},
			{"ตาบอดได้แว่น","ตาบอดถือแว่น","ตาบอดไม่ใส่แว่น"},
			{"จับปลาสองมือ","จับปลาหลายตัว","น้ำขึ้นให้จับปลา"},
			{"น้ำขึ้นให้รีบตัก","น้ำท่วมท่า","น้ำเต็มตลิ่ง"},
			{"หมาหวงก้าง","หมาได้ก้าง","หมาคาบก้าง"},
			{"ปิดทองหลังพระ","ปิดทองข้างหลัง","ปิดทองหลังภาพ"},
			{"ขี่ช้างจับตั๊กแตน","ขี่ช้างไล่ตั๊กแตน","ขี่ช้างชมธรรมชาติ"},
			{"เห็นกงจักรเป็นดอกบัว","มองกงจักร คิดถึงดอกบัว","มองกงจักรเห็นเป็นดอกบัว"},
			{"หนูตกถังข้าวสาร","หนูนั่งบนถังบนข้าวสาร","หนูกินข้าวสาร"},
			{"ไก่งามเพราะขน คนงามเพราะแต่ง","ไก่ได้พลอย","ไก่ส่องกระจกวิเศษ"},
			{"มือไม่พายเอาเท้าราน้ำ","มือไม่พายเอาเท้าพายช่วย","น้ำเชี่ยวอย่าเอาเท้าจุ่ม"},
			{"รักวัวให้ผูกรักลูกให้ตี","ตีลูกให้วัวกลัว","ตีลูกต่อหน้าวัว"},
			{"ง่ายเหมือนปอกกล้วยเข้าปาก","กินกล้วยเข้าปาก","เด็กหญิงกินกล้วย"},
			{"เพชร ตัด เพชร","เพชร ชน เพชร","เพชร กระทบ เพชร"}
			};
	// 1 ch[0][0]
	// 2 ch[1][0]
	private String[] ans = { "กระต่ายตื่นตูม", "นกสองหัว", "ช้างตายทั้งตัวเอาใบบัวปิดไม่มิด","ฝากปลาย่างไว้กับแมว",
			"หัวล้านได้หวี","กาคาบพริก","ไก่เห็นตีนงู งูเห็นนมไก่",
			"ตาบอดได้แว่น","จับปลาสองมือ","น้ำขึ้นให้รีบตัก","หมาหวงก้าง",
			"ปิดทองหลังพระ","ขี่ช้างจับตั๊กแตน","เห็นกงจักรเป็นดอกบัว","หนูตกถังข้าวสาร",
			"ไก่งามเพราะขน คนงามเพราะแต่ง","มือไม่พายเอาเท้าราน้ำ","รักวัวให้ผูกรักลูกให้ตี",
			"ง่ายเหมือนปอกกล้วยเข้าปาก","เพชร ตัด เพชร"
	};

	private int Choiec_num = 0;// 0 = ch 1; (int) (Math.random() * 3);
	private int num;
	private ImageView imageview;
	private TextView booLean;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single_exam);
		threadCountDown = new ThreadCountDown(count, this);
		threadCountDown.start();
		score = 0;
		txtscore = (TextView) findViewById(R.id.txtscore);
		txtResult = (TextView) findViewById(R.id.txtResult);
		booLean = (TextView) findViewById(R.id.booLean);
		imageview = (ImageView)findViewById(R.id.imageView1);

		ch01 = (Button) findViewById(R.id.choice1);
		ch02 = (Button) findViewById(R.id.choice2);
		ch03 = (Button) findViewById(R.id.choice3);

		num = (int) (Math.random() * 3); // random
		//Toast.makeText(getApplication(), String.valueOf(Choiec_num), Toast.LENGTH_LONG)
			//	.show();
		if (Choiec_num <= c) {
			
			imageview.setImageResource(images[Choiec_num]);
			if (num == 0) {
				ch01.setText(String.valueOf(ch[Choiec_num][0]));
				ch02.setText(String.valueOf(ch[Choiec_num][1]));
				ch03.setText(String.valueOf(ch[Choiec_num][2]));
			}
			if (num == 1) {
				ch03.setText(String.valueOf(ch[Choiec_num][0]));
				ch02.setText(String.valueOf(ch[Choiec_num][1]));
				ch01.setText(String.valueOf(ch[Choiec_num][2]));
			}
			if (num == 2) {
				ch01.setText(String.valueOf(ch[Choiec_num][0]));
				ch03.setText(String.valueOf(ch[Choiec_num][1]));
				ch02.setText(String.valueOf(ch[Choiec_num][2]));
			}
		} else { // dialog end

			AlertDialog.Builder alt_bld = new AlertDialog.Builder(
					singleactivity.this);
			alt_bld.setMessage("Score " + score + "\nNew Game?")
					.setCancelable(false)
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent intent = getIntent();
									finish();
									startActivity(intent);
								}
							})
					.setNegativeButton("No",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// Action for 'NO' Button
									Intent intent = new Intent(
											singleactivity.this,
											MainActivity.class);
									finish();
									startActivity(intent);
								}
							});
			AlertDialog alert = alt_bld.create();
			// Title for AlertDialog
			alert.setTitle("Game Over!!!");
			// Icon for AlertDialog
			alert.setIcon(R.drawable.ic_launcher);
			alert.show();
		}
		
		ch01.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if (Choiec_num <= c) {
					if (ch01.getText().toString()
							.equals(String.valueOf(ans[Choiec_num]))) {
					//	Toast.makeText(getApplication(), "T", Toast.LENGTH_LONG)
					//			.show();
						booLean.setText("ถูก");
						score++;
						// txtscore.setText(String.valueOf(score));
					} else{
					//	Toast.makeText(getApplication(), "F", Toast.LENGTH_LONG)
						//		.show();
						booLean.setText("ผิด");
					}
					Choiec_num++;
					num = (int) (Math.random() * 3);
				//	Toast.makeText(getApplication(), String.valueOf(Choiec_num),
					//		Toast.LENGTH_LONG).show();
					if (Choiec_num <= c) {
						imageview.setImageResource(images[Choiec_num]);
						if (num == 0) {
							ch01.setText(String.valueOf(ch[Choiec_num][0]));
							ch02.setText(String.valueOf(ch[Choiec_num][1]));
							ch03.setText(String.valueOf(ch[Choiec_num][2]));
						}
						if (num == 1) {
							ch03.setText(String.valueOf(ch[Choiec_num][0]));
							ch02.setText(String.valueOf(ch[Choiec_num][1]));
							ch01.setText(String.valueOf(ch[Choiec_num][2]));
						}
						if (num == 2) {
							ch01.setText(String.valueOf(ch[Choiec_num][0]));
							ch03.setText(String.valueOf(ch[Choiec_num][1]));
							ch02.setText(String.valueOf(ch[Choiec_num][2]));
						}
					}
				} else { // dialog end

					AlertDialog.Builder alt_bld = new AlertDialog.Builder(
							singleactivity.this);
					alt_bld.setMessage("Score " + score + "\nNew Game?")
							.setCancelable(false)
							.setPositiveButton("Yes",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog, int id) {
											Intent intent = getIntent();
											finish();
											startActivity(intent);
										}
									})
							.setNegativeButton("No",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog, int id) {
											// Action for 'NO' Button
											Intent intent = new Intent(
													singleactivity.this,
													MainActivity.class);
											finish();
											startActivity(intent);
										}
									});
					AlertDialog alert = alt_bld.create();
					// Title for AlertDialog
					alert.setTitle("Game Over!!!");
					// Icon for AlertDialog
					alert.setIcon(R.drawable.ic_launcher);
					alert.show();
				}
			}
		});
		ch02.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (Choiec_num <= c) {
					if (ch02.getText().toString()
							.equals(String.valueOf(ans[Choiec_num]))) {
					//	Toast.makeText(getApplication(), "T", Toast.LENGTH_LONG)
					//			.show();
						score++;
						booLean.setText("ถูก");
						// txtscore.setText(String.valueOf(score));
					}

					else{
				//		Toast.makeText(getApplication(), "F", Toast.LENGTH_LONG)
						//		.show();
						booLean.setText("ผิด");
						}
					Choiec_num++;
					num = (int) (Math.random() * 3);
			//	Toast.makeText(getApplication(), String.valueOf(Choiec_num),
				//			Toast.LENGTH_LONG).show();
					if (Choiec_num <= c) {
						imageview.setImageResource(images[Choiec_num]);
						if (num == 0) {
							ch01.setText(String.valueOf(ch[Choiec_num][0]));
							ch02.setText(String.valueOf(ch[Choiec_num][1]));
							ch03.setText(String.valueOf(ch[Choiec_num][2]));
						}
						if (num == 1) {
							ch03.setText(String.valueOf(ch[Choiec_num][0]));
							ch02.setText(String.valueOf(ch[Choiec_num][1]));
							ch01.setText(String.valueOf(ch[Choiec_num][2]));
						}
						if (num == 2) {
							ch01.setText(String.valueOf(ch[Choiec_num][0]));
							ch03.setText(String.valueOf(ch[Choiec_num][1]));
							ch02.setText(String.valueOf(ch[Choiec_num][2]));
						}
					}
				} else { // dialog end

					AlertDialog.Builder alt_bld = new AlertDialog.Builder(
							singleactivity.this);
					alt_bld.setMessage("Score " + score + "\nNew Game?")
							.setCancelable(false)
							.setPositiveButton("Yes",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog, int id) {
											Intent intent = getIntent();
											finish();
											startActivity(intent);
										}
									})
							.setNegativeButton("No",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog, int id) {
											// Action for 'NO' Button
											Intent intent = new Intent(
													singleactivity.this,
													MainActivity.class);
											finish();
											startActivity(intent);
										}
									});
					AlertDialog alert = alt_bld.create();
					// Title for AlertDialog
					alert.setTitle("Game Over!!!");
					// Icon for AlertDialog
					alert.setIcon(R.drawable.ic_launcher);
					alert.show();
				}
			}
		});
		ch03.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (Choiec_num <= c) {
					if (ch03.getText().toString()
							.equals(String.valueOf(ans[Choiec_num]))) {
					//	Toast.makeText(getApplication(), "T", Toast.LENGTH_LONG)
					//		.show();
						score++;
						booLean.setText("ถูก");
						// txtscore.setText(String.valueOf(score));
					} else{
					//	Toast.makeText(getApplication(), "F", Toast.LENGTH_LONG)
					//			.show();
						booLean.setText("ผิด");
					}
					Choiec_num++;
					num = (int) (Math.random() * 3);
				//	Toast.makeText(getApplication(), String.valueOf(Choiec_num),
					//		Toast.LENGTH_LONG).show();
					if (Choiec_num <= c) {
						imageview.setImageResource(images[Choiec_num]);
						if (num == 0) {
							ch01.setText(String.valueOf(ch[Choiec_num][0]));
							ch02.setText(String.valueOf(ch[Choiec_num][1]));
							ch03.setText(String.valueOf(ch[Choiec_num][2]));
						}
						if (num == 1) {
							ch03.setText(String.valueOf(ch[Choiec_num][0]));
							ch02.setText(String.valueOf(ch[Choiec_num][1]));
							ch01.setText(String.valueOf(ch[Choiec_num][2]));
						}
						if (num == 2) {
							ch01.setText(String.valueOf(ch[Choiec_num][0]));
							ch03.setText(String.valueOf(ch[Choiec_num][1]));
							ch02.setText(String.valueOf(ch[Choiec_num][2]));
						}
					}
				} else { // dialog end

					AlertDialog.Builder alt_bld = new AlertDialog.Builder(
							singleactivity.this);
					alt_bld.setMessage("Score " + score + "\nNew Game?")
							.setCancelable(false)
							.setPositiveButton("Yes",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog, int id) {
											Intent intent = getIntent();
											finish();
											startActivity(intent);
										}
									})
							.setNegativeButton("No",
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog, int id) {
											// Action for 'NO' Button
											Intent intent = new Intent(
													singleactivity.this,
													MainActivity.class);
											finish();
											startActivity(intent);
										}
									});
					AlertDialog alert = alt_bld.create();
					// Title for AlertDialog
					alert.setTitle("Game Over!!!");
					// Icon for AlertDialog
					alert.setIcon(R.drawable.ic_launcher);
					alert.show();
				}
			}
		});

	}

	public void threadProcess(int count) {
		if(count%2==0)
			booLean.setText("");
		txtscore.setText("Score : " + String.valueOf(score));
		this.countresult = count;
		if (count < 0) {
			threadCountDown.requestStop();
			// dialog
			AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
			alt_bld.setMessage("Score " + score + "\nNew Game?")
					.setCancelable(false)
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent intent = getIntent();
									finish();
									startActivity(intent);
								}
							})
					.setNegativeButton("No",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// Action for 'NO' Button
									Intent intent = new Intent(
											singleactivity.this,
											MainActivity.class);
									finish();
									startActivity(intent);
								}
							});
			AlertDialog alert = alt_bld.create();
			// Title for AlertDialog
			alert.setTitle("Game Over!!!");
			// Icon for AlertDialog
			alert.setIcon(R.drawable.ic_launcher);
			alert.show();

		} else {
			txtResult.setText(String.valueOf(count));
		}
	}

}

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
	public static int countresult,c=19; //c�.�.���-1
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
	}; //�����ٻ

	public String[][] ch = {
			{ "��е��µ����", "��е��µ�蹵��", "��е��������ԧ" },
			{ "���ͧ���", "���ͧ�", "���ͧ�ա" }, 
			{ "��ҧ��Ѻ", "��ҧ��·�駵�����㺺�ǻԴ����Դ", "��ҧ���" },
			{"�ҡ�����ҧ���Ѻ���","�����һ����ҧ","��ǡԹ�����ҧ"},
			{"�����ҹ�����","�����ҹ㨴�","�س�ا������"},
			{"�ҤҺ��ԡ","���ӡԹ��ԡ","�����ԡ"},
			{"����繵չ�� ����繹���","����蹡Ѻ��","���� �Ѻ ���ҧ���"},
			{"�Һʹ�����","�Һʹ������","�Һʹ���������"},
			{"�Ѻ����ͧ���","�Ѻ������µ��","��Ӣ�����Ѻ���"},
			{"��Ӣ������պ�ѡ","��ӷ������","����������"},
			{"����ǧ��ҧ","������ҧ","��ҤҺ��ҧ"},
			{"�Դ�ͧ��ѧ���","�Դ�ͧ��ҧ��ѧ","�Դ�ͧ��ѧ�Ҿ"},
			{"����ҧ�Ѻ���ᵹ","����ҧ�����ᵹ","����ҧ�������ҵ�"},
			{"��繡��ѡ��繴͡���","�ͧ���ѡ� �Դ�֧�͡���","�ͧ���ѡ�����繴͡���"},
			{"˹ٵ��ѧ�������","˹ٹ�觺��ѧ���������","˹١Թ�������"},
			{"�������Т� �����������","�������","����ͧ��Ш������"},
			{"���������������ҹ��","�������������Ҿ�ª���","�����������������Ҩ���"},
			{"�ѡ������١�ѡ�١����","���١�����ǡ���","���١���˹�����"},
			{"��������͹�͡�������һҡ","�Թ�������һҡ","��˭ԧ�Թ�����"},
			{"ྪ� �Ѵ ྪ�","ྪ� �� ྪ�","ྪ� ��з� ྪ�"}
			};
	// 1 ch[0][0]
	// 2 ch[1][0]
	private String[] ans = { "��е��µ�蹵��", "���ͧ���", "��ҧ��·�駵�����㺺�ǻԴ����Դ","�ҡ�����ҧ���Ѻ���",
			"�����ҹ�����","�ҤҺ��ԡ","����繵չ�� ����繹���",
			"�Һʹ�����","�Ѻ����ͧ���","��Ӣ������պ�ѡ","����ǧ��ҧ",
			"�Դ�ͧ��ѧ���","����ҧ�Ѻ���ᵹ","��繡��ѡ��繴͡���","˹ٵ��ѧ�������",
			"�������Т� �����������","���������������ҹ��","�ѡ������١�ѡ�١����",
			"��������͹�͡�������һҡ","ྪ� �Ѵ ྪ�"
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
						booLean.setText("�١");
						score++;
						// txtscore.setText(String.valueOf(score));
					} else{
					//	Toast.makeText(getApplication(), "F", Toast.LENGTH_LONG)
						//		.show();
						booLean.setText("�Դ");
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
						booLean.setText("�١");
						// txtscore.setText(String.valueOf(score));
					}

					else{
				//		Toast.makeText(getApplication(), "F", Toast.LENGTH_LONG)
						//		.show();
						booLean.setText("�Դ");
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
						booLean.setText("�١");
						// txtscore.setText(String.valueOf(score));
					} else{
					//	Toast.makeText(getApplication(), "F", Toast.LENGTH_LONG)
					//			.show();
						booLean.setText("�Դ");
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

package com.example.suphasitpichijai;
 
import android.util.Log;
 
public class ThreadCheckstart extends Thread {
 
    public static int Resultcount;
    private Boolean stop=false;
    private connect CDA;
 
    //�Ѻ��� count �ҡ CountDownActivity �����ҹѺ�����ѧ
    //�Ѻ Object CountDownActivity �������¡��ҹ runOnUiThread 㹡�� Update View
    public ThreadCheckstart(connect CDA){
        this.CDA = CDA;
    }

	//function �������Ѻ��ͧ�͡����ش��÷ӧҹ�ͧ Thread
    public void requestStop() {
        this.stop = true;
    }
 
  //function ��ǹ��÷ӧҹ�ͧ Thread
    @Override
    public void run() {
        // TODO Auto-generated method stub
 
        while(true) {
                    try {
                        sleep((long)1000); //��ش��÷ӧҹ 1 �Թҷ�
                    }
                    catch(InterruptedException e) {
                        Log.e("log_thread", "Error Thread : " + e.toString());
                    }
 
                    if(this.stop) //����ա����ͧ�͡����ش���� ��騺��÷ӧҹ�ͧ Thread
                        return;

 
                    //���¡�� function threadProcess �ͧ threadProcess
                    this.CDA.runOnUiThread(new Runnable(){
                        public void run(){
                            CDA.threadProcess();
                            
                          }
                    });
        }
    }
}
package com.example.suphasitpichijai;
 
import android.util.Log;
 
public class ThreadCheckstart extends Thread {
 
    public static int Resultcount;
    private Boolean stop=false;
    private connect CDA;
 
    //รับค่า count จาก CountDownActivity เพื่อมานับถอยหลัง
    //รับ Object CountDownActivity เพื่อเรียกใช้งาน runOnUiThread ในการ Update View
    public ThreadCheckstart(connect CDA){
        this.CDA = CDA;
    }

	//function ไว้สำหรับร้องขอการหยุดการทำงานของ Thread
    public void requestStop() {
        this.stop = true;
    }
 
  //function ส่วนการทำงานของ Thread
    @Override
    public void run() {
        // TODO Auto-generated method stub
 
        while(true) {
                    try {
                        sleep((long)1000); //หยุดการทำงาน 1 วินาที
                    }
                    catch(InterruptedException e) {
                        Log.e("log_thread", "Error Thread : " + e.toString());
                    }
 
                    if(this.stop) //ถ้ามีการร้องขอการหยุดแล้ว ให้จบการทำงานของ Thread
                        return;

 
                    //เรียกใช้ function threadProcess ของ threadProcess
                    this.CDA.runOnUiThread(new Runnable(){
                        public void run(){
                            CDA.threadProcess();
                            
                          }
                    });
        }
    }
}
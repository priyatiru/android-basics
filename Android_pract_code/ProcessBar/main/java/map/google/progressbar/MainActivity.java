package map.google.progressbar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar prb;
    int progress=0;
    Handler h=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prb=(ProgressBar)findViewById(R.id.progressBar1);
        new Thread(new Runnable() {                          //anonymous class of thread

            @Override
            public void run() {
                // TODO Auto-generated method stub
                for(int i=0;i<5;i++)
                {
                    progress+=20;

                    h.post(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            prb.setProgress(progress);
                            if(progress==prb.getMax())
                            {
                                //prb.setVisibility(4);     //ID: 4-public 0-static 8-final
                                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                                startActivity(i);
                            }
                        }
                    });

                    try{
                        Thread.sleep(2000);

                    }
                    catch(InterruptedException e)
                    {


                    }
                }
            }
        }).start();                  //for anonymous class of Thred


    }


}


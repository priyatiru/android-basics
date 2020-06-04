package map.google.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SeekBar seek_baar;
    private TextView text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekbaar();
    }
    public void seekbaar()
    {
        seek_baar=(SeekBar)findViewById(R.id.seekBar1);
        text_view=(TextView)findViewById(R.id.textView2);
        text_view.setText("covered:"+seek_baar.getProgress() +"/"+seek_baar.getMax());

        seek_baar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress_value;
            @Override
            public void onStopTrackingTouch(SeekBar ekB) {
                // TODO Auto-generated method stub
                text_view.setText("covered:"+ progress_value+"/"+seek_baar.getMax());
                Toast.makeText(MainActivity.this, "seek bar is Stop Trackg", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

                Toast.makeText(MainActivity.this, "seek bar is Start Tracking", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                progress_value=progress;
                text_view.setText("covered:"+progress+"/"+seek_baar.getMax());
                Toast.makeText(MainActivity.this, "seek bar is in progress", Toast.LENGTH_LONG).show();
            }
        });
    }

}

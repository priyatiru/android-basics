package map.google.sendsms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button sendBtn;
    EditText txtphoneNo;
    EditText txtMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sendBtn = (Button) findViewById(R.id.btnSendSMS);
        txtphoneNo = (EditText) findViewById(R.id.editText);
        txtMessage = (EditText) findViewById(R.id.editText2);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }
    protected void sendSMSMessage() {
        Log.i("Send SMS", "");
        //String phoneNo = txtphoneNo.getText().toString();
        //String message = txtMessage.getText().toString();

        try {

            //SmsManager smsManager = SmsManager.getDefault();
            //smsManager.sendTextMessage(phoneNo, null, message, null, null);

            //sendTextMessage(String destinationAddress, String scAddress, String text,
            //PendingIntent sentIntent, PendingIntent deliveryIntent);

            //scAddress : service center address
            //sendIntent: if not NULL this PendingIntent is broadcast when the message is
            //successfully sent, or failed.
            //The result code will be Activity.RESULT_OK for success, or one of these errors:

            //deliveryIntent : if not NULL this PendingIntent is broadcast when the message is
            //delivered to the recipient.



         //void android.telephony.SmsManager.sendTextMessage
         //(String destinationAddress, String scAddress, String text, PendingIntent sentIntent, PendingIntent deliveryIntent)*//*


            Intent sendIntent = new Intent(Intent.ACTION_VIEW);

            sendIntent.putExtra("sms_body", "default content");

            sendIntent.setType("vnd.android-dir/mms-sms");
           startActivity(sendIntent);

            Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
        }

        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}


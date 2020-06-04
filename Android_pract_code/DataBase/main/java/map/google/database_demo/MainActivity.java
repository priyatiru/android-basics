package map.google.database_demo;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button insert,show,delete;
    //TextView tv1,tv2;
    EditText et1,et2;
    DBadapter db;
    //String st;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert=(Button)findViewById(R.id.button1);
        show=(Button)findViewById(R.id.button2);
        delete=(Button)findViewById(R.id.button3);
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);

        db=new DBadapter(this);
        insert.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                db.insert(et1.getText().toString(), et2.getText().toString());

                Toast.makeText(getBaseContext(), "Data Inserted ", Toast.LENGTH_LONG).show();

            }
        });
        show.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                showDataOnToast();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                db.clearData();

            }
        });
    }
    protected void showDataOnToast() {
        // TODO Auto-generated method stub
        Cursor c=db.getInsertedData();
        if(c.moveToFirst())
        {
            do
            {
                Toast.makeText(this, "id: "+c.getString(0)+"\n"+
                        "Name: "+c.getString(1)+"\n"+
                        "EmailId: "+c.getString(2), Toast.LENGTH_LONG).show();
            }while(c.moveToNext());
        }
        db.close();
    }

}



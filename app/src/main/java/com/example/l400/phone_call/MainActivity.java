package com.example.l400.phone_call;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button callbtn = (Button)findViewById(R.id.callbtn);
        final EditText editText = (EditText)findViewById(R.id.editText);
        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(Intent.ACTION_CALL);
               String number = editText.getText().toString();
//                intent.setData(Uri.parse(number));
//                startActivity(intent);
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent.setData(Uri.parse("tel:"+ number));
                try { startActivity(phoneIntent);
                    finish();

                }
                catch (android.content.ActivityNotFoundException ex)
                { Toast.makeText(MainActivity.this, "Call faild, please try again later.", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}

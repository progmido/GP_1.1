package io.google.gp_11;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int type;
        EditText username = (EditText) findViewById(R.id.usr_name);
        String inputname = username.getText().toString();
        EditText userpass = (EditText) findViewById(R.id.user_password);
        String inputPass = userpass.getText().toString();
        //give you input name and input pass and you give me the type id
        //assume you retrieve me 1 it means this is admin
        type = 1;
        Button sign_in = (Button) findViewById(R.id.sing_in);
        final int finalType = type;
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (finalType == 1) {
                    Intent i_to_admin = new Intent(MainActivity.this, AdminActivity.class);
                    startActivity(i_to_admin);
                }
            }
        });
        TextView sign_up = (TextView) findViewById(R.id.sin_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });


    }
}

package io.google.gp_11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import models.ToEgyptAPI;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends Activity {

    private Retrofit retrofit;
    private String Fullname;
    private String Username;
    private String pass;
    private String Email;
    private EditText fname;
    private EditText mail;
    private EditText username;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fname = (EditText) findViewById(R.id.fname);
        mail = (EditText) findViewById(R.id.mail);
        username = (EditText) findViewById(R.id.usrusr);
        password = (EditText) findViewById(R.id.pswrd);
        retrofit = new Retrofit.Builder()
                .baseUrl("http://2egyptwebservice.somee.com")
                .build();

        setContentView(R.layout.activity_register);
//        TextView sign_in = (TextView) findViewById(R.id.sin_up);
//        sign_in.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                try {
////                    Fullname=fname.getText().toString();
////                    Email=mail.getText().toString();
////                    pass=password.getText().toString();
////                    Username=username.getText().toString();
////                    retrofit = new Retrofit.Builder()
////                            .baseUrl("http://2egyptwebservice.somee.com")
////                            .build();
////                    ToEgyptAPI toEgyptAPI = retrofit.create(ToEgyptAPI.class);
////                    toEgyptAPI.adduser(Fullname,Username,Email,pass,20,32476,2,false,23,"rgfgfdgsdg").enqueue(new Callback<ResponseBody>() {
////                        @Override
////                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
////
////                            Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();
////                            Intent i_to_admin = new Intent(RegisterActivity.this, MainActivity.class);
////                            startActivity(i_to_admin);
////
////
////                        }
////
////                        @Override
////                        public void onFailure(Call<ResponseBody> call, Throwable t) {
////                            Toast.makeText(RegisterActivity.this, "Error Check connection", Toast.LENGTH_SHORT).show();
////
////                        }
////                    });
////                } catch (Exception ex) {
////
////
////                }
//
//            }
//        });
    }

    public void register(View view) {

//        Fullname=fname.getText().toString();
//        Email=mail.getText().toString();
//        pass=password.getText().toString();
//        Username=username.getText().toString();
        try {


            ToEgyptAPI toEgyptAPI = retrofit.create(ToEgyptAPI.class);
            toEgyptAPI.adduser("karim Ghonim", "kimo", "m07ammedaef.210@gmail", "123", 20, 32476, 2, false, 23, "rgfgfdgsdg").enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                    Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                    Intent i_to_admin = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(i_to_admin);


                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "Error Check connection", Toast.LENGTH_SHORT).show();

                }
            });
        } catch (Exception ex) {


        }


    }
}

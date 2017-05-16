package io.google.gp_11;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminUpdateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_user);

        EditText fname = (EditText) findViewById(R.id.userFullName);
        fname.setText("Ahmed Abuelhassen");
        EditText Age = (EditText) findViewById(R.id.userAge);
        Age.setText("25");
        EditText phone = (EditText) findViewById(R.id.userNumberPhone);
        phone.setText("01146000129");
        EditText country = (EditText) findViewById(R.id.userCountry);
        country.setText("USA");
        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(AdminUpdateUser.this);
                alertDialog.setTitle("Confirm Reset ..");
                alertDialog.setMessage("Are you sure you want reset password for this user?");
                alertDialog.setIcon(R.drawable.reset);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                Toast.makeText(AdminUpdateUser.this, "You clicked on YES", Toast.LENGTH_SHORT).show();
                            }
                        });
                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog

                                dialog.cancel();
                            }
                        });

                // Showing Alert Message
                alertDialog.show();
            }
        });
        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(AdminUpdateUser.this);
                alertDialog.setTitle("Confirm Delete ..");
                alertDialog.setMessage("Are you sure you want delete this user?");
                alertDialog.setIcon(R.drawable.delete);
                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog
                                Toast.makeText(AdminUpdateUser.this, "You clicked on YES", Toast.LENGTH_SHORT).show();
                            }
                        });
                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Write your code here to execute after dialog

                                dialog.cancel();
                            }
                        });

                // Showing Alert Message
                alertDialog.show();
            }
        });


    }
}

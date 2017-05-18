package io.google.gp_11;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class AdminUpdatePlace extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_place);


        EditText place_name = (EditText) findViewById(R.id.place_Name);
        Spinner category = (Spinner) findViewById(R.id.place_category);
        Spinner governorate = (Spinner) findViewById(R.id.place_Governate);
        EditText Description = (EditText) findViewById(R.id.place_description);
        LinearLayout img = (LinearLayout) findViewById(R.id.placeimagetoview);
        Button Update = (Button) findViewById(R.id.updatePlace);
        Button delete = (Button) findViewById(R.id.deletePlace);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.nav_actionbar);

        category.setOnItemSelectedListener(this);
        governorate.setOnItemSelectedListener(this);


        List<String> categories = new ArrayList<String>();

        categories.add("relgious");
        categories.add("ancient");

        List<String> governates = new ArrayList<String>();
        governates.add("Cairo");
        governates.add("Giza");
        governates.add("sinai");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<String> Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, governates);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(dataAdapter);
        governorate.setAdapter(Adapter);


        Intent i = getIntent();
        mode = i.getExtras().getInt("Mode");

        if (mode == 1) {

            String myString = "ancient"; //the value you want the position for
            ArrayAdapter myAdap = (ArrayAdapter) category.getAdapter(); //cast to an ArrayAdapter
            int spinnerPosition = myAdap.getPosition(myString);
            //set the default according to value
            category.setSelection(spinnerPosition);


            img.setBackgroundResource(R.drawable.egyptianmuseum);
            mToolbar.setTitle("Update Place");
            Update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(AdminUpdatePlace.this, "Place updated", Toast.LENGTH_SHORT).show();
                }
            });
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(AdminUpdatePlace.this);
                    alertDialog.setTitle("Confirm Delete ..");
                    alertDialog.setMessage("Are you sure you want delete this Place?");
                    alertDialog.setIcon(R.drawable.delete);
                    alertDialog.setPositiveButton("YES",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Write your code here to execute after dialog
                                    Toast.makeText(AdminUpdatePlace.this, "You clicked on YES", Toast.LENGTH_SHORT).show();
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

        } else {
            if (mode == 2) {
                mToolbar.setTitle("Create Place");

                Update.setVisibility(View.GONE);
                delete.setText("Create");
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AdminUpdatePlace.this, "Place created", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Spinner spin = (Spinner) parent;
        if (spin.getId() == R.id.place_category) {
            String item = parent.getItemAtPosition(position).toString();
        } else {
            if (spin.getId() == R.id.place_Governate) {
                String item = parent.getItemAtPosition(position).toString();
            }
        }

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

}

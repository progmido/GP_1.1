package io.google.gp_11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class AdminAddGuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_guide);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.nav_actionbar);
        mToolbar.setTitle("Add Guide");

    }
}

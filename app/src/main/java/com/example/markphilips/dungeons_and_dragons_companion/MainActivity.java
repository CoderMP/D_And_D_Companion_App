package com.example.markphilips.dungeons_and_dragons_companion;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //region Private Field Variables
    private EditText edtCharName;
    private EditText edtArmourRating;
    private EditText edtCurrHealth;
    private EditText edtMaxHealth;
    private EditText edtExperience;
    private EditText edtInitiative;
    private EditText edtSpeed;
    private EditText edtHitDice;

    private Spinner spnCharBackground;
    private Spinner spnCharClass;
    private Spinner spnCharRace;
    private Spinner spnCharAlignment;

    private Button btnDsSuccessIncrement;
    private Button btnDsSuccessDecrement;
    private TextView txtDeathSaveSuccessTotal;
    private Button btnDsFailureIncrement;
    private Button btnDsFailureDecrement;
    private TextView txtDeathSaveFailureTotal;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void setupViews(){
        edtCharName = findViewById(R.id.edt_char_name);
        edtArmourRating = findViewById(R.id.edt_armour_rating);
        edtCurrHealth = findViewById(R.id.edt_curr_health);
        edtMaxHealth = findViewById(R.id.edt_max_health);
        edtExperience = findViewById(R.id.edt_xp);
        edtInitiative = findViewById(R.id.edt_initiative);
        edtSpeed = findViewById(R.id.edt_speed);
        edtHitDice = findViewById(R.id.edt_hit_dice);

        spnCharAlignment = findViewById(R.id.spn_alignment);
        spnCharBackground = findViewById(R.id.spn_background);
        spnCharRace = findViewById(R.id.spn_race);
        spnCharClass = findViewById(R.id.spn_class);

        btnDsSuccessIncrement = findViewById(R.id.btn_success_increase);
        btnDsSuccessDecrement = findViewById(R.id.btn_success_decrease);
        btnDsFailureIncrement = findViewById(R.id.btn_failure_increase);
        btnDsFailureDecrement = findViewById(R.id.btn_failure_decrease);

        txtDeathSaveSuccessTotal = findViewById(R.id.txt_death_save_success_total);
        txtDeathSaveFailureTotal = findViewById(R.id.txt_death_save_failure_total);

        btnDsSuccessIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                successIncrementDecrement(v);
            }
        });
        btnDsSuccessDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                successIncrementDecrement(v);
            }
        });
    }


    /**
     * Private method that is responsible for incrementing or decrementing the Death Save Success
     * total.
     *
     * @param view The increment/decrement button that was tapped
     */
    private void successIncrementDecrement(View view){
        //Retrieve the ID of the View that was passed to the method
        int viewID = view.getId();

        if (viewID == btnDsSuccessIncrement.getId()){
            //TODO: Implement code to increment & update total
        }
        else if (viewID == btnDsSuccessDecrement.getId()){
            //TODO: Implement code to decrement & update total
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

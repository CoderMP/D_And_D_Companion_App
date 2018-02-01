package com.example.markphilips.dungeons_and_dragons_companion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    private Intent navIntent;
    //endregion

    //region Creation Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //TODO: Open SQLiteDatabases for Character, Weapons, Armour, & Spells & load in the appropriate data

        //Call the setupViews method
        setupViews();
    }


    /**
     * Method that is responsible for setting up the necessary Views for the MainActivity
     *
     * @author Mark Philips
     * @since 01/30/2018
     * @version 1
     */
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

        //region Button OnClickListeners
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
        btnDsFailureIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                successIncrementDecrement(v);
            }
        });
        btnDsFailureDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                successIncrementDecrement(v);
            }
        });
        //endregion

        //region Spinner OnItemSelectedListeners
        spnCharRace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnCharClass.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO:Implement Methods
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnCharBackground.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO:Implement Methods
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spnCharAlignment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //TODO:Implement Methods
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //endregion
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    /**
     * Method that is responsible for inflating the ActionBar from the according XML layout file
     *
     * @param menu The ActionBar Object that needs to be inflated
     * @return
     *
     * @author Mark Philips
     * @since 01/02/2018
     * @version 1
     */
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
    //endregion

    //region Navigation Method(s)
    /**
     * Method that is responsible for handling inter-Activity navigation based on the tapped menu
     * items in the Navigation Drawer
     *
     * @param item The MenuItem that was tapped
     * @return
     *
     * @author Mark Philips
     * @since 01/02/2018
     * @version 1
     */
    @SuppressWarnings("StatementWithEmptyBody") //TODO: Remove this statement once navigation cases are complete
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //Get the ID of the MenuItem that was tapped in the Navigation Drawer
        int id = item.getItemId();

        //Initialize the navIntent with the appropriate Activity.class naming and Context, then navigate
        if (id == R.id.nav_stats) {
            navIntent = new Intent(getApplicationContext(), StatsActivity.class);
            startActivity(navIntent);
        }
        else if (id == R.id.nav_bio) {
            navIntent = new Intent(getApplicationContext(), BioActivity.class);
            startActivity(navIntent);
        }
        else if (id == R.id.nav_spells) {
            navIntent = new Intent(getApplicationContext(), SpellsActivity.class);
            startActivity(navIntent);
        }
        else if (id == R.id.nav_inventory) {
            navIntent = new Intent(getApplicationContext(), InventoryActivity.class);
            startActivity(navIntent);
        }
        else if (id == R.id.nav_info_races) {
            //TODO: Implement InfoRacesActivity navigation case
            //navIntent = new Intent(getApplicationContext(), InfoRacesActivity.class);
            //startActivity(navIntent);
        }
        else if (id == R.id.nav_info_classes) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    //endregion

    //region Methods
    /**
     * Private method that is responsible for incrementing or decrementing the Death Save Success
     * total.
     *
     * @param view The increment/decrement button that was tapped
     *
     * @author Mark Philips
     * @since 01/25/2018
     * @version 1
     */
    private void successIncrementDecrement(View view){
        //Retrieve the ID of the View that was passed to the method
        int viewID = view.getId();

        //Determine which button was tapped and manipulate the data accordingly
        if (viewID == btnDsSuccessIncrement.getId()){
            //TODO: Implement code to increment & update total
            Toast.makeText(this, "Success Incr Button Tapped", Toast.LENGTH_SHORT).show();

        }
        else if (viewID == btnDsSuccessDecrement.getId()){
            //TODO: Implement code to decrement & update total
            Toast.makeText(this, "Success Decr Button Tapped", Toast.LENGTH_SHORT).show();
        }
        else if (viewID == btnDsFailureIncrement.getId()){
            //TODO: Implement code to increment & update total
            Toast.makeText(this, "Failure Incr Button Tapped", Toast.LENGTH_SHORT).show();
        }
        else if (viewID == btnDsSuccessDecrement.getId()){
            //TODO: Implement code to decrement & update total
            Toast.makeText(this, "Failure Decr Button Tapped", Toast.LENGTH_SHORT).show();
        }
    }
    //endregion
}

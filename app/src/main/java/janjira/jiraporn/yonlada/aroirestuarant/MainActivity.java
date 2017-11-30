package janjira.jiraporn.yonlada.aroirestuarant;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import janjira.jiraporn.yonlada.aroirestuarant.fragment.MainFragment;
import janjira.jiraporn.yonlada.aroirestuarant.utility.MyConstanct;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    private TextView homeTextView, singleFoodTextView, sopeTextView, burnTextView;
    private int indexAnInt = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//       Add Fragment to Activity
        addFragement(savedInstanceState);

//        Cteate Toolbar
        cteateToolbar();

//        TextView Controller
        textViewController();

    } //Main Method

    private void textViewController() {

//        Initial View
        homeTextView = findViewById(R.id.txtHome);
        singleFoodTextView = findViewById(R.id.txtSingleFood);
        sopeTextView = findViewById(R.id.txtSoup);
        burnTextView = findViewById(R.id.txtburn);

//        Show View
        MyConstanct myConstanct = new MyConstanct();
        String[] categoryStrings = myConstanct.getCategoryStrings();
        homeTextView.setText(categoryStrings[0]);
        singleFoodTextView.setText(categoryStrings[1]);
        sopeTextView.setText(categoryStrings[2]);
        burnTextView.setText(categoryStrings[3]);

//        Listener
        homeTextView.setOnClickListener(MainActivity.this);
        singleFoodTextView.setOnClickListener(MainActivity.this);
        sopeTextView.setOnClickListener(MainActivity.this);
        burnTextView.setOnClickListener(MainActivity.this);

    }

    private void addFragement(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentMain, MainFragment.mainInstance(indexAnInt))
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private void cteateToolbar() {
        toolbar = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this,
                drawerLayout, R.string.open, R.string.close);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.txtHome:
                indexAnInt = 0;
                break;
            case R.id.txtSingleFood:
                indexAnInt = 1;
                break;
            case R.id.txtSoup:
                indexAnInt = 2;
                break;
            case R.id.txtburn:
                indexAnInt = 3;
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contentFragmentMain, MainFragment.mainInstance(indexAnInt)).commit();
        Log.d("30novV1", "You Choose index ==> " + indexAnInt);
        drawerLayout.closeDrawers();
    }
} // Main Class

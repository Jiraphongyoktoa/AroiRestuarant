package janjira.jiraporn.yonlada.aroirestuarant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import janjira.jiraporn.yonlada.aroirestuarant.fragment.DetailFragment;
import janjira.jiraporn.yonlada.aroirestuarant.fragment.RegisterFragment;

public class SerciveOrderActivity extends AppCompatActivity {

    private String nameFoodString, categoryString, imagePathString, priceString, detailString;

//    Explicit

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sercive_order);

//        Get Value Frome Intent
        nameFoodString = getIntent().getStringExtra("NameFood");
        categoryString = getIntent().getStringExtra("Category");
        imagePathString = getIntent().getStringExtra("ImagePath");
        priceString = getIntent().getStringExtra("Price");
        detailString = getIntent().getStringExtra("Detail");

//        Create Toolbar
        createToolbar();

//        Add Fragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenfragmentService, DetailFragment.detailInstance(
                            nameFoodString, categoryString,
                            imagePathString, priceString, detailString))
                    .addToBackStack(null)
                    .commit();
        }

    }   // Main Method

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_service, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.itemMenuNewRegister) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.contenfragmentService, new RegisterFragment())
                    .addToBackStack(null)
                    .commit();
        }

        return super.onOptionsItemSelected(item);
    }

    private void createToolbar() {

        Toolbar toolbar = findViewById(R.id.toolbarService);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.service));

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}   // Main Class














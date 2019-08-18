package flickagram.com.flickagram.modules.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import flickagram.com.flickagram.R;
import flickagram.com.flickagram.base.BaseActivity;
import flickagram.com.flickagram.modules.adapter.RecyclerAdapter;
import flickagram.com.flickagram.modules.viewmodel.RecyclerViewModel;

public class RecyclerActivity extends BaseActivity {
    public String[] Name = {"Dhoni", "Cool ", "BackGround", "Nature", "Evening", "Ship","Tiger","Gujrati River","Healthy River","Dhoni", "Cool ", "BackGround", "Nature", "Evening", "Ship","Tiger","Gujrati River","Healthy River"};

    int logos[] = {R.drawable.dhoni, R.drawable.cool, R.drawable.background, R.drawable.nature,
            R.drawable.evening, R.drawable.ship,R.drawable.tiger,R.drawable.gujrati,R.drawable.healtyriver,R.drawable.dhoni, R.drawable.cool, R.drawable.background, R.drawable.nature,
            R.drawable.evening, R.drawable.ship,R.drawable.tiger,R.drawable.gujrati,R.drawable.healtyriver};


    RecyclerView Recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Recycler = findViewById(R.id.recyclerview);

        Recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Recycler.setAdapter(new RecyclerAdapter(Name, logos));



       // getinformation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.gridview:
                Recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                Recycler.setAdapter(new RecyclerAdapter(Name, logos));
                StaggeredGridLayoutManager staggeredGridLayoutManager =
                        new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);

                Recycler.setLayoutManager(staggeredGridLayoutManager);
                return true;
            case R.id.verticalView:
                Recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                Recycler.setAdapter(new RecyclerAdapter(Name, logos));

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


/*
    private void getinformation() {

        RecyclerViewModel recyclerViewModel = ViewModelProviders.of(this).get(RecyclerViewModel.class);

        recyclerViewModel.getinformation().observe(this, recyclerResponse -> {
            hideProgressDialgogue();
            if (recyclerResponse.getinformation() != null) {
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(recyclerResponse.getinformation());
                RecyclerView recyclerView = findViewById(R.id.recyclerview);
                recyclerView.setHasFixedSize(true);
                recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
                recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(recyclerAdapter);
            } else {
                showErrorMessage(recyclerResponse.getMessage());
            }

        });

    }
*/


}

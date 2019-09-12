package id.sch.bdg.smkn4.pwpb.biodataapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements RecyclerviewAdapter.OnUserClickListener {
    RecyclerView recyclerView;
    LinearLayout btnInput;
    RecyclerView.LayoutManager layoutManager;
    List<Student> listPersonInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Data Mahasiswa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.rvData);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        btnInput = findViewById(R.id.btnInputData);
        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, InputActivity.class);
                startActivity(i);
            }
        });
        setupRecyclerView();

    }

    private void setupRecyclerView() {
        DatabaseHelper db = new DatabaseHelper(MainActivity.this);
        listPersonInfo = db.selectUserData();
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(MainActivity.this, listPersonInfo, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onUserClick(Student currentPerson, String action) {
        if(action.equals("Edit")){
            Intent i = new Intent(MainActivity.this, UpdateActivity.class);
            i.putExtra(UpdateActivity.CURRENT_PERSON, currentPerson);
            startActivity(i);
        }
        if(action.equals("Delete")){
            DatabaseHelper db = new DatabaseHelper(MainActivity.this);
            db.delete(currentPerson.getName());
            setupRecyclerView();
        }
        if(action.equals("View")) {
            Intent i = new Intent(MainActivity.this, DetailActivity.class);
            i.putExtra(DetailActivity.CURRENT_PERSON, currentPerson);
            startActivity(i);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

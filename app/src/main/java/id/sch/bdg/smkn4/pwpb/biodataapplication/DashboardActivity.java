package id.sch.bdg.smkn4.pwpb.biodataapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout btnToView, btnToInput, btnToInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Dashboard");
        initialize();

        btnToView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
        btnToInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DashboardActivity.this, InputActivity.class);
                startActivity(i);
            }
        });
        btnToInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
//
//                // Set a message/question for alert dialog
//                builder.setMessage("Biodata App v1.0\nSMKN 4 Bandung\n\nAip Ariyadi & Audi Syahzehan\nXII-RPL 3");
//
//                // Specify the dialog is not cancelable
////                builder.setCancelable(false);
//
//                // Set a title for alert dialog
//                builder.setTitle("Information");
//                builder.show();
                Intent i = new Intent(DashboardActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });
    }

    private void initialize() {
        btnToView = (LinearLayout) findViewById(R.id.btnMenuViewData);
        btnToInput = (LinearLayout) findViewById(R.id.btnMenuInputData);
        btnToInfo = (LinearLayout) findViewById(R.id.btnMenuAbout);
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}

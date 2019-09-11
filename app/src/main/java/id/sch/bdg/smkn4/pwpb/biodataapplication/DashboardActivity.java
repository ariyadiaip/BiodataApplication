package id.sch.bdg.smkn4.pwpb.biodataapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class DashboardActivity extends AppCompatActivity {

    LinearLayout btnToView, btnToInput, btnToInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
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
}

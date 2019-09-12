package id.sch.bdg.smkn4.pwpb.biodataapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("About");
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        Animation animFadeInOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in_out);
        TextView tv = (TextView)findViewById(R.id.tv);
        TextView tvDet = (TextView)findViewById(R.id.tvDet);
        TextView tvKelas = (TextView)findViewById(R.id.tvKelas);
        tv.setText("Biodata App v1.0");
        tv.startAnimation(animFadeIn);
        tvDet.setText("Aip Ariyadi & Audi Syahzehan");
        tvDet.startAnimation(animFadeInOut);
        tvKelas.setText("XII-RPL 3");
        tvKelas.startAnimation(animFadeOut);

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

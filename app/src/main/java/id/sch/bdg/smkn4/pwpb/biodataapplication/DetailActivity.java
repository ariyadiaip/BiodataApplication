package id.sch.bdg.smkn4.pwpb.biodataapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static String CURRENT_PERSON = "extra_person";
    TextView txtNo, txtName, txtGender, txtBirth, txtAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Student student = getIntent().getParcelableExtra(CURRENT_PERSON);
        initialize();
        txtNo.setText(student.getNo()+"");
        txtName.setText(student.getName());
        if (student.getJenkel() == "L") {
            txtGender.setText("Laki - Laki");
        } else if (student.getJenkel() == "P") {
            txtGender.setText("Perempuan");
        } else {
            txtGender.setText("None");
        }
        txtBirth.setText(student.getTgl_lahir());
        txtAddress.setText(student.getAlamat());
    }

    private void initialize() {
        txtNo = findViewById(R.id.txtNo);
        txtName = findViewById(R.id.txtNama);
        txtGender = findViewById(R.id.txtJenkel);
        txtBirth = findViewById(R.id.txtTglLahir);
        txtAddress = findViewById(R.id.txtAlamat);
    }
}

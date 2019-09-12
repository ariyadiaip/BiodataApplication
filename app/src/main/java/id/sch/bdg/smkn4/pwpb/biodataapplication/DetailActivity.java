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

        this.setTitle("Detail Data");
        Student student = getIntent().getParcelableExtra(CURRENT_PERSON);
        initialize();
        txtNo.setText(student.getNo()+"");
        txtName.setText(student.getName());
        switch (student.getJenkel()){
            case "L" :
                txtGender.setText("Laki - Laki");
                break;
            case "P" :
                txtGender.setText("Perempuan");
                break;
            default:
                txtGender.setText("None");
                break;
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

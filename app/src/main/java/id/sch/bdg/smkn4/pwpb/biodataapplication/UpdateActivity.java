package id.sch.bdg.smkn4.pwpb.biodataapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    public static String CURRENT_PERSON = "extra_person";
    EditText edtNo, edtName, edtGender, edtBirth, edtAddress;
    LinearLayout btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Student student = getIntent().getParcelableExtra(CURRENT_PERSON);
        initialize();
        edtNo.setText(student.getNo()+"");
        edtName.setText(student.getName());
        edtGender.setText(student.getJenkel());
        edtBirth.setText(student.getTgl_lahir());
        edtAddress.setText(student.getAlamat());
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(edtNo.getText().toString().trim().equals("") || edtName.getText().toString().trim().equals("") ||
                        edtGender.getText().toString().trim().equals("") || edtBirth.getText().toString().trim().equals("") ||
                        edtBirth.getText().toString().trim().equals("") || edtAddress.getText().toString().trim().equals(""))) {
                    DatabaseHelper db = new DatabaseHelper(UpdateActivity.this);
                    Student currentPerson = new Student();
                    currentPerson.setNo(Integer.parseInt(edtNo.getText().toString()));
                    currentPerson.setName(edtName.getText().toString());
                    currentPerson.setJenkel(edtGender.getText().toString());
                    currentPerson.setTgl_lahir(edtBirth.getText().toString());
                    currentPerson.setAlamat(edtAddress.getText().toString());
                    db.update(currentPerson);
                    Intent i = new Intent(UpdateActivity.this, MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(UpdateActivity.this,"Data tidak boleh kosong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void initialize() {
        edtNo = findViewById(R.id.edtUNo);
        edtName = findViewById(R.id.edtUNama);
        edtGender = findViewById(R.id.edtUJenkel);
        edtBirth = findViewById(R.id.edtUTglLahir);
        edtAddress = findViewById(R.id.edtUAlamat);
        btnSave = findViewById(R.id.btnSimpanData);
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

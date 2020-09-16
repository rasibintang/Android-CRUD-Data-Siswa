package fathorazi.ac.id.unuja.finalprojectmkbm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText editText_nis, editText_nama, editText_nipd, editText_tempat, editText_tgl, editText_nik, editText_alamat, editText_rt, editText_rw, editText_desa, editText_kecamatan, editText_kelas;
    private RadioButton radioButton_l, radioButton_p;
    private Spinner spinner_agama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_nis = findViewById(R.id.ed_nis);
        editText_nis = findViewById(R.id.ed_nama);
        editText_nis = findViewById(R.id.ed_nipd);
        editText_nis = findViewById(R.id.ed_tempat);
        editText_nis = findViewById(R.id.ed_tgl);
        editText_nis = findViewById(R.id.ed_nik);
        editText_nis = findViewById(R.id.ed_alamat);
        editText_nis = findViewById(R.id.ed_rt);
        editText_nis = findViewById(R.id.ed_rw);
        editText_nis = findViewById(R.id.ed_desa);
        editText_nis = findViewById(R.id.ed_kecamatan);
        editText_nis = findViewById(R.id.ed_kelas);

        radioButton_l = findViewById(R.id.rb_l);
        radioButton_l = findViewById(R.id.rb_p);

        spinner_agama = findViewById(R.id.sp_agama);


    }
}

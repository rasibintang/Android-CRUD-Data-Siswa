package fathorazi.ac.id.unuja.finalprojectmkbm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText editText_nis, editText_nama, editText_nipd, editText_tempat, editText_tgl, editText_nik, editText_alamat, editText_rt, editText_rw, editText_desa, editText_kecamatan, editText_kelas;
    private RadioButton radioButton_l, radioButton_p;
    private Spinner spinner_agama;
    private Button button_simpan;

    private int mMonth, mYear, mDay;

    private String nis, nama, nipd, tempat, tgl, nik, alamat, rt, rw, desa, kecamatan, kelas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText_nis = findViewById(R.id.ed_nis);
        editText_nama = findViewById(R.id.ed_nama);
        editText_nipd = findViewById(R.id.ed_nipd);
        editText_tempat = findViewById(R.id.ed_tempat);
        editText_tgl = findViewById(R.id.ed_tgl);
        editText_nik = findViewById(R.id.ed_nik);
        editText_alamat = findViewById(R.id.ed_alamat);
        editText_rt = findViewById(R.id.ed_rt);
        editText_rw = findViewById(R.id.ed_rw);
        editText_desa = findViewById(R.id.ed_desa);
        editText_kecamatan = findViewById(R.id.ed_kecamatan);
        editText_kelas = findViewById(R.id.ed_kelas);

        radioButton_l = findViewById(R.id.rb_l);
        radioButton_p = findViewById(R.id.rb_p);

        spinner_agama = findViewById(R.id.sp_agama);

        editText_tgl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                final DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                Time chosenDate = new Time();
                                chosenDate.set(dayOfMonth, monthOfYear, year);
                                long dtDob = chosenDate.toMillis(true);
                                CharSequence strDate = DateFormat.format("yyyy-MM-dd", dtDob);
                                editText_tgl.setText(strDate);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        button_simpan = findViewById(R.id.bt_simpan);
        button_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText_nis.setError(null);
                editText_nama.setError(null);
                editText_nipd.setError(null);
                editText_tempat.setError(null);
                editText_tgl.setError(null);
                editText_nik.setError(null);
                editText_alamat.setError(null);
                editText_rt.setError(null);
                editText_rw.setError(null);
                editText_desa.setError(null);
                editText_kecamatan.setError(null);
                editText_kelas.setError(null);

                nis = editText_nis.getText().toString();
                nama = editText_nama.getText().toString();
                nipd = editText_nipd.getText().toString();
                tempat = editText_tempat.getText().toString();
                tgl = editText_tgl.getText().toString();
                nik = editText_nik.getText().toString();
                alamat = editText_alamat.getText().toString();
                rt = editText_rt.getText().toString();
                rw = editText_rw.getText().toString();
                desa = editText_desa.getText().toString();
                kecamatan = editText_kecamatan.getText().toString();
                kelas = editText_kelas.getText().toString();

                boolean cancel = false;
                View focusView = null;

                if (TextUtils.isEmpty(nis)) {
                    editText_nis.setError("Silahkan Isi NISN Anda");
                    focusView = editText_nis;
                    cancel = true;
                }

                if (TextUtils.isEmpty(nama)) {
                    editText_nama.setError("Silahkan Isi Nama Anda");
                    focusView = editText_nama;
                    cancel = true;
                }

                if (TextUtils.isEmpty(nipd)) {
                    editText_nipd.setError("Silahkan Isi NIPD Anda");
                    focusView = editText_nipd;
                    cancel = true;
                }

                if (TextUtils.isEmpty(tempat)) {
                    editText_tempat.setError("Silahkan Isi Tempat Lahir Anda");
                    focusView = editText_tempat;
                    cancel = true;
                }

                if (TextUtils.isEmpty(tgl)) {
                    editText_tgl.setError("Silahkan Isi Tanggal Lahir Anda");
                    focusView = editText_tgl;
                    cancel = true;
                }

                if (TextUtils.isEmpty(nik)) {
                    editText_nik.setError("Silahkan Isi NIK Anda");
                    focusView = editText_nik;
                    cancel = true;
                }

                if (TextUtils.isEmpty(alamat)) {
                    editText_alamat.setError("Silahkan Isi Alamat Anda");
                    focusView = editText_alamat;
                    cancel = true;
                }

                if (TextUtils.isEmpty(rt)) {
                    editText_rt.setError("Silahkan Isi RT Anda");
                    focusView = editText_rt;
                    cancel = true;
                }

                if (TextUtils.isEmpty(rw)) {
                    editText_rw.setError("Silahkan Isi RW Anda");
                    focusView = editText_rw;
                    cancel = true;
                }

                if (TextUtils.isEmpty(desa)) {
                    editText_desa.setError("Silahkan Isi Desa Anda");
                    focusView = editText_desa;
                    cancel = true;
                }

                if (TextUtils.isEmpty(kecamatan)) {
                    editText_kecamatan.setError("Silahkan Isi Kecamatan Anda");
                    focusView = editText_kecamatan;
                    cancel = true;
                }

                if (TextUtils.isEmpty(kelas)) {
                    editText_kelas.setError("Silahkan Isi kelas Anda");
                    focusView = editText_kelas;
                    cancel = true;
                }

                if (cancel){
                    focusView.requestFocus();
                }else{
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://siswa.le-melle.online/checkandroid.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("nisn", nis);
                            return params;
                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    requestQueue.add(stringRequest);

                }

            }
        });

    }
}

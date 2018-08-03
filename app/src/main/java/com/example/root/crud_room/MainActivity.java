package com.example.root.crud_room;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.crud_room.Room.Mahasiswa;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

import static com.example.root.crud_room.Room.MyApp.db;

public class MainActivity extends AppCompatActivity {

    private EditText edtNama;
    private EditText edtNpm;
    private EditText edtToken;
    private Button btnSave;

    private Mahasiswa mahasiswa;
    private Button btnDelete;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        Stetho.initializeWithDefaults(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        mahasiswa = new Mahasiswa();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mahasiswa.setNama(edtNama.getText().toString().trim());
                mahasiswa.setNpm(edtNpm.getText().toString().trim());
                mahasiswa.setToken(edtToken.getText().toString().trim());
                db.userDao().insertAll(mahasiswa);
                Toast.makeText(MainActivity.this, "Sukses", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.userDao().hapus(edtToken.getText().toString().trim());
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.userDao().updateMhs(edtNama.getText().toString().trim(),
                        edtNpm.getText().toString().trim(),
                        edtToken.getText().toString().trim());
            }
        });

    }

    private void initView() {
        edtNama = findViewById(R.id.edt_nama);
        edtNpm = findViewById(R.id.edt_npm);
        edtToken = findViewById(R.id.edt_token);
        btnSave = findViewById(R.id.btn_save);
        btnDelete = findViewById(R.id.btn_delete);
        btnUpdate = findViewById(R.id.btn_update);
    }
}

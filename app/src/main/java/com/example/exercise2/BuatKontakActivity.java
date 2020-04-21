package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatKontakActivity extends AppCompatActivity {
    protected Cursor cursor;
    DBHelper dbHelper;
    Button  butsimpan;
    EditText innama, innomor, inemail, inalamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_kontak);

        dbHelper = new DBHelper(this);

        innama = (EditText) findViewById(R.id.innama);
        innomor = (EditText) findViewById(R.id.innomor);
        inemail = (EditText) findViewById(R.id.inemail);
        inalamat = (EditText) findViewById(R.id.inalamat);
        butsimpan = (Button) findViewById(R.id.butsimpan);

        butsimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into kontak(nama, nomor, email, alamat) values('" +
                        innama.getText().toString()  + "','" +
                        innomor.getText().toString() + "','" +
                        inemail.getText().toString() + "','" +
                        inalamat.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}
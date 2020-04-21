package com.example.exercise2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LihatKontakActivity extends AppCompatActivity {
    protected Cursor cursor;
    DBHelper dbHelper;
    TextView text1, nama, nomor, email, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_kontak);
        dbHelper = new DBHelper(this);
        text1 = (TextView) findViewById(R.id.text1);
        nama = (TextView) findViewById(R.id.nama);
        nomor = (TextView) findViewById(R.id.nomor);
        email = (TextView) findViewById(R.id.email);
        alamat = (TextView) findViewById(R.id.alamat);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM kontak WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);

            nama.setText(cursor.getString(0).toString());
            nomor.setText(cursor.getString(1).toString());
            email.setText(cursor.getString(2).toString());
            alamat.setText(cursor.getString(3).toString());
        }
    }
}

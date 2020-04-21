package com.example.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateKontakActivity extends AppCompatActivity {
    protected Cursor cursor;
    DBHelper dbHelper;
    Button butubdata, butbatal, butsimpan;
    EditText innama, innomor, inemail, inalamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_kontak);

        dbHelper = new DBHelper(this);
        innama = (EditText) findViewById(R.id.innama);
        innomor = (EditText) findViewById(R.id.innomor);
        inemail = (EditText) findViewById(R.id.inemail);
        inalamat = (EditText) findViewById(R.id.inalamat);
        butubdata = (Button) findViewById(R.id.butubdata);
        butbatal = (Button) findViewById(R.id.butbatal);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        cursor = db.rawQuery("SELECT * FROM kontak WHERE nama = '"+
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0);
        {
            cursor.moveToPosition(0);
            innama.setText(cursor.getString(0).toString());
            innomor.setText(cursor.getString(1).toString());
            inemail.setText(cursor.getString(2).toString());
            inalamat.setText(cursor.getString(3).toString());
        }

        butubdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update kontak set nama='"+
                        innama.getText().toString()  + "', nama='" +
                        innomor.getText().toString() + "', nomor'" +
                        inemail.getText().toString() + "', email'" +
                        inalamat.getText().toString() + "', alamat')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });

        butbatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });

    }
}

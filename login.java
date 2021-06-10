package com.nikitafront.androidlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnIn, btnReg;
    private EditText login, password;
    private DBHelper dbhelper;
    private ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIn = (Button) findViewById(R.id.btnIn);
        btnReg = (Button) findViewById(R.id.btnReg);
        login = (EditText) findViewById(R.id.login);
        password = (EditText) findViewById(R.id.password);
        cl = (ConstraintLayout) findViewById(R.id.mainLayout);
        
        dbhelper = new DBHelper(getBaseContext());
        
        btnIn.setOnClickListener(this);
        btnReg.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        SQLiteDatabase db = dbhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String log = login.getText().toString();
        String pass = password.getText().toString();
        Cursor cursor = db.query(dbhelper.TABLE_NAME, null, null, null,
                null, null, null);

        switch (v.getId()) {
            case R.id.btnReg:
                boolean f = false;
                try {
                    String query = "SELECT * FROM " + dbhelper.TABLE_NAME + " WHERE _login=\"" + log + "\"";
                    Cursor cs = db.rawQuery(query, null);

                    if ((cs != null) && cs.moveToFirst()) {
                        f = true;
                    }

                } catch (Exception e) {
                    System.err.println("ERROR");
                }

                if (f) {
                    contentValues.put(dbhelper.KEY_LOGIN, log);
                    contentValues.put(dbhelper.KEY_PASSWORD, pass);
                    db.update(dbhelper.TABLE_NAME, contentValues, dbhelper.KEY_LOGIN + " = ? ", new String[]{log});
                    Toast.makeText(this, "Login has been rewritten!", Toast.LENGTH_LONG).show();
                } else {
                    contentValues.put(dbhelper.KEY_LOGIN, log);
                    contentValues.put(dbhelper.KEY_PASSWORD, pass);

                    db.insert(dbhelper.TABLE_NAME, null, contentValues);

                    login.setText("");
                    password.setText("");

                    Log.e("myl", "Your registration was successful");
                    Toast.makeText(this, "Your registration was successful", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btnIn:
                while (cursor.moveToNext()) {
                    int idIndex = cursor.getColumnIndex(dbhelper.KEY_ID);
                    int loginIndex = cursor.getColumnIndex(dbhelper.KEY_LOGIN);
                    int passwordIndex = cursor.getColumnIndex(dbhelper.KEY_PASSWORD);

                    if (cursor.getString(loginIndex).equals(log)) {
                        if (cursor.getString(passwordIndex).equals(pass)) {
                            Toast.makeText(this, "You are successfully logged in", Toast.LENGTH_LONG).show();
                            Log.e("myl", "You are successfully logged in");
                        } else {
                            Toast.makeText(this, "Your login attempt has failed", Toast.LENGTH_LONG).show();
                            Log.e("myl", "Your login attempt has failed");
                        }
                    }
                }
                break;

            default:
                cursor.close();
                break;
        }
    }
}

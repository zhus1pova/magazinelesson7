package com.example.magazine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView androidPhone, iOsPhone;
    RadioButton bankcardRadiobtn, qolmaqolRadiobtn;
    CheckBox siylyqCheckBox, mekenCheckBox;
    Button btnzhiberu;

    String tolemTuri, jetkizuText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidPhone = findViewById(R.id.androidPhone);
        iOsPhone = findViewById(R.id.iOsPhone);

        bankcardRadiobtn = findViewById(R.id.bankcardRadiobtn);
        qolmaqolRadiobtn = findViewById(R.id.qolmaqolRadiobtn);

        siylyqCheckBox = findViewById(R.id.siylyqCheckBox);
        mekenCheckBox = findViewById(R.id.mekenCheckBox);

        btnzhiberu= findViewById(R.id.btnzhiberu);

        registerForContextMenu(androidPhone);
        registerForContextMenu(iOsPhone);

        btnzhiberu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bankcardRadiobtn.isChecked()){
                    tolemTuri = "with bank card";
                }else if (qolmaqolRadiobtn.isChecked()){
                    tolemTuri = "qolma qol tolem";
                }

                if(siylyqCheckBox.isChecked()){
                    jetkizuText = "siylyq turinde zhiberu";
                }
                if (mekenCheckBox.isChecked()){
                    jetkizuText = "meken zhaiga dein";
                }

                String result = "Android:"+ androidPhone.getText()+"\n"+
                        "iOs:"+ iOsPhone.getText()+"\n"+
                        "Tolem turi:"+tolemTuri+"\n"+
                        "Jetkizu turi:"+jetkizuText;
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v == androidPhone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.andraoidmenu, menu);
        }
        if (v == iOsPhone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.iosmenu, menu);
        }


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.samsungPhone:
                androidPhone.setText("Samsung");
                break;
            case R.id.mi9Phone:
                androidPhone.setText("Mi9");
                break;
            case R.id.huaweiPhone:
                androidPhone.setText("Huawei");
                break;
            case R.id.xiaomiPhone:
                androidPhone.setText("Xiaomi");
                break;

            case R.id.iPhoneX:
                iOsPhone.setText("iPhone X");
                break;
            case R.id.iPhone13:
                iOsPhone.setText("iPhone 13");
                break;
            case R.id.iPhone7:
                iOsPhone.setText("iPhone 7");
                break;
            case R.id.iPhone13PRO:
                iOsPhone.setText("iPhone 13PRO");
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_settings:
                Toast.makeText(this, "Setting menu basyldy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_exit:
                Toast.makeText(this, "Exit menu basyldy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_save:
                Toast.makeText(this, "Save menu basyldy", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_cut:
                Toast.makeText(this, "Cut menu basyldy", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
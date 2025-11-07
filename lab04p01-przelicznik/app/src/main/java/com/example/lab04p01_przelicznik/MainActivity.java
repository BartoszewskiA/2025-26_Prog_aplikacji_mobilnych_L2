package com.example.lab04p01_przelicznik;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et_01, et_02;
    TextView tv_01, tv_02;
    SeekBar suwak;
    RadioGroup rg_01, rg_02;
    RadioButton rb_zr_pln, rb_zr_usd, rb_zr_eur;
    RadioButton rb_wy_pln, rb_wy_usd, rb_wy_eur;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        znajdzKontrolki();
        obslugaSuwaka();
        obslugaRadioButtons();
    }

    private void obslugaRadioButtons() {
        RadioGroup.OnCheckedChangeListener sluchacz = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                przelicz();
                if(rb_zr_pln.isChecked())
                    tv_01.setText("PLN");
                else if(rb_zr_eur.isChecked())
                    tv_01.setText("EURO");
                else if(rb_zr_usd.isChecked())
                    tv_01.setText("USD");

                if(rb_wy_pln.isChecked())
                    tv_02.setText("PLN");
                else if(rb_wy_eur.isChecked())
                    tv_02.setText("EURO");
                else if(rb_wy_usd.isChecked())
                    tv_02.setText("USD");
            }
        };
        rg_01.setOnCheckedChangeListener(sluchacz);
        rg_02.setOnCheckedChangeListener(sluchacz);
    }

    private void obslugaSuwaka() {
        suwak.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                et_01.setText(String.valueOf(progress));
                przelicz();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void przelicz() {
        double wynik = 0, posrednia_PLN =0;
        double kurs_EURO = 4.2;
        double kurs_DOLAR = 4.0;
        double zrodlo = Double.parseDouble(et_01.getText().toString());

        if(rb_zr_pln.isChecked())
            posrednia_PLN = zrodlo;
        else if(rb_zr_eur.isChecked())
            posrednia_PLN = zrodlo * kurs_EURO;
        else if(rb_zr_usd.isChecked())
            posrednia_PLN = zrodlo * kurs_DOLAR;
//---------------------------
        if(rb_wy_pln.isChecked())
            wynik = posrednia_PLN;
        else if(rb_wy_eur.isChecked())
            wynik = posrednia_PLN / kurs_EURO;
        else if(rb_wy_usd.isChecked())
            wynik = posrednia_PLN / kurs_DOLAR;
        wynik = Math.round(wynik * 100.0) / 100.0;
        et_02.setText(String.valueOf(wynik));

    }

    private void znajdzKontrolki() {
        et_01 = findViewById(R.id.et_01);
        et_02 = findViewById(R.id.et_02);
        tv_01 = findViewById(R.id.tv_01);
        tv_02 = findViewById(R.id.tv_02);
        suwak = findViewById(R.id.sb_01);
        rg_01 = findViewById(R.id.rg_01);
        rg_02 = findViewById(R.id.rg_02);
        rb_zr_pln = findViewById(R.id.rb_zr_pln);
        rb_zr_usd = findViewById(R.id.rb_zr_usd);
        rb_zr_eur = findViewById(R.id.rb_zr_euro);
        rb_wy_pln = findViewById(R.id.rb_wy_pln);
        rb_wy_usd = findViewById(R.id.rb_wy_usd);
        rb_wy_eur = findViewById(R.id.rb_wy_euro);
    }
}
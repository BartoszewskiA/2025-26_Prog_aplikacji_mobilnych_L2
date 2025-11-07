package com.example.lab05p01_atlas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv_nazwa, tv_opis;
    Button btn_poprzedni, btn_następny;
    ImageView iv_obraz;


    private String[] nazwy;
    private String[] opisy;
    private int[] obrazki = {   R.drawable.prawdziwek,
                                R.drawable.podgrzybek,
                                R.drawable.muchomor,
                                R.drawable.kania
                            };
    private int pozycja = 0;

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
        nazwy = getResources().getStringArray(R.array.nazwy);
        opisy = getResources().getStringArray(R.array.opisy);
        tv_nazwa.setText(nazwy[pozycja]);
        tv_opis.setText(opisy[pozycja]);
        iv_obraz.setImageResource(obrazki[pozycja]);
        dodaj_sluchacza();
        dostepnosc_przyciskow();
    }

    private void dodaj_sluchacza() {
        View.OnClickListener sluchacz = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    int Id = v.getId();
                    if(Id == R.id.btn_np)
                        pozycja++;
                    else if(Id == R.id.btn_ws)
                        pozycja--;
                tv_nazwa.setText(nazwy[pozycja]);
                tv_opis.setText(opisy[pozycja]);
                iv_obraz.setImageResource(obrazki[pozycja]);
                dostepnosc_przyciskow();
            }
        };
        btn_poprzedni.setOnClickListener(sluchacz);
        btn_następny.setOnClickListener(sluchacz);
    }

    private void dostepnosc_przyciskow() {
        if(pozycja==obrazki.length - 1)
            btn_następny.setEnabled(false);
        else
            btn_następny.setEnabled(true);
        if(pozycja==0)
            btn_poprzedni.setEnabled(false);
        else
            btn_poprzedni.setEnabled(true);
    }

    private void znajdzKontrolki() {
        tv_nazwa = findViewById(R.id.tv_nazwa);
        tv_opis = findViewById(R.id.tv_opis);
        btn_poprzedni = findViewById(R.id.btn_ws);
        btn_następny = findViewById(R.id.btn_np);
        iv_obraz = findViewById(R.id.iv_obraz);
    }
}
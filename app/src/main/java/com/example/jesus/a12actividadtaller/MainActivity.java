package com.example.jesus.a12actividadtaller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private TextView numero;
    private SeekBar seek;
    private Button btncalc;
    private TextView txtRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = (TextView) findViewById(R.id.txt_num);
        seek = (SeekBar) findViewById(R.id.sk_barra);
        btncalc = (Button) findViewById(R.id.btn_calc);
        txtRes = (TextView) findViewById(R.id.txt_res);

        btncalc.setOnClickListener(this);

        numero.setText("" + seek.getProgress());

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numero.setText("" + seek.getProgress());

                String texto;
                int num;
                texto = numero.getText().toString();
                num = Integer.parseInt(texto);

                String cad = calcula(num);

                txtRes.setText("");
                txtRes.scrollTo(0, 0);
                txtRes.setText(cad);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public String calcula(int n) {
        String cad = "";
        for (int i = 1; i < 31; i++) {
            cad = cad + i + "*" + n + "=" + n * i + "\n";
        }
        return cad;
    }


    @Override
    public void onClick(View v) {
        String texto;
        int num;
        texto = numero.getText().toString();
        num = Integer.parseInt(texto);

        String cad = calcula(num);

        txtRes.setText("");
        txtRes.scrollTo(0, 0);
        txtRes.setText(cad);
    }

}

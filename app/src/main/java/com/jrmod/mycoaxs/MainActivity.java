package com.jrmod.mycoaxs;

import static java.lang.Math.sqrt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {


    Button button1, reset;
    EditText input1, input2, input3, input4;
    TextView hasil1, x, y, z, c, justment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        input3 = findViewById(R.id.input3);
        input4 = findViewById(R.id.input4);

        button1 = findViewById(R.id.button1);
        reset = findViewById(R.id.reset);
        hasil1 = findViewById(R.id.hasil1);
        justment = findViewById(R.id.justy);
        x = findViewById(R.id.hsil1);
        y = findViewById(R.id.hsil2);
        z = findViewById(R.id.hsilA);
        c = findViewById(R.id.hsilB);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double pertama, kedua, ketiga, keempat, hsl1, hsl2, hslA, hslB, A, X, final1;
                    NumberFormat nf = NumberFormat.getInstance();
                    pertama = Double.parseDouble(input1.getText().toString());
                    kedua = Double.parseDouble(input2.getText().toString());
                    ketiga = Double.parseDouble(input3.getText().toString());
                    keempat = Double.parseDouble(input4.getText().toString());
                    hsl1 = pertama - ketiga;
                    hsl2 = kedua - keempat;
                    hslA = hsl1 * hsl1;
                    hslB = hsl2 * hsl2;
                    A = hslA + hslB;
                    X = Math.sqrt(A);
                    final1 = X * 2;

                    DecimalFormat df = new DecimalFormat("#.######");
                    DecimalFormat formater = new DecimalFormat("#.###");
                    String hsl1akhir = df.format(hsl1);
                    String hsl2akhir = df.format(hsl2);
                    String hslAakhir = df.format(hslA);
                    String hslBakhir = df.format(hslB);
                    String akhir = formater.format(final1);

                    hasil1.setText(akhir);
                    if (final1 >= 0.020) {
                        justment.setText("Not Good");
                        justment.setBackgroundColor(Color.RED);
                        hasil1.setTextColor(Color.RED);
                    } else if (final1 >= 0.014) {
                        double drawing, outPersentase;
                        drawing = 0.020;
                        outPersentase = final1 / drawing;
                        NumberFormat formatOut = NumberFormat.getPercentInstance();
                        formatOut.setMaximumFractionDigits(1);
                        String akhirOutPersentase = formatOut.format(outPersentase);
                        justment.setText("out " + akhirOutPersentase);
                        justment.setBackgroundColor(Color.BLUE);
                        hasil1.setTextColor(Color.BLUE);
                    } else {
                        justment.setText("OK");
                        justment.setBackgroundColor(Color.WHITE);
                        hasil1.setTextColor(Color.BLACK);
                    }

                    x.setText(hsl1akhir);
                    y.setText(hsl2akhir);
                    z.setText(hslAakhir);
                    c.setText(hslBakhir);
                } catch (NumberFormatException ne) {
                    hasil1.setText("Input dulu");
                }
            }


        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                input1.getText().clear();
                input2.getText().clear();
                input3.getText().clear();
                input4.getText().clear();
                hasil1.setText(R.string.hasil1);
                x.setText(null);
                y.setText(null);
                z.setText(null);
                c.setText(null);
                justment.setText("");
            }
        });
    }
}

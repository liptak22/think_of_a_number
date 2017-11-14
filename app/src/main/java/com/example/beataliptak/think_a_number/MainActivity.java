package com.example.beataliptak.think_a_number;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button_plus, button_minus, button_send, button_restart;
    private TextView szoveg1, szam;
    private ImageView heart1, heart2, heart3, heart4, heart5;
    int eletek = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_plus = (Button) findViewById(R.id.button_plus);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_send = (Button) findViewById(R.id.button_send);
        button_restart = (Button) findViewById(R.id.button_restart);
        szoveg1 = (TextView) findViewById(R.id.textView_szoveg1);
        szam = (TextView) findViewById(R.id.textView_szam);
        heart1 = (ImageView) findViewById(R.id.imageView_heart1);
        heart2 = (ImageView) findViewById(R.id.imageView_heart2);
        heart3 = (ImageView) findViewById(R.id.imageView_heart3);
        heart4 = (ImageView) findViewById(R.id.imageView_heart4);
        heart5 = (ImageView) findViewById(R.id.imageView_heart5);

        Random r = new Random();
        final int i1 = r.nextInt(51 - 0) + 0;

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sajatSzam = 0;

                try {
                    sajatSzam = Integer.parseInt(szam.getText().toString());
                    sajatSzam += 1;
                    szam.setText(""+sajatSzam);

                } catch(NumberFormatException nfe) {
                    System.out.println("Sikertelen parseolás" + nfe);
                }
                if (sajatSzam > 50) {
                    sajatSzam -= 1;
                    szam.setText(""+sajatSzam);
                    Context context = getApplicationContext();
                    CharSequence text = "50-nál nem lehet több a gondolt szám!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {}
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sajatSzam = 0;

                try {
                    sajatSzam = Integer.parseInt(szam.getText().toString());
                    sajatSzam -= 1;
                    szam.setText(""+sajatSzam);

                } catch(NumberFormatException nfe) {
                    System.out.println("Sikertelen parseolás" + nfe);
                }
                if (sajatSzam < 0) {
                    sajatSzam += 1;
                    szam.setText(""+sajatSzam);
                    Context context = getApplicationContext();
                    CharSequence text = "0-nál nem lehet kisebb a gondolt szám!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {}
            }
        });

        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sajatSzam = 0;

                try {
                    sajatSzam = Integer.parseInt(szam.getText().toString());
                } catch(NumberFormatException nfe) {
                    System.out.println("Sikertelen parseolás" + nfe);
                }
                if (sajatSzam < i1) {
                    eletek -= 1;
                    Context context = getApplicationContext();
                    CharSequence text = "Nagyobbra gondoltam! (" + i1 + ")";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else if (sajatSzam > i1) {
                    eletek -= 1;
                    Context context = getApplicationContext();
                    CharSequence text = "Kisebbre gondoltam! (" + i1 + ")";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else if (sajatSzam == i1){
                    Context context = getApplicationContext();
                    CharSequence text = "Győztél, kitaláltad a helyes megfejtést! (" + i1 + ")" + "\nÖsszesen " + eletek + " db életed maradt!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {Toast.makeText(MainActivity.this, "Hiba történt az alkalmazásban!", Toast.LENGTH_LONG).show();}
                switch(eletek) {
                    case 1:
                        heart1.setBackgroundResource(R.drawable.heart2);
                        heart2.setBackgroundResource(R.drawable.heart1);
                        heart3.setBackgroundResource(R.drawable.heart1);
                        heart4.setBackgroundResource(R.drawable.heart1);
                        heart5.setBackgroundResource(R.drawable.heart1);
                        break;
                    case 2:
                        heart1.setBackgroundResource(R.drawable.heart2);
                        heart2.setBackgroundResource(R.drawable.heart2);
                        heart3.setBackgroundResource(R.drawable.heart1);
                        heart4.setBackgroundResource(R.drawable.heart1);
                        heart5.setBackgroundResource(R.drawable.heart1);
                        break;
                    case 3:
                        heart1.setBackgroundResource(R.drawable.heart2);
                        heart2.setBackgroundResource(R.drawable.heart2);
                        heart3.setBackgroundResource(R.drawable.heart2);
                        heart4.setBackgroundResource(R.drawable.heart1);
                        heart5.setBackgroundResource(R.drawable.heart1);
                        break;
                    case 4:
                        heart1.setBackgroundResource(R.drawable.heart2);
                        heart2.setBackgroundResource(R.drawable.heart2);
                        heart3.setBackgroundResource(R.drawable.heart2);
                        heart4.setBackgroundResource(R.drawable.heart2);
                        heart5.setBackgroundResource(R.drawable.heart1);
                        break;
                    case 5:
                        heart1.setBackgroundResource(R.drawable.heart2);
                        heart2.setBackgroundResource(R.drawable.heart2);
                        heart3.setBackgroundResource(R.drawable.heart2);
                        heart4.setBackgroundResource(R.drawable.heart2);
                        heart5.setBackgroundResource(R.drawable.heart2);
                        break;
                    case 0:
                        heart1.setBackgroundResource(R.drawable.heart1);
                        heart2.setBackgroundResource(R.drawable.heart1);
                        heart3.setBackgroundResource(R.drawable.heart1);
                        heart4.setBackgroundResource(R.drawable.heart1);
                        heart5.setBackgroundResource(R.drawable.heart1);
                        Toast.makeText(MainActivity.this,
                                "Meghaltál! HAHAHA! A szám a " + i1 + " volt. Kezdd újra a játékot!", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        Toast.makeText(MainActivity.this,
                                "Hiba történt az alkalmazásban!", Toast.LENGTH_LONG).show();
                }

            }
        });
        button_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

    }
}

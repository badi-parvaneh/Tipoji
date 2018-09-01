package com.example.tipoji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private static double ZERO = 0.0;
    private static double FIVE = 0.05;
    private static double TEN = 0.1;
    private static double FIFTEEN = 0.15;
    private static double EIGHTEEN = 0.18;
    private static double TWENTY = 0.2;
    double tip = 0.0;
    double total = 0.0;

    EditText bill;
    ImageView zero;
    ImageView five;
    ImageView ten;
    ImageView fifteen;
    ImageView eighteen;
    ImageView twenty;
    ImageView custom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bill = findViewById(R.id.bill_amount);
        zero = findViewById(R.id.zero);
        five = findViewById(R.id.five);
        ten = findViewById(R.id.ten);
        fifteen = findViewById(R.id.fifteen);
        eighteen = findViewById(R.id.eighteen);
        twenty = findViewById(R.id.twenty);
        custom = findViewById(R.id.custom);


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bill.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "You must enter the bill amount first!", Toast.LENGTH_LONG).show();
                } else {
                    double billAmount = Double.parseDouble(bill.getText().toString());
                    tip = ZERO;
                    total = billAmount;
                    Intent next = new Intent(v.getContext(), Result.class);
                    Bundle b = new Bundle();
                    b.putDouble("tip", tip);
                    b.putDouble("total", total);
                    b.putDouble("percent", ZERO);
                    next.putExtras(b);
                    startActivity(next);
                }

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bill.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "You must enter the bill amount first!", Toast.LENGTH_LONG).show();
                } else {
                    double billAmount = Double.parseDouble(bill.getText().toString());
                    tip = FIVE * billAmount;
                    total = billAmount + tip;
                    Intent next = new Intent(v.getContext(), Result.class);
                    Bundle b = new Bundle();
                    b.putDouble("tip", tip);
                    b.putDouble("total", total);
                    b.putDouble("percent", FIVE);
                    next.putExtras(b);
                    startActivity(next);
                }

            }
        });

        ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bill.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "You must enter the bill amount first!", Toast.LENGTH_LONG).show();
                } else {
                    double billAmount = Double.parseDouble(bill.getText().toString());
                    tip = TEN * billAmount;
                    total = billAmount + tip;
                    Intent next = new Intent(v.getContext(), Result.class);
                    Bundle b = new Bundle();
                    b.putDouble("tip", tip);
                    b.putDouble("total", total);
                    b.putDouble("percent", TEN);
                    next.putExtras(b);
                    startActivity(next);
                }

            }
        });

        fifteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bill.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "You must enter the bill amount first!", Toast.LENGTH_LONG).show();
                } else {
                    double billAmount = Double.parseDouble(bill.getText().toString());
                    tip = FIFTEEN * billAmount;
                    total = billAmount + tip;
                    Intent next = new Intent(v.getContext(), Result.class);
                    Bundle b = new Bundle();
                    b.putDouble("tip", tip);
                    b.putDouble("total", total);
                    b.putDouble("percent", FIFTEEN);
                    next.putExtras(b);
                    startActivity(next);
                }

            }
        });

        eighteen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bill.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "You must enter the bill amount first!", Toast.LENGTH_LONG).show();
                } else {
                    double billAmount = Double.parseDouble(bill.getText().toString());
                    tip = EIGHTEEN * billAmount;
                    total = billAmount + tip;
                    Intent next = new Intent(v.getContext(), Result.class);
                    Bundle b = new Bundle();
                    b.putDouble("tip", tip);
                    b.putDouble("total", total);
                    b.putDouble("percent", EIGHTEEN);
                    next.putExtras(b);
                    startActivity(next);
                }

            }
        });

        twenty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bill.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "You must enter the bill amount first!", Toast.LENGTH_LONG).show();
                } else {
                    double billAmount = Double.parseDouble(bill.getText().toString());
                    tip = TWENTY * billAmount;
                    total = billAmount + tip;
                    Intent next = new Intent(v.getContext(), Result.class);
                    Bundle b = new Bundle();
                    b.putDouble("tip", tip);
                    b.putDouble("total", total);
                    b.putDouble("percent", TWENTY);
                    next.putExtras(b);
                    startActivity(next);
                }

            }
        });

        custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bill.getText().toString().equals("")) {
                    Toast.makeText(v.getContext(), "You must enter the bill amount first!", Toast.LENGTH_LONG).show();
                } else {
                    double billAmount = Double.parseDouble(bill.getText().toString());
                    Intent next = new Intent(v.getContext(), custom.class);
                    Bundle b = new Bundle();
                    b.putDouble("bill", billAmount);
                    next.putExtras(b);
                    startActivity(next);
                }

            }
        });


    }
}

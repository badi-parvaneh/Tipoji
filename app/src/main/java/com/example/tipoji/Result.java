package com.example.tipoji;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView bill = findViewById(R.id.bill_result);
        TextView tip = findViewById(R.id.tip_result);
        TextView total = findViewById(R.id.total_result);
        ImageView emoji = findViewById(R.id.money_emoji);

        total.setShadowLayer(
                2.0f,
                   5.0f,
                5.0f,
                Color.parseColor("#FF3D803D")

        );

        double billAmount = 0.0;
        double tipAmount = 0.0;
        double totalAmount = 0.0;
        double percent = 0.0;


        Bundle b = getIntent().getExtras();
        if (b != null) {
            tipAmount = b.getDouble("tip");
            totalAmount = b.getDouble("total");
            billAmount = totalAmount - tipAmount;
            percent = b.getDouble("percent");
        }
        String tipText = String.format("%.2f", tipAmount);
        String perText = String.format("%.0f", (percent * 100));
        bill.setText("your bill amount was: $" + billAmount);
        tip.setText("you will tip $" + tipText + " (%" + perText + ")");
        total.setText("your final bill amount is: $" + totalAmount);

        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        emoji.startAnimation(myFadeInAnimation);

    }
}

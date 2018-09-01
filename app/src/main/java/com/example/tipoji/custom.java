package com.example.tipoji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class custom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);


        final TextView title = findViewById(R.id.title);
        Bundle b = getIntent().getExtras();
        double bill = 0.0;
        if (b != null) {
            bill = b.getDouble("bill");
        }

        //Add textchangelistener to calculate data
        final String top = "your bill amount is: $" + Double.toString(bill);

        title.setText(top);

        final EditText percentage = findViewById(R.id.percentage_custom);
        final EditText tipAmount = findViewById(R.id.tip_custom);
        final ImageView pEmoji = findViewById(R.id.p_emoji);
        final ImageView tEmoji = findViewById(R.id.t_emoji);

        pEmoji.setImageDrawable(null);
        tEmoji.setImageDrawable(null);

        final double bill_copy = bill;
        percentage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (!percentage.getText().toString().equals("")) {
                    String pStr = percentage.getText().toString();
                    double percent = 0.0;
                    double tip = 0.0;
                    double total = 0.0;
                    percent = Double.parseDouble(pStr) / 100;
                    tip = bill_copy * percent;
                    total = bill_copy + tip;
                    int pEmojiId = 0;

                    if (percent == 0) {
                        pEmojiId = R.drawable.zero;
                    } else if (percent > 0 && percent <= 0.05) {
                        pEmojiId = R.drawable.five;
                    } else if (percent > 0.05 && percent <= 0.10) {
                        pEmojiId = R.drawable.ten;
                    } else if (percent > 0.10 && percent <= 0.15) {
                        pEmojiId = R.drawable.fifteen;
                    } else if (percent > 0.15 && percent <= 0.18) {
                        pEmojiId = R.drawable.eighteen;
                    } else if (percent > 0.18) {
                        pEmojiId = R.drawable.twenty;
                    }
                    pEmoji.setImageResource(pEmojiId);
                    Animation myFadeInAnimation = AnimationUtils.loadAnimation(custom.this, R.anim.fadein);
                    pEmoji.startAnimation(myFadeInAnimation);
                    String newTitle = "your total bill is: $" + total;
                    title.setText(newTitle);

                } else {
                    title.setText(top);
                    pEmoji.setImageDrawable(null);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (percentage.getText().toString().equals("")) {
                    if (tipAmount.getText().toString().equals("")) {
                        title.setText(top);
                    } else {

                        title.setText("your total bill is: $" + (bill_copy + Double.parseDouble(tipAmount.getText().toString())));
                    }
                }

            }
        });

        tipAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!tipAmount.getText().toString().equals("")) {
                    String tStr = tipAmount.getText().toString();
                    double tip = 0.0;
                    double total = 0.0;
                    tip = Double.parseDouble(tStr);
                    total = bill_copy + tip;
                    int tEmojiId = 0;
                    if (tip == 0) {
                        tEmojiId = R.drawable.zero;
                    } else if (tip > 0 && tip <= (0.05 * bill_copy)) {
                        tEmojiId = R.drawable.five;
                    } else if (tip > (0.05 * bill_copy) && tip <= (0.1 * bill_copy)) {
                        tEmojiId = R.drawable.ten;
                    } else if (tip > (0.1 * bill_copy) && tip <= (0.15 * bill_copy)) {
                        tEmojiId = R.drawable.fifteen;
                    } else if (tip > (0.15 * bill_copy) && tip <= (0.18 * bill_copy)) {
                        tEmojiId = R.drawable.eighteen;
                    } else if (tip > (0.18 * bill_copy)) {
                        tEmojiId = R.drawable.twenty;
                    }
                    tEmoji.setImageResource(tEmojiId);
                    Animation myFadeInAnimation = AnimationUtils.loadAnimation(custom.this, R.anim.fadein);
                    tEmoji.startAnimation(myFadeInAnimation);
                    String newTitle = "your total bill is: $" + total;
                    title.setText(newTitle);
                } else {
                    title.setText(top);
                    tEmoji.setImageDrawable(null);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (tipAmount.getText().toString().equals("")) {
                    if (percentage.getText().toString().equals("")) {
                        title.setText(top);
                    } else {

                        title.setText("your total bill is: $" + (bill_copy + ((Double.parseDouble(percentage.getText().toString()) / 100) * bill_copy)));
                    }
                }
            }
        });


    }
}

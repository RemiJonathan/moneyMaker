package com.remijonathan.moneymaker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button makeMoney;
    private int balance = 2000;
    private TextView balanceTextView;
    private TextView wealthyText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        makeMoney = findViewById(R.id.button_make_money);
        balanceTextView = findViewById(R.id.balance);
        wealthyText = findViewById(R.id.textview_wealthy);
        makeMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(balance>149999) showWealthy();
                makeMoney(view);
            }
        });

    }

    private void showWealthy() {
        wealthyText.setText("Congrats! $ "+balance+".00 is a high balance!\n You should look into investments!");
    }

    private void makeMoney(View view) {
        balance += 1000;
        Log.d("ButtonClickLog", "onClick: Added $1000.00 to balance. Total is $"+balance+".00");
        balanceTextView.setText("$ "+balance+".00");
        balanceTextView.setTextColor(Color.argb(255,255-((balance/1000)%255),255,255-((balance/1000)%255)));

    }

    public void showToast(View view) {
        Log.d("ButtonShowToast", "showToast: Toast shown");
        Toast.makeText(getApplicationContext(), "You go girl!", Toast.LENGTH_LONG).show();
    }


}

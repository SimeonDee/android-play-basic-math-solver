package com.example.simeon_dee.simplemathsolver;

import android.app.Dialog;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SimpleInterest extends AppCompatActivity {

    private EditText edPrincipal, edRate, edTime;
    private TextView tvInterest;
    private Button btnGetInterest;
    private LinearLayout linearLayoutInterestOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_interest);

        edPrincipal = (EditText) findViewById(R.id.edPrincipal);
        edRate = (EditText) findViewById(R.id.edRate);
        edTime = (EditText) findViewById(R.id.edTime);
        tvInterest = (TextView) findViewById(R.id.tvInterest);

        linearLayoutInterestOutput = (LinearLayout) findViewById(R.id.linearLayoutInterestOutput);
        linearLayoutInterestOutput.setVisibility(View.INVISIBLE);

    }

    public void calculateInterestButtonHandler(View view) {
        double principal, rate, interest;
        int time;

        principal = Double.valueOf(edPrincipal.getText().toString());
        rate = Double.valueOf(edRate.getText().toString());
        time = Integer.valueOf(edTime.getText().toString());

        if(principal != 0 || rate != 0 || time != 0){
            interest = (principal * rate * time) / 100;
            tvInterest.setText(String.valueOf(interest));
            linearLayoutInterestOutput.setVisibility(View.VISIBLE);
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(SimpleInterest.this);
            builder.setTitle("EMPTY FIELD ALERT")
                    .setMessage("All Fields Are Required.");

            AlertDialog dialog = builder.create();
            dialog.show();

        }
    }

    public void clearButtonHandler(View view) {
        clearControls();
    }

    private void clearControls() {
        edPrincipal.setText("");
        edRate.setText("");
        edTime.setText("");
        tvInterest.setText("");
        linearLayoutInterestOutput.setVisibility(View.INVISIBLE);
    }

}

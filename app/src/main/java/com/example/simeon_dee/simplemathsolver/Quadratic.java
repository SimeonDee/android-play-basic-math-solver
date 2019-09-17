package com.example.simeon_dee.simplemathsolver;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Quadratic extends AppCompatActivity {

    private EditText edXSquareCoeff, edXCoeff, edConstant;
    private TextView tvRootX1, tvRootX2;
    private Button btnGetInterest;
    private LinearLayout linearLayoutRootX1, linearLayoutRootX2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadratic);

        edXSquareCoeff = (EditText) findViewById(R.id.edXSquareCoefficient);
        edXCoeff = (EditText) findViewById(R.id.edXCoefficient);
        edConstant = (EditText) findViewById(R.id.edConstant);

        tvRootX1 = (TextView) findViewById(R.id.tvRootX1);
        tvRootX2 = (TextView) findViewById(R.id.tvRootX2);

        linearLayoutRootX1 = (LinearLayout) findViewById(R.id.linearLayRootX1Output);
        linearLayoutRootX2 = (LinearLayout) findViewById(R.id.linearLayRootX2Output);

        hideOutputView();
    }


    public void calculateInterestButtonHandler(View view) {
        double a, b, c, d, x1, x2;
        a = Integer.valueOf(edXSquareCoeff.getText().toString());
        b = Integer.valueOf(edXCoeff.getText().toString());
        c = Integer.valueOf(edConstant.getText().toString());

        try{

            if(a != 0 && b != 0 && c != 0){

                d = Math.pow(b,2) - (4 * a * c);


                if(d < 0){
                    AlertDialog.Builder  builder = new AlertDialog.Builder(this);
                    builder.setTitle("ERROR ALERT")
                            .setMessage("Complex Root... Cannot Solve")
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                }
                            });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                else if(d == 0){
                    x1 = -b / (2 * a);
                    x2 = x1;

                    tvRootX1.setText(String.valueOf(x1));
                    tvRootX2.setText(String.valueOf(x2));

                    showOutputView();
                }
                else{
                    x1 = (-b + Math.sqrt(d)) / (2 * a);
                    x2 = (-b - Math.sqrt(d)) / (2 * a);

                    tvRootX1.setText(String.valueOf(x1));
                    tvRootX2.setText(String.valueOf(x2));

                 showOutputView();
                }

            }


        }
        catch (Exception e){
            Log.v("QUADRATIC", e.getMessage());
            AlertDialog.Builder  builder2 = new AlertDialog.Builder(this);
            builder2.setTitle("ERROR ALERT")
                    .setMessage("Something Went Wrong... \nMay Be You Enter Nothing/Zero " +
                            "as Value for X-Square Coefficient")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });

            AlertDialog dialog2 = builder2.create();
            dialog2.show();
        }

    }

    public void clearButtonHandler(View view) {
        clearControls();
    }

    private void clearControls(){
        edXSquareCoeff.setText("");
        edXCoeff.setText("");
        edConstant.setText("");
        tvRootX1.setText("");
        tvRootX2.setText("");
        hideOutputView();
    }

    private void showOutputView(){
        linearLayoutRootX1.setVisibility(View.VISIBLE);
        linearLayoutRootX2.setVisibility(View.VISIBLE);
    }

    private void hideOutputView(){
        linearLayoutRootX1.setVisibility(View.INVISIBLE);
        linearLayoutRootX2.setVisibility(View.INVISIBLE);
    }
}

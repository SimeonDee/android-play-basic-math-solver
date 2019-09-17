package com.example.simeon_dee.simplemathsolver;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class AreaOfCircle extends AppCompatActivity {

    private EditText edRadius;
    private RadioButton radApproxPi, radFullPi;
    private TextView tvArea;
    private LinearLayout linearLayoutOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_of_circle);

        edRadius = (EditText) findViewById(R.id.edRadius);
        radApproxPi = (RadioButton) findViewById(R.id.radApproxPi);
        radFullPi = (RadioButton) findViewById(R.id.radFullPi);

        linearLayoutOutput = (LinearLayout) findViewById(R.id.linlayOutput);

        tvArea = (TextView) findViewById(R.id.tvArea);

        linearLayoutOutput.setVisibility(View.INVISIBLE);
    }


    public void computeAreaButtonHandler(View view) {
        double radius, area, pi = 0.0;
        try{

            radius = Double.valueOf(edRadius.getText().toString());
            if(!(radApproxPi.isChecked()) && !(radFullPi.isChecked())) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AreaOfCircle.this);
                builder.setTitle("PI NOT SELECTED ALERT")
                        .setMessage("You Have to Select a Value for Pi")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
            }
            else if(radApproxPi.isChecked()) {  pi = 3.142;  }
            else if(radFullPi.isChecked()) { pi = 22 / 7; }

            area = pi * Math.pow(radius,2);
            tvArea.setText(String.valueOf(area));

            linearLayoutOutput.setVisibility(View.VISIBLE);

        } catch (Exception e){
            Log.d("AreaOfCircle","Area Of Circle: " + e.getMessage());
        }


    }

    public void clearAreaButtonHandler(View view) {
        clearControls();
    }

    private void clearControls() {
        edRadius.setText("");
        tvArea.setText("");
        radApproxPi.setChecked(false);
        radFullPi.setChecked(false);
        linearLayoutOutput.setVisibility(View.INVISIBLE);
    }
}

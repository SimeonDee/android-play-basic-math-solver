package com.example.simeon_dee.simplemathsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MathOperations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_operations);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mnu_operations,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void buttonClickHandler(View view) {
        int buttonClicked = view.getId();
        switch (buttonClicked){
            case R.id.btnSimpleInterest:
                Intent intent = new Intent(this,SimpleInterest.class);
                startActivity(intent);
                break;

            case R.id.btnQuadratic:
                Intent intent2 = new Intent(this,Quadratic.class);
                startActivity(intent2);
                break;

            case R.id.btnAreaOfCircle:
                Intent intent3 = new Intent(this,AreaOfCircle.class);
                startActivity(intent3);
                break;


        }
    }

    public void handleMenu(MenuItem item) {
        int itemSelected = item.getItemId();
        switch (itemSelected){
            case R.id.itmSimpleInterest:
                Intent intent = new Intent(MathOperations.this,SimpleInterest.class);
                startActivity(intent);
                break;

            case R.id.itmQuadratic:
                Intent intent2 = new Intent(MathOperations.this,Quadratic.class);
                startActivity(intent2);
                break;

            case R.id.itmAreaOfCircle:
                Intent intent3 = new Intent(this,AreaOfCircle.class);
                startActivity(intent3);
                break;

            case R.id.itmExit:
                MathOperations.this.finish();
                break;


        }
    }

    public void quadraticButtonClickHandler(View view) {
        Intent intent = new Intent(MathOperations.this, Quadratic.class);
        startActivity(intent);
    }

    public void exitButtonClickHandler(View view) {
        MathOperations.this.finish();
    }
}

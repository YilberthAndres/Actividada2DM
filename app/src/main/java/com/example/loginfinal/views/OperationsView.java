package com.example.loginfinal.views;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginfinal.R;
import com.example.loginfinal.interfaces.OperationsInterfaceView;
import com.example.loginfinal.presenters.OperationsPresenter;

public class OperationsView extends AppCompatActivity implements OperationsInterfaceView {
    private OperationsPresenter presenter;
    private EditText number1;
    private EditText number2;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       // presenter = new OperationsPresenter(this);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        txtResult = findViewById(R.id.Solucion);
    }

    public void doAdd(View view) {
        try {
            int num1 = Integer.parseInt(number1.getText().toString());
            int num2 = Integer.parseInt(number2.getText().toString());
          //  presenter.add(num1, num2);
        } catch (NumberFormatException e) {
            invalidOperation();
        }
    }

    public void doSubtract(View view) {


    }

    public void doMultiply(View view) {


    }

    public void doDivide(View view) {


    }

    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }

    @Override
    public void invalidOperation() {
        Toast.makeText(this, "Invalid operation", Toast.LENGTH_SHORT).show();
    }
}

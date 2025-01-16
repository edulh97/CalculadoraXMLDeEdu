package com.example.myapplication4;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Aqui se obtienen los componentes
        EditText Input1 = findViewById(R.id.number1);
        EditText Input2 = findViewById(R.id.number2);
        Button calculateButton = findViewById(R.id.calculateButton);
        TextView resultTextView = findViewById(R.id.resultSuma);


        calculateButton.setOnClickListener(v -> {
            //Aqui se obtiene el valor del componente en String por defecto al ser EditText
            String num1txt = Input1.getText().toString();
            String num2txt = Input2.getText().toString();

            if (!num1txt.isEmpty() && !num2txt.isEmpty()) {
                try {
                    // Aqui lo convertimos a numeros
                    Double num1suma = Double.parseDouble(num1txt);
                    Double num2suma = Double.parseDouble(num2txt);

                    double resultado = num1suma + num2suma;
                    resultTextView.setText("Resultado: " + resultado);
                } catch (NumberFormatException e) {
                    // Manejar valores no numéricos
                    resultTextView.setText("Por favor, ingresa números válidos.");
                }
            } else {
                // Manejar campos vacíos
                resultTextView.setText("Ingresa dos números válidos y dejate de tonterías.");
            }
        });
    }
}
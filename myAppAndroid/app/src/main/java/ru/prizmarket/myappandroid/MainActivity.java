package ru.prizmarket.myappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewFirst;
    TextView textViewSecond;
    Button changeText;
    Button nextActivity, nextActivity3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFirst = findViewById(R.id.textViewFirst);
        textViewSecond = findViewById(R.id.textViewSecond);
        changeText = findViewById(R.id.changeText);
        nextActivity = findViewById(R.id.nextActivity);
        nextActivity3 = findViewById(R.id.nextActivity3);

        addListenerOnButton();

        if (getIntent().getBooleanExtra("EXIT", false)) { finish(); }
    }

    public void onChangeText(View view){
        CharSequence text = textViewSecond.getText();

        if (text == "Просто по нажатию меняется текст!") {
            textViewSecond.setText("А теперь выбери тест!");
        }else {
            textViewSecond.setText("Просто по нажатию меняется текст!");
        }

        Toast.makeText(
                MainActivity.this, "Смена текста!)",
                Toast.LENGTH_SHORT
        ).show();
    }

    public void addListenerOnButton() {

        // обработчик нажатия на кнопку "Тест 1" (nextActivity)
        nextActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".SecondActivity");
                        startActivity(intent);

                        Toast.makeText(
                                MainActivity.this, "Тестирование звука!)",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

        // обработчик нажатия на кнопку "Тест 2" (nextActivity3)
        nextActivity3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".ThirdActivity");
                        startActivity(intent);

                        Toast.makeText(
                                MainActivity.this, "Тест записи в файл!)",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

    }

}

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
    Button nextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFirst = findViewById(R.id.textViewFirst);
        textViewSecond = findViewById(R.id.textViewSecond);
        changeText = findViewById(R.id.changeText);
        nextActivity = findViewById(R.id.nextActivity);

        addListenerOnButton();

        if (getIntent().getBooleanExtra("EXIT", false)) { finish(); }
    }

    public void onChangeText(View view){
        CharSequence text = textViewSecond.getText();

        if (text == "Прикинь, кнопка теперь работает)))") {
            textViewSecond.setText("А теперь жми 'Далее'!");
        }else {
            textViewSecond.setText("Прикинь, кнопка теперь работает)))");
        }

        Toast.makeText(
                MainActivity.this, "Норм нажатие!)",
                Toast.LENGTH_SHORT
        ).show();
    }

    public void addListenerOnButton() {

        // обработчик нажатия на кнопку "Далее >>" (nextActivity)
        nextActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".SecondActivity");
                        startActivity(intent);
//                        finish();
                    }
                }
        );

    }

}

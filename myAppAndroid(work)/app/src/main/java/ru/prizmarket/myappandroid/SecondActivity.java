package ru.prizmarket.myappandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    Button exit_btn;
    Button back_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        exit_btn = findViewById(R.id.exit_btn);
        back_btn = findViewById(R.id.back_btn);

        addListenerOnButton();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Пока что ничего тут нет)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void addListenerOnButton() {

        // обработчик нажатия на кнопку "Выход" (exit_btn)
        exit_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(SecondActivity.this);
                        a_builder.setMessage("Вы хотите закрыть приложение?")
                            .setCancelable(false)
                            .setPositiveButton("Да", new DialogInterface.OnClickListener(){
                                @Override
                                public void onClick (DialogInterface dialog, int which) {
//                                    finish();

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                    intent.putExtra("EXIT", true);
                                    startActivity(intent);

                                }
                            })
                            .setNegativeButton ("Нет", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick (DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                        AlertDialog alert = a_builder.create();
                        alert.setTitle("Закрытие приложения");
                        alert.show();
                    }
                }
        );

        // обработчик нажатия на кнопку "Назад" (back_btn)
        back_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(
                                SecondActivity.this, "Норм кнопка?",
                                Toast.LENGTH_LONG
                        ).show();

                        finish();
                    }
                }
        );

    }

}

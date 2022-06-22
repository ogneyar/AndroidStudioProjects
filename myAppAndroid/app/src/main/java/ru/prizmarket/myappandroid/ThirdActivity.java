package ru.prizmarket.myappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThirdActivity extends AppCompatActivity {

    private EditText multiLine;
    private TextView textOutput;
    private Button write_btn, read_btn, prev_btn, exit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        multiLine = (EditText) findViewById(R.id.multiLine);
        textOutput = (TextView) findViewById(R.id.textOutput);
        write_btn = (Button) findViewById(R.id.write_btn);
        read_btn = (Button) findViewById(R.id.read_btn);
        prev_btn = (Button) findViewById(R.id.prev_btn);
        exit_btn = (Button) findViewById(R.id.exit_btn);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        write_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String myTxt = multiLine.getText().toString();

                        try {
                            FileOutputStream fileOutput = openFileOutput("example.txt", MODE_PRIVATE);
                            fileOutput.write(myTxt.getBytes());
                            fileOutput.close();
                            multiLine.setText("");
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(
                                ThirdActivity.this, "Записал в файл!)",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

        read_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        try {
                            FileInputStream fileInput = openFileInput("example.txt");
                            InputStreamReader reader = new InputStreamReader(fileInput);
                            BufferedReader buffer = new BufferedReader(reader);
                            StringBuffer strBuffer = new StringBuffer();
                            String lines;
                            while ((lines = buffer.readLine()) != null) {
                                strBuffer.append(lines + "\n");
                            }
                            textOutput.setText(strBuffer.toString());
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                        Toast.makeText(
                                ThirdActivity.this, "Выгрузил из файла!)",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );


        // обработчик нажатия на кнопку "Назад" (prev_btn)
        prev_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(
                                ThirdActivity.this, "Шаг назад",
                                Toast.LENGTH_LONG
                        ).show();

                        finish();
                    }
                }
        );


        // обработчик нажатия на кнопку "Выход" (exit_btn)
        exit_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(ThirdActivity.this);
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


    }

}
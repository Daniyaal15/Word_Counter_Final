package com.example.word_counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.word_counter.utils.TextCounter;

public class MainActivity extends AppCompatActivity {
    Spinner SpinnerCounting;
    EditText editTextInput;
    TextView textViewResult;
    Button button;
    String check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpinnerCounting = findViewById(R.id.SpinnerCounting);
        editTextInput = findViewById(R.id.editTextInput);
        textViewResult = findViewById(R.id.TextViewResult);
        button=findViewById(R.id.ButtonCount);
        spinner();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextInput.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Text !", Toast.LENGTH_SHORT).show();
                }
                else if (check.equals("Words"))
                {
                    wordsCount();
                }
                else if (check.equals("Char"))
                {
                characterCount();
                }

            }
        });



    }

    private void wordsCount()
    {

        int count=editTextInput.getText().toString().split(" ").length;
        textViewResult.setVisibility(View.VISIBLE);
        textViewResult.setText(String.valueOf(count));


    }

    private void characterCount()
    {
        String phrase = this.editTextInput.getText().toString();
        int CountChar = TextCounter.CountChar(phrase);
        String formattedResult = String.valueOf(CountChar);

        if(CountChar == 0){
            Toast.makeText(this, "Please type Something :D", Toast.LENGTH_LONG).show();}
        textViewResult.setVisibility(View.VISIBLE);
        textViewResult.setText(formattedResult);
    }

    private void spinner()
    {
        String[] items = new String[]{"Words", "Characters"};
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                 android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerCounting.setAdapter(adapter);
        SpinnerCounting.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        check="Words";
                        break;
                    case 1:
                        check="Char";
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


}
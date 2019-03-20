package com.rachel.polachova.aaplab2part3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button englishButton;
    Button sverigeButton;
    Button suomeskiButton;
    Button surpriseButton;
    EditText nameText;
    TextView greetingTextView;
    String greetText = "Hey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupUI();
        setEnglishButton();
        setSverigeButton();
        setSuomeskiButton();
        setSurpriseButton();
        setNameText();
    }



    void setupUI() {
        LinearLayout parent = new LinearLayout(this);
        parent.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        parent.setOrientation(LinearLayout.VERTICAL);

        nameText = new EditText(this);
        englishButton = new Button(this);
        englishButton.setText("english");
        sverigeButton = new Button(this);
        sverigeButton.setText("sverige");
        suomeskiButton = new Button(this);
        suomeskiButton.setText("suomeski");
        surpriseButton = new Button(this);
        surpriseButton.setText("surprise");
        greetingTextView = new TextView(this);
        greetingTextView.setGravity(Gravity.CENTER);
        greetingTextView.setTextSize(25);

        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        parent.addView(nameText);
        parent.addView(getRow(englishButton, sverigeButton));
        parent.addView(getRow(suomeskiButton, surpriseButton));
        parent.addView(greetingTextView);
        setContentView(parent);

    }

    void setEnglishButton () {
        englishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetText = "Hello";
                updateGreetTextView(nameText.getText().toString());
            }
        });
    }

    void setSurpriseButton() {
        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetText = "Hola";
                updateGreetTextView(nameText.getText().toString());
            }
        });
    }

    void setSuomeskiButton() {
        suomeskiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetText = "Terve";
                updateGreetTextView(nameText.getText().toString());
            }
        });
    }

    void setSverigeButton() {
        sverigeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greetText = "Hejjsan";
                updateGreetTextView(nameText.getText().toString());
            }
        });
    }

    void updateGreetTextView(String name) {
        greetingTextView.setText(greetText + " " + name);
    }

    void setNameText() {
        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateGreetTextView(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    LinearLayout getRow(View... views) {
        LinearLayout row = new LinearLayout(this);
        row.setOrientation(LinearLayout.HORIZONTAL);
        row.setGravity(Gravity.CENTER);
        for (View view: views) {
            row.addView(view);
        }

        return row;
    }
}

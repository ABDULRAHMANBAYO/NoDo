package com.example.nodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewNoDoActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "TESTING";
    private EditText nodoEditTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_no_do);

        nodoEditTextView = findViewById(R.id.edit_nodo);

        final Button button = findViewById(R.id.save_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(nodoEditTextView.getText()))
                {
                    setResult(RESULT_CANCELED,replyIntent);
                }
                else
                    {
                        String noDoString = nodoEditTextView.getText().toString();
                        replyIntent.putExtra(EXTRA_REPLY,noDoString);
                        setResult(RESULT_OK,replyIntent);
                    }
                finish();
            }
        });
    }
}

package com.cjw.test.dynamicvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cjw.test.R;

public class MainActivityDynamicVP extends AppCompatActivity {
    Button buttonAddPage;
    FragmentParent fragmentParent;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dynamicvp);
        getIDs();
        setEvents();

    }

    private void getIDs() {
        buttonAddPage = (Button) findViewById(R.id.buttonAddPage);
        fragmentParent = (FragmentParent) this.getSupportFragmentManager().findFragmentById(R.id.fragmentParent);
        textView = (TextView) findViewById(R.id.editTextPageName);
    }

    private void setEvents() {
        buttonAddPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!textView.getText().toString().equals("")) {
                    fragmentParent.addPage(textView.getText() + "");
                    textView.setText("");
                } else {
                    Toast.makeText(MainActivityDynamicVP.this, "Page name is empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

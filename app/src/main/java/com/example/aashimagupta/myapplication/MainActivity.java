package com.example.aashimagupta.myapplication;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button button;
    EditText t;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from activity_main.xml
        setContentView(R.layout.activity_main);
        // Locate the button in activity_main.xml
        button = (Button) findViewById(R.id.button3);
        t = (EditText) findViewById(R.id.editText);
        // Capture button clicks
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Start NewActivity.class

//                Toast.makeText(MainActivity.this, t.getTextetText() "", Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(MainActivity.this,SecondActivity.class);
                myIntent.putExtra("noOfButtons",t.getText().toString().trim());
                startActivity(myIntent);
            }
        });
    }
}
package com.example.aashimagupta.myapplication;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
public class SecondActivity extends AppCompatActivity {
    int noOfButtons;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        noOfButtons = Integer.parseInt(getIntent().getStringExtra("noOfButtons"));
        TableLayout layout = (TableLayout) findViewById(R.id.table);
        TableLayout.LayoutParams p = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT
        );
        int counter = 1;
        double noOfTimesPatternIsToBeRepeated = Math.ceil(noOfButtons/6);
        int subCounter = 1;
        for(int j=1;j<=noOfTimesPatternIsToBeRepeated;j++){
            if(subCounter == 1){
                TableRow tr_head = new TableRow(this);
                tr_head.setLayoutParams(new LayoutParams(
                        LayoutParams.FILL_PARENT,
                        LayoutParams.WRAP_CONTENT));
                int noOfBtnsToAddedInThisSubCounter = 3;
                while(noOfBtnsToAddedInThisSubCounter>0){
                    if(counter<=noOfButtons){
                        Button buttonView = new Button(this);
                        buttonView.setText(counter);
                        buttonView.setId(counter);
                        counter++;
                        buttonView.setOnClickListener(mThisButtonListener);
                        tr_head.addView(buttonView, p);
                    }
                    noOfBtnsToAddedInThisSubCounter--;
                }
                layout.addView(tr_head);
                subCounter++;
                if(counter >= noOfButtons)
                    break;
            }
            if(subCounter == 2){
                TableRow tr_head = new TableRow(this);
                tr_head.setLayoutParams(new LayoutParams(
                        LayoutParams.FILL_PARENT,
                        LayoutParams.WRAP_CONTENT));
                if(counter<= noOfButtons) {
                    Button buttonView1 = new Button(this);
                    buttonView1.setText(counter);
                    buttonView1.setId(counter);
                    counter++;
                    buttonView1.setOnClickListener(mThisButtonListener);
                    tr_head.addView(buttonView1, p);
                }
                layout.addView(tr_head);
                subCounter++;
                if(counter >= noOfButtons)
                    break;
            }
            if(subCounter == 3){
                TableRow tr_head = new TableRow(this);
                tr_head.setLayoutParams(new LayoutParams(
                        LayoutParams.FILL_PARENT,
                        LayoutParams.WRAP_CONTENT));
                int noOfBtnsToAddedInThisSubCounter = 2;
                while(noOfBtnsToAddedInThisSubCounter>0){
                    if(counter<=noOfButtons){
                        Button buttonView = new Button(this);
                        buttonView.setText(counter);
                        buttonView.setId(counter);
                        counter++;
                        buttonView.setOnClickListener(mThisButtonListener);
                        tr_head.addView(buttonView, p);
                    }
                    noOfBtnsToAddedInThisSubCounter--;
                }
                layout.addView(tr_head);
                subCounter = 1;
                if(counter >= noOfButtons)
                    break;
            }
        }
    }
    private OnClickListener mThisButtonListener = new OnClickListener() {
        public void onClick(View v) {
            int idOfButtonClicked = v.getId();
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle("Button clicked");
            alertDialogBuilder.setMessage(String.valueOf(idOfButtonClicked)).setCancelable(false)
                    .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, close
                            // current activity
                            SecondActivity.this.finish();
                        }
                    })
                    .setNegativeButton("No",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    };
}

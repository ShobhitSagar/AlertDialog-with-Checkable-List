package com.example.shobhitsagar.andy101;

import android.os.Bundle;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CharSequence[] items = {"Red", "Orange", "Blue"};
    boolean[] itemsChecked = new boolean[items.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        showDialog(0);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case 0:
                return new AlertDialog.Builder(this)
                        .setIcon(R.drawable.ic_hshsh)
                        .setTitle("This is a dialog with simple text...")
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        Toast.makeText(getBaseContext(), "OK Clicked!", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        Toast.makeText(getBaseContext(), "Cancel Clicked!", Toast.LENGTH_SHORT).show();
                                    }
                                })
                        .setMultiChoiceItems(items, itemsChecked,
                                new DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                        Toast.makeText(getBaseContext(),items[which] + (isChecked ? " Checked!":" Unchecked!"), Toast.LENGTH_SHORT).show();
                                    }
                                }).create();
        }
        return null;
    }

}

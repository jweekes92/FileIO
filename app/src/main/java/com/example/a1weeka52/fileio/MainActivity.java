package com.example.a1weeka52.fileio;

import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu (Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_save, menu);
        return true;
    }

    public boolean onOptionsItemsSelected(MenuItem item)
    {
        if(item.getItemId() ==R.id.save)
        {
            try
            {
                PrintWriter pw = new PrintWriter(new FileWriter(Environment.getExternalStorageDirectory().getAbsolutePath() + "/save.txt"));
                EditText et1 = (EditText)findViewById(R.id.et1);
                pw.println(et1.getText().toString());
                pw.close();
            }
            catch (IOException e)
            {
                new AlertDialog.Builder(this).setMessage("ERROR: " + e).setPositiveButton("OK",null).show();
            }
        }
        if(item.getItemId() ==R.id.load)
            try
            {
                FileReader fr = new FileReader(Environment.getExternalStorageDirectory().getAbsolutePath() + "/load.txt");
                BufferedReader reader = new BufferedReader(fr);
                String line = "";
                while ((line=reader.readLine()) !=null)
            }
    }
}

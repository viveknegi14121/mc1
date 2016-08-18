package com.example.vivek.mc1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    static int countc=0,counti=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null)
        {
            Button correct=(Button)findViewById(R.id.correct);
            Button incorrect=(Button)findViewById(R.id.incorrect);

            int btn=savedInstanceState.getInt("btntoggle");
            if(btn==1)
            {
                correct.setEnabled(true);
                incorrect.setEnabled(true);
                //Log.d("str","1");

            }
            else
            {
                correct.setEnabled(false);
                incorrect.setEnabled(false);
                //Log.d("str","0");
            }
            int p=savedInstanceState.getInt("currentprime");
            TextView a=(TextView)findViewById(R.id.t1);
            TextView b=(TextView)findViewById(R.id.nct);
            TextView c=(TextView)findViewById(R.id.nit);
            a.setText(Integer.toString(p));
            b.setText(Integer.toString(countc));
            c.setText(Integer.toString(counti));
        }
        else{
            TextView a=(TextView)findViewById(R.id.t1);
            Random rn = new Random();
            int randomNum =  rn.nextInt(1001);
            a.setText(Integer.toString(randomNum));
        }
    }

    public void oncn(View v)
    {
        Button correct=(Button)findViewById(R.id.correct);
        Button incorrect=(Button)findViewById(R.id.incorrect);
        TextView a=(TextView)findViewById(R.id.t1);
        Random rn = new Random();
        int randomNum =  rn.nextInt(1001);
        a.setText(Integer.toString(randomNum));
        correct.setEnabled(true);
        incorrect.setEnabled(true);
    }

    public void oncc(View v)
    {
        TextView a=(TextView)findViewById(R.id.t1);
        TextView b=(TextView)findViewById(R.id.nct);
        TextView c=(TextView)findViewById(R.id.nit);
        Button correct=(Button)findViewById(R.id.correct);
        Button incorrect=(Button)findViewById(R.id.incorrect);
        int n=Integer.parseInt(a.getText().toString());
        //a.setText(Integer.toString(randomNum));
        int c1=0;
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0) {
                c1++;
                break;
            }
        }
        if(c1==0)
        {
            countc++;
            Toast.makeText(getApplicationContext(),"True",1000).show();
        }
        else
        {
            counti++;
            Toast.makeText(getApplicationContext(), "False",1000).show();
        }
        correct.setEnabled(false);
        incorrect.setEnabled(false);
        b.setText(Integer.toString(countc));
        c.setText(Integer.toString(counti));
    }

    public void onci(View v)
    {
        TextView a=(TextView)findViewById(R.id.t1);
        TextView b=(TextView)findViewById(R.id.nct);
        TextView c=(TextView)findViewById(R.id.nit);
        int n=Integer.parseInt(a.getText().toString());
        //a.setText(Integer.toString(randomNum));
        Button correct=(Button)findViewById(R.id.correct);
        Button incorrect=(Button)findViewById(R.id.incorrect);
        int c1=0;
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0) {
                c1++;
                break;
            }
        }
        if(c1==1)
        {
            countc++;
            Toast.makeText(getApplicationContext(), "True",1000).show();
        }
        else
        {
            counti++;
            Toast.makeText(getApplicationContext(), "False",1000).show();
        }
        correct.setEnabled(false);
        incorrect.setEnabled(false);
        b.setText(Integer.toString(countc));
        c.setText(Integer.toString(counti));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        //outState.putString("u",str);
        Button correct=(Button)findViewById(R.id.correct);
        //Button incorrect=(Button)findViewById(R.id.incorrect);
        if(correct.isEnabled())
            outState.putInt("btntoggle",1);
        else
            outState.putInt("btntoggle",0);

        TextView a=(TextView)findViewById(R.id.t1);
        int n=Integer.parseInt(a.getText().toString());
        outState.putInt("currentprime",n);
    }
}

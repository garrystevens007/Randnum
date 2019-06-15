package com.example.randnum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText lownum,highnum;
    TextView resnum;
    Button generate;

    Random rand;
    int min,max,resout;
    float numb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lownum = (EditText)findViewById(R.id.lownum);
        highnum = (EditText)findViewById(R.id.highnum);
        generate = (Button)findViewById(R.id.generate);
        resnum = (TextView)findViewById(R.id.resnum);

        rand = new Random();

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempMin, tempMax;
                tempMin = lownum.getText().toString();
                tempMax = highnum.getText().toString();

                if (!tempMin.equals("") && !tempMax.equals("")) {
                    min = Integer.parseInt(tempMin);
                    max = Integer.parseInt(tempMax);
                    if(min%2!=0 && min%1!=0){
                        resnum.setText("Only decimal number input !");
                    }
                    if(max > min) {
                        resout = rand.nextInt((max - min) + 1) + min;
                        resnum.setText("" + resout);
                    }else{
                        resnum.setText("Please input the correct way");
                    }
                }else{
                    resnum.setText("Please input both number");
                }
            }
        });
    }
}

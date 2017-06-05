package com.example.anirudhs.colourcontroller;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int r=0,b=0,g=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView2 = (TextView)findViewById(R.id.textView2);
        final TextView textView3 = (TextView)findViewById(R.id.textView3);
        final TextView textView4 = (TextView)findViewById(R.id.textView4);
        Button button = (Button)findViewById(R.id.button);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);
        Button resetButton = (Button)findViewById(R.id.resetButton);

        final RelativeLayout appScreen = (RelativeLayout)findViewById(R.id.activity_main);
        appScreen.setBackgroundColor(Color.rgb(0,0,0));


        button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        if(r==255)
                            r=0;
                        else
                            r++;
                       appScreen.setBackgroundColor(Color.rgb(r,g,b));
                        textView2.setText(Integer.toString(r));


                    }
                }
        );

        button2.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        if(b==255)
                            b=0;
                        else
                            b++;

                        appScreen.setBackgroundColor(Color.rgb(r,g,b));
                        textView3.setText(Integer.toString(b));
                    }
                }
        );
        button3.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        if(g==255)
                            g=0;
                        else
                            g++;

                        appScreen.setBackgroundColor(Color.rgb(r,g,b));
                        textView4.setText(Integer.toString(g));
                    }
                }
        );
        resetButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        r=0;
                        b=0;
                        g=0;
                        appScreen.setBackgroundColor(Color.rgb(r,g,b));
                        textView4.setText(Integer.toString(g));
                        textView3.setText(Integer.toString(b));
                        textView2.setText(Integer.toString(r));

                    }
                }
        );
    }
        private void storeColour(int colour){
        SharedPreferences sharedPref = getSharedPreferences("Background colour",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("colour",colour);

        editor.apply();
    }
    private int getColour(){
        SharedPreferences sharedPref = getSharedPreferences("Background colour",MODE_PRIVATE);
        int selectedColour =sharedPref.getInt("colour",Color.rgb(0,0,0));
        return selectedColour;
    }

}

package com.example.handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    public  static final String TAG ="ASYNC";
    Button btnColorChange;
    ListView lvItems;
    ConstraintLayout clBackground;
    String[] items =new String[]{
            "Messi",
            "Ronaldo",
            "kaka",
            "pele",
            "Neymar",
            "beckham",
            "saurez",
            "lewandoski",
            "muller",
            "iniesta",
            "xavi"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnColorChange = findViewById(R.id.btnColorChange);
        lvItems =findViewById(R.id.lvItems);
        clBackground=findViewById(R.id.clBackground);
        ArrayAdapter<String> itemAdapter =new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items
        ) ;
        lvItems.setAdapter(itemAdapter);
        btnColorChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler h = new Handler();
                Runnable r=new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG,"run : we have waited 5 second");
                        clBackground.setBackgroundColor(Color.YELLOW);
                    }
                };

                h.postDelayed(r,5000) ;

            }
        });



    }
    void wait1Sec()
    {
        long startTime = System.currentTimeMillis();
        while( startTime + 1000 > System.currentTimeMillis());
    }
    void waitNsec(int n){
        for(int i=0;i<n;i++){
            wait1Sec();
        }
    }
}

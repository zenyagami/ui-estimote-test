package com.zenkun.beaconcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.main_app_title);
    }


    public int getVoltage(int[] payload)
    {
        int size = payload.length;
        //if size is less than 18 we cant get the byte for battery  voltage
        if(size>=18)
        {
            // we need ignore the first 2 bits of the byte 17 and take the rest and all from byte 18
            //we use as complement 0b11111100 and avoiding filling with zero on the right
            int byte17 =(payload[17])&0xFF & 0b11111100 >>2;
            int byte18=payload[18];

            //battery is 14 bits, 2 bytes
           //im using bitwise operator <<6 to create 6 zeros to the right of the byte18 so i can make a sum with the 6 bits from byte17 variable
            //im using bitwise |  (inclusive or) to "sum" the numbers so basically when the bit on the variable 17 is 1 the byte 18 on the right will be 1.

            return payload[18]<<6 | byte17;
        }
        return -1;

    }

}

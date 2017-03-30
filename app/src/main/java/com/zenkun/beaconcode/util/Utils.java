package com.zenkun.beaconcode.util;

import android.util.Log;

import com.zenkun.beaconcode.R;
import com.zenkun.beaconcode.model.ModelCoffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Zen zenyagami@gmail.com on 24/02/2017.
 */

public class Utils {
    //hardcoded for demo purpose
    public static final String[] title= new String[]{"Extra Espresso","Cafe Latte","Chocolate"};
    public static final int[] drawableResources= new int[]{R.drawable.espresso,R.drawable.latte,R.drawable.chocolate};

    public static List<ModelCoffee> getRandomCoffeData()
    {
        Random random = new Random();
        //title and drawable resource should be the same size...
        int randomSize = title.length;
        List<ModelCoffee> list= new ArrayList<>();
        //we need add one more for header (empty)
        list.add(null);

        int ran1 = random.nextInt(randomSize);
        for (int i=0;i<5;i++)
        {
            ModelCoffee m = new ModelCoffee();
            m.title = title[ran1];
            m.resourcePhoto = drawableResources[ran1];
            m.isStarred = (i<= randomSize/3); //just the first  1/3 of  the list are starred
            list.add(m);
            ran1 =random.nextInt(randomSize);
        }
        return list;
    }


}

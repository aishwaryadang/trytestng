package com.ad.DataForTests;

import org.testng.annotations.DataProvider;

public class DataProvisiong {

    @DataProvider(name = "dataForPost")
    public Object[][] dataForPost(){
        Object[][] data = new Object[2][2];

        data[0][0] = "Goku";
        data[0][1] = "Saiyan";

        data[1][0] = "Beerus";
        data[1][1] = "Destroyer";

        return data;
    }

    @DataProvider(name = "DataForDelete")
    public Object[][] dataForDelete(){

        Object[][] arr = new Object[2][1];
        arr[0][0] = 1;
        arr[1][0] = 2;
        return arr;
    }
}

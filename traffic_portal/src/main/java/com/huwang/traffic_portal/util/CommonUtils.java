package com.huwang.traffic_portal.util;


import java.util.HashMap;
import java.util.Map;

public class CommonUtils {

    private static Map<Integer,Integer> zooms=new HashMap<>();
    private static double screenSize=50;//默认屏幕尺寸为50cm
    private static double atUnit=100000;//默认单位经纬度间距(m)
    public static String LOADTYPE="LOAD";


    static{
        zooms.put(3,2000000);
        zooms.put(4,1000000);
        zooms.put(5,500000);
        zooms.put(6,200000);
        zooms.put(7,100000);
        zooms.put(8,50000);
        zooms.put(9,25000);
        zooms.put(10,20000);
        zooms.put(11,10000);
        zooms.put(12,5000);
        zooms.put(13,2000);
        zooms.put(14,1000);
        zooms.put(15,500);
        zooms.put(16,200);
        zooms.put(17,100);
        zooms.put(18,50);
        zooms.put(19,20);
    }

    public static double ZoomTransform(int unit)
    {
        int zoom=zooms.get(unit);
        return ((double)zoom*screenSize)/atUnit;
    }
}

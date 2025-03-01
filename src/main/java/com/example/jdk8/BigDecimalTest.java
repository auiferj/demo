package com.example.jdk8;

import org.apache.poi.hpsf.Decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTest {

    public static void main(String[] args) {
        String a = "56.0000";
        BigDecimal bigDecimala = new BigDecimal(a);
        //去末尾0
        BigDecimal bigDecimalb = bigDecimala.stripTrailingZeros();
        System.out.println(bigDecimalb.toString());//直接使用toString,可能得到科学计数法的值。
        System.out.println(bigDecimalb.toPlainString());//要得到本来值，用toPlainString

        //几位小数
        int scale = bigDecimala.scale();
        System.out.println(scale);

        if(scale > 2){
            BigDecimal bigDecimalc = bigDecimalb.setScale(2, RoundingMode.HALF_UP);
        }

    }
}

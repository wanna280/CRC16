package com.example.demo.util;

import java.util.ArrayList;

public class CheckSums {
    public static int GetCheckSum(ArrayList<Integer> ten) {  //生成校验和
        int checkSumNum = 0;   //检验和
        int sum = 0;  //保存所有内容的十六进制之和，每次读取2Bytes，也就是16bits
        for (int i = 0; i < ten.size(); i++) {
            sum += ten.get(i);  //求出所有元素之和
        }
        int ffff = Integer.parseInt("FFFF", 16);   //得到16bits的最大数0xFFFF的十进制数
        if (sum > ffff) {   //如果检验和＞0xFFFF
            int carry = sum & ffff;   //得到高16bits
            System.out.println("效验和的高16bits为" + Integer.toHexString(carry).toUpperCase());
            int low_16_bits = sum >> 16;   //得到低16bits
            System.out.println("效验和的低16bits为" + Integer.toHexString(low_16_bits).toUpperCase());
            checkSumNum = carry + low_16_bits;  //得到校验和
        }
        return checkSumNum;
    }
}

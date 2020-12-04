package com.example.demo.util;

import java.util.ArrayList;

public class TransForm {

    static ArrayList<String> hex = new ArrayList<>();   //hex存放字节的十六进制字符串数组
    static ArrayList<Integer> ten = new ArrayList<>();   //将hex直接转换为10进制

    public static ArrayList<String> GetHexList(byte[] bytes){  //得到十六进制列表
        for (int i = 0; i < bytes.length; i++) {
            String str = Integer.toHexString(bytes[i]).toUpperCase();  //将小写转换成大写
            if (i % 2 == 0 && i != bytes.length - 1) {  //如果i是偶数，并且i不是最后一个元素，是两个字母拼接成一个字符串
                String hexStr = str + Integer.toHexString(bytes[i + 1]).toUpperCase();
                hex.add(hexStr);
            } else if (i % 2 == 0 && i == bytes.length - 1) {  //如果i是偶数并且i是最好一个元素，在最后拼接00
                String hexStr = str + "00";
                hex.add(hexStr);
            } else {

            }

        }
        return hex;
    }

    public static ArrayList<Integer> GetTenList(ArrayList<String> Hex){  //得到十进制列表
        for (int i = 0;i<Hex.size();i++){
            int tenNum = Integer.parseInt(Hex.get(i),16);  //从16进制解析
            ten.add(tenNum);   //直接将其内容加入十进制的列表
        }
        return ten;
    }

    public static ArrayList<Integer> GetTenList(byte[] bytes){   //得到十进制文件列表
        if(hex == null){   //如果hex为空，执行一遍GetHexList，否则直接执行GetTenList
           GetHexList(bytes);
        }

        return GetTenList(hex);
    }
}

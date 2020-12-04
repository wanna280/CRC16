package com.example.demo.util;

import java.io.*;

public class FileOp {  //文件操作类
    public static void WriteFile(String pathName, String content) {  //写文件
        File file = new File(pathName);    //创建一个文件指针
        if (!file.exists()) {   //如果文件不存在，创建一个文件
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(file, true);  //true表示附加
            } catch (IOException e) {
                e.printStackTrace();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            try {
                bufferedWriter.write(content);   //向缓冲区写内容
                bufferedWriter.flush();  //刷新缓冲区
                bufferedWriter.close();  //关闭缓冲区指针
                fileWriter.close();  //关闭写文件的指针
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static String ReadFile(String pathName){   //读文件
        FileReader fileReader = null;  //创建一个读文件指针
        try {
            fileReader = new FileReader(pathName);  //初始化读文件指针，指向传入的路径的文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);  //创建一个读缓冲区指针
        String content = "";  //content存储读取出来的文件的内容的第一行
        try {
            content = bufferedReader.readLine();  //读一行
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}

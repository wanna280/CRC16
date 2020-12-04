package com.example.demo;

import com.example.demo.util.CheckSums;
import com.example.demo.util.FileOp;
import com.example.demo.util.TransForm;

import java.util.ArrayList;

public class DemoApplication {

	public static void main(String[] args) {
		String pathName = (args[0]==null?"check_sum.txt":args[0]);   //如果为空，则默认为check_sum.txt
		FileOp.WriteFile(pathName, "Hello world.");  //如果check_sum.txt未被创建，创建这个文件并且写入内容
		String content = FileOp.ReadFile(pathName);   //读取文件到content中
		System.out.println("读取的" + pathName + "文件的内容是:" + content);  //打印文件内容
		byte[] bytes = content.getBytes();   //调用getBytes方法将读取的文件内容转为为ASCII码的格式
		String status_bytes = (bytes.length % 2 == 0 ? "偶数" : "奇数");  //status_bytes保存文件的字符是奇数还是偶数
		System.out.println("读取到的文件字节的数量为："+status_bytes);   //打印文件的字节数量是奇数还是偶数
		ArrayList<String> hex = TransForm.GetHexList(bytes);   //hex存放字节的十六进制字符串数组
		ArrayList<Integer> ten = TransForm.GetTenList(bytes);   //将hex直接转换为10进制
		System.out.println("读取到的文件的十六进制为：");
		for (int i = 0; i < hex.size(); i++) {  //打印文件的十六进制形式
			System.out.print("0x" + hex.get(i));
			if(i!=hex.size()-1){   //如果不是最后一个元素，拼接-，表示连接
				System.out.print("-");
			}else{
				System.out.println();   //如果是最后一个元素，换行打印
			}
		}
		int checkSumNum = CheckSums.GetCheckSum(ten);  //得到检验和
		String hexCheckSum = Integer.toHexString(checkSumNum);   //将数字转换为十六进制
		System.out.println("数据的效验和为："+"0x"+hexCheckSum.toUpperCase());
	}

}

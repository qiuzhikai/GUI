package demo1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class file {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter f = new FileWriter("data1.txt", true);
		BufferedWriter out = new BufferedWriter(f); 
		String s="1:2:asd";
		String []s1=s.split(":");
		System.out.println(s1[2]);
        out.write("我会写入文件啦\r\n"); // \r\n即为换行  
        out.write("我会写入文件啦\r\n");
        out.flush(); // 把缓存区内容压入文件  
        out.close(); // 最后记得关闭文件
        File filename1 = new File("data1.txt"); 
        BufferedWriter out1 = new BufferedWriter(new FileWriter(filename1));
        out1.write("");
        out1.close();
        File filename = new File("data1.txt"); // 要读取以上路径的input。txt文件  
        InputStreamReader reader = new InputStreamReader(  
                new FileInputStream(filename)); // 建立一个输入流对象reader  
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
        String line = "";  
        line = br.readLine();  
        if (line == null) {  
            System.out.println("no");
        }else{
        	System.out.println("yes");
        }
	}

}

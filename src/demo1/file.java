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
        out.write("�һ�д���ļ���\r\n"); // \r\n��Ϊ����  
        out.write("�һ�д���ļ���\r\n");
        out.flush(); // �ѻ���������ѹ���ļ�  
        out.close(); // ���ǵùر��ļ�
        File filename1 = new File("data1.txt"); 
        BufferedWriter out1 = new BufferedWriter(new FileWriter(filename1));
        out1.write("");
        out1.close();
        File filename = new File("data1.txt"); // Ҫ��ȡ����·����input��txt�ļ�  
        InputStreamReader reader = new InputStreamReader(  
                new FileInputStream(filename)); // ����һ������������reader  
        BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
        String line = "";  
        line = br.readLine();  
        if (line == null) {  
            System.out.println("no");
        }else{
        	System.out.println("yes");
        }
	}

}

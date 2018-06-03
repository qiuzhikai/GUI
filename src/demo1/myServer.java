package demo1;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Queue;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class myServer implements Runnable {
	private ServerSocket ss;
	private JTextArea jt;
	private JLabel jl;
//
//	public void sendToken(int x) throws UnknownHostException, IOException{
//		int port=10000+x%7;
//        Socket s= new Socket("192.168.138.1",port);
//        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
//        out.println("Token".getBytes());
//        s.shutdownOutput();
//        s.close();
//	}
	public void send(String str,Socket s,int num) throws IOException{
		File filename = new File(str); // 要读取以上路径的input。txt文件  
        InputStreamReader reader = new InputStreamReader(  
                new FileInputStream(filename)); // 建立一个输入流对象reader  
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
        String line = "";  
        line = br.readLine();       
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        while(line != null)
        {
        	if(line.split(":").length!=3){
        		int x=0;
        		Random ran1 = new Random();
        		x=ran1.nextInt(9);
        		while(x==num||x==0)
        		{
        			x=ran1.nextInt(9);
        			System.out.println(x);
        		}
        		line=String.valueOf(num)+":"+String.valueOf(x)+":"+line;
        		this.jt.append(line+"\r\n");
        		System.out.println(line);
        	}
        	out.println(line);
        	line = br.readLine(); 
        }
        s.shutdownOutput();
        //终止
        File filename1 = new File(str); 
        BufferedWriter out1 = new BufferedWriter(new FileWriter(filename1));
        out1.write("");
        out1.close();
        
        s.close();
	}
	public myServer(ServerSocket ss,JTextArea jt,JLabel jl)
	{
		super();
		this.ss=ss;
		this.jt=jt;
		this.jl=jl;
		//this.queue=queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
				Socket s;
				boolean flag=false;
//				jt.append("123\r\n");
//				jt.append("123\r\n");
			try {
				int port;
				s = ss.accept();
				port=s.getLocalPort();
				int x=port-10000;
				x++;
				port=10000+x%8;
				
				String ip=s.getInetAddress().getHostAddress();
				System.out.println(ip+".....connected");
				BufferedReader bufIn =new BufferedReader(new InputStreamReader(s.getInputStream()));
				String str=null;
				System.out.println(port);
				Socket s1= new Socket("192.168.138.1",port);	        	
	            PrintWriter out = new PrintWriter(s1.getOutputStream(),true);
				while((str=bufIn.readLine())!=null)
				{
					System.out.println(str);
					if(str.equals("Token")){
						this.jl.setBorder(BorderFactory.createLineBorder(Color.green,2));
						String name="data"+String.valueOf(x)+".txt";
						System.out.println(name);
						File filename = new File(name); // 要读取以上路径的input。txt文件  
				        InputStreamReader reader = new InputStreamReader(  
				                new FileInputStream(filename)); // 建立一个输入流对象reader  
				        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
				        String line = "";  
				        line = br.readLine();
				        if(line==null)
				        {	
				        	try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				            out.println("Token");
				            //s1.shutdownOutput();
				            //s1.close();
				            System.out.println(String.valueOf(port)+"send Token");
				            this.jl.setBorder(BorderFactory.createLineBorder(Color.blue,2));
				        }else{
				        	send(name,s1,x);
				        	try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				        }
					}else{
						String []info=str.split(":");
						if(info[0].equals(String.valueOf(x))){
							flag=true;
							//sendToken(x);
						}else if(info[1].equals(String.valueOf(x))){
							this.jt.append(info[0]+":"+info[2]+"\r\n");
							out.println(str);
						}else{
							out.println(str);
						}
					}
				}
				if(flag){
					out.println("Token");
		            //s1.shutdownOutput();
		            this.jl.setBorder(BorderFactory.createLineBorder(Color.blue,2));
		            flag=false;
		            //s1.close();
				}
				s1.shutdownOutput();
	            s1.close();
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
	}

}

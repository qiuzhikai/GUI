package demo1;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class demo {
	//private static JTextField textField;

	private Queue<String> queue;
	public static void setServer(int x,JTextArea jt,JLabel jl) throws IOException
	{
		System.out.println("服务器端启动。。。。");
		
		ServerSocket ss= new ServerSocket(x-1);
		new Thread(new myServer(ss,jt,jl)).start();		
	}
	
	public static void send() throws UnknownHostException, IOException{
		System.out.println("客户端启动。。。。");
		//1.创建客户端对象，明确目的地址和端口
		Socket s= new Socket("192.168.138.1",10000);
		//2.获取socket流中的输出流，将数据发送给服务器
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		//3.通过输出流写数据
		
		out.println("Token");
		s.shutdownOutput();

		s.close();
	}
	
	public static void write(String str,int x) throws IOException{
		FileWriter f = new FileWriter("data"+String.valueOf(x)+".txt", true);
		BufferedWriter out = new BufferedWriter(f);
		out.write(str);
		out.flush(); // 把缓存区内容压入文件  
        out.close();
	}
	public void create(final int num){
		final demo d = new demo();
//		d.setServer(10003);
//		demo d1 = new demo();
//		System.out.println("123");
//		d1.setServer(10004);
//		d.send("123123", 10004);
//		d1.send("321", 10003);
//		d1.send("321", 10003);

		final JFrame frame = new JFrame("主机"+String.valueOf(num));
		if(num<5){
			frame.setLocation(380*num, 100);
		}else{
			frame.setLocation(380*(num-4), 600);
		}
		//frame.setLocation(100, 100);
	    frame.setSize(369, 456);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
	    

	    
	    final JPanel panel_1 = new JPanel();
	    panel_1.setBounds(14, 13, 323, 383);
	    frame.getContentPane().add(panel_1);
	    panel_1.setLayout(null);
	    
	    JButton btnNewButton = new JButton("发送");
	    
	    btnNewButton.setBounds(229, 307, 94, 27);
	    panel_1.add(btnNewButton);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(14, 295, 201, 39);
	    panel_1.add(scrollPane);
	    
	    final JTextArea textArea_1 = new JTextArea();
	    scrollPane.setViewportView(textArea_1);
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(14, 13, 295, 252);
	    panel_1.add(scrollPane_1);
	    
	    final JTextArea textArea = new JTextArea();
	    scrollPane_1.setViewportView(textArea);
	    
	    final JLabel label_1 = new JLabel("令牌");
	    label_1.setBounds(118, 352, 72, 18);
	    label_1.setBackground(Color.blue);
	    panel_1.add(label_1);
	    label_1.setBorder(BorderFactory.createLineBorder(Color.blue,2));
	    panel_1.setVisible(true);	    
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String str=textArea_1.getText();
	    		str=str+"\r\n";
	    		textArea.append(str);
	    		try {
	    			int x=num;
					write(str,x);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		textArea_1.setText("");
	    	}
	    });
	    try {
			d.setServer(10000+num,textArea, label_1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    if(num==8){
	    	try {
				d.send();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
        frame.setVisible(true);
	}
	public static void main(String[] args) throws IOException {
		final demo d = new demo();
//		d.setServer(10003);
//		demo d1 = new demo();
//		System.out.println("123");
//		d1.setServer(10004);
//		d.send("123123", 10004);
//		d1.send("321", 10003);
//		d1.send("321", 10003);

		final JFrame frame = new JFrame("主机");
		frame.setLocation(500, 500);
	    frame.setSize(369, 456);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(null);
	    
	    final JPanel panel = new JPanel();
	    panel.setBounds(59, 48, 211, 275);
	    frame.getContentPane().add(panel);
	    panel.setLayout(null);
	    
	    JLabel label = new JLabel("主机名");
	    label.setBounds(14, 34, 60, 18);
	    panel.add(label);
	    final JTextField textField;
	    textField = new JTextField();
	    textField.setBounds(75, 31, 122, 24);
	    panel.add(textField);
	    textField.setColumns(10);
	    
	    JButton bt= new JButton("创建");
	    
	    bt.setBounds(14, 112, 183, 27);
	    panel.add(bt);
	    
	    final JPanel panel_1 = new JPanel();
	    panel_1.setBounds(14, 13, 323, 383);
	    frame.getContentPane().add(panel_1);
	    panel_1.setLayout(null);
	    
	    JButton btnNewButton = new JButton("发送");
	    
	    btnNewButton.setBounds(229, 307, 94, 27);
	    panel_1.add(btnNewButton);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(14, 295, 201, 39);
	    panel_1.add(scrollPane);
	    
	    final JTextArea textArea_1 = new JTextArea();
	    scrollPane.setViewportView(textArea_1);
	    
	    JScrollPane scrollPane_1 = new JScrollPane();
	    scrollPane_1.setBounds(14, 13, 295, 252);
	    panel_1.add(scrollPane_1);
	    
	    final JTextArea textArea = new JTextArea();
	    scrollPane_1.setViewportView(textArea);
	    
	    final JLabel label_1 = new JLabel("令牌");
	    label_1.setBounds(118, 352, 72, 18);
	    label_1.setBackground(Color.blue);
	    panel_1.add(label_1);
	    label_1.setBorder(BorderFactory.createLineBorder(Color.blue,2));
	    panel_1.setVisible(false);
	    bt.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel.setVisible(false);
	    		panel_1.setVisible(true);
	    		frame.setTitle("主机"+textField.getText());
	    		String str=textField.getText();
	    		int x=10000;
	    		x=x+Integer.valueOf(str);
	    		try {
					d.setServer(x,textArea, label_1);
					if(x==10008)
					{
						d.send();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    });
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String str=textArea_1.getText();
	    		str=str+"\r\n";
	    		textArea.append(str);
	    		try {
	    			String str1=textField.getText();
	    			int x=Integer.valueOf(str1);
					write(str,x);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		textArea_1.setText("");
	    	}
	    });
        frame.setVisible(true);
	}
}



package demo1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class draw{
	public static void main(String[] args) {
		JFrame frame =new JFrame();
		frame.setLocation(500, 500);
	    frame.setSize(350, 200);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel panel = new JPanel();
	    panel.setLayout(null);
	    //panel.setBackground(Color.black);
	    JTextField jt=new JTextField();
	    jt.setBounds(50, 50, 300, 5);
	    jt.setBackground(Color.BLACK);
	    panel.add(jt);
	    frame.add(panel);
	    frame.setVisible(true);
	}
}
//public class draw extends JFrame{
//	 public draw() {
//	        this.add(new DrawPanel());//������ӻ��ߵ�JPanel
//	        this.setTitle("���ߴ���");//���ڱ���
//	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رյĲ���
//	        this.setLocation(100, 200);//����λ��
//	        this.setSize(500, 500);//���ڴ�С
//	        this.setVisible(true);//���ڿɼ�
//	    }
//	 
//	    public static void main(String[] args) {
//	        draw frame=new draw();
//	        JPanel panel = new JPanel();
//	        JButton loginButton = new JButton("����1");
//	        loginButton.setLocation(200, 50);
//	        loginButton.setSize(100, 30);
//	        loginButton.setBackground(Color.GREEN);
//	        panel.add(loginButton);
//	        frame.add(panel);
//	    }
//}
//
//class DrawPanel extends JPanel {//���ߵ�JPanel
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        //����ȷ��һ��ֱ��.  ������(����ͬһֱ��)�������ӾͿ��Գ�Ϊ������
//        g.setColor(Color.RED);//���õ�һ���ߵ���ɫ
//        g.drawLine(50, 50, 100, 100);//����һ���� ��(50,50) ����  (100,100)
//        g.setColor(Color.BLUE);
//        g.drawLine(50, 50, 50, 150);//���ڶ����� ��(50,50) ����  (50,150)
//        g.setColor(Color.GREEN);
//        g.drawLine(50, 150, 100, 100);//���������� ��(50,150) ����  (100,100)
//    }
//}


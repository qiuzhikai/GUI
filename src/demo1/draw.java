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
//	        this.add(new DrawPanel());//窗口添加画线的JPanel
//	        this.setTitle("画线窗口");//窗口标题
//	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭的操作
//	        this.setLocation(100, 200);//窗口位置
//	        this.setSize(500, 500);//窗口大小
//	        this.setVisible(true);//窗口可见
//	    }
//	 
//	    public static void main(String[] args) {
//	        draw frame=new draw();
//	        JPanel panel = new JPanel();
//	        JButton loginButton = new JButton("主机1");
//	        loginButton.setLocation(200, 50);
//	        loginButton.setSize(100, 30);
//	        loginButton.setBackground(Color.GREEN);
//	        panel.add(loginButton);
//	        frame.add(panel);
//	    }
//}
//
//class DrawPanel extends JPanel {//画线的JPanel
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        //两点确定一条直线.  三个点(不在同一直线)两两连接就可以成为三角形
//        g.setColor(Color.RED);//设置第一条线的颜色
//        g.drawLine(50, 50, 100, 100);//画第一条线 点(50,50) 到点  (100,100)
//        g.setColor(Color.BLUE);
//        g.drawLine(50, 50, 50, 150);//画第二条线 点(50,50) 到点  (50,150)
//        g.setColor(Color.GREEN);
//        g.drawLine(50, 150, 100, 100);//画第三条线 点(50,150) 到点  (100,100)
//    }
//}


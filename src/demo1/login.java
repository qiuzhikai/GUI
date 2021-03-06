package demo1;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
public class login {

	public static void main(String[] args) {
		   // 创建 JFrame 实例
        JFrame frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setLocation(500, 500);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();    
        // 添加面板
        frame.add(panel);
        //frame.add(new DrawPanel());
        /* 
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);
        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel userLabel = new JLabel("User:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        userLabel.setBounds(10,20,80,25);
        userLabel.setBorder(BorderFactory.createLineBorder(Color.blue,2));
        panel.add(userLabel);

        /* 
         * 创建文本域用于用户输入
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // 输入密码的文本域
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /* 
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // 创建登录按钮
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.setBackground(Color.white);
        panel.add(loginButton);
    }

}

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


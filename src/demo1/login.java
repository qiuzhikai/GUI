package demo1;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;
public class login {

	public static void main(String[] args) {
		   // ���� JFrame ʵ��
        JFrame frame = new JFrame("Login Example");
        // Setting the width and height of frame
        frame.setLocation(500, 500);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* ������壬��������� HTML �� div ��ǩ
         * ���ǿ��Դ��������岢�� JFrame ��ָ��λ��
         * ��������ǿ�������ı��ֶΣ���ť�����������
         */
        JPanel panel = new JPanel();    
        // ������
        frame.add(panel);
        //frame.add(new DrawPanel());
        /* 
         * �����û�����ķ����������������
         */
        placeComponents(panel);
        // ���ý���ɼ�
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* ���ֲ���������߲���������
         * ������ò���Ϊ null
         */
        panel.setLayout(null);

        // ���� JLabel
        JLabel userLabel = new JLabel("User:");
        /* ������������������λ�á�
         * setBounds(x, y, width, height)
         * x �� y ָ�����Ͻǵ���λ�ã��� width �� height ָ���µĴ�С��
         */
        userLabel.setBounds(10,20,80,25);
        userLabel.setBorder(BorderFactory.createLineBorder(Color.blue,2));
        panel.add(userLabel);

        /* 
         * �����ı��������û�����
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // ����������ı���
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /* 
         *�����������������ı���
         * �����������Ϣ���Ե�Ŵ��棬���ڰ�������İ�ȫ��
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // ������¼��ť
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        loginButton.setBackground(Color.white);
        panel.add(loginButton);
    }

}

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


package demo1;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Hello {
	private static void create(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("demo");
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lable =new JLabel("123");
		frame.getContentPane().add(lable);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                create();
	            }
	        });
	}

}

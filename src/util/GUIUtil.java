package util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIUtil {
	private static String imageFolder = "D:/java/student/hutubill/hutubill/img";
	
	//给按钮设置图标和文本以及提示文字
	public static void setImageIcon(JButton b,String fileName,String tip) {
		ImageIcon i = new ImageIcon(new File(imageFolder,fileName).getAbsolutePath());
		b.setIcon(i);
		b.setPreferredSize(new Dimension(61,81));
		b.setToolTipText(tip);
		b.setVerticalTextPosition(JButton.BOTTOM);
		b.setHorizontalTextPosition(JButton.CENTER);
		b.setText(tip);
	}

	//多个组件设置前景色
	public static void setColor(Color color,JComponent... cs) {
		for(JComponent c : cs) {
			c.setForeground(color);
		}
	}
	
	//独立面板显示
	public static void showPanel(JPanel p,double strechRate) {
		GUIUtil.useLNF();
		JFrame f = new JFrame();
		f.setSize(500,500);
		f.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(strechRate);
		f.setContentPane(cp);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		cp.show(p);
	}
	public static void showPanel(JPanel p) {
		showPanel(p,0.85);
	}

	//判断是否为数字格式
	public static boolean checkNumber(JTextField tf, String input) {
		if(!checkEmpty(tf,input))
			return false;
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, input + "需要是整数");
			tf.grabFocus();
			return false;
		}		
	}
	
	//组件的内容是否是零
	public static boolean checkZero(JTextField tf,String input) {
		if(!checkNumber(tf,input))
			return false;
		String text = tf.getText().trim();
		if (0 == Integer.parseInt(text)) {
			JOptionPane.showMessageDialog(null, input + "不能为零");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	//判断是否为空
	public static boolean checkEmpty(JTextField tf, String input) {
		String text  =tf.getText().trim();
		if (0 == text.length()) {
			JOptionPane.showMessageDialog(null, input + "不能为空");
			tf.grabFocus();
			return false;
		}
		return true;
	}

	public static int getInt(JTextField tf) {
        return Integer.parseInt(tf.getText());
    }
	
	//载入java皮肤，注：要放在最前面
	public static void useLNF() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}

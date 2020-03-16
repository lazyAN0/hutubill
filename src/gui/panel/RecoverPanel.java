package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.RecoverListener;
import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel extends WorkingPanel{
	//加载水晶皮肤
	static {
		GUIUtil.useLNF();
	}
	//单例化
	public static RecoverPanel instance = new RecoverPanel ();
	
	//恢复列表控件
	JButton bRecover = new JButton("恢复");
	
	public RecoverPanel () {
		GUIUtil.setColor(ColorUtil.blueColor, bRecover);
		this.add(bRecover);
		addListener();
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(RecoverPanel.instance);
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		RecoverListener listener = new RecoverListener();
		bRecover.addActionListener(listener);
	}
}

package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;

public class BackupPanel extends WorkingPanel{
	//加载水晶皮肤
	static {
		GUIUtil.useLNF();
	}
	//单例化
	public static BackupPanel instance = new BackupPanel();
	
	//备份面板控件
	JButton bBackup = new JButton("备份");
	
	public BackupPanel() {
		GUIUtil.setColor(ColorUtil.blueColor, bBackup);
		this.add(bBackup);
		addListener();
	}
	
	public static void main(String[] args) {
		GUIUtil.showPanel(BackupPanel.instance);
	}

	@Override
	public void updateData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener() {
		BackupListener listener = new BackupListener();
		bBackup.addActionListener(listener);
	}
}

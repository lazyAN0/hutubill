package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

public class RecoverListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		BackupPanel p = BackupPanel.instance;
		String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
		if(0 == mysqlPath.length()) {
			JOptionPane.showMessageDialog(p, "ª÷∏¥«∞«Î ¬œ»≈‰÷√mysqlµƒ¬∑æ∂");
			MainPanel.instance.workingPanel.show(ConfigPanel.instance);
			ConfigPanel.instance.tfMysqlPath.grabFocus();
			return;
		}
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(new File("hutubill.sql"));
		fc.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File f) {
				return f.getName().toLowerCase().endsWith(".sql");
			}

			@Override
			public String getDescription() {
				return ".sql";
			}
			
		});
		
		int returenVal = fc.showOpenDialog(p);
		File file = fc.getSelectedFile();
		System.out.println(file);
		if(returenVal == JFileChooser.APPROVE_OPTION) {
			try {
				MysqlUtil.recover(mysqlPath, file.getAbsolutePath());
				JOptionPane.showMessageDialog(p, "ª÷∏¥≥…π¶");
			} catch (Exception e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(p, "ª÷∏¥ ß∞‹ \r\n,¥ÌŒÛ: \r\n"+e1.getMessage());
			}
		}
	}

}

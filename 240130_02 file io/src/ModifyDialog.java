import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModifyDialog extends JDialog {
	private JTextField[] tfs;
	
	public ModifyDialog(int index, StudentGUIApp app) {
		setModal(true);
		
		JPanel pnl = new JPanel();
		tfs = new JTextField[4];
		for (int i = 0; i < tfs.length; i++) {
			tfs[i] = new JTextField(10);
			pnl.add(tfs[i]);
		}
		JButton btnConfirm = new JButton("수정 완료");
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = new Student(tfs[0].getText()
						, Integer.valueOf(tfs[1].getText())
						, Integer.valueOf(tfs[2].getText())
						, Integer.valueOf(tfs[3].getText())
						);
				app.studentChanged(index, s);
				dispose();
			}
		});
		
		pnl.add(btnConfirm);
		JButton btnDelete = new JButton("삭제");
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				app.studentDeleted(index);
				dispose();
			}
		});
		pnl.add(btnDelete);
		
		add(pnl);
		
		setSize(400, 400);
		setLocationRelativeTo(null);
	}
}







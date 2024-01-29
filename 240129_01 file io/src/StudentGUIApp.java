import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class StudentPanel extends JPanel {
	public StudentPanel(Student s) {
		setBorder(BorderFactory.createTitledBorder(s.getName()));

		JLabel lblKor = new JLabel(String.valueOf(s.getKor()));
		JLabel lblEng = new JLabel(String.valueOf(s.getEng()));
		JLabel lblMath = new JLabel(String.valueOf(s.getMath()));

		add(lblKor);
		add(lblEng);
		add(lblMath);

	}
}

public class StudentGUIApp extends JFrame {
	private StudentDAO dao;
	private JTextField[] tfs;

	public StudentGUIApp() {
		JPanel pnlSouth = new JPanel();
		JPanel pnlCenter = new JPanel();
		dao = new StudentDAO();
		tfs = new JTextField[4];
		for (int i = 0; i < tfs.length; i++) {
			tfs[i] = new JTextField(10);
			pnlSouth.add(tfs[i]);

		}
		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Student s = new Student(tfs[0].getText(), Integer.valueOf(tfs[1].getText()),
						Integer.valueOf(tfs[2].getText()), Integer.valueOf(tfs[3].getText()));
				dao.appendRow(s);

				JPanel p = new StudentPanel(s);
				pnlCenter.add(p);

				pnlCenter.revalidate();
				pnlCenter.repaint();

			}
		});

		pnlSouth.add(btnAdd);
		add(pnlSouth, "South");

		List<Student> list = dao.getAll();
		for (int i = 0; i < list.size(); i++) {

			Student s = list.get(i);
			pnlCenter.add(new StudentPanel(s));
		}
		add(pnlCenter);

		showgui();

	}

	private void showgui() {
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new StudentGUIApp();

	}

}

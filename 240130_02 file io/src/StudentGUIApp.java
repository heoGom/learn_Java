import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class StudentPanel extends JPanel {
	private JLabel lblKor;
	private JLabel lblEng;
	private JLabel lblMath;

	public StudentPanel(Student s) {
		lblKor = new JLabel();
		lblEng = new JLabel();
		lblMath = new JLabel();

		add(lblKor);
		add(lblEng);
		add(lblMath);

		setStudent(s);
	}

	public void setStudent(Student s) {
		setNameTitle(s.getName());
		setKorText(String.valueOf(s.getKor()));
		setEngText(String.valueOf(s.getEng()));
		setMathText(String.valueOf(s.getMath()));
	}

	public void setNameTitle(String name) {
		setBorder(BorderFactory.createTitledBorder(name));
	}

	public void setKorText(String kor) {
		lblKor.setText(kor);
	}

	public void setEngText(String eng) {
		lblEng.setText(eng);
	}

	public void setMathText(String math) {
		lblMath.setText(math);
	}
}

public class StudentGUIApp extends JFrame {
	private JTextField[] tfs;
	private StudentManager manager;
	private List<StudentPanel> studentPnls;
	private JPanel pnlCenter;

	public StudentGUIApp() {
		manager = new StudentManager();
		studentPnls = new ArrayList<>();

		pnlCenter = new JPanel();
		
		for(Student s : manager.getList()) {
			createPanel(s);
		}
		JPanel pnlSouth = new JPanel();

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

				createPanel(s);
				
				pnlCenter.revalidate();
				pnlCenter.repaint();
				manager.add(s);
			}

			

		});

		pnlSouth.add(btnAdd);
		add(pnlSouth, "South");
		
		JButton btnSave = new JButton("저장하기");
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				manager.saveList();
				
			}
		});

		add(pnlCenter);

		showgui();
	}
	
	private void createPanel(Student s) {
		StudentPanel p = new StudentPanel(s);
		addMouseAdapter(p);
		studentPnls.add(p);
		pnlCenter.add(p);
	}

	private void addMouseAdapter(StudentPanel p) {
		p.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int index = studentPnls.indexOf(e.getSource());
				ModifyDialog dialog = new ModifyDialog(index, StudentGUIApp.this);
				dialog.setVisible(true);
			}
		});
	}

	public void studentChanged(int index, Student s) {
		studentPnls.get(index).setStudent(s);
		manager.update(index, s);
	}
	
	public void studentDeleted(int index) {
		studentPnls.remove(index);
		pnlCenter.remove(index);
		
		pnlCenter.revalidate();
		pnlCenter.repaint();
		
		manager.delete(index);
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

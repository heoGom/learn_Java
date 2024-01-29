import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main4 extends JFrame {
	private MyMessageLogger logger;
	
	public Main4() {
		logger = new MyMessageLogger("keylog.log");
		
		
		JPanel pnl = new JPanel();
		pnl.setFocusable(true);
		add(pnl);
		
		pnl.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				logger.saveLog(e.getKeyText(e.getKeyCode()));
				
			}
			
		});
		showgui();
	}
	private void showgui() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
	public static void main(String[] args) {
		new Main4();

	}
}

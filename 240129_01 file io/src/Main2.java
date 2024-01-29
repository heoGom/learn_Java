import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

//배경색 환경설정 파일을 저장하여
// 1. 고정된 경로 파일 이름 사용.
// ㄴ> 1-1. 종료 의사가 있을 때, 저장한다.
// ㄴ> 1-2. 새로운 배경색을 적용할 때, 저장한다. <<
// 2. RGB 수치값 기록
// ㄴ> red, green, blue 순 기록, 한줄에 하나의 정보 (텍스트 형태의 기록)
//배경색이 적용된 프레임을 보여주는 프로그램
// 1. 고정된 경로 파일 이름 사용
// ㄴ>  1-1. 배경 패널 생성 후 & 프레임 보여지기 전
// 2. RGB 수치값 읽어옴.
// ㄴ> 색 객체 구성 후. 배경 색 설정. (단, 설정값이 없는 경우는 기본 색상을 사용한다)

// ---------------------------------------------------

// 변경의 기록(log)
// 1. 고정된 경로 파일 이름 사용(설정 파일과 별개의 파일)
// 2. 시간. 색상.  
// ex) 2024-01-29 12:58 :33 사용자가 색(233, 211, 201)을 변경함.
// 3. 새로운 색상이 적용될 때마다, 저장.

public class Main2 extends JFrame {
	private final MyColorConfigFileAccessor configAccessor;
	private final MyMessageLogger logger;
	private final File logFile = new File("d:\\mydata\\change.log");

	public Main2() {
		super("color 프레임");
		configAccessor = new MyColorConfigFileAccessor();
		logger = new MyMessageLogger(logFile);

		JPanel center = new JPanel();
		JButton btn = new JButton("색깔 선택");

		Color backgroundColor = configAccessor.readConfig();
		center.setBackground(backgroundColor);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JColorChooser chooser = new JColorChooser();
				Color color = chooser.showDialog(null, "배경색 선택", Color.WHITE);
				if (color != null) {
					center.setBackground(color);
					configAccessor.saveColor(color);
					logger.saveLog(String.format("사용자가 색상(%d,%d,%d)을 변경함", color.getRed(), color.getGreen(),color.getBlue()));
				}

			}
		});
		center.add(btn);
		add(center);

		showgui();
	}



	private void showgui() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {
		new Main2();

	}

}

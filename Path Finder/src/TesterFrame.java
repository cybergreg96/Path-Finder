import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TesterFrame extends JFrame implements KeyListener {
	private TesterPanel suitePanel;
	public static boolean condition = false;
	public static boolean condition2 = false;
	public static boolean condition3 = false;
	public static boolean condition4 = false;
	public static int start_count = 0;
	public static int end_count = 0;

	public TesterFrame() {
		suitePanel = new TesterPanel();
		suitePanel.setBackground(new Color(128, 0, 0));
		this.addKeyListener((KeyListener) this);
		this.setContentPane(suitePanel);
		int row = 10;
		int col = 10;
		int count = 0;
		suitePanel.setLayout(new GridLayout(row, col));
		for (int i = 1; i <= (row * col); i++) {
			JPanel pan = new JPanel();
			pan.setEnabled(true);
			pan.setBackground(Color.WHITE);
			pan.setPreferredSize(new Dimension(1, 1));
			pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pan.addMouseListener(new BoxListener());
			pan.setName(count + "");
			++count;
			add(pan);
		}

	}

	public static class BoxListener implements MouseListener {
		private Object s_index;
		private Object e_index;

		@Override
		public void mouseClicked(MouseEvent e) {
			condition2 = true;
			mouseEntered(e);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if (condition && condition2) {
				JPanel clickedBox = (JPanel) e.getSource();
				clickedBox.setBackground(Color.BLACK);
			}
			if (condition3 && condition2 && start_count == 0 && e.getSource() != e_index) {
				start_count++;
				JPanel clickedBox = (JPanel) e.getSource();
				s_index = e.getSource();
				clickedBox.setBackground(Color.GREEN);
			}
			if (condition4 && condition2 && end_count == 0 && e.getSource() != s_index) {
				end_count++;
				JPanel clickedBox = (JPanel) e.getSource();
				e_index = e.getSource();
				clickedBox.setBackground(Color.RED);
			}

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	public void keyTyped(KeyEvent me) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent me) {
		// TODO Auto-generated method stub
		char ch = me.getKeyChar();
		if (ch == 'w') {
			condition = true;
		} else if (ch == 's') {
			condition3 = true;
		} else if (ch == 'e') {
			condition4 = true;
		}

	}

	@Override
	public void keyReleased(KeyEvent me) {
		// TODO Auto-generated method stub
		condition = false;
		condition2 = false;
		condition3 = false;
		condition4 = false;

	}

	public void start() {
		this.setSize(700, 700);
		this.setVisible(true);
	}

}

import javax.swing.JFrame;

public class Screen extends JFrame {

	public Screen(int width, int height, String title) {
		
		Game comp = new Game();
		
		new JFrame();
		setVisible(true);
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		add(comp);
		addKeyListener(comp);
	}
}

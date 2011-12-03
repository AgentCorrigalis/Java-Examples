package swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class InternalFrame implements ActionListener {

	private static JFrame frame;
	private static Font uiFont = new Font("Dialog", Font.PLAIN, 10);
	private JDesktopPane desktopPane;
	private List<Component> initialUiComponents = new ArrayList<Component>();

	public static void main(String[] args) {
		if (frame == null) {
			InternalFrame paneExample = new InternalFrame();
			frame = new JFrame();
			paneExample.display();
		}
	}

	private void display() {
		desktopPane = new JDesktopPane();
		frame.setTitle("Internal Frame Example");
		frame.setBounds(200, 200, 500, 250);
		frame.setContentPane(desktopPane);
		frame.setVisible(true);
		attachMenus();
		formatComponents();
	}

	private void attachMenus() {
		JMenuBar menuBar = new JMenuBar();
		initialUiComponents.add(menuBar);
		menuBar.add(fileMenu());
		frame.setJMenuBar(menuBar);
	}

	private JMenu fileMenu() {
		JMenu fileMenu = new JMenu("File");
		initialUiComponents.add(fileMenu);
		JMenuItem newBox = new JMenuItem("New Box");
		initialUiComponents.add(newBox);
		newBox.addActionListener(this);
		fileMenu.add(newBox);
		return fileMenu;
	}

	private void newInternalPane() {
		JInternalFrame internalFrame = new JInternalFrame("pane", true, true,
				true, true);
		internalFrame.setSize(new Dimension(200, 200));
		internalFrame.setVisible(true);
		formatSingleComponent(internalFrame);
		desktopPane.add(internalFrame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Box")) {
			newInternalPane();
		}
	}

	private void formatComponents() {
		for (Component c : initialUiComponents) {
			formatSingleComponent(c);
		}
	}

	private void formatSingleComponent(Component c) {
		c.setFont(uiFont);
	}

}

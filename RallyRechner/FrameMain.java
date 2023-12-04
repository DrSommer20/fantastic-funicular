import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

//import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.IntelliJTheme;

class FrameMain {	
	private JFrame frame;
	
	private JTabbedPane tabPane;
	
	private JPanel tab1;
	private JPanel tab2;
	private JPanel tab3;	
	
	private JMenuBar menuBar;

	///////////Preperation//////////////////
	
	public FrameMain() {
		prepareGUI();
	}

	private void prepareGUI() {
		// Frame Shit
		frame = new JFrame("RallyRechner");
		frame.setVisible(true);
		frame.setSize(1250, 700);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Prepare Panes
		prepareMenuBar();
		
		JPanel tbPane = new TBPane().getContentPaneTB();
		JPanel puPane = new PUPane("PU_JI").getContentPanePU();
		JPanel miwoPane = new PUPane("MiWo_JI").getContentPanePU();
		
		tab1 = new JPanel(new BorderLayout());
		tab2 = new JPanel(new BorderLayout());
		tab3 = new JPanel(new BorderLayout());
		
		tab1.add(tbPane, BorderLayout.CENTER);
		tab1.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
		
		tab2.add(puPane, BorderLayout.CENTER);
		tab2.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
		
		tab3.add(miwoPane, BorderLayout.CENTER);
		tab3.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
		
		prepareTabbedPane();

		// Frame Shit
		frame.add(tabPane, BorderLayout.CENTER);
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
	}

	private void prepareMenuBar() {
//		ImageIcon iconLogoBig = new ImageIcon("resources/Logo.jpg");
//		Image imageLogo = iconLogoBig.getImage();
//		Image Logo = imageLogo.getScaledInstance(200, 95, java.awt.Image.SCALE_SMOOTH);
//		ImageIcon iconLogo = new ImageIcon(Logo);
		
		menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("Datei");
		JMenuItem item11 = new JMenuItem("Item1");
		JMenuItem item12 = new JMenuItem("Item2");
		JMenuItem item13 = new JMenuItem("Item3");
		JMenuItem item14 = new JMenuItem("Item4");
		menu1.add(item11);
		menu1.add(item12);
		menu1.add(item13);
		menu1.add(item14);
		menuBar.add(menu1);
		
		JMenu menu2 = new JMenu("Ansicht");
		JMenuItem item21 = new JMenuItem("Arc Theme");
		JMenuItem item22 = new JMenuItem("Arc Dark Theme");
		JMenuItem item23 = new JMenuItem("Cobalt 2 Theme");
		JMenuItem item24 = new JMenuItem("Gradianto Theme");
		menu2.add(item21);
		menu2.add(item22);
		menu2.add(item23);
		menu2.add(item24);
		menuBar.add(menu2);
		
		JMenu menu3 = new JMenu("Optionen");
		JMenuItem item31 = new JMenuItem("Hinweise anzeigen");
		JMenuItem item32 = new JMenuItem("Item2");
		JMenuItem item33 = new JMenuItem("Item3");
		JMenuItem item34 = new JMenuItem("Item4");
		menu3.add(item31);
		menu3.add(item32);
		menu3.add(item33);
		menu3.add(item34);
		menuBar.add(menu3);
		
		item21.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	          changeTheme("\\resources\\arc-theme.theme.json");
	        }
		});
		item22.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	          changeTheme("\\resources\\arc_theme_dark.theme.json");
	        }
		});
		item23.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	          changeTheme("\\resources\\Cobalt_2.theme.json");
	        }
		});
		item24.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ev) {
	          changeTheme("\\resources\\Gradianto_deep_ocean.theme.json");
	        }
		});

	}

	private void changeTheme(String lnfName) {
		
		IntelliJTheme.setup(FrameMain.class.getResourceAsStream(lnfName));
		IntelliJTheme.ThemeLaf.updateUI();
	}
	
	private void prepareTabbedPane() {
		tabPane = new JTabbedPane(JTabbedPane.NORTH, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabPane.setFont( new Font("Helvetica", Font.BOLD, 20)); 
		
		ImageIcon iconLogoBig = new ImageIcon("resources/TBIcon.png");
		Image imageLogo = iconLogoBig.getImage();
		Image Logo = imageLogo.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		ImageIcon iconLogo = new ImageIcon(Logo);
		
		tabPane.addTab("Trapezblech", iconLogo, tab1);
		
		
		
		iconLogoBig = new ImageIcon("resources/PaneelIcon.png");
		imageLogo = iconLogoBig.getImage();
		Logo = imageLogo.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		iconLogo = new ImageIcon(Logo);
		
		tabPane.addTab("PU-Paneele", iconLogo, tab2);
		
		iconLogoBig = new ImageIcon("resources/PaneelIcon.png");
		imageLogo = iconLogoBig.getImage();
		Logo = imageLogo.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		iconLogo = new ImageIcon(Logo);
		
		tabPane.addTab("MiWo-Paneele", iconLogo, tab3);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public static void main(String[] args) throws Exception {
		IntelliJTheme.setup(FrameMain.class.getResourceAsStream("\\resources\\Cobalt_2.theme.json"));
		new FrameMain();
	}
	
	
	


}

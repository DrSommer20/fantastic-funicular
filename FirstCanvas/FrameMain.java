import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

class FrameMain implements ActionListener{
	
	private JFrame frame = new JFrame("RallyRechner");
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
	private JComboBox<String> profilCB;
	private JComboBox<String> dickeCB ;
	private JComboBox<String> beschichtungCB ;
	private JComboBox<String> zulageCB ;
	private JTextField mengeTF;
	private JLabel labelErgebniss = new JLabel("");
	private JLabel labelProfil = new JLabel("Profil:");
	private JLabel labelDicke = new JLabel("Dicke:");
	private JLabel labelBeschichtung = new JLabel("Beschichtung:");
	private JLabel labelZulage = new JLabel("Zulage:");
	private JLabel labelMenge = new JLabel("Menge:");
	private JButton calc = new JButton("Berrechnen");
	private GridLayout experimentLayout = new GridLayout(0,5);
	private JTable table = new JTable(new DefaultTableModel(new Object[]{"Profil:", "Dicke:", "Beschichtung:", "Zulage:", "Menge:", "Preis:"}, 0));
	private DefaultTableModel model = (DefaultTableModel) table.getModel();	
	public FrameMain() {
		prepareGUI();
	}
	
	private void prepareGUI() {
		frame.setVisible(true);
		frame.setSize(500, 500);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        String[] profil = {	"18", "19", "27", "30", "35", "40", "45", "50", "85", "89", "100", "106", "135", "153", "158", "200" };        
        String[] dicke = { "0,63 mm", "0,75 mm", "0,88 mm", "1,00 mm", "1,13 mm", "1,25 mm", "1,50 mm"};
        String[] beschichtung = {"DU/RSL", "25my/RSL", "25my/25my"};
        String[] zulage = {"keine Zulagen", "Akustiklochung", "Vliesbeschichtung"};
        
        profilCB = new JComboBox<String>(profil);
        dickeCB = new JComboBox<String>(dicke);
        beschichtungCB = new JComboBox<String>(beschichtung);
        zulageCB = new JComboBox<String>(zulage);
        mengeTF = new JTextField(6);
        model.addRow(new Object[]{"Profil:", "Dicke:", "Beschichtung:", "Zulage:", "Menge:", "Preis:"});
        
        
        
		panel2.setLayout(experimentLayout);
		panel2.add(labelProfil);
		panel2.add(labelDicke);
		panel2.add(labelBeschichtung);
		panel2.add(labelZulage);
		panel2.add(labelMenge);
        panel2.add(profilCB);
        panel2.add(dickeCB);
        panel2.add(beschichtungCB);
        panel2.add(zulageCB);
        panel2.add(mengeTF);
        panel2.add(calc);
        panel2.add(labelErgebniss);
        
        panel.add(table);
        
        calc.addActionListener(this);

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, panel2);
        frame.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == this.calc) {
			
			Trapezblech tb = new Trapezblech(Integer.parseInt(mengeTF.getText()) , profilCB.getSelectedIndex(), dickeCB.getSelectedIndex(), beschichtungCB.getSelectedIndex(), zulageCB.getSelectedIndex());
			labelErgebniss.setText(""+tb.getQmPreis());	
			model.addRow(new Object[]{"" +tb.getProfil(), tb.getDicke(), tb.getBeschichtung(), tb.getZulage(), ""+tb.getMenge(),tb.getQmPreis()+ " €/qm"});

			
			
		}

	}

}

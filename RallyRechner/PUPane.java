import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelListener;

class PUPane {
	
	private String daemmungArt;
	
	private JPanel contentPanePU;
	private JPanel selectionPanePU;
	private JPanel listPanePU;
	private JPanel buttonPanePU;
	private JPanel lableGesamtPanePU;
	
	private JComboBox<String> puArtCB;
	private JComboBox<String> puDickeCB;
	private JComboBox<String> puBeschichtungCB;
	
	private JTextField puPlzTF;
	
	private JCheckBox puCheckVerpackung;
	private JCheckBox miwoCheckPerfo;

	private JSpinner mengePU;

	private JLabel label;
	
	private JLabel puGesamtqmLb;

	private JButton puCalcBtn;
	private JButton puExportBtn;
	private JButton puResetBtn;
	private JButton puDeleteRowBtn;
	
	private JRadioButton puBedarfRB;
	private JRadioButton puAlternativeRB;
	
	TableModelListener puListenerTabel;

	private CustomTableModelPU puModel;
	private JTable puTable;
	
	
	private String[] puArt = {"Dach", "Wand SB", "Wand VB"};
	private String[] puFarbe = {"Sonderfarbe", "Standardfarbe"};
	private String[] puDickeDach = {"30", "40", "60", "80", "100", "120", "150"};
	private String[] puDickeSB = {"40", "60", "80", "100", "120", "150", "170", "200", "220"};
	private String[] puDickeVB = {"60", "80", "100", "120", "150"};
	
	
	public PUPane(String s) {
		this.daemmungArt = s;
		setStrings();
		prepareSelectionPanePU();
		prepareListPanePU();
		prepareButtonPanePU();
		setDickeCB(puArtCB.getSelectedIndex());
		
		// Add to ContentPanePU
		contentPanePU.add(selectionPanePU, BorderLayout.NORTH);
		contentPanePU.add(listPanePU, BorderLayout.CENTER);
		contentPanePU.add(buttonPanePU, BorderLayout.PAGE_END);
		
		//Listeners PU
		puCalcBtn.addActionListener(e -> this.puCalcBtnPressed());
		puArtCB.addActionListener(e -> this.setDickeCB(puArtCB.getSelectedIndex()));
		puDeleteRowBtn.addActionListener(e -> this.puDeleteBtnPressed());
		puResetBtn.addActionListener(e -> this.puResetBtnPressed());
		puPlzTF.addActionListener(e -> this.updatePUGesamt());
	}
	
	public JPanel getContentPanePU() {
		return contentPanePU;
	}
	
	private void setStrings() {
		switch(daemmungArt) {
		case "MiWo_JI":
			puArt = new String[]{"Dach", "Wand SB", "Wand VB"};
			puFarbe = new String[]{"Standardfarbe"};
			puDickeDach= new String[]{"50", "60", "80", "100", "120", "150", "175", "200"};
			puDickeSB = new String[]{"50", "60", "80", "100", "120", "150", "175", "200"};
			puDickeVB = new String[]{"50", "60", "80", "100", "120", "150", "175", "200"};
			break;
		case "PU_JI":
			puArt = new String[]{"Dach", "Wand SB", "Wand VB"};
			puFarbe = new String[]{"Sonderfarbe", "Standardfarbe"};
			puDickeDach= new String[]{"30", "40", "60", "80", "100", "120", "150"};
			puDickeSB = new String[]{"40", "60", "80", "100", "120", "150", "170", "200", "220"};
			puDickeVB = new String[]{"60", "80", "100", "120", "150"};
			break;
		}
		
	}
	
	private void prepareSelectionPanePU() {
		contentPanePU = new JPanel(new BorderLayout());
		selectionPanePU = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		selectionPanePU.add(Box.createHorizontalStrut(10), c);

		label = new JLabel("Art:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		selectionPanePU.add(label, c);

		label = new JLabel("Dicke:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		selectionPanePU.add(label, c);

		label = new JLabel("Beschichtung:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 0;
		selectionPanePU.add(label, c);

		label = new JLabel("Zulagen:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.4;
		c.gridx = 4;
		c.gridy = 0;
		selectionPanePU.add(label, c);

		label = new JLabel("Menge:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 5;
		c.gridy = 0;
		selectionPanePU.add(label, c);

		label = new JLabel("Bedarfsmarkierung");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.4;
		c.gridx = 6;
		c.gridy = 0;
		selectionPanePU.add(label, c);

		c.gridx = 7;
		c.gridy = 0;
		selectionPanePU.add(Box.createHorizontalStrut(10), c);

		puArtCB = new JComboBox<>(puArt);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridheight = 2;
		c.gridx = 1;
		c.gridy = 1;
		selectionPanePU.add(puArtCB, c);

		puDickeCB = new JComboBox<>();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		selectionPanePU.add(puDickeCB, c);
		
		switch(daemmungArt) {
			case "MiWo_JI":
				label = new JLabel("<html><i>Standardfarben 0,6mm</i></html>");
				label.setToolTipText("<html>1015 5008 6011 7015 7016 <br> 7022 7032 7035 7037 8012 <br> 8014 9002 9006 9007 9010</html>");
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 0.5;
				c.gridx = 3;
				c.gridy = 1;
				selectionPanePU.add(label, c);
				
				miwoCheckPerfo = new JCheckBox("Innenseite Akustiklochung");
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 0.4;
				c.gridheight = 1;
				c.gridx = 4;
				c.gridy = 2;
				selectionPanePU.add(miwoCheckPerfo, c);
				break;
			case "PU_JI":
				puBeschichtungCB = new JComboBox<>(puFarbe);
				c.fill = GridBagConstraints.HORIZONTAL;
				c.weightx = 0.5;
				c.gridx = 3;
				c.gridy = 1;
				selectionPanePU.add(puBeschichtungCB, c);
				break;
		}

		puCheckVerpackung = new JCheckBox("A-Seitige Verpackung");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.4;
		c.gridx = 4;
		c.gridy = 1;
		selectionPanePU.add(puCheckVerpackung, c);

		mengePU = new JSpinner();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridheight = 2;
		c.gridx = 5;
		c.gridy = 1;
		selectionPanePU.add(mengePU, c);

		puBedarfRB = new JRadioButton("Bedarf");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = 1;
		c.weightx = 0.4;
		c.gridx = 6;
		c.gridy = 1;
		selectionPanePU.add(puBedarfRB, c);

		puAlternativeRB = new JRadioButton("Alternativ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.4;
		c.gridx = 6;
		c.gridy = 2;
		selectionPanePU.add(puAlternativeRB, c);

		ButtonGroup btn = new ButtonGroup();
		btn.add(puBedarfRB);
		btn.add(puAlternativeRB);

		puBedarfRB.setSelected(true);
		
		label = new JLabel("Postleitzahl:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = 1;
		c.gridx = 7;
		c.gridy = 0;
		selectionPanePU.add(label, c);
		
		puPlzTF = new JTextField(8);
		c.gridheight = 1;
		c.gridx = 7;
		c.gridy = 1;
		c.weightx = 0.5;
		selectionPanePU.add(puPlzTF, c);

		puCalcBtn = new JButton("Berrechnen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 7;
		c.gridy = 2;
		selectionPanePU.add(puCalcBtn, c);
		
		c.gridx = 8;
		c.gridy = 0;
		selectionPanePU.add(Box.createHorizontalStrut(3), c);

	}
	
	private void prepareListPanePU() {
		listPanePU = new JPanel(new BorderLayout());
		puModel = new CustomTableModelPU();
		puTable = new JTable(puModel);
		JTableUtilities.setCellsAlignmentPU(puTable, SwingConstants.CENTER);
		
//	    TableColumn col = puTable.getColumnModel().getColumn(0);
//	    col.setCellEditor(new MyComboBoxEditor(puArt));
//	    col.setCellRenderer(new MyComboBoxRenderer(puArt));
//	    
//	    TableColumn col2 = puTable.getColumnModel().getColumn(1);
//	    col2.setCellEditor(new MyComboBoxEditor(puDicke));
//	    col2.setCellRenderer(new MyComboBoxRenderer(dicke));
//	    
//	    TableColumn col3 = puTable.getColumnModel().getColumn(2);
//	    col3.setCellEditor(new MyComboBoxEditor(beschichtung));
//	    col3.setCellRenderer(new MyComboBoxRenderer(beschichtung));
//	    
//	    TableColumn col4 = puTable.getColumnModel().getColumn(3);
//	    col4.setCellEditor(new MyComboBoxEditor(zulage));
//	    col4.setCellRenderer(new MyComboBoxRenderer(zulage));
		

		listPanePU.add(new JScrollPane(puTable), BorderLayout.CENTER);
		listPanePU.add(Box.createHorizontalStrut(10), BorderLayout.WEST);
		listPanePU.add(Box.createHorizontalStrut(10), BorderLayout.EAST);
		listPanePU.add(Box.createVerticalStrut(10), BorderLayout.NORTH);
		listPanePU.add(Box.createVerticalStrut(10), BorderLayout.SOUTH);
	}

	private void prepareButtonPanePU() {
		lableGesamtPanePU = new JPanel(new GridBagLayout());
		GridBagConstraints lblCons = new GridBagConstraints();

		lblCons.gridx = 0;
		lblCons.gridy = 0;
		lableGesamtPanePU.add(Box.createHorizontalStrut(2), lblCons);

		puDeleteRowBtn = new JButton("Ausgewählte Zeile löschen");
		lblCons.weightx = 0.5;
		lblCons.gridheight = 2;
		lblCons.gridx = 1;
		lblCons.gridy = 0;
		lableGesamtPanePU.add(puDeleteRowBtn, lblCons);
		

		
		lblCons.gridx = 3;
		lblCons.gridy = 0;
		lableGesamtPanePU.add(Box.createHorizontalStrut(4), lblCons);
		
		label = new JLabel("Gesamt-QM:");
		lblCons.fill = GridBagConstraints.HORIZONTAL;
		lblCons.gridheight = 1;
		lblCons.gridx = 4;
		lblCons.gridy = 0;
		lableGesamtPanePU.add(label, lblCons);

		puGesamtqmLb = new JLabel("0.00 qm");
		lblCons.fill = GridBagConstraints.HORIZONTAL;
		lblCons.gridx = 4;
		lblCons.gridy = 1;
		lableGesamtPanePU.add(puGesamtqmLb, lblCons);

		////////////////////////////////////////////////////////////////////////////////////////////////////

		buttonPanePU = new JPanel();
		buttonPanePU.setLayout(new BoxLayout(buttonPanePU, BoxLayout.LINE_AXIS));
		buttonPanePU.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPanePU.add(lableGesamtPanePU);
		buttonPanePU.add(Box.createHorizontalGlue());
		puResetBtn = new JButton("Reset");
		puExportBtn = new JButton("Export");

		buttonPanePU.add(puResetBtn);
		buttonPanePU.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPanePU.add(puExportBtn);
	}


	
	
	///////////Funktions for Tabel PU//////////
	
	private void setDickeCB(int artIndex) {
		puCheckVerpackung.setSelected(false);
		puDickeCB.removeAllItems();
		if(artIndex == 0) {
			for(int i = 0; i < puDickeDach.length; i++) {
				puDickeCB.addItem(puDickeDach[i]);
			}
			puCheckVerpackung.setEnabled(true);
		}
		else if (artIndex == 1) {
			for(int i = 0; i < puDickeSB.length; i++) {
				puDickeCB.addItem(puDickeSB[i]);
			}
			puCheckVerpackung.setEnabled(false);
		}
		else if (artIndex == 2) {
			for(int i = 0; i < puDickeVB.length; i++) {
				puDickeCB.addItem(puDickeVB[i]);
			}
			puCheckVerpackung.setEnabled(false);
		}
		
	}

	private void addPaneel(Paneel pnl) {
		puModel.addRow(new Object[] {pnl.getArt() , pnl.getDicke(), pnl.getBeschichtung(), pnl.isVerpackung(),
 				pnl.getMenge(), pnl.getQMPreis() + " €/qm", pnl.isBedarf()});
	}
	
	private Paneel calcPaneel(int artIndex, String dicke, int beschichtung, String plz, boolean verpackung, int menge, boolean bedarf) {

		switch(artIndex) {
		case 0: return new PUPaneelDach(dicke, beschichtung, plz, verpackung , menge, bedarf);
		case 1: return new PUPaneelSB(dicke, beschichtung, plz , menge, bedarf);
		default: return new PUPaneelVB(dicke, beschichtung, plz , menge, bedarf);
		}
	}
	
	private void puCalcBtnPressed() {
		try {
			mengePU.commitEdit();
		} catch (Exception ex) {
			System.err.println("Failed to commit edit Spinner Menge");
		}
		Paneel pnl = calcPaneel(puArtCB.getSelectedIndex(), puDickeCB.getItemAt(puDickeCB.getSelectedIndex()), puBeschichtungCB.getSelectedIndex(), puPlzTF.getText(), puCheckVerpackung.isSelected() , (int)mengePU.getValue(), puBedarfRB.isSelected());
		addPaneel(pnl);
		if (puBedarfRB.isSelected()) this.updatePUGesamt();	
		
	}
	
	private void updatePUGesamt() {
		
		Paneel.setGesamtQM(0);
		
		for(int i = 0; i < puModel.getRowCount(); i++) {
		int art = -1;
		System.out.println((String)puModel.getValueAt(i, 0));
		
		switch((String)puModel.getValueAt(i, 0)) {
			case "Dach" -> art = 0;
			case "Wand SB" -> art = 1;
			case "Wand VB" -> art = 2;
		}
		System.out.println(art);
		String dicke = puModel.getValueAt(i, 1) + "";
		int beschichtung = 0;
		switch((String)puModel.getValueAt(i, 2)) {
		case "Sonderfarbe" -> beschichtung = 0;
		case "Standardfarbe" -> beschichtung = 1;
		}
		
		String plz = puPlzTF.getText();
		boolean verpackung = (Boolean)puModel.getValueAt(i, 3);
		int menge = (Integer)puModel.getValueAt(i, 4);
		boolean isBedarf = (Boolean)puModel.getValueAt(i, 6);
		Paneel pnl = calcPaneel(art, dicke, beschichtung, plz, verpackung, menge, isBedarf);
		
		puModel.setValueAt(pnl.getArt(), i, 0);
		puModel.setValueAt(pnl.getDicke(), i, 1);
		puModel.setValueAt(pnl.getBeschichtung(), i, 2);
		puModel.setValueAt(pnl.isVerpackung(), i, 3);
		puModel.setValueAt(pnl.getMenge(), i, 4);
		puModel.setValueAt(pnl.getQMPreis() + " €/qm", i, 5);
		puModel.setValueAt(pnl.isBedarf(), i, 6);
		}
		puGesamtqmLb.setText(Paneel.getGesamtQM() + " qm");
	}
	
	private void puResetBtnPressed() {
		while (puModel.getRowCount() > 0) {
			puModel.removeRow(0);
		}
		updatePUGesamt();
	}
	
	private void puDeleteBtnPressed() {
		puModel.removeRow(puTable.getSelectedRow());
		updatePUGesamt();
	}
}

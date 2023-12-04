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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
//import javax.swing.border.BevelBorder;
import javax.swing.table.TableColumn;


class TBPane {
	private JPanel contentPaneTB;
	private JPanel selectionPaneTB;
	private JPanel listPaneTB;
	private JPanel buttonPaneTB;	
	private JPanel lableGesamtPaneTB;
	
	private JComboBox<String> profilCB;
	private JComboBox<String> dickeCB;
	private JComboBox<String> beschichtungCB;
	private JComboBox<String> zulageCB;
	private JComboBox<String> laengeCB;
	
	private JSpinner mengeSP;
	
	private JTextField plzTF;
	
	
	private JLabel label;
	private JLabel gesamtgewichtLb;
	private JLabel gesamtqmLb;
	private JLabel transportLb;
	
	private JRadioButton bedarfRB;
	private JRadioButton alternativeRB;
	
	private TBTableModel model;
	private JTable table;
	TableColumn tableColumn5;
	TableColumn tableColumn6;
	TableColumn tableColumn7;
	
	private String[] profil = { "18", "19", "27", "30", "35", "40", "45", "50", "85", "89", "100", "106", "135", "153",
								"158", "200" };
	private final String[] dicke = { "0,63 mm", "0,75 mm", "0,88 mm", "1,00 mm", "1,13 mm", "1,25 mm", "1,50 mm" };
	private final String[] beschichtung = { "DU/RSL", "25my/RSL", "25my/25my" };
	private final String[] zulage = { "keine Zulagen", "Akustiklochung", "Vliesbeschichtung" };
	private final String[] maxLaenge = { "13,60 mtr.", "16,00 mtr.", "18,00 mtr.", "19,00 mtr." };

	public TBPane() {
		prepareSelectionPaneTB();
		prepareListPaneTB();
		prepareButtonPaneTB();
		
		
		contentPaneTB.add(selectionPaneTB, BorderLayout.NORTH);
		contentPaneTB.add(listPaneTB, BorderLayout.CENTER);
		contentPaneTB.add(buttonPaneTB, BorderLayout.PAGE_END);
		selectionPaneTB.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		// Listeners TB


	}
	
	public JPanel getContentPaneTB() {
		return contentPaneTB;
	}
	
	private void prepareSelectionPaneTB() {

		contentPaneTB = new JPanel(new BorderLayout());
		selectionPaneTB = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		selectionPaneTB.add(Box.createHorizontalStrut(10), c);

		label = new JLabel("Profil:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		selectionPaneTB.add(label, c);

		label = new JLabel("Dicke:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		selectionPaneTB.add(label, c);

		label = new JLabel("Beschichtung:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 0;
		selectionPaneTB.add(label, c);

		label = new JLabel("Zulage:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 4;
		c.gridy = 0;
		selectionPaneTB.add(label, c);

		label = new JLabel("Menge:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 5;
		c.gridy = 0;
		selectionPaneTB.add(label, c);

		label = new JLabel("Bedarfsmarkierung");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.4;
		c.gridx = 6;
		c.gridy = 0;
		selectionPaneTB.add(label, c);

		c.gridx = 7;
		c.gridy = 0;
		selectionPaneTB.add(Box.createHorizontalStrut(10), c);

		profilCB = new JComboBox<>(profil);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridheight = 2;
		c.gridx = 1;
		c.gridy = 1;
		selectionPaneTB.add(profilCB, c);

		dickeCB = new JComboBox<>(dicke);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 1;
		selectionPaneTB.add(dickeCB, c);

		beschichtungCB = new JComboBox<>(beschichtung);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 3;
		c.gridy = 1;
		selectionPaneTB.add(beschichtungCB, c);

		zulageCB = new JComboBox<>(zulage);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 4;
		c.gridy = 1;
		selectionPaneTB.add(zulageCB, c);

		mengeSP = new JSpinner();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 5;
		c.gridy = 1;
		selectionPaneTB.add(mengeSP, c);

		bedarfRB = new JRadioButton("Bedarf");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = 1;
		c.weightx = 0.4;
		c.gridx = 6;
		c.gridy = 1;
		selectionPaneTB.add(bedarfRB, c);

		alternativeRB = new JRadioButton("Alternativ");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.4;
		c.gridx = 6;
		c.gridy = 2;
		selectionPaneTB.add(alternativeRB, c);

		ButtonGroup btn = new ButtonGroup();
		btn.add(bedarfRB);
		btn.add(alternativeRB);

		bedarfRB.setSelected(true);
		
		JSeparator sep = new JSeparator(SwingConstants.VERTICAL);
		sep.setPreferredSize(new Dimension(3,1));
		c.fill = GridBagConstraints.VERTICAL;
		c.weighty = 1;
		c.weightx = 0.1;
		c.gridx = 7;
		c.gridy = 0;
		c.gridheight = 3;
		selectionPaneTB.add(sep, c);
		
		label = new JLabel("max. Länge:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = 1;
		c.gridx = 8;
		c.gridy = 0;
		selectionPaneTB.add(label, c); 
		
		laengeCB = new JComboBox<>(maxLaenge);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = 1;
		c.weightx = 0.5;
		c.gridx = 8;
		c.gridy = 1;
		selectionPaneTB.add(laengeCB, c);
		laengeCB.addActionListener(e -> changePLZ());
		
		label = new JLabel("Postleitzahl:");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridheight = 1;
		c.gridx = 10;
		c.gridy = 0;
		selectionPaneTB.add(label, c);
		
		plzTF = new JTextField(8);
		c.gridheight = 1;
		c.gridx = 10;
		c.gridy = 1;
		c.weightx = 0.5;
		selectionPaneTB.add(plzTF, c);
		plzTF.addActionListener(e -> changePLZ());
		
		JButton calcBtn = new JButton("Zur Liste hinzufügen");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 3;
		c.gridx = 8;
		c.gridy = 2;
		c.weightx = 0.5;
		selectionPaneTB.add(calcBtn, c);
		calcBtn.addActionListener(e -> this.calcBtnPressed());
		
		c.gridx = 0;
		c.gridy = 0;
		selectionPaneTB.add(Box.createVerticalStrut(3), c);
		
		c.gridx = 0;
		c.gridy = 3;
		selectionPaneTB.add(Box.createVerticalStrut(3), c);
		
	}

	private void prepareListPaneTB() {
		listPaneTB = new JPanel();
		listPaneTB.setLayout(new BoxLayout(listPaneTB, BoxLayout.PAGE_AXIS));
		model = new TBTableModel();
		table = new JTable(model);
		JTableUtilities.setCellsAlignmentTB(table, SwingConstants.CENTER);
		
		tableColumn5 = table.getColumnModel().getColumn(5);
		tableColumn6 = table.getColumnModel().getColumn(6);
		tableColumn7 = table.getColumnModel().getColumn(7);
		
		table.getColumnModel().getColumn(8).setCellRenderer(new StatusColumnCellRenderer());
		table.getColumnModel().getColumn(5).setCellRenderer(new StatusColumnCellRenderer());
		
		model.addTableModelListener(e -> updateGesamt());
		
	    TableColumn col = table.getColumnModel().getColumn(0);
	    col.setCellEditor(new MyComboBoxEditor(profil));
	    col.setCellRenderer(new MyComboBoxRenderer(profil));
	    
	    TableColumn col2 = table.getColumnModel().getColumn(1);
	    col2.setCellEditor(new MyComboBoxEditor(dicke));
	    col2.setCellRenderer(new MyComboBoxRenderer(dicke));
	    
	    TableColumn col3 = table.getColumnModel().getColumn(2);
	    col3.setCellEditor(new MyComboBoxEditor(beschichtung));
	    col3.setCellRenderer(new MyComboBoxRenderer(beschichtung));
	    
	    TableColumn col4 = table.getColumnModel().getColumn(3);
	    col4.setCellEditor(new MyComboBoxEditor(zulage));
	    col4.setCellRenderer(new MyComboBoxRenderer(zulage));
		
		
		

		listPaneTB.add(new JScrollPane(table));
		listPaneTB.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

	}

	private void prepareButtonPaneTB() {
		lableGesamtPaneTB = new JPanel(new GridBagLayout());
		GridBagConstraints lblCons = new GridBagConstraints();

		lblCons.gridx = 0;
		lblCons.gridy = 0;
		lableGesamtPaneTB.add(Box.createHorizontalStrut(10), lblCons);

		JCheckBox showAllRowsBtn = new JCheckBox("Alle Spalten anzeigen");
		lblCons.weightx = 0.5;
		lblCons.gridheight = 1;
		lblCons.gridx = 1;
		lblCons.gridy = 0;
		lableGesamtPaneTB.add(showAllRowsBtn, lblCons);
		showAllRowsBtn.addActionListener(e -> this.allColumnBtnPressed(showAllRowsBtn.isSelected()));
		allColumnBtnPressed(false);
		
		JButton deleteRowBtn = new JButton("Ausgewählte Zeile löschen");
		lblCons.weightx = 0.5;
		lblCons.gridheight = 1;
		lblCons.gridx = 1;
		lblCons.gridy = 1;
		lableGesamtPaneTB.add(deleteRowBtn, lblCons);
		deleteRowBtn.addActionListener(e -> this.removeTrapez());

		label = new JLabel("Gesamtgewicht:");
		lblCons.fill = GridBagConstraints.HORIZONTAL;
		lblCons.weightx = 0.5;
		lblCons.gridheight = 1;
		lblCons.gridx = 2;
		lblCons.gridy = 0;
		lableGesamtPaneTB.add(label, lblCons);

		gesamtgewichtLb = new JLabel("0.00 to");
		lblCons.fill = GridBagConstraints.HORIZONTAL;
		lblCons.gridx = 2;
		lblCons.gridy = 1;
		lableGesamtPaneTB.add(gesamtgewichtLb, lblCons);

		label = new JLabel("Gesamt-QM:");
		lblCons.fill = GridBagConstraints.HORIZONTAL;
		lblCons.gridx = 3;
		lblCons.gridy = 0;
		lableGesamtPaneTB.add(label, lblCons);

		gesamtqmLb = new JLabel("0.00 qm");
		lblCons.fill = GridBagConstraints.HORIZONTAL;
		lblCons.gridx = 3;
		lblCons.gridy = 1;
		lableGesamtPaneTB.add(gesamtqmLb, lblCons);
		
		label = new JLabel("Transport");
		lblCons.fill = GridBagConstraints.HORIZONTAL;
		lblCons.gridx = 4;
		lblCons.gridy = 0;
		lableGesamtPaneTB.add(label, lblCons);
		
		transportLb = new JLabel("///");
		lblCons.fill = GridBagConstraints.HORIZONTAL;
		lblCons.gridx = 4;
		lblCons.gridy = 1;
		lableGesamtPaneTB.add(transportLb, lblCons);
		

		////////////////////////////////////////////////////////////////////////////////////////////////////

		buttonPaneTB = new JPanel();
		buttonPaneTB.setLayout(new BoxLayout(buttonPaneTB, BoxLayout.LINE_AXIS));
		buttonPaneTB.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		buttonPaneTB.add(lableGesamtPaneTB);
		buttonPaneTB.add(Box.createHorizontalGlue());
		JButton resetBtn = new JButton("Reset");
		JButton exportBtn = new JButton("Export");

		buttonPaneTB.add(resetBtn);
		buttonPaneTB.add(Box.createRigidArea(new Dimension(10, 0)));
		buttonPaneTB.add(exportBtn);
		
		resetBtn.addActionListener(e -> this.resetBtnPressed());
		exportBtn.addActionListener(e -> System.out.println(model.getValueAt(table.getSelectedRow(), 2)));
	}

///////////Funktions for Tabel TB//////////
	

private boolean checkPreisliste(Trapezblech tb) {
	if (tb.isInPreisliste()) {
		return true;
	}
	else {
		JOptionPane.showMessageDialog(contentPaneTB, "Nur auf Anfrage verfügbar");
		return false;
	}
}

public void addTrapez(Trapezblech tb) {
	model.addTB(tb);
}

private void removeTrapez() {
	model.removeTB(table.getSelectedRow());
	updateGesamt();
}

private void changePLZ() {
	if(Trapezblech.getPlz() == null || Trapezblech.getMaxLaenge() == null || (Trapezblech.getPlz() == laengeCB.getItemAt(laengeCB.getSelectedIndex())  && Trapezblech.getMaxLaenge() == plzTF.getText())) {
		return;
	}
	else {
		Trapezblech.setMaxLaenge(laengeCB.getSelectedIndex());
		Trapezblech.setPlz(plzTF.getText());
		model.refreshAll();
	}
}

private void updateGesamt() {
	gesamtgewichtLb.setText(Trapezblech.getGesamtgewicht() + " to");
	gesamtqmLb.setText(Trapezblech.getGesamtqm() + " qm");
	if(Trapezblech.getBenoetigteLKW() == 0 ) transportLb.setText("Beiladung nach " + Trapezblech.getPlz());
	else if(Trapezblech.getBenoetigteLKW() ==1 ) transportLb.setText(Trapezblech.getBenoetigteLKW() + " LKW mit max. " + Trapezblech.getMaxLaenge() + " nach " + Trapezblech.getPlz());
	else transportLb.setText(Trapezblech.getBenoetigteLKW() + " LKWs mit max. " + Trapezblech.getMaxLaenge()+ " nach " + Trapezblech.getPlz());

}

private void calcBtnPressed() {
	try {
		mengeSP.commitEdit();
	} catch (Exception ex) {
		System.err.println("Failed to commit edit Spinner Menge");
	}
	Trapezblech tb = new Trapezblech(profilCB.getSelectedIndex(), dickeCB.getSelectedIndex(), beschichtungCB.getSelectedIndex(), zulageCB.getSelectedIndex(), (int) mengeSP.getValue(), bedarfRB.isSelected(), laengeCB.getSelectedIndex(), plzTF.getText());
	if(this.checkPreisliste(tb)){
		addTrapez(tb);
		if (bedarfRB.isSelected()) this.updateGesamt();	
	}

}

public void allColumnBtnPressed(boolean b) {
	if(!b) {
		table.getColumnModel().removeColumn(tableColumn5);
		table.getColumnModel().removeColumn(tableColumn6);
		table.getColumnModel().removeColumn(tableColumn7);
	}
	else {
		table.getColumnModel().addColumn(tableColumn5);
		table.getColumnModel().moveColumn(table.getColumnCount()-1, 5);
		table.getColumnModel().addColumn(tableColumn6);
		table.getColumnModel().moveColumn(table.getColumnCount()-1, 6);
		table.getColumnModel().addColumn(tableColumn7);
		table.getColumnModel().moveColumn(table.getColumnCount()-1, 7);
	}

}

private void resetBtnPressed() {
	while (model.getRowCount() > 0) {
		model.removeTB(0);
		Trapezblech.resetGesamt();
		this.updateGesamt();
	}
}


	

}

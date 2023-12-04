import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class StatusColumnCellRenderer extends DefaultTableCellRenderer {
	
	private static final long serialVersionUID = 333158653405947546L;

		@Override
		  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {

		    //Cells are by default rendered as a JLabel.
		    JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

		    //Get the status for the current row.
		    TBTableModel tableModel = (TBTableModel) table.getModel();
		    if (tableModel.getValueAt(row, col) == "Nur auf Anfrage" ||tableModel.getValueAt(row, col) == "0 €/qm") {
		      l.setBackground(Color.decode("#8B0000"));
		    } else {
		      l.setBackground(Color.decode("#001b36"));
		    }

		  //Return the JLabel which renders the cell.
		  return l;

		}
	}
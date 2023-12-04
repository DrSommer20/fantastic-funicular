import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

class JTableUtilities
{
    public static void setCellsAlignmentTB(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
        	if(!(columnIndex == 10)) table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
    public static void setCellsAlignmentPU(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount()-1; columnIndex++)
        {
        	if(!(columnIndex == 3)) table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
}
class MyComboBoxRenderer extends JComboBox<String> implements TableCellRenderer {

	private static final long serialVersionUID = 1L;

	public MyComboBoxRenderer(String[] items) {
	    super(items);
	  }

	  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
	      boolean hasFocus, int row, int column) {
	    if (isSelected) {
	      setForeground(table.getSelectionForeground());
	      super.setBackground(table.getSelectionBackground());
	    } else {
	      setForeground(table.getForeground());
	      setBackground(table.getBackground());
	    }
	    setSelectedItem(value);
	    return this;
	  }
	}

	class MyComboBoxEditor extends DefaultCellEditor {
	
		private static final long serialVersionUID = 1L;

	public MyComboBoxEditor(String[] items) {
	    super(new JComboBox<String>(items));
	  }
	}
	
	
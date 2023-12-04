import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

class CustomTableModelTB extends DefaultTableModel implements TableModelListener{
	private static final String[] columnNames= new String[]{"Profil", "Dicke", "Beschichtung", "Zulage", "Menge", "Preis", "Gewicht", "Bedarf", "max. Länge", "PLZ"};
	public CustomTableModelTB() { 
		super(columnNames, 0);
	}
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
            	return Integer.class;
            case 5:
            	return String.class;
            case 6:
            	return Double.class;
            case 7:
            	return Boolean.class;
            case 8:
            	return String.class;
            default:
            	return String.class;
        }
    }
	
	@Override
	public boolean isCellEditable(int row, int col) {
	        if (col == 5 || col == 6) {
	            return false;
	        } else {
	            return true;
	        }

	}

	@Override
	public void tableChanged(TableModelEvent e) {		
		
	}

}


class CustomTableModelPU extends DefaultTableModel implements TableModelListener{
	private static final String[] columnNames= new String[]{"Art", "Dicke", "Beschichtung", "Verpackung", "Menge", "Preis", "Bedarf"};
	public CustomTableModelPU() { 
		super(columnNames, 0);
	}
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public Class<?> getColumnClass(int column) {
        switch (column) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Boolean.class;
            case 4:
            	return Integer.class;
            case 5:
            	return Double.class;
            case 6:
                return Boolean.class;
            default:
                return Boolean.class;
        }
    }
	
	@Override
	public boolean isCellEditable(int row, int col) {
	            return false;
	        }

	@Override
	public void tableChanged(TableModelEvent e) {		
		
	}

}
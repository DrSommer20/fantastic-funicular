import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TBTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String[] columnNames= new String[]{"Profil", "Dicke", "Beschichtung", "Zulage", "Menge", "Tonnenpreis ohne Zuschläge", "Aufschlag Tonnenpreis","Preis ab Werk", "Preis Franko", "Gewicht", "Bedarf"};
	private List<Trapezblech> trapezbleche;
	
	public TBTableModel() {
		trapezbleche = new ArrayList<Trapezblech>();
	}
	
	public TBTableModel(List<Trapezblech> trapezbleche) {
		this.trapezbleche = trapezbleche;
	}

	@Override
	public int getRowCount() {
		return trapezbleche.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
	
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
            	return String.class;
            case 8:
            	return String.class;
            case 9:
            	return Double.class;
            case 10:
            	return Boolean.class;
//            case 11:
//            	return String.class;
            default:
            	return String.class;
        }
    }
	@Override
	public boolean isCellEditable(int row, int col) {
	        if (col == 5 || col == 7 || col == 8 || col == 9) {
	            return false;
	        } else {
	            return true;
	        }

	}
	@Override
	public Object getValueAt(int row, int column)
	{
	    Trapezblech tb = getTB(row);
	 
	    switch (column)
	    {
	        case 0: return "" + tb.getProfil();
	        case 1: return tb.getDicke();
	        case 2: return tb.getBeschichtung();
	        case 3: return tb.getZulage();
	        case 4: return tb.getMenge();
	        case 5: return tb.getToPreis();
	        case 6: return tb.getZuschlagToManuell();
	        case 7: return tb.getQmPreisAbWerk();
	        case 8: return tb.getQmPreis();
	        case 9: return tb.getGewicht();
	        case 10: return tb.isBedarf();
	        //case 11: return Trapezblech.getMaxLaenge();
	       // case 12: return Trapezblech.getPlz();
	        default: return null;
	    }
	}
	 
	@Override
	public void setValueAt(Object value, int row, int column)
	{		
		
		int profil = Trapezblech.StringtoIndex(""+this.getValueAt(row, 0));
    	int dicke = Trapezblech.StringtoIndex((String)this.getValueAt(row, 1));
    	int beschichtung = Trapezblech.StringtoIndex((String)this.getValueAt(row, 2));
    	int zulage = Trapezblech.StringtoIndex((String)this.getValueAt(row, 3));
    	int menge = (Integer)this.getValueAt(row, 4);
    	boolean isBedarf = (Boolean)this.getValueAt(row, 10);
    	int laengeIndex = Trapezblech.StringtoIndex(Trapezblech.getMaxLaenge());
    	String plz = (String)Trapezblech.getPlz();
		
	 
	    switch (column)
	    {
	        case 0 -> profil = Trapezblech.StringtoIndex((String)value);
	        case 1 -> dicke = Trapezblech.StringtoIndex((String)value);
	        case 2 -> beschichtung = Trapezblech.StringtoIndex((String)value);
	        case 3 -> zulage = Trapezblech.StringtoIndex((String)value);
	        case 4 -> menge = (Integer)value;
	        case 10 -> isBedarf = (Boolean)value;
	        //case 11 -> laengeIndex = Trapezblech.StringtoIndex((String)value);
	        //case 12 -> plz = (String)value;
	        

	    }
	    
	    Trapezblech tbNew = new Trapezblech(profil, dicke, beschichtung, zulage, menge, isBedarf, laengeIndex, plz);
	    removeTB(row);
	    insertTB(row, tbNew);
	    refreshAll();
	}
	
	public Trapezblech getTB(int row)
	{
	    return trapezbleche.get( row );
	}
	
	public void addTB(Trapezblech tb)
	{
	    insertTB(getRowCount(), tb);
	    refreshAll();
	}
	 
	public void insertTB(int row, Trapezblech tb)
	{
	    trapezbleche.add(row, tb);
	    refreshAll();
	}
	
	public void removeTB(int row)
	{
	    trapezbleche.remove(row);
	    refreshAll();
	}
	
	public void refreshAll() {
		
		int menge = 0;
		double gewicht = 0;
		for(int i = 0; i < getRowCount(); i++) {
			if((Boolean)this.getValueAt(i, 10)) {
				Trapezblech tb = getTB(i);
				menge += tb.getMenge();
				gewicht += tb.getGewichtDouble();
			}
		}
		Trapezblech.setGesamtgewicht(gewicht);
		Trapezblech.setGesamtqm(menge);
		Trapezblech.setTransportpreisProQm();
		
		fireTableDataChanged();
	}
	

}

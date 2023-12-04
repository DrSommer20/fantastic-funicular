
class Paneel {
	protected String art;
	protected int menge;
	protected int dicke;
	protected int dickeIndex;
	protected int beschichtung;
	private boolean verpackung;
	private String plz;
	private int plzGebiet;
	protected double zuschlagQm;
	protected int zuschlagFix;
	private double QMEinzelpreis;
	private boolean isBedarf;
	private static int gesamtQM;
	private static int fracht;
	
	public Paneel(String dicke, int beschichtung, String plz, int menge, boolean isBedarf) {
		this.dicke = Integer.parseInt(dicke);
		this.beschichtung = beschichtung;
		this.plz = plz;
		this.menge = menge;
		this.isBedarf = isBedarf;
		setArt();
		PlzGebiet();
		setDickeIndex();
		PlzQMPreis();
		zuschlaegeFarbe();
		einstellkosten();
		if(isBedarf) gesamtQM += menge;
	}
	public Paneel(String dicke, int beschichtung, String plz, boolean verpackung, int menge, boolean isBedarf) {
		this(dicke, beschichtung, plz, menge, isBedarf);
		this.verpackung = verpackung;
		if(verpackung)verpackungDach();
	}
	protected void setArt(){
		art = "";
	}
	
	public String getArt() {
		return art;
	}
	public boolean isBedarf() {
		return isBedarf;
	}
	public int getMenge() {
		return menge;
	}
	public int getDicke() {
		return dicke;
	}
	public String getBeschichtung() {
		String s;
		switch(beschichtung) {
		case 0 -> s = "Sonderfarbe";
		default -> s = "Standardfarbe";
		}
		return s;
	}
	public boolean isVerpackung() {
		return verpackung;
	}

	public static int getGesamtQM() {
		return gesamtQM;
	}
	public static void setGesamtQM(int gesamtQM) {
		Paneel.gesamtQM = gesamtQM;
	}
	protected void PlzGebiet(){
		int[][] plzArr = ScannerListe.PaneelZwevezelePlz();
		int plz1 = Integer.parseInt(plz.substring(0, 1));
		int plz2 = Integer.parseInt(plz.substring(1, 2));

		plzGebiet = plzArr[plz1][plz2];	
	}
	
	protected void PlzQMPreis(){
		double[][] qmPreis = ScannerListe.PaneelZwevezele();
		QMEinzelpreis = qmPreis[dickeIndex][plzGebiet-1];
	}
	protected void zuschlaegeFarbe() {
		double[][] zuschlaegeFarbe = ScannerListe.PaneelZwevezeleFarbe();
		int mengeIndex = -1;
		if(menge <= 50) {
			mengeIndex = 0;
		}
		else if(menge <= 100) {
			mengeIndex = 1;
		}
		else if(menge <= 250) {
			mengeIndex = 2;
		}
		else if(menge <= 500) {
			mengeIndex = 3;
		}
		else if(menge > 500) {
			mengeIndex = 4;
		}
		zuschlagQm = zuschlaegeFarbe[mengeIndex][beschichtung];
	}
	protected void einstellkosten() {
		
	}
	protected void verpackungDach() {
		
	}
	protected void frachtkosten() {
		if(gesamtQM < 500) fracht = 500;
	}
	protected void setDickeIndex() {
		
	}
	
	public double getQMPreis() {
		return QMEinzelpreis + zuschlagQm + ((double)zuschlagFix)/menge + ((double)fracht)/gesamtQM;
	}
	
	
}


class PUPaneelDach extends Paneel{
	
	public PUPaneelDach(String dicke, int beschichtung, String plz, boolean verpackung, int menge, boolean isBedarf) {
		super(dicke, beschichtung, plz, verpackung, menge, isBedarf);
		
		System.out.println("Dach erstellt");
	}
	@Override
	protected void setDickeIndex() {
		switch(dicke) {
		case 30 -> dickeIndex = 0;
		case 40 -> dickeIndex = 1;
		case 60 -> dickeIndex = 2;
		case 80 -> dickeIndex = 3;
		case 100 -> dickeIndex = 4;
		case 120 -> dickeIndex = 5;
		case 150 -> dickeIndex = 6;
		}
	}
	@Override
	protected void einstellkosten() {
		if(menge<100) {
			if(beschichtung == 0) zuschlagFix += 250;
			else zuschlagFix += 150;
		}
	}
	@Override
	protected void verpackungDach() {
		if(dicke < 70) zuschlagQm += 0.50;
		else zuschlagQm += 0.25;
	}
	
	@Override
	protected void setArt(){
		art =  "Dach";
	}	
	
}

class PUPaneelSB extends Paneel{
	
	public PUPaneelSB(String dicke, int beschichtung, String plz, int menge, boolean isBedarf) {
		super(dicke, beschichtung, plz,  menge, isBedarf);
	}
	@Override
	protected void setDickeIndex() {
		switch(dicke) {
		case 40 -> dickeIndex = 8;
		case 60 -> dickeIndex = 9;
		case 80 -> dickeIndex = 10;
		case 100 -> dickeIndex = 11;
		case 120 -> dickeIndex = 12;
		case 150 -> dickeIndex = 13;
		case 170 -> dickeIndex = 14;
		case 200 -> dickeIndex = 15;
		case 220 -> dickeIndex = 16;
		}
	}
	@Override
	protected void einstellkosten() {
		if(menge<100) {
			if(beschichtung == 0) {
				if(menge<50)zuschlagFix += 350;
				else zuschlagFix += 500;
			}
			else zuschlagFix += 250;
		}
	}
	
	@Override
	protected void setArt(){
		art =  "Wand SB";
	}
}
class PUPaneelVB extends Paneel{
	
	public PUPaneelVB(String dicke, int beschichtung, String plz, int menge, boolean isBedarf) {
		super(dicke, beschichtung, plz,  menge, isBedarf);
	}
	@Override
	protected void setDickeIndex() {
		switch(dicke) {
		case 60 -> dickeIndex = 18;
		case 80 -> dickeIndex = 19;
		case 100 -> dickeIndex = 20;
		case 120 -> dickeIndex = 21;
		case 150 -> dickeIndex = 22;
		}
	}
	@Override
	protected void einstellkosten() {
		if(menge<100) {
			if(beschichtung == 0) {
				if(menge<50)zuschlagFix += 350;
				else zuschlagFix += 500;
			}
			else zuschlagFix += 250;
		}
	}
	
	@Override
	protected void setArt(){
		art = "Wand VB";
	}
}
class MiWoPaneelDach extends Paneel{
	
	public MiWoPaneelDach(String dicke, int beschichtung, String plz, int menge, boolean isBedarf) {
		super(dicke, beschichtung, plz,  menge, isBedarf);
	}
	
	
}
class MiWoPaneelWandSB extends Paneel{
	
	public MiWoPaneelWandSB(String dicke, int beschichtung, String plz, int menge, boolean isBedarf) {
		super(dicke, beschichtung, plz,  menge, isBedarf);
	}
}
class MiWoPaneelWandVB extends Paneel{
	
	public MiWoPaneelWandVB(String dicke, int beschichtung, String plz, int menge, boolean isBedarf) {
		super(dicke, beschichtung, plz,  menge, isBedarf);
	}
}

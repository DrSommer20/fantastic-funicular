
class Trapezblech{

	private int menge;
	private int profil;
	private int dicke;
	private int beschichtung;
	private int zulage;
	private double toProQm;
	private int einlaufbreite;
	private int toPreis;
	private int zuschlagTo;
	private double zuschlagQm;
	private int zuschlagFix;
	private int zuschlagProzent;
	private double QmPreis;

	public Trapezblech(int menge, int profil, int dicke, int beschichtung, int zulage) {
		this.profil = profil;
		this.dicke = dicke;
		this.beschichtung = beschichtung;
		this.zulage = zulage;
		this.menge = menge;
		this.calcQmProTo();
		this.calcEinlaufbreite();
		this.calcToPreis();
		this.calcMindermengen();
	}
	public int getProfil() {
		int profil = 0;
		switch(this.profil) {
		case 0:
			profil = 18;
			break;
		case 1:
			profil = 19;
			break;
		case 2:
			profil = 27;
			break;
		case 3:
			profil = 30;
			break;
		case 4:
			profil = 35;
			break;
		case 5:
			profil = 40;
			break;
		case 6:
			profil = 45;
			break;
		case 7:
			profil = 50;
			break;
		case 8:
			profil = 85;
			break;
		case 9:
			profil = 89;
			break;
		case 10:
			profil = 100;
			break;
		case 11:
			profil = 106;
			break;
		case 12:
			profil = 135;
			break;
		case 13:
			profil = 153;
			break;
		case 14:
			profil = 158;
			break;
		case 15:
			profil = 200;
			break;
			
		}
		return profil;
	}
	public String getDicke() {
		String dicke = "";
		switch(this.dicke) {
		case 0:
			dicke = "0,60 mm";
			break;
		case 1:
			dicke = "0,75 mm";
			break;			
		case 2:
			dicke = "0,88 mm";
			break;
		case 3:
			dicke = "1,00 mm";
			break;
		case 4:
			dicke = "1,13 mm";
			break;
		case 5:
			dicke = "1,25 mm";
			break;
		case 6:
			dicke = "1,50 mm";
			break;
		}
		
		return dicke;
	}
	public String getBeschichtung() {
		String beschichtung = "";
		switch(this.beschichtung) {
		case 0:
			beschichtung = "DU/RSL";
			break;
		case 1:
			beschichtung = "25my/RSL";
			break;
		case 2:
			beschichtung = "25my/25my";
			break;
		}
		return beschichtung;
	}
	public String getZulage() {
		String zulage = "";
		switch(this.zulage) {
		case 0:
			zulage = "keine Zulagen";
			break;
		case 1:
			zulage = "Akustiklochung";
			break;
		case 2:
			zulage = "Vliesbeschichtung";
			break;
		}
		return zulage;
	}
	public double gettToProQm() {
		return toProQm;
	}
	public int getMenge() {
		return menge;
	}
	public void setMenge(int menge) {
		this.menge = menge;
	}
	private void calcQmProTo() {
		double[][] kgqmListe = null;
		try {
			kgqmListe = ScannerListe.kgqm();
		} catch (Exception e) {
			e.printStackTrace();
		}

		toProQm = kgqmListe[profil][dicke]/1000;
	}

	private void calcEinlaufbreite() {
		switch(profil) {
		case 0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11:
			this.einlaufbreite = 1250;
			break;
		case 8, 12, 13, 14, 15:
			this.einlaufbreite = 1500;
			break;
		}
	}
	private void calcToPreis(){
		int[][] preisliste = null;
		try {
			if(einlaufbreite == 1250) {
				preisliste = ScannerListe.pl1250();
				this.toPreis = preisliste[dicke][beschichtung];
			}
			else if(einlaufbreite == 1500) {
				preisliste = ScannerListe.pl1500();
				this.toPreis = preisliste[dicke][beschichtung];
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void calcMindermengen(){
		this.zuschlagFix = 0;
		this.zuschlagQm = 0;
		this.zuschlagTo = 0;
		this.zuschlagProzent = 100;
		int help= 0;
		int einlaufbreite = 0;

		if(this.einlaufbreite == 1250)einlaufbreite = 0;
		else if(this.einlaufbreite == 1500)einlaufbreite = 1;
		try {
		int[][] mm = ScannerListe.mindermenge();
		double[][] vlies = ScannerListe.vlies();
		int[][] perfo = ScannerListe.perfo();


		if(this.zulage == 1) {
			if(menge<= 100) zuschlagQm += vlies[einlaufbreite][0];
			else if(menge>100&&menge<=250) zuschlagQm += vlies[einlaufbreite][1];
			else if(menge>250&&menge<=1500) zuschlagQm += vlies[einlaufbreite][2];
			else if(menge>1500) zuschlagQm +=	 vlies[einlaufbreite][3];
		}
		else if(this.zulage == 2) {
			if(einlaufbreite == 0) help = 0;
			else if(einlaufbreite == 1 && beschichtung == 0) help = 3;
			else if(einlaufbreite == 1 && beschichtung == 1) help = 6;
			if(menge<= 250) {
				zuschlagTo += perfo[help][0];
				zuschlagFix += perfo[help][1];
			}
			else if(menge>250&&menge<=500)  {
				zuschlagTo += perfo[help+1][0];
				zuschlagFix += perfo[help+1][1];
			}
			else if(menge>500)  {
				zuschlagTo += perfo[help+2][0];
				zuschlagFix += perfo[help+2][1];
			}
		}
		if(menge<=25) {
			zuschlagProzent += mm[0][0];
			zuschlagFix += mm[0][1];
		}
		else if(menge>25&&menge<=50) {
			zuschlagProzent += mm[1][0];
			zuschlagFix += mm[1][1];
		}
		else if(menge>50&&menge<=100) {
			zuschlagProzent += mm[2][0];
			zuschlagFix += mm[2][1];
		}
		else if(menge>100&&menge<=250) {
			zuschlagProzent += mm[3][0];
			zuschlagFix += mm[3][1];
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public double getQmPreis() {
		QmPreis = ((toPreis + zuschlagTo)*toProQm + zuschlagQm + (double)zuschlagFix/menge) * ((double)zuschlagProzent / 100);
		QmPreis = Trapezblech.round(QmPreis, 2);
		return QmPreis;
	}
	private static double round(double x, int digits) {
		long help = (long) Math.pow(10, digits);
		return ((double) Math.round(x * help)) / help;
	}


}

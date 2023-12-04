import java.util.Arrays;

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
	private int zuschlagToManuell;
	private double zuschlagQm;
	private int zuschlagFix;
	private int zuschlagProzent;
	private double QmPreis;
	private static double gesamtgewicht;
	private static double gesamtqm;
	private static double transportProQm;
	private static int benoetigteLKW;
	private static String plz;
	private static int maxLaenge;
	private boolean isBedarf;

	public Trapezblech(int profil, int dicke, int beschichtung, int zulage, int menge, boolean isBedarf, int maxLaenge, String plz) {
		this.profil = profil;
		this.dicke = dicke;
		this.beschichtung = beschichtung;
		this.zulage = zulage;
		this.menge = menge;
		this.isBedarf = isBedarf;
		Trapezblech.plz = plz;
		Trapezblech.maxLaenge = maxLaenge;
		this.calcQmProTo();
		this.calcEinlaufbreite();
		this.calcToPreis();
		this.calcMindermengen();
		if(isBedarf) this.addGesamt();
		Trapezblech.setTransportpreisProQm();
	}
	
	public static String getPlz() {
		return plz;
	}

	public static String getMaxLaenge() {
		String maxLaenge = "";
		switch(Trapezblech.maxLaenge) {
		case 0 ->maxLaenge = "13,60 mtr.";
		case 1 -> maxLaenge = "16,00 mtr.";
		case 2 -> maxLaenge = "18,00 mtr.";
		case 3 -> maxLaenge = "19,00 mtr.";
		}
		
		return maxLaenge;
	}

	public static void setGesamtgewicht(double gesamtgewicht) {
		Trapezblech.gesamtgewicht = gesamtgewicht;
	}

	public static void setGesamtqm(double gesamtqm) {
		Trapezblech.gesamtqm = gesamtqm;
	}

	public static double getGesamtgewicht() {
		return Trapezblech.round(gesamtgewicht, 2);
	}

	public static double getGesamtqm() {
		return gesamtqm;
	}
	
	public static void setPlz(String plz) {
		Trapezblech.plz = plz;
	}

	public static void setMaxLaenge(int maxLaenge) {
		Trapezblech.maxLaenge = maxLaenge;
	}

	public static int getBenoetigteLKW() {
		return benoetigteLKW;
	}


	public boolean isBedarf() {
		return isBedarf;
	}

	public void setBedarf(boolean isBedarf) {
		this.isBedarf = isBedarf;
	}

	public static void resetGesamt() {
		Trapezblech.gesamtqm = 0;
		Trapezblech.gesamtgewicht = 0;
		Trapezblech.benoetigteLKW= 0;
		Trapezblech.transportProQm = 0;
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
	
	public int getProfilInt() {
		return profil;
	}
	
	public String getDicke() {
		String dicke = "";
		switch(this.dicke) {
		case 0:
			dicke = "0,63 mm";
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
	
	public int getDickeInt() {
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
	
	public int getBeschichtungInt() {
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
	
	public int getZulageInt() {
		return zulage;
	}
	
	public double getToProQm() {
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


		if(this.zulage == 2) {
			if(menge<= 100) zuschlagQm += vlies[einlaufbreite][0];
			else if(menge>100&&menge<=250) zuschlagQm += vlies[einlaufbreite][1];
			else if(menge>250&&menge<=1500) zuschlagQm += vlies[einlaufbreite][2];
			else if(menge>1500) zuschlagQm +=	 vlies[einlaufbreite][3];
		}
		else if(this.zulage == 1) {
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
	
	public String getQmPreis() {
		if(isInPreisliste() || Trapezblech.transportProQm > 0) {
			if(gesamtqm != 0) {
				QmPreis = ((toPreis + zuschlagTo)*toProQm + zuschlagQm + (double)zuschlagFix/menge) * ((double)zuschlagProzent / 100) + Trapezblech.transportProQm ;
				QmPreis = Trapezblech.round(QmPreis, 2);
				return QmPreis + " €/qm";
			}
			else return "0 €/qm";
		}
		else {
			return "Nur auf Anfrage";
		}
		
	}
	
	public String getQmPreisAbWerk() {
		if(isInPreisliste()) {
		QmPreis = ((toPreis + zuschlagTo)*toProQm + zuschlagQm + (double)zuschlagFix/menge) * ((double)zuschlagProzent / 100);
		QmPreis = Trapezblech.round(QmPreis, 2);
		return QmPreis + " €/qm";
		}
		else {
			return "Nur auf Anfrage";
		}
		
	}
	
	public String getToPreis() {
		return toPreis + " €/to.";
	}
	
	public double getZuschlagToManuell() {
		return zuschlagToManuell;
	}
	
	private static double round(double x, int digits) {
		long help = (long) Math.pow(10, digits);
		return ((double) Math.round(x * help)) / help;
	}
	
	public boolean isInPreisliste() {
		if(this.toPreis == 0 || this.toProQm == 0 || this.zulage == 2 && this.dicke >= 5) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String getGewicht() {
		return Trapezblech.round(toProQm*menge, 2) + " to.";
	}
	public double getGewichtDouble() {
		return Trapezblech.round(toProQm*menge, 2);
	}
	
	private void addGesamt() {
		gesamtgewicht = gesamtgewicht+ Trapezblech.round(toProQm*menge, 2);
		gesamtqm = gesamtqm + this.menge;
	}

	public static int StringtoIndex(String s) {
		int index = -1;
		switch(s) {
		case "18" -> index = 0;
		case "19" -> index = 1;
		case "27" -> index = 2;
		case "30" -> index = 3;
		case "35" -> index = 4;
		case "40" -> index = 5;
		case "45" -> index = 6;
		case "50" -> index = 7;
		case "85" -> index = 8;
		case "89" -> index = 9;
		case "100" -> index = 10;
		case "106" -> index = 11;
		case "135" -> index = 12;
		case "153" -> index = 13;
		case "158" -> index = 14;	
		case "200" -> index = 15;
		
		case "0,63 mm" -> index = 0;
		case "0,75 mm" -> index = 1;
		case "0,88 mm" -> index = 2;
		case "1,00 mm" -> index = 3;
		case "1,13 mm" -> index = 4;
		case "1,25 mm" -> index = 5;
		case "1,50 mm" -> index = 6;
		
		case "DU/RSL" -> index = 0;
		case "25my/RSL" -> index = 1;
		case "25my/25my" -> index = 2;
		
		case "keine Zulagen" -> index = 0;
		case "Akustiklochung" -> index = 1;
		case "Vliesbeschichtung" -> index = 2;
		
		case "13,60 mtr." -> index = 0;
		case "16,00 mtr." -> index = 1;
		case "18,00 mtr." -> index = 2;
		case "19,00 mtr." -> index = 3;
		}
		
		return index;
	}
	
	public static int plzToIndex(String plz) {
		plz = plz.substring(0,2);
		int index = -1;
		switch(plz) {
		case "01" -> index = 0;
		case "02" -> index = 1;
		case "03" -> index = 2;
		case "04" -> index = 3;
		case "06" -> index = 4;
		case "07" -> index = 5;
		case "08" -> index = 6;
		case "09" -> index = 7;
		
		case "10" -> index = 8;
		case "12" -> index = 9;
		case "13" -> index = 10;
		case "14" -> index = 11;
		case "15" -> index = 12;
		case "16" -> index = 13;
		case "17" -> index = 14;
		case "18" -> index = 15;
		case "19" -> index = 16;
		
		case "20" -> index = 17;
		case "21" -> index = 18;
		case "22" -> index = 19;
		case "23" -> index = 20;
		case "24" -> index = 21;
		case "25" -> index = 22;
		case "26" -> index = 23;
		case "27" -> index = 24;
		case "28" -> index = 25;
		case "29" -> index = 26;
	
		case "30" -> index = 27;
		case "31" -> index = 28;
		case "32" -> index = 29;
		case "33" -> index = 30;
		case "34" -> index = 31;
		case "35" -> index = 32;
		case "36" -> index = 33;
		case "37" -> index = 34;
		case "38" -> index = 35;
		case "39" -> index = 36;
		
		case "40" -> index = 37;
		case "41" -> index = 38;
		case "42" -> index = 39;
		case "44" -> index = 40;
		case "45" -> index = 41;
		case "46" -> index = 42;
		case "47" -> index = 43;
		case "48" -> index = 44;
		case "49" -> index = 45;
	
		case "50" -> index = 46;
		case "51" -> index = 47;
		case "52" -> index = 48;
		case "53" -> index = 49;
		case "54" -> index = 50;
		case "55" -> index = 51;
		case "56" -> index = 52;
		case "57" -> index = 53;
		case "58" -> index = 54;
		case "59" -> index = 55;
		
		case "60" -> index = 56;
		case "61" -> index = 57;
		case "63" -> index = 58;
		case "64" -> index = 59;
		case "65" -> index = 60;
		case "66" -> index = 61;
		case "67" -> index = 62;
		case "68" -> index = 63;
		case "69" -> index = 64;
		
		case "70" -> index = 65;
		case "71" -> index = 66;
		case "72" -> index = 67;
		case "73" -> index = 68;
		case "74" -> index = 69;
		case "75" -> index = 70;
		case "76" -> index = 71;
		case "77" -> index = 72;
		case "78" -> index = 73;
		case "79" -> index = 74;
		
		case "80" -> index = 75;
		case "81" -> index = 76;
		case "82" -> index = 77;
		case "83" -> index = 78;
		case "84" -> index = 79;
		case "85" -> index = 80;
		case "86" -> index = 81;
		case "87" -> index = 82;
		case "88" -> index = 83;
		case "89" -> index = 84;
	
		case "90" -> index = 85;
		case "91" -> index = 86;
		case "92" -> index = 87;
		case "93" -> index = 88;
		case "94" -> index = 89;
		case "95" -> index = 90;
		case "96" -> index = 91;
		case "97" -> index = 92;
		case "98" -> index = 93;
		case "99" -> index = 94;
		
		}
		return index;
	}
	
	public static void setTransportpreisProQm(){
		if(gesamtgewicht < 4 && maxLaenge == 0) {
			benoetigteLKW = 0;
			int plz = Integer.parseInt(Trapezblech.plz.substring(0, 2));
			int[][] transportArr = ScannerListe.JIBeiladung();
			int preis = 0;
			int kategorie = -1;
			for(int i = 0; i < transportArr.length; i++) {
				for(int j = 0; j < transportArr[0].length; j++) {
					if(transportArr[i][j] == plz) kategorie = j;
				}
			}
			switch (kategorie) {
			case 0 -> preis = 300;
			case 1 -> preis = 340;
			case 2 -> preis = 410;
			case 3 -> preis = 450;
			case 4 -> preis = 580;
			case -1 -> preis = 0;
			}
			
			
			transportProQm = preis/gesamtqm;
		}
		else {
			int[][] transportArr = ScannerListe.JITransport();

			int LKWPreis = transportArr[plzToIndex(plz)][maxLaenge];
			int maxTonnen = 0;
			if(maxLaenge == 0) maxTonnen = 25;
			else maxTonnen = 20;
			
			benoetigteLKW = (int)Math.ceil(gesamtgewicht / (double)maxTonnen);
			
			transportProQm = (benoetigteLKW * LKWPreis) / gesamtqm;
		}
		
		
	}
	public static boolean arrayContains(final int[] arr, final int key) {
	    return Arrays.stream(arr).anyMatch(i -> i == key);
	}
}

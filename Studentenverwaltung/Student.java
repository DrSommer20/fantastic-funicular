
class Student {
	private String vorname;
	private String nachname;
	private String hochschule;
	private int semesterzahl;
	private int gebJahr;
	private boolean vonUniFH;
	private int matrikelNr;
	public static int anzahlStudenten = 0;
	
	public Student() {
		vonUniFH = false;
		anzahlStudenten++;
	}
	public Student(String vorname, String nachname, int gebJahr, int matrikelNr) {
		this();
		this.vorname = vorname;
		this.nachname = nachname;
		this.gebJahr = gebJahr;
		this.matrikelNr = matrikelNr;
	}
	public void setSemesterzahl(int semesterzahl) {
		this.semesterzahl = semesterzahl;
	}
	public void setHochschule(String hochschule){
		this.hochschule = hochschule;
	}
	public void setVonUniFH(boolean vonUniFH) {
		this.vonUniFH = vonUniFH;
	}
	public int getSemesterzahl() {
		return semesterzahl;
	}
	public String getNachname() {
		return nachname;
	}
	public String getVorname() {
		return vorname;
	}
	public String getHochschule() {
		return hochschule;
	}
	public boolean getVonUniFH() {
		return vonUniFH;
	}
	public int getMatrikelNr() {
		return matrikelNr;
	}
	public void datenausgabe() {
		System.out.println(vorname + "\n" + nachname + "\n" + hochschule + "\n" + semesterzahl + "\n" + gebJahr + "\n" + vonUniFH + "\n" + matrikelNr);
	}
	public void data2DB() {
		System.out.println("Daten in DB gespeichert");
	}
	public static void vergleicheSemesterzahl(Student s1, Student s2) {
		if(s1.getSemesterzahl() == s2.getSemesterzahl()) System.out.println("Identisch");
		else System.out.println("Verschieden");
	}
	public static Student createStudent() {
		IO.writeln("Anlegen eines Studenten:");
		Student s1 = new Student (IO.promptAndReadString("Vorname: "), IO.promptAndReadString("Nachname: "), IO.promptAndReadInt("Geburtsjahr: "), IO.promptAndReadInt("Matrikelnummer: "));
		s1.setSemesterzahl(IO.promptAndReadInt("Semesterzahl: "));
		s1.setHochschule(IO.promptAndReadString("Hochschule: "));
		s1.setVonUniFH(IO.promptAndReadBoolean("Von Hochschule oder FH? "));
		return s1;
	}
	
		
}

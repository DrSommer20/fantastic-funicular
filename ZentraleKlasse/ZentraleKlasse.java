import java.util.Scanner;
class ZentraleKlasse {
	private static Scanner scn;

	public static void main(String[] args) {
		scn = new Scanner(System.in);
		do {
			switch(eingabeInt("Was moechtest du tun? \n 1. ggtRekursiv \n 2. ggTIterativ \n 3. Falkultaet \n 4. Runden auf zwei Stellen \n 5. Kreisflaechenberechnung \n 6. Potenzberechung \n 7. Laufzeitberechung von Rente \n 8. Zinsberechung \n")) {
				case 1:
					ausgabe("Der groesste gemeinsame Teiler ist " + MyMath.ggTRekursiv(eingabeInt("Erste Zahl: "), eingabeInt("Zweite Zahl: ")));
					break;
				case 2:
					ausgabe("Der groesste gemeinsame Teiler ist " + MyMath.ggTIterativ(eingabeInt("Erste Zahl: "), eingabeInt("Zweite Zahl: ")));
					break;
				case 3:
					int b = eingabeInt("Basis der Fakultaet: ");
					ausgabe("Die Fakulaet von " + b + " ist " + MyMath.fakultaet(b));
					break;
				case 4:
					ausgabe("Gerundetes Ergebniss: " + MyMath.runden2Stellen(eingabeDouble("Flieskommazahl: ")));
					break;
				case 5:
					ausgabe("Die Kreisflaeche beträgt: " + MyMath.kreisFlaeche(eingabeDouble("Kreisradius eingeben: ")));
					break;
				case 6:
					ausgabe("Die Potenz beträgt " + MyMath.power(eingabeDouble("Basis der Potenz: "), eingabeInt("Exponent der Potenz: ")));
					break;
				case 7:
					double kapital = eingabeDouble("Anfagskapital: ");
					double zinssatz = eingabeDouble("Zinssatz in %: ")/100;
					int rente = eingabeInt("Monatliche Rente: ");
					if(kapital*zinssatz >= rente) ausgabe("Die Rente kann bei bleibenden Zinssatz unbegrenzt gezahlt werden.");
					else ausgabe("Die Rente kann für " + MyFinancialMath.rentenlaufzeit(kapital, zinssatz, rente) + " gezahlt werden.");
					break;
				case 8:
					ausgabe("Das Endkapital berträgt " + MyFinancialMath.zins(eingabeDouble("Anfagskapital: "), eingabeDouble("Zinssatz in %: "), eingabeInt("Laufzeit des Zinses in Jahren: ")) + ".");
				default:
					ausgabe("Falsche Eingabe");
			}
		}while(eingabeChar("Programm beenden? (y/n): ") != 'y');
	}
	private static int eingabeInt(String s) {
		ausgabe(s);
		int i = scn.nextInt();
		return i;
	}
	private static double eingabeDouble(String s) {
		ausgabe(s);
		double d = scn.nextDouble();
		return d;
	}
	private static char eingabeChar(String s) {
		ausgabe(s);
		char c = scn.next().charAt(0);
		return c;
	}
	private static void ausgabe(String s) {
		System.out.println(s);
	}
}
class MyMath{
	public static final double PI = 3.14;
	public static int ggTRekursiv(int a, int b) {
		if(b==0) return a;
		else if (a==0) return b;
		else if (a>b) return ggTRekursiv(a-b, b);
		else return ggTRekursiv(a, b-a);
	}
	public static int ggTIterativ(int a, int b) {
		if(a==b) {
			return b;
		}
		else {
			while(b!=0) {
				if(a>b)a=a-b;
				else b = b-a;
			}
			return a;
		}
	}
	public static long fakultaet(int m) {
		long x = 1;
		for(int i = 1; i<=m; i++) {
			x = i*x;
		}
		return x;
	}
	public static double runden2Stellen(double x) {
		return (int)(x*100.0+0.5)/100.0;
	}
	public static double kreisFlaeche(double r) {
		return r*r*PI;
	}
	public static double power(double x, int n) {
		double potenz = 1;
		for(int i = 1; i<=n; i++) {
			potenz = potenz*x;
		}
		return potenz;
	}
}
class MyFinancialMath{
	public static int rentenlaufzeit(double kapital, double zinssatz, int rente){
        int laufzeit = 0;
		while(kapital > 0){
            kapital = kapital - rente;
            kapital = MyMath.runden2Stellen(kapital + kapital * zinssatz);
            laufzeit++;
        }
        return laufzeit;
	}

	public static double zins(double kapital, double zinssatz, int laufzeit){
        for(int i = 1; i <= laufzeit; i++){
            kapital = kapital + kapital * (zinssatz);
        }
        return MyMath.runden2Stellen(kapital);
	}

}

import java.io.File;
import java.util.Scanner;

class ScannerListe {
	
	public static double[][] kgqm(){
		double[][] kgqm = new double[24][7];
		
		try {
			File file=new File("resources\\Tabellen\\kg_qm.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", 7);
				for(int i = 0; i <= 6; i++) {
					kgqm[counter][i] = Double.parseDouble(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kgqm;
	}
	
	public static int[][] pl1250(){
		int[][] preisliste = new int[7][2];
		
		try {
			File file=new File("resources\\Tabellen\\1250Einlaufbreite.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", 2);
				for(int i = 0; i <= 1; i++) {
					preisliste[counter][i] = Integer.parseInt(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preisliste;
	}
	
	public static int[][] pl1500(){
		int[][] preisliste = new int[7][2];
		
		try {
			File file=new File("resources\\Tabellen\\1500Einlaufbreite.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", 2);
				for(int i = 0; i <= 1; i++) {
					preisliste[counter][i] = Integer.parseInt(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preisliste;
	}

	public static int[][] mindermenge(){
		int[][] preisliste = new int[4][2];
		
		try {
			File file=new File("resources\\Tabellen\\Mindermenge.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", 2);
				for(int i = 0; i <= 1; i++) {
					preisliste[counter][i] = Integer.parseInt(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preisliste;
	}
	public static double[][] vlies(){
		double[][] preisliste = new double[2][4];
		
		try {
			File file=new File("resources\\Tabellen\\Vlies.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", 4);
				for(int i = 0; i <= 3; i++) {
					preisliste[counter][i] = Double.parseDouble(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preisliste;
	}
	public static int[][] perfo(){
		int[][] preisliste = new int[9][2];
		
		try {
			File file=new File("resources\\Tabellen\\Perfo.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", 2);
				for(int i = 0; i <= 1; i++) {
					preisliste[counter][i] = Integer.parseInt(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preisliste;
	}
	
	public static double[][] PaneelZwevezele(){
		double[][] preisliste = new double[23][9];
		
		try {
			File file=new File("resources\\Tabellen\\PaneeleZwevezele.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", preisliste.length);
				for(int i = 0; i < preisliste[counter].length; i++) {
					preisliste[counter][i] = Double.parseDouble(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preisliste;
	}
	
	public static int[][] PaneelZwevezelePlz(){
		int[][] preisliste = new int[10][10];
		
		try {
			File file=new File("resources\\Tabellen\\PaneeleZwevezelePlz.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", preisliste.length);
				for(int i = 0; i < preisliste[counter].length; i++) {
					preisliste[counter][i] = Integer.parseInt(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preisliste;
	}
	public static double[][] PaneelZwevezeleFarbe(){
		double[][] preisliste = new double[5][2];
		
		try {
			File file=new File("resources\\Tabellen\\PaneeleZwevezeleFarbe.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", preisliste.length);
				for(int i = 0; i < preisliste[counter].length; i++) {
					preisliste[counter][i] = Double.parseDouble(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preisliste;
	}
	
	public static double[][] PaneelZwevezeleMiW0(){
		double[][] preisliste = new double[24][9];
		
		try {
			File file=new File("resources\\Tabellen\\PaneeleZwevezeleMiWo.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", preisliste.length);
				for(int i = 0; i < preisliste[counter].length; i++) {
					preisliste[counter][i] = Double.parseDouble(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preisliste;
	}
	
	public static int[][] JITransport(){
		int[][] preisliste = new int[95][4];
		
		try {
			File file=new File("resources\\Tabellen\\JITrapezTransport.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", preisliste.length);
				for(int i = 0; i < preisliste[counter].length; i++) {
					preisliste[counter][i] = Integer.parseInt(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preisliste;
	}
	public static int[][] JIBeiladung(){
		int[][] preisliste = new int[24][5];
		
		try {
			File file=new File("resources\\Tabellen\\JITrapezBeiladung.txt");      
			Scanner sc=new Scanner(file);
			int counter = 0;
			while(sc.hasNextLine()) {
				String[] help = sc.nextLine().split("\t", preisliste.length);
				for(int i = 0; i < preisliste[counter].length; i++) {
					preisliste[counter][i] = Integer.parseInt(help[i]);
				}
				counter++;
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return preisliste;
	}
	
	
	
}

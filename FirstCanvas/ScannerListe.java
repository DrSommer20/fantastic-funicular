import java.io.File;
import java.util.Scanner;

class ScannerListe {
	
	public static double[][] kgqm() throws Exception{
		double[][] kgqm = new double[24][7];
		
		try {
			File file=new File("C:\\Users\\TSO\\Documents\\Tabellen\\kg_qm.txt");      
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
	
	public static int[][] pl1250() throws Exception{
		int[][] preisliste = new int[7][2];
		
		try {
			File file=new File("C:\\Users\\TSO\\Documents\\Tabellen\\1250Einlaufbreite.txt");      
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
	
	public static int[][] pl1500() throws Exception{
		int[][] preisliste = new int[7][2];
		
		try {
			File file=new File("C:\\Users\\TSO\\Documents\\Tabellen\\1500Einlaufbreite.txt");      
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

	public static int[][] mindermenge() throws Exception{
		int[][] preisliste = new int[4][2];
		
		try {
			File file=new File("C:\\Users\\TSO\\Documents\\Tabellen\\Mindermenge.txt");      
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
	public static double[][] vlies() throws Exception{
		double[][] preisliste = new double[2][4];
		
		try {
			File file=new File("C:\\Users\\TSO\\Documents\\Tabellen\\Vlies.txt");      
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
	public static int[][] perfo() throws Exception{
		int[][] preisliste = new int[9][2];
		
		try {
			File file=new File("C:\\Users\\TSO\\Documents\\Tabellen\\Perfo.txt");      
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
	
}

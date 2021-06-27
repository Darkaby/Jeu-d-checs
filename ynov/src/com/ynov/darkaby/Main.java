package com.ynov.darkaby;

import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static Map context;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner input = new Scanner(System.in);
		
		Main.showTitle();
		
		String player1 = readString("Entrez le nom du joueur 1");
		System.out.println("Bonjour " + player1 + " !!!");
		
		String player2 = readString("Entrez le nom du joueur 2");
		System.out.println("Bonjour " + player2 + " !!!");
		
		String white = Main.chooseWhites(player1, player2);
		
		Player gamer1 = new Player(player1, player1.equals(white));
		Player gamer2 = new Player(player2, player2.equals(white));
		
		System.out.println(gamer1.getName() + " joue avec les "
				+ chooseObject(gamer1.isWhite(), "blancs", "noirs"));
		System.out.println(gamer2.getName() + " joue avec les "
				+ chooseObject(gamer2.isWhite(), "blancs", "noirs"));
		
		Chessboard chessboard = new Chessboard();
		chessboard.display();
		
		Main.context = new HashMap<>();
		Main.context.put("whites", chooseObject(gamer1.isWhite(), gamer1, gamer2));
		Main.context.put("blacks", chooseObject(!gamer1.isWhite(), gamer1, gamer2));
		Main.context.put("board", chessboard);
		
		
		Game game = new Game();
		game.play();
	}
	
	// Demander d'entrer une valeur
	public static String readString(String invite) {
		Scanner input = new Scanner(System.in);
		System.out.print(invite + " : ");
		
		return input.nextLine();
	}
	
	private static double readDouble(String string) {
		boolean ok = false;
		double value = 0;
		while (!ok) {
			String text = Main.readString(string);
			try {
				value = Double.parseDouble(text);
				ok = true;
			}
			catch (java.lang.NumberFormatException exception) {
				System.out.println("Erreur de saisie\n"
					+ "Veuillez entrer un nombre décimal (ex: 0.43)");
			}
		}
		return value;
	}
	
	// Dessiner un chéquier
	public static void showChessboard() {
		StdDraw.setCanvasSize(600,600);
		StdDraw.setXscale(0, 8);
		StdDraw.setYscale(0, 8);
		
		StdDraw.setPenColor(StdDraw.BLACK);		
		for (int y=0; y<8; y++) {
			for (int x=0; x<8; x++) {
				if ((x+y)%2==0) {
					// Coordonnées du centre du carré et sa démi-largeur
					StdDraw.filledSquare(x+0.5, y+0.5, 0.5);
				}
			}
		}
	}
	
	// Dessiner des pièces
	public static void showPieces() {
		for (int n=0; n<8; n++) {
			// Coordonnées du centre de l'image, son nom, sa largeur et sa hauteur
			StdDraw.picture(n+0.5, n+0.5, "images/Cb.png", 1, 1);
			StdDraw.picture(n+0.5, 7-n+0.5, "images/Cn.png", 1, 1);
		}
		
	}

	// Afficher du texte
	public static void showTitle() {
		Main.showChessboard();
		Main.showPieces();
		
		Font font = new Font("Arial", Font.BOLD, 80);
		StdDraw.setFont(font);
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.text(4, 4, "JEU D'ECHEC");
	}
	
	public static String chooseWhites(String p1, String p2) {
		double target = Math.random();
		
		//double value1 = Double.parseDouble(Main.readString(p1 + " valeur entre 0 et 1"));
		//double value2 = Double.parseDouble(Main.readString(p2 + " valeur entre 0 et 1"));
		
		double value1 = Main.readDouble(p1 + " valeur entre 0 et 1");
		double value2 = Main.readDouble(p2 + " valeur entre 0 et 1");
		double delta1 = Math.abs(target - value1);
		double delta2 = Math.abs(target - value2);
		
		if (delta1<delta2)
			return p1;
		else
			return p2;
			
	}

	public static Object chooseObject(boolean value, Object o1, Object o2) {
		return value ? o1 : o2;
	}

}

package com.ynov.darkaby;

import com.ynov.darkaby.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import com.ynov.darkaby.pieces.Bishop;
import com.ynov.darkaby.pieces.King;
import com.ynov.darkaby.pieces.Knight;
import com.ynov.darkaby.pieces.Pawn;
import com.ynov.darkaby.pieces.Queen;
import com.ynov.darkaby.pieces.Rook;

public class Chessboard {
	// Attibuts
	private Cell[][] _matrix;

	// Constructeur: Initialisation de la matrice et de ses cellules
	public Chessboard() {
		this._matrix = new Cell[8][8];
		
		for (int y=0; y<8; y++) {
			for (int x=0; x<8; x++) {
				if ((x + y) % 2 == 0 )
					this._matrix[x][y] = new Cell(CellColor.BLACK);
				else
					this._matrix[x][y] = new Cell(CellColor.WHITE);
			}
		}
		
		this.buildPieces();
	}
	
	private void buildPieces() {
		List<Piece> pieces = new ArrayList<>();
		
		pieces.add(new King(CellColor.WHITE));
		pieces.add(new Queen(CellColor.WHITE));
		pieces.add(new Bishop(CellColor.WHITE));
		pieces.add(new Knight(CellColor.WHITE));
		pieces.add(new Rook(CellColor.WHITE));
		pieces.add(new Pawn(CellColor.WHITE));
		
		pieces.add(new King(CellColor.BLACK));
		pieces.add(new Queen(CellColor.BLACK));
		pieces.add(new Bishop(CellColor.BLACK));
		pieces.add(new Knight(CellColor.BLACK));
		pieces.add(new Rook(CellColor.BLACK));
		pieces.add(new Pawn(CellColor.BLACK));

		for (Piece e : pieces)
			System.out.println(e.toString());
		
		String[][] positions = {
				{"Tn", "Cn", "Fn", "Dn", "Rn", "Fn", "Cn", "Tn"},
				{"Pn", "Pn", "Pn", "Pn", "Pn", "Pn", "Pn", "Pn"},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{"Pb", "Pb", "Pb", "Pb", "Pb", "Pb", "Pb", "Pb"},
				{"Tb", "Cb", "Fb", "Db", "Rb", "Fb", "Cb", "Tb"}
			};
		
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				for (Piece e : pieces) {
					if (e.toString().equals(positions[7-y][x]))
						this._matrix[x][y].setPiece(e);
				}
			}
		} 
	}

	// Afficher l'échiquier
	public void display() {
		for (int y=0; y<8; y++) {
			for (int x=0; x<8; x++) {
				this._matrix[x][y].display(x, y);
			}
		}
		
	}

	public Cell getCell(int x, int y) {
		return this._matrix[x][y];
	}
}

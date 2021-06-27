package com.ynov.darkaby.pieces;

import com.ynov.darkaby.CellColor;
import com.ynov.darkaby.StdDraw;

public class Rook extends Piece {
	
	public Rook(CellColor color) {
		super(color);
	}

	@Override
	public void display(int x, int y) {
		String image = this._color == CellColor.BLACK ? "images/Tn.png" : "images/Tb.png";
		StdDraw.picture(x+0.5, y+0.5, image, 1, 1);
		
	}

	@Override
	public String toString() {
		return "T" + super.toString();
	}

}

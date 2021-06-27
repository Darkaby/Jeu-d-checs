package com.ynov.darkaby.pieces;

import com.ynov.darkaby.CellColor;
import com.ynov.darkaby.StdDraw;

public class Bishop extends Piece {
	
	public Bishop(CellColor color) {
		super(color);
	}

	@Override
	public void display(int x, int y) {
		String image = this._color == CellColor.BLACK ? "images/Fn.png" : "images/Fb.png";
		StdDraw.picture(x+0.5, y+0.5, image, 1, 1);
	}

	@Override
	public String toString() {
		return "F" + super.toString();
	}

}

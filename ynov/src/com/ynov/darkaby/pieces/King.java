package com.ynov.darkaby.pieces;

import com.ynov.darkaby.CellColor;
import com.ynov.darkaby.StdDraw;

public class King extends Piece {
	
	public King(CellColor color) {
		super(color);
	}

	@Override
	public void display(int x, int y) {
		String image = this._color == CellColor.BLACK ? "images/Rn.png" : "images/Rb.png";
		StdDraw.picture(x+0.5, y+0.5, image, 1, 1);
		
		/*
		 * if (this._color == CellColor.WHITE) 
		 * StdDraw.picture(x+0.5, y+0.5,"images/Rb.png", 1, 1); 
		 * else 
		 * StdDraw.picture(x+0.5, y+0.5, "images/Rn.png",1, 1);
		 */
	}

	@Override
	public String toString() {
		return "R" + super.toString();
	}

}

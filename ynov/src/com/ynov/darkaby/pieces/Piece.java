/*
 * Main class for all pieces of the chessboard
 */

package com.ynov.darkaby.pieces;

import com.ynov.darkaby.CellColor;

public abstract class Piece {

	// For this variable to be visible and usable to its subclasses, we use the protected keyword
	protected CellColor _color; // Color of the piece

	public Piece(CellColor color) {
		this._color = color;
	}

	// Draw the piece on the chessboard
	public abstract void display(int x, int y);

	@Override
	public String toString() {
		return this._color == CellColor.WHITE ? "b" : "n";
	}

}

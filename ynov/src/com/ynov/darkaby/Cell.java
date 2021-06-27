package com.ynov.darkaby;

import com.ynov.darkaby.pieces.Piece;

public class Cell implements Selectable{

	private CellColor _color;
	private Piece _piece;
	private boolean _selected;
	
	public void setPiece(Piece piece) {
		this._piece = piece;
	}

	public Piece getPiece() {
		return this._piece;
	}
	
	public Cell(CellColor color) {
		this._color = color;
		this._piece = null;
		this._selected = false;
	}
	
	// Dessiner une cellule
	public void display(int x, int y) {
		if (this._color == CellColor.BLACK)
			StdDraw.setPenColor(StdDraw.DARK_GRAY);
		else
			StdDraw.setPenColor(StdDraw.WHITE);
		
		StdDraw.filledSquare(x + .5, y + .5, .5);
		
		if (this.isSelected()) {
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.square(x + .5, y + .5, .5);
		}
		
		if(this._piece != null)
			this._piece.display(x,y);
	}

	@Override
	public void select() {
		this._selected = true;
	}

	@Override
	public void unselect() {
		this._selected = false;
	}

	@Override
	public boolean isSelected() {
		return this._selected;
	}

}

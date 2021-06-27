package com.ynov.darkaby;

public class Game {
	
	private Chessboard _board = (Chessboard) Main.context.get("board");
	Player _whites = (Player) Main.context.get("whites");
	Player _blacks = (Player) Main.context.get("blacks");
	
	public void play() {
		boolean isPlaying = true;
		
		while (isPlaying) {
			Cell origin, target;
			
			/// Les blancs jouent /// 
			System.out.println(this._whites.getName() + " choisi une pièce.");
			origin = this.waitForPiece(CellColor.WHITE);
			
			System.out.println(this._whites.getName() + " joue la pièce.");
			target = this.waitForTarget();
			
			this.movePiece(origin, target);
			
			/// Les noirs jouent ///
			System.out.println(this._blacks.getName() + " choisi une pièce.");
			origin = this.waitForPiece(CellColor.BLACK);
			
			System.out.println(this._blacks.getName() + " joue la pièce.");
			target = this.waitForTarget();

			this.movePiece(origin, target);
		}
	}
	
	private Cell waitForTarget() {
		this.waitForClick();
		
		int x = (int) StdDraw.mouseX();
		int y = (int) StdDraw.mouseY();
		
		Cell cell = this._board.getCell(x,y);
		cell.select();
		this._board.display();
		
		return cell;
	}

	private void movePiece(Cell cellA, Cell cellB) {
		cellB.setPiece(cellA.getPiece());
		cellA.setPiece(null);
		cellA.unselect();
		cellB.unselect();
		this._board.display();
	}

	private Cell waitForPiece(CellColor color) {
		boolean ok = false;
		Cell cell = null;
		
		while(!ok) {
			this.waitForClick();
			
			int x = (int) StdDraw.mouseX();
			int y = (int) StdDraw.mouseY();
			
			cell = this._board.getCell(x,y);
			
			if (cell.getPiece() != null) {
				if ((cell.getPiece().toString().endsWith("n") && color == CellColor.BLACK) || 
						(cell.getPiece().toString().endsWith("b") && color == CellColor.WHITE)) {
					cell.select(); 
					ok = true;
				}
				else
					System.out.println("This is not one of your pieces. Try again!");
			}
			else
				System.out.println("You have to select a piece. Try again!");
		}
				
		this._board.display();
		
		return cell;
	}

	private void waitForClick() {
		while( !StdDraw.isMousePressed() ) {
			StdDraw.pause(70);
		}
		
		while( StdDraw.isMousePressed() ) {
			StdDraw.pause(70);
		}
		
	}

}

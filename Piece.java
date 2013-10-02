/* Piece.java */

import java.util.*;

public abstract class Piece {
	public String name;
	public String color;
	public int x_cord;
	public int y_cord;

	/* 
	GENERIC PIECE CONSTRUCTOR - abstract classes cannot create objects

	public Piece(Board board, Player player, String piece_name, int x, int y) {
		board.place(this, x_cord, y_cord);
		name = piece_name;
		color = player.color;
		x_cord = x;
		y_cord = y;
		player.pieces.add(this);
	}
	*/

	public void move(Board board, Move m) {
		int original_x = x_cord, original_y = y_cord;
		int new_x = m.x, new_y = m.y;
		
		board.remove(original_x, original_y);
		board.place(this, new_x, new_y);
	}

	public String printPiece() {
		String printed = this.color + " " + this.name;
		return printed;
	}

	public abstract ArrayList<Move> valid_moves(Board board);
}
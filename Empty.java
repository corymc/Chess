/* Empty.Java */

import java.util.*;

public class Empty extends Piece {

	public Empty(Board board, int x, int y) {
		board.place(this, x, y);
		name = "(" + x + ", " + y + ")";
		color = "     ";
		x_cord = x;
		y_cord = y;
	}

	public ArrayList<Move> valid_moves(Board board) {
		ArrayList<Move> moves = new ArrayList<Move>();
		return moves;
	}
}
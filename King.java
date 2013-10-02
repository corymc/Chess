/* King.java */

import java.util.*;

public class King extends Piece {

	public King(Board board, Player player, int x, int y) {
		name = "King  ";
		board.place(this, x, y);
		color = player.color;
		x_cord = x;
		y_cord = y;
		player.pieces.add(this);
	}

	public ArrayList valid_moves(Board board) {
		ArrayList<Move> moves = new ArrayList<Move>();
		int i = 0;

		// move up
		if (board.valid(this, x_cord, y_cord + 1)) {
			moves.add(new Move(x_cord, y_cord + 1, i));
			i++;

		}

		// move down
		if (board.valid(this, x_cord, y_cord - 1)) {
			moves.add(new Move(x_cord, y_cord - 1, i));
			i++;
		}

		// move right
		if (board.valid(this, x_cord + 1, y_cord)) {
			moves.add(new Move(x_cord + 1, y_cord, i));
			i++;
		}

		// move left
		if (board.valid(this, x_cord - 1, y_cord)) {
			moves.add(new Move(x_cord - 1, y_cord, i));
			i++;
		}


		// move up and to the right
		if (board.valid(this, x_cord + 1, y_cord + 1)) {
			moves.add(new Move(x_cord + 1, y_cord + 1, i));
			i++;
		}

		// move up and to the left
		if (board.valid(this, x_cord - 1, y_cord + 1)) {
			moves.add(new Move(x_cord - 1, y_cord + 1, i));
			i++;
		}

		// moves down and to the right
		if (board.valid(this, x_cord + 1, y_cord - 1)) {
			moves.add(new Move(x_cord + 1, y_cord - 1, i));
			i++;
		}

		// moves down and to the left
		if (board.valid(this, x_cord - 1, y_cord - 1)) {
			moves.add(new Move(x_cord - 1, y_cord - 1, i));
			i++;
		}

		return moves;
	}
}
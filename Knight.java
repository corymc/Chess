/* Knight.java */

import java.util.*;

public class Knight extends Piece {

	public Knight(Board board, Player player, int x, int y) {
		name = "Knight";
		board.place(this, x, y);
		color = player.color;
		x_cord = x;
		y_cord = y;
		player.pieces.add(this);
	}

	public ArrayList valid_moves(Board board) {
		ArrayList<Move> moves = new ArrayList<Move>();
		int i = 0;

		if (board.valid(this, x_cord + 2, y_cord + 1)) {
			moves.add(new Move(x_cord + 2, y_cord + 1, i));
			i++;
		}
		if (board.valid(this, x_cord + 2, y_cord - 1)) {
			moves.add(new Move(x_cord + 2, y_cord - 1, i));
			i++;
		}
		if (board.valid(this, x_cord - 2, y_cord + 1)) {
			moves.add(new Move(x_cord - 2, y_cord + 1, i));
			i++;
		}
		if (board.valid(this, x_cord - 2, y_cord - 1)) {
			moves.add(new Move(x_cord - 2, y_cord - 1, i));
			i++;
		}

		if (board.valid(this, x_cord + 1, y_cord + 2)) {
			moves.add(new Move(x_cord + 1, y_cord + 2, i));
			i++;
		}
		if (board.valid(this, x_cord + 1, y_cord - 2)) {
			moves.add(new Move(x_cord + 1, y_cord - 2, i));
			i++;
		}
		if (board.valid(this, x_cord - 1, y_cord + 2)) {
			moves.add(new Move(x_cord - 1, y_cord + 2, i));
			i++;
		}
		if (board.valid(this, x_cord - 1, y_cord - 2)) {
			moves.add(new Move(x_cord - 1, y_cord - 2, i));
			i++;
		}

		return moves;
	}
}














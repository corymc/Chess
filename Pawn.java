/* Pawn.java */

import java.util.*;

public class Pawn extends Piece {

	public Pawn(Board board, Player player, int x, int y) {
		name = "Pawn  ";
		board.place(this, x, y);
		color = player.color;
		x_cord = x;
		y_cord = y;
		player.pieces.add(this);
	}

	public ArrayList valid_moves(Board board) {
		ArrayList<Move> moves = new ArrayList<Move>();
		int i = 0;
		if (color == "Black") {
			if (! board.valid(this, x_cord, y_cord + 1)) {
				return null;
			}
			else if (board.valid(this, x_cord, y_cord + 2)) {
				moves.add(new Move(x_cord, y_cord + 1, i));
				i++;
				moves.add(new Move(x_cord, y_cord + 2, i));
			}
			else {
				moves.add(new Move(x_cord, y_cord + 1, i));
			}

		}
		else {
			if (! board.valid(this, x_cord, y_cord - 1)) {
				return null;
			}
			else if (board.valid(this, x_cord, y_cord - 2)) {
				moves.add(new Move(x_cord, y_cord - 1, i));
				i++;
				moves.add(new Move(x_cord, y_cord - 2, i));
				i++;
			}
			else {
				moves.add(new Move(x_cord, y_cord - 1, i));
				i++;
			}

			// checks if pawn can capture a piece -- DOESN"T WORK - FIX -- somehow getting an error before ever getting to here
			if (board.valid(this, x_cord + 1, y_cord - 1)) {
				if (board.containsEnemy(this, x_cord + 1, y_cord - 1)) {
					moves.add(new Move(x_cord + 1, y_cord + 1, i));
					i++;
				}
			}

			if (board.valid(this, x_cord - 1, y_cord - 1)) {
				if (board.containsEnemy(this, x_cord + 1, y_cord - 1)) {
					moves.add(new Move(x_cord - 1, y_cord + 1, i));
					i++;
				}
			}
		}
		return moves;
	}
}


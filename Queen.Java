/* Queen.java */

import java.util.*;

public class Queen extends Piece {
	
	public Queen(Board board, Player player, int x, int y) {
		name = "Queen ";
		board.place(this, x, y);
		color = player.color;
		x_cord = x;
		y_cord = y;
		player.pieces.add(this);
	}
	
	public ArrayList valid_moves(Board board) {
		ArrayList<Move> moves = new ArrayList<Move>();
		int i = 0;

		// moves up
		for (int x = x_cord, y = y_cord + 1; y <= board.TOP; y++) {
			if (board.valid(this, x, y)) {
				moves.add(new Move(x, y, i));
				i++;
				if (board.hitEnemy(this, x, y)) {
					break;
				}
			}
			else {
				break;
			}
		}

		// moves down
		for (int x = x_cord, y = y_cord - 1; y >= board.BOTTOM; y--) {
			if (board.valid(this, x, y)) {
				moves.add(new Move(x, y, i));
				i++;
				if (board.hitEnemy(this, x, y)) {
					break;
				}
			}
			else {
				break;
			}
		}

		// moves right
		for (int x = x_cord + 1, y = y_cord; x <= board.RIGHT; x++) {
			if (board.valid(this, x, y)) {
				moves.add(new Move(x, y, i));
				i++;
				if (board.hitEnemy(this, x, y)) {
					break;
				}
			}
			else {
				break;
			}
		}

		// moves left
		for (int x = x_cord - 1, y = y_cord; x >= board.LEFT; x--) {
			if (board.valid(this, x, y)) {
				moves.add(new Move(x, y, i));
				i++;
				if (board.hitEnemy(this, x, y)) {
					break;
				}
			}
			else {
				break;
			}
		}

		// moves up and to the right
		for (int x = x_cord + 1, y = y_cord + 1; (x <= board.RIGHT) && (y <= board.TOP) ; x++, y++) {
			if (board.valid(this, x, y)) {
				moves.add(new Move(x, y, i));
				i++;
				if (board.hitEnemy(this, x, y)) {
					break;
				}
			}
			else {
				break;
			}
		}

		// moves up and to the left
		for (int x = x_cord - 1, y = y_cord + 1; (x >= board.LEFT) && (y <= board.TOP) ; x--, y++) {
			if (board.valid(this, x, y)) {
				moves.add(new Move(x, y, i));
				i++;
				if (board.hitEnemy(this, x, y)) {
					break;
				}
			}
			else {
				break;
			}
		}

		// moves down and to the right
		for (int x = x_cord + 1, y = y_cord - 1; (x <= board.RIGHT) && (y >= board.BOTTOM) ; x++, y--) {
			if (board.valid(this, x, y)) {
				moves.add(new Move(x, y, i));
				i++;
				if (board.hitEnemy(this, x, y)) {
					break;
				}
			}
			else {
				break;
			}
		}

		// moves down and to the left
		for (int x = x_cord - 1, y = y_cord - 1; (x >= board.LEFT) && (y >= board.BOTTOM) ; x--, y--) {
			if (board.valid(this, x, y)) {
				moves.add(new Move(x, y, i));
				i++;
				if (board.hitEnemy(this, x, y)) {
					break;
				}
			}
			else {
				break;
			}
		}
		return moves;
	}
}
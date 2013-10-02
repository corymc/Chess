public class InvalidPieceException {
	public Move selectedPiece;

	public InvalidPieceException(Move enteredPiece) {
		super("Invalid piece selected. Entered coordinates: " + selectedPiece);
		selectedPiece = enteredPiece;
	}
}

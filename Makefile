JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
    Game.java \
    Board.java \
    Player.java \
    Move.java \
    Piece.java \
    Empty.java \
    Pawn.java \
    Knight.java \
    Bishop.java \
    Rook.java \
    Queen.java \
    King.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
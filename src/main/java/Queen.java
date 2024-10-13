public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        ChessPiece newCell = chessBoard.board[toLine][toColumn];
        if (!checkPosition(line) || !checkPosition(toLine)) {
            return false;
        }
        if (!checkPosition(column) || !checkPosition(toColumn)) {
            return false;
        }
        if (toColumn == column && toLine == line) {
            return false;
        }
        if (newCell != null && newCell.getColor().equals(this.getColor())) {
            return false;
        }
        if (!checkPath(chessBoard, line, column, toLine, toColumn)) {
            return false;
        }
        return Math.abs(line - toLine) == Math.abs(column - toColumn) || ((line == toLine) != (column == toColumn));
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
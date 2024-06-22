package experiments.app

import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.shape.Rectangle
import javafx.stage.Stage


class Checkers : Application() {    
    private val boardSize = 8
    private val tileSize = 100.0
    private val tiles = Array(boardSize) { arrayOfNulls<Rectangle>(boardSize) }
    private val pieces = Array(boardSize) { arrayOfNulls<Circle?>(boardSize) }
    private var currentPlayer = "Red"
    private var selectedPiece: Circle? = null
    private var selectedRow = -1
    private var selectedCol = -1

    fun dostuff(){
        println("im here")
    }
    override fun start(primaryStage: Stage) {
        val grid = GridPane()
        grid.padding = Insets(10.0)
        grid.hgap = 0.0
        grid.vgap = 0.0

        for (i in 0 until boardSize) {
            for (j in 0 until boardSize) {
                val tile = Rectangle(tileSize, tileSize)
                tile.fill = if ((i + j) % 2 == 0) Color.BEIGE else Color.BROWN
                tiles[i][j] = tile
                grid.add(tile, j, i)

                if ((i + j) % 2 != 0 && (i < 3 || i > 4)) {
                    val piece = Circle(tileSize / 2 - 10)
                    piece.fill = if (i < 3) Color.RED else Color.BLACK
                    pieces[i][j] = piece
                    grid.add(piece, j, i)

                    piece.setOnMousePressed { handlePiecePressed(piece, i, j) }
                    piece.setOnMouseDragged { handlePieceDragged(piece, i, j) }
                    piece.setOnMouseReleased { handlePieceReleased(piece, i, j) }
                }
            }
        }

        val scene = Scene(grid, tileSize * boardSize, tileSize * boardSize)
        primaryStage.title = "Checkers"
        primaryStage.scene = scene
        primaryStage.show()
    }

    private fun handlePiecePressed(event: MouseEvent, piece: Circle, row: Int, col: Int) {
        if ((currentPlayer == "Red" && piece.fill == Color.RED) || (currentPlayer == "Black" && piece.fill == Color.BLACK)) {
            selectedPiece = piece
            selectedRow = row
            selectedCol = col
        }
    }
    

    private fun handlePieceDragged(event: MouseEvent, piece: Circle, x:Int, y:Int) {
        if (selectedPiece == piece) {
            piece.translateX = event.x - tileSize / 2
            piece.translateY = event.y - tileSize / 2
        }
    }
    

    private fun handlePieceReleased(event: MouseEvent, piece: Circle, targetRow: Int, targetCol: Int) {
        if (selectedPiece == piece) {
            val isValidMove = validateMove(selectedRow, selectedCol, targetRow, targetCol)
            if (isValidMove) {
                movePiece(selectedRow, selectedCol, targetRow, targetCol)
                switchPlayer()
            } else {
                // Move the piece back to its original position if the move is invalid
                piece.translateX = 0.0
                piece.translateY = 0.0
            }
    
            // Reset selected piece and position variables
            selectedPiece = null
            selectedRow = -1
            selectedCol = -1
        }
    }

    private fun validateMove(fromRow: Int, fromCol: Int, toRow: Int, toCol: Int): Boolean {
        // Check if the destination is within the board boundaries
        if (toRow < 0 || toRow >= boardSize || toCol < 0 || toCol >= boardSize) {
            return false
        }
    
        // Check if there's already a piece at the destination
        if (pieces[toRow][toCol] != null) {
            return false
        }
    
        val piece = pieces[fromRow][fromCol] ?: return false
        val isKing = piece.fill == Color.GOLD
        val pieceColor = if (piece.fill == Color.RED) Color.RED else Color.BLACK
        val direction = if (pieceColor == Color.RED) 1 else -1
    
        // Calculate move distance
        val rowDiff = toRow - fromRow
        val colDiff = Math.abs(toCol - fromCol)
    
        // Regular move: diagonal, one step
        if (Math.abs(rowDiff) == 1 && colDiff == 1) {
            // Check direction for regular pieces
            if (!isKing && rowDiff != direction) {
                return false
            }
            return true
        }
    
        // Capture move: diagonal, two steps (jump over an opponent's piece)
        if (Math.abs(rowDiff) == 2 && colDiff == 2) {
            val middleRow = fromRow + rowDiff / 2
            val middleCol = fromCol + (toCol - fromCol) / 2
            val middlePiece = pieces[middleRow][middleCol] ?: return false
            val opponentColor = if (pieceColor == Color.RED) Color.BLACK else Color.RED
            if (middlePiece.fill == opponentColor) {
                return true
            }
        }
    
        return false
    }
    
    
    

    private fun movePiece(fromRow: Int, fromCol: Int, toRow: Int, toCol: Int) {
        // Update game board state
        pieces[toRow][toCol] = pieces[fromRow][fromCol]
        pieces[fromRow][fromCol] = null
    
        // Move the piece visually
        val piece = pieces[toRow][toCol]!!
        piece.centerX = toCol * tileSize + tileSize / 2
        piece.centerY = toRow * tileSize + tileSize / 2
    
        // Additional logic for promotion, if any
    }
    

    private fun promotePiece(piece: Circle) {
        piece.fill = Color.GOLD
    }

    private fun switchPlayer() {
        currentPlayer = if (currentPlayer == "Red") "Black" else "Red"
    }

    private fun showAlert(message: String) {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = "Game Over"
        alert.headerText = null
        alert.contentText = message
        alert.showAndWait()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Checkers::class.java)
        }
    }
}

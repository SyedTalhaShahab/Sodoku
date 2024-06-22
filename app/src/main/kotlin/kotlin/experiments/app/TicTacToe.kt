import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.layout.GridPane
import javafx.stage.Stage

class TicTacToe : Application() {

    private val buttons = Array(3) {
        arrayOfNulls<Button>(3)
    }
    
    private var currentPlayer = "X"

    override fun start(primaryStage: Stage) {
        val grid = GridPane()
        grid.padding = Insets(10.0)
        grid.hgap = 10.0
        grid.vgap = 10.0

        for (i in 0..2) {
            for (j in 0..2) {
                val button = Button()
                button.minWidth = 100.0
                button.minHeight = 100.0
                button.setOnAction { handleButtonClick(i, j) }
                buttons[i][j] = button
                grid.add(button, j, i)
            }
        }

        val scene = Scene(grid, 320.0, 350.0)
        primaryStage.title = "Tic Tac Toe"
        primaryStage.scene = scene
        primaryStage.show()
    }

    private fun handleButtonClick(row: Int, col: Int) {
        val button = buttons[row][col]
        if (button?.text.isNullOrEmpty()) {
            button?.text = currentPlayer
            if (checkWinner()) {
                showAlert("Player $currentPlayer wins!")
                resetBoard()
            } else if (isBoardFull()) {
                showAlert("It's a draw!")
                resetBoard()
            } else {
                currentPlayer = if (currentPlayer == "X") "O" else "X"
            }
        }
    }

    private fun checkWinner(): Boolean {
        for (i in 0..2) {
            if (buttons[i][0]?.text == currentPlayer && buttons[i][1]?.text == currentPlayer && buttons[i][2]?.text == currentPlayer) {
                return true
            }
            if (buttons[0][i]?.text == currentPlayer && buttons[1][i]?.text == currentPlayer && buttons[2][i]?.text == currentPlayer) {
                return true
            }
        }
        if (buttons[0][0]?.text == currentPlayer && buttons[1][1]?.text == currentPlayer && buttons[2][2]?.text == currentPlayer) {
            return true
        }
        return buttons[0][2]?.text == currentPlayer && buttons[1][1]?.text == currentPlayer && buttons[2][0]?.text == currentPlayer
    }

    private fun isBoardFull(): Boolean {
        for (row in buttons) {
            for (button in row) {
                if (button?.text.isNullOrEmpty()) {
                    return false
                }
            }
        }
        return true
    }

    private fun showAlert(message: String) {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = "Game Over"
        alert.headerText = null
        alert.contentText = message
        alert.showAndWait()
    }

    private fun resetBoard() {
        for (row in buttons) {
            for (button in row) {
                button?.text = ""
            }
        }
        currentPlayer = "X"
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(TicTacToe::class.java)
        }
    }
}
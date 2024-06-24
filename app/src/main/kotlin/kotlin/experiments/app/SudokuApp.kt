package experiments.app

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.control.TextField
import javafx.scene.layout.GridPane
import javafx.stage.Stage
import java.util.Random

import experiments.app.RandomGeneratorFile

class SudokuApp : Application() {
    private val size = 9
    private val cells = Array(size) { Array(size) { TextField() } }
    private val cellSize = 70.0

    private fun createSudokuGrid(sudokuString: String): Array<IntArray> {
        // Create a 9x9 array
        val grid = Array(9) { IntArray(9) }
    
        // Fill the array with values from the string
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                grid[i][j] = sudokuString[i * 9 + j].toString().toInt()
            }
        }
        return grid
    }

    override fun start(primaryStage: Stage) {

        val obj = RandomGeneratorFile()
        val sudokuString = obj.giveMeRandomBoard() 

        val sudoku_board = createSudokuGrid(sudokuString)

        val grid = GridPane()
        grid.style = "-fx-background-color: grey;"

        val randomNUMBER = Random() // creates an instance of the Random class.

        for (i in 0 until size) {
            for (j in 0 until size) {
                val cell = cells[i][j]
                cell.prefWidth = cellSize
                cell.prefHeight = cellSize
                
                if (randomNUMBER.nextInt(81) < 40){
                    cell.text = (sudoku_board[i][j]).toString()//String

                    cell.isEditable = false // You can set this to false for non-editable cells
                    cell.style = "-fx-alignment: center; -fx-font-size: 18px; -fx-background-color: #a8a8a8;"
                }

                grid.add(cell, j, i)
            }
        }

        val button = Button("Check")
        button.setOnAction {
            val message = if (isValidSolution()) "Correct Solution!" else "Incorrect Solution."
            showAlert(message)
        }

        grid.add(button, size / 2, size + 1)

        val scene = Scene(grid)
        primaryStage.scene = scene
        primaryStage.title = "Sudoku"
        primaryStage.isFullScreen = false
        primaryStage.isResizable = false // Disable screen resizing
        primaryStage.show()
    }

    private fun showAlert(message: String) {
        val alert = Alert(Alert.AlertType.INFORMATION)
        alert.title = "Sudoku Solution"
        alert.headerText = null
        alert.contentText = message
        alert.showAndWait()
    }

    private fun isValidSolution(): Boolean {
        // Validate rows
        for (i in 0 until size) {
            if (!isValidGroup(cells[i].map { it.text.toIntOrNull() })) return false
        }

        // Validate columns
        for (j in 0 until size) {
            if (!isValidGroup((0 until size).map { cells[it][j].text.toIntOrNull() })) return false
        }

        // Validate 3x3 subgrids
        for (row in 0 until size step 3) {
            for (col in 0 until size step 3) {
                if (!isValidSubgrid(row, col)) return false
            }
        }

        return true
    }

    private fun isValidGroup(group: List<Int?>): Boolean {
        val seen = mutableSetOf<Int>()
        for (num in group) {
            if (num == null || num !in 1..9 || !seen.add(num)) {
                return false
            }
        }
        return true
    }

    private fun isValidSubgrid(startRow: Int, startCol: Int): Boolean {
        val seen = mutableSetOf<Int>()
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val num = cells[startRow + i][startCol + j].text.toIntOrNull()
                if (num == null || num !in 1..9 || !seen.add(num)) {
                    return false
                }
            }
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Creating an instance of MainClass to call the main method
            launch(SudokuApp::class.java)
        }
    }
}

package experiments.app

import java.util.Random

class RandomGeneratorFile {
    private val sudokuGrids = arrayOf(
        arrayOf(
            intArrayOf(5, 3, 4, 6, 7, 8, 9, 1, 2),
            intArrayOf(6, 7, 2, 1, 9, 5, 3, 4, 8),
            intArrayOf(1, 9, 8, 3, 4, 2, 5, 6, 7),
            intArrayOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
            intArrayOf(4, 2, 6, 8, 5, 3, 7, 9, 1),
            intArrayOf(7, 1, 3, 9, 2, 4, 8, 5, 6),
            intArrayOf(9, 6, 1, 5, 3, 7, 2, 8, 4),
            intArrayOf(2, 8, 7, 4, 1, 9, 6, 3, 5),
            intArrayOf(3, 4, 5, 2, 8, 6, 1, 7, 9)
        ),
        arrayOf(
            intArrayOf(1, 4, 7, 3, 6, 9, 2, 5, 8),
            intArrayOf(2, 5, 8, 1, 4, 7, 3, 6, 9),
            intArrayOf(3, 6, 9, 2, 5, 8, 1, 4, 7),
            intArrayOf(4, 7, 1, 5, 8, 2, 6, 9, 3),
            intArrayOf(5, 8, 2, 6, 9, 3, 4, 7, 1),
            intArrayOf(6, 9, 3, 4, 7, 1, 5, 8, 2),
            intArrayOf(7, 1, 4, 8, 2, 5, 9, 3, 6),
            intArrayOf(8, 2, 5, 9, 3, 6, 7, 1, 4),
            intArrayOf(9, 3, 6, 7, 1, 4, 8, 2, 5)
        ),
        arrayOf(
            intArrayOf(9, 6, 3, 1, 7, 4, 2, 5, 8),
            intArrayOf(1, 7, 8, 3, 2, 5, 6, 4, 9),
            intArrayOf(2, 5, 4, 6, 8, 9, 7, 3, 1),
            intArrayOf(8, 2, 1, 4, 3, 7, 5, 9, 6),
            intArrayOf(4, 9, 6, 8, 5, 2, 3, 1, 7),
            intArrayOf(7, 3, 5, 9, 6, 1, 8, 2, 4),
            intArrayOf(5, 8, 9, 7, 1, 3, 4, 6, 2),
            intArrayOf(3, 1, 7, 2, 4, 6, 9, 8, 5),
            intArrayOf(6, 4, 2, 5, 9, 8, 1, 7, 3)
        ),
        arrayOf(
            intArrayOf(2, 9, 4, 7, 5, 3, 6, 1, 8),
            intArrayOf(3, 1, 8, 6, 2, 9, 5, 4, 7),
            intArrayOf(7, 5, 6, 4, 8, 1, 2, 3, 9),
            intArrayOf(8, 4, 2, 1, 7, 5, 3, 9, 6),
            intArrayOf(1, 3, 9, 2, 6, 4, 7, 8, 5),
            intArrayOf(5, 6, 7, 9, 3, 8, 4, 2, 1),
            intArrayOf(9, 7, 1, 5, 4, 2, 8, 6, 3),
            intArrayOf(6, 2, 3, 8, 9, 7, 1, 5, 4),
            intArrayOf(4, 8, 5, 3, 1, 6, 9, 7, 2)
        ),
        arrayOf(
            intArrayOf(4, 3, 5, 2, 6, 9, 7, 8, 1),
            intArrayOf(6, 8, 2, 5, 7, 1, 4, 9, 3),
            intArrayOf(1, 9, 7, 8, 3, 4, 5, 6, 2),
            intArrayOf(8, 2, 6, 1, 9, 5, 3, 7, 4),
            intArrayOf(3, 7, 4, 6, 8, 2, 9, 1, 5),
            intArrayOf(9, 5, 1, 7, 4, 3, 6, 2, 8),
            intArrayOf(5, 1, 9, 3, 2, 6, 8, 4, 7),
            intArrayOf(2, 4, 8, 9, 5, 7, 1, 3, 6),
            intArrayOf(7, 6, 3, 4, 1, 8, 2, 5, 9)
        ),
        arrayOf(
            intArrayOf(6, 2, 4, 8, 3, 7, 9, 1, 5),
            intArrayOf(5, 1, 9, 6, 2, 4, 8, 7, 3),
            intArrayOf(8, 7, 3, 5, 1, 9, 6, 2, 4),
            intArrayOf(4, 5, 2, 7, 9, 8, 1, 3, 6),
            intArrayOf(9, 6, 7, 3, 4, 1, 2, 5, 8),
            intArrayOf(3, 8, 1, 2, 6, 5, 4, 9, 7),
            intArrayOf(1, 4, 8, 9, 7, 6, 3, 5, 2),
            intArrayOf(7, 9, 5, 4, 8, 3, 2, 6, 1),
            intArrayOf(2, 3, 6, 1, 5, 2, 7, 8, 9)
        ),
        arrayOf(
            intArrayOf(3, 5, 2, 8, 1, 7, 6, 4, 9),
            intArrayOf(4, 1, 6, 9, 3, 5, 8, 7, 2),
            intArrayOf(8, 9, 7, 4, 6, 2, 5, 1, 3),
            intArrayOf(2, 6, 8, 3, 9, 1, 4, 5, 7),
            intArrayOf(1, 7, 3, 5, 4, 6, 9, 2, 8),
            intArrayOf(9, 4, 5, 7, 2, 8, 3, 6, 1),
            intArrayOf(7, 8, 4, 1, 5, 9, 2, 3, 6),
            intArrayOf(6, 3, 9, 2, 7, 4, 1, 8, 5),
            intArrayOf(5, 2, 1, 6, 8, 3, 7, 9, 4)
        ),
        arrayOf(
            intArrayOf(7, 3, 1, 5, 8, 2, 6, 4, 9),
            intArrayOf(8, 4, 6, 9, 1, 7, 5, 3, 2),
            intArrayOf(9, 5, 2, 4, 6, 3, 7, 1, 8),
            intArrayOf(5, 1, 7, 6, 4, 8, 2, 9, 3),
            intArrayOf(4, 6, 9, 2, 3, 1, 8, 7, 5),
            intArrayOf(2, 8, 3, 7, 9, 5, 1, 6, 4),
            intArrayOf(3, 2, 5, 1, 7, 9, 4, 8, 6),
            intArrayOf(1, 9, 4, 8, 5, 6, 3, 2, 7),
            intArrayOf(6, 7, 8, 3, 2, 4, 9, 5, 1)
        ),
        arrayOf(
            intArrayOf(8, 1, 2, 7, 5, 3, 6, 4, 9),
            intArrayOf(9, 4, 3, 6, 8, 2, 1, 7, 5),
            intArrayOf(6, 7, 5, 4, 9, 1, 2, 8, 3),
            intArrayOf(1, 5, 4, 2, 3, 7, 8, 9, 6),
            intArrayOf(3, 6, 9, 8, 4, 5, 7, 2, 1),
            intArrayOf(2, 8, 7, 1, 6, 9, 5, 3, 4),
            intArrayOf(5, 2, 1, 9, 7, 4, 3, 6, 8),
            intArrayOf(4, 3, 8, 5, 2, 6, 9, 1, 7),
            intArrayOf(7, 9, 6, 3, 1, 8, 4, 5, 2)
        ),
        arrayOf(
            intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 1),
            intArrayOf(5, 6, 7, 8, 9, 1, 2, 3, 4),
            intArrayOf(8, 9, 1, 2, 3, 4, 5, 6, 7),
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9),
            intArrayOf(4, 5, 6, 7, 8, 9, 1, 2, 3),
            intArrayOf(7, 8, 9, 1, 2, 3, 4, 5, 6),
            intArrayOf(3, 4, 5, 6, 7, 8, 9, 1, 2),
            intArrayOf(6, 7, 8, 9, 1, 2, 3, 4, 5),
            intArrayOf(9, 1, 2, 3, 4, 5, 6, 7, 8)
        ),
        arrayOf(
            intArrayOf(5, 9, 8, 1, 2, 3, 7, 4, 6),
            intArrayOf(3, 1, 7, 6, 4, 5, 2, 8, 9),
            intArrayOf(6, 4, 2, 8, 9, 7, 3, 5, 1),
            intArrayOf(7, 6, 3, 5, 8, 2, 9, 1, 4),
            intArrayOf(1, 2, 4, 9, 7, 6, 5, 3, 8),
            intArrayOf(9, 8, 5, 3, 1, 4, 6, 7, 2),
            intArrayOf(8, 5, 9, 7, 6, 1, 4, 2, 3),
            intArrayOf(2, 7, 6, 4, 3, 8, 1, 9, 5),
            intArrayOf(4, 3, 1, 2, 5, 9, 8, 6, 7)
        ),
        arrayOf(
            intArrayOf(1, 2, 6, 4, 9, 5, 3, 7, 8),
            intArrayOf(5, 8, 4, 7, 3, 2, 6, 1, 9),
            intArrayOf(9, 3, 7, 6, 8, 1, 2, 4, 5),
            intArrayOf(2, 5, 3, 8, 1, 4, 7, 9, 6),
            intArrayOf(4, 1, 9, 3, 6, 7, 8, 5, 2),
            intArrayOf(7, 6, 8, 9, 5, 2, 4, 3, 1),
            intArrayOf(8, 4, 1, 2, 7, 9, 5, 6, 3),
            intArrayOf(6, 7, 5, 1, 4, 3, 9, 8, 2),
            intArrayOf(3, 9, 2, 5, 8, 6, 1, 2, 4)
        ),
        arrayOf(
            intArrayOf(9, 6, 7, 3, 8, 2, 1, 4, 5),
            intArrayOf(3, 8, 5, 1, 4, 7, 6, 2, 9),
            intArrayOf(1, 4, 2, 6, 9, 5, 7, 3, 8),
            intArrayOf(5, 2, 1, 7, 3, 6, 8, 9, 4),
            intArrayOf(6, 9, 3, 4, 5, 8, 2, 1, 7),
            intArrayOf(7, 3, 8, 9, 2, 1, 4, 5, 6),
            intArrayOf(8, 7, 9, 2, 1, 4, 5, 6, 3),
            intArrayOf(4, 5, 6, 8, 7, 3, 9, 2, 1),
            intArrayOf(2, 1, 4, 5, 6, 9, 3, 7, 8)
        ),
        arrayOf(
            intArrayOf(2, 5, 7, 6, 4, 8, 9, 3, 1),
            intArrayOf(3, 8, 6, 9, 7, 1, 2, 4, 5),
            intArrayOf(4, 9, 1, 3, 5, 2, 6, 7, 8),
            intArrayOf(7, 4, 8, 1, 6, 3, 5, 9, 2),
            intArrayOf(5, 1, 9, 7, 2, 4, 3, 8, 6),
            intArrayOf(6, 3, 2, 8, 9, 5, 7, 1, 4),
            intArrayOf(1, 6, 4, 2, 3, 7, 8, 5, 9),
            intArrayOf(9, 7, 5, 4, 8, 6, 1, 2, 3),
            intArrayOf(8, 2, 3, 5, 1, 9, 4, 6, 7)
        ),
        arrayOf(
            intArrayOf(7, 2, 9, 4, 6, 8, 3, 5, 1),
            intArrayOf(3, 5, 4, 7, 1, 2, 8, 9, 6),
            intArrayOf(8, 6, 1, 3, 9, 5, 7, 2, 4),
            intArrayOf(9, 4, 2, 1, 8, 7, 6, 3, 5),
            intArrayOf(5, 8, 3, 6, 4, 9, 1, 7, 2),
            intArrayOf(6, 1, 7, 2, 5, 3, 9, 4, 8),
            intArrayOf(1, 7, 5, 9, 3, 4, 2, 8, 6),
            intArrayOf(4, 9, 8, 5, 2, 6, 7, 1, 3),
            intArrayOf(2, 3, 6, 8, 7, 1, 4, 6, 9)
        ),
        arrayOf(
            intArrayOf(8, 7, 5, 4, 3, 9, 2, 1, 6),
            intArrayOf(4, 9, 6, 8, 1, 2, 7, 5, 3),
            intArrayOf(3, 1, 2, 7, 6, 5, 9, 8, 4),
            intArrayOf(1, 2, 8, 6, 4, 7, 5, 3, 9),
            intArrayOf(9, 4, 7, 3, 5, 8, 1, 6, 2),
            intArrayOf(6, 5, 3, 9, 2, 1, 8, 4, 7),
            intArrayOf(7, 3, 1, 5, 9, 4, 6, 2, 8),
            intArrayOf(5, 8, 9, 2, 7, 6, 4, 9, 1),
            intArrayOf(2, 6, 4, 1, 8, 3, 9, 7, 5)
        ),
        arrayOf(
            intArrayOf(2, 9, 4, 8, 5, 7, 3, 6, 1),
            intArrayOf(5, 1, 6, 3, 4, 9, 7, 2, 8),
            intArrayOf(7, 3, 8, 1, 2, 6, 9, 5, 4),
            intArrayOf(1, 8, 2, 4, 7, 5, 6, 9, 3),
            intArrayOf(9, 4, 3, 6, 8, 2, 1, 7, 5),
            intArrayOf(6, 7, 5, 9, 3, 1, 4, 8, 2),
            intArrayOf(8, 5, 7, 2, 6, 3, 9, 4, 1),
            intArrayOf(3, 2, 9, 7, 1, 4, 8, 5, 6),
            intArrayOf(4, 6, 1, 5, 9, 8, 2, 3, 7)
        ),
        arrayOf(
            intArrayOf(3, 5, 8, 6, 7, 2, 1, 9, 4),
            intArrayOf(6, 9, 2, 1, 4, 5, 7, 8, 3),
            intArrayOf(7, 4, 1, 9, 8, 3, 6, 2, 5),
            intArrayOf(4, 8, 7, 2, 3, 6, 5, 1, 9),
            intArrayOf(5, 1, 9, 4, 5, 7, 8, 3, 2),
            intArrayOf(2, 3, 6, 8, 1, 9, 4, 5, 7),
            intArrayOf(1, 7, 5, 3, 9, 8, 2, 4, 6),
            intArrayOf(8, 2, 4, 5, 6, 1, 3, 7, 9),
            intArrayOf(9, 6, 3, 7, 2, 4, 9, 6, 1)
        ),
        arrayOf(
            intArrayOf(5, 7, 6, 4, 2, 9, 1, 3, 8),
            intArrayOf(4, 8, 9, 1, 3, 7, 6, 5, 2),
            intArrayOf(1, 2, 3, 5, 8, 6, 4, 9, 7),
            intArrayOf(7, 4, 5, 2, 6, 8, 9, 1, 3),
            intArrayOf(3, 9, 8, 7, 1, 4, 5, 2, 6),
            intArrayOf(2, 6, 1, 3, 9, 5, 7, 8, 4),
            intArrayOf(8, 5, 7, 9, 4, 1, 2, 6, 3),
            intArrayOf(6, 1, 4, 8, 7, 2, 3, 4, 9),
            intArrayOf(9, 3, 2, 6, 5, 1, 8, 7, 4)
        ),
        arrayOf(
            intArrayOf(6, 2, 5, 3, 7, 8, 4, 1, 9),
            intArrayOf(1, 3, 8, 4, 9, 6, 7, 2, 5),
            intArrayOf(7, 4, 9, 5, 1, 2, 6, 3, 8),
            intArrayOf(8, 1, 6, 9, 4, 5, 2, 7, 3),
            intArrayOf(3, 7, 2, 8, 6, 1, 9, 5, 4),
            intArrayOf(5, 9, 4, 2, 3, 7, 1, 8, 6),
            intArrayOf(9, 5, 1, 7, 8, 3, 5, 4, 2),
            intArrayOf(2, 6, 3, 1, 5, 4, 8, 9, 7),
            intArrayOf(4, 8, 7, 6, 2, 9, 3, 6, 1)
        ),
        arrayOf(
            intArrayOf(8, 4, 1, 5, 9, 7, 6, 3, 2),
            intArrayOf(5, 7, 3, 4, 1, 2, 9, 6, 8),
            intArrayOf(9, 6, 2, 3, 8, 6, 7, 5, 1),
            intArrayOf(6, 5, 7, 9, 3, 8, 1, 2, 4),
            intArrayOf(1, 2, 9, 6, 7, 4, 3, 8, 5),
            intArrayOf(3, 8, 4, 1, 2, 5, 6, 9, 7),
            intArrayOf(7, 1, 6, 8, 4, 3, 2, 9, 5),
            intArrayOf(4, 9, 8, 2, 5, 1, 3, 7, 6),
            intArrayOf(2, 3, 5, 7, 6, 9, 8, 4, 1)
        ),
        arrayOf(
            intArrayOf(5, 8, 6, 3, 4, 9, 1, 2, 7),
            intArrayOf(9, 1, 4, 6, 2, 7, 8, 3, 5),
            intArrayOf(7, 3, 2, 8, 1, 5, 6, 9, 4),
            intArrayOf(4, 5, 9, 1, 6, 3, 2, 7, 8),
            intArrayOf(6, 7, 1, 5, 8, 2, 9, 4, 3),
            intArrayOf(3, 2, 8, 9, 7, 4, 5, 6, 1),
            intArrayOf(1, 6, 7, 4, 5, 8, 3, 1, 2),
            intArrayOf(8, 4, 5, 2, 9, 1, 7, 8, 6),
            intArrayOf(2, 9, 3, 7, 3, 6, 4, 5, 9)
        )
    ) // size 22

    public fun giveMeRandomBoard(): String{
        val randomer = Random()
        val index = randomer.nextInt(sudokuGrids.size) // Generates random int between 0 (inclusive) and 22 (exclusive)

        var toReturn_sudokuString = ""
        // return 

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                toReturn_sudokuString = toReturn_sudokuString + (sudokuGrids[index][i][j].toString())
            }
        }

        return toReturn_sudokuString
        // example
        // 963174258178325649254689731821437596496852317735961824589713462317246985642598173
    }
}
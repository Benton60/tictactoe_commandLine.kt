
var board = listOf(listOf(' ', '|', ' ', '|', ' '),
                   listOf('-', '|', '-', '|', '-'),
                   listOf(' ', '|', ' ', '|', ' '),
                   listOf('-', '|', '-', '|', '-'),
                   listOf(' ', '|', ' ', '|', ' '));

val start = listOf(listOf('1', '|', '2', '|', '3'),
                   listOf('-', '|', '-', '|', '-'),
                   listOf('4', '|', '5', '|', '6'),
                   listOf('-', '|', '-', '|', '-'),
                   listOf('7', '|', '8', '|', '9'));

val winCombos = listOf(listOf(1,2,3),
                       listOf(4,5,6),
                       listOf(7,8,9),
                       listOf(1,4,7),
                       listOf(2,5,6),
                       listOf(3,6,9),
                       listOf(1,5,9),
                       listOf(3,5,7))
fun main(){
    printBoard(start)
    printBoard(board)
}

fun printBoard(board: List<List<Char>>) = board.forEach{
    it.forEach{
        print(it)
    }
    println()
}
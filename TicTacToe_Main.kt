import kotlin.random.Random.Default.nextInt

var board = mutableListOf(mutableListOf(' ', '|', ' ', '|', ' '),
    mutableListOf('-', '|', '-', '|', '-'),
    mutableListOf(' ', '|', ' ', '|', ' '),
    mutableListOf('-', '|', '-', '|', '-'),
    mutableListOf(' ', '|', ' ', '|', ' '))

val start = mutableListOf(mutableListOf('1', '|', '2', '|', '3'),
    mutableListOf('-', '|', '-', '|', '-'),
    mutableListOf('4', '|', '5', '|', '6'),
    mutableListOf('-', '|', '-', '|', '-'),
    mutableListOf('7', '|', '8', '|', '9'))

var playerMoves = mutableListOf(0)
var computerMoves= mutableListOf(0)

fun main(){
    printBoard(start)
    while(checkWin() == ""){
        playerTurn()
        if(checkWin() == ""){
            computerTurn()
        }
    }
    println(checkWin())
}
fun computerTurn(){
    val move = getComputerMove()
    computerMoves.add(move)
    when(move){
        1 -> board[0][0] = 'o'
        2 -> board[0][2] = 'o'
        3 -> board[0][4] = 'o'
        4 -> board[2][0] = 'o'
        5 -> board[2][2] = 'o'
        6 -> board[2][4] = 'o'
        7 -> board[4][0] = 'o'
        8 -> board[4][2] = 'o'
        9 -> board[4][4] = 'o'
    }
    printBoard(board)
}
fun getComputerMove(): Int {
    var move = 20
    while(move > 9) {
        try {
            move = nextInt(0,10)
            while(playerMoves.contains(move) or computerMoves.contains(move)){
                move = nextInt(0,10)
            }
        } catch (e: Exception) {
        }
    }
    return move
}
fun playerTurn() {
    val move = getPlayerMove()
    playerMoves.add(move)
    when(move){
        1 -> board[0][0] = 'x'
        2 -> board[0][2] = 'x'
        3 -> board[0][4] = 'x'
        4 -> board[2][0] = 'x'
        5 -> board[2][2] = 'x'
        6 -> board[2][4] = 'x'
        7 -> board[4][0] = 'x'
        8 -> board[4][2] = 'x'
        9 -> board[4][4] = 'x'
    }
    printBoard(board)
}
fun getPlayerMove(): Int {
    println("Where would you like to go?")
    var move = 20
    while(move > 9) {
        try {
            move = readln().toInt()
            while(playerMoves.contains(move) or computerMoves.contains(move)){
                println("Please enter a valid value")
                move = readln().toInt()
            }
        } catch (e: Exception) {
            println("Please enter a valid value")
        }
    }
    return move
}

fun printBoard(board: List<List<Char>>) = board.forEach{
    it.forEach{
        print(it)
    }
    println()
}

fun checkWin(): String? {
    val winCombos = listOf(listOf(1,2,3),
        listOf(4,5,6),
        listOf(7,8,9),
        listOf(1,4,7),
        listOf(2,5,6),
        listOf(3,6,9),
        listOf(1,5,9),
        listOf(3,5,7))

    winCombos.forEach{
        if(playerMoves.contains(it[0]) && playerMoves.contains(it[1]) && playerMoves.contains(it[2])){
            return "Yay you won"
        }
        if(computerMoves.contains(it[0]) && computerMoves.contains(it[1]) && computerMoves.contains(it[2])){
            return "Sorry you lost"
        }
        if(playerMoves.size == 6){
            return "Cat game"
        }
    }
    return ""
}
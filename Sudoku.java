import java.util.InputMismatchException;
import java.util.Scanner;
import Theme.Colors;

public class Sudoku{
    private final static int[][] board = {    // 9x9 Sudoku grid representation.
    { 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
    { 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
    { 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
    { 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
    { 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
    { 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
    { 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
    { 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 },
    { 0, 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 }
    };

    static void main(String[] args) {
        System.out.println(Colors.GREEN+ Colors.BOLD + "\tWelcome to my sudoku , enjoy :)" + Colors.RESET);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(Colors.PURPLE + "╔═══════════════════════════════╗");
            System.out.println("║ " + Colors.mainTitle("      Main Menu               ") + Colors.PURPLE + "║");
            System.out.println("╠═══════════════════════════════╣");
            System.out.println("║ " + Colors.option("  1. child                   ") + Colors.PURPLE + " ║");
            System.out.println("║ " + Colors.option("  2. beginner                ") + Colors.PURPLE + " ║");
            System.out.println("║ " + Colors.option("  3. intermediate            ") + Colors.PURPLE + " ║");
            System.out.println("║ " + Colors.option("  4. advanced                ") + Colors.PURPLE + " ║");
            System.out.println("║ " + Colors.option("  0. Exit                    ") + Colors.PURPLE + " ║");
            System.out.println("╚═══════════════════════════════╝" + Colors.RESET);
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch(choice){
                    case 1:
                        gamePlayLogic(10);
                        break;
                    case 2:
                        gamePlayLogic(35);
                        break;
                    case 3:
                        gamePlayLogic(45);
                        break;
                    case 4:
                        gamePlayLogic(55);
                        break;
                    case 0:
                        System.out.println(Colors.RED + "Exiting......" + Colors.RESET);
                        return;
                    default:
                        System.out.println("Enter valid number :1, 2, 3, or 4");
                }
            }catch (InputMismatchException e) {
                System.out.println(Colors.RED + "Please enter NUMBERS only" + Colors.RESET);
                scanner.nextLine();
            }
        }
    }

    private static void gamePlayLogic(int Delete){
        int num;
        resetBoard();
        generateBoardNumbers(Delete);
        Scanner input = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        int row;
        int col;
        int lives=3;
        while(true){
            printBoard();
            System.out.println("You have "+lives+" lives");
            System.out.println( "Enter your Coordinates (Row then Column 1-9): ");
            try {
                row = input.nextInt() - 1;
                col = input.nextInt() - 1;

                if (row < 0 || row > 8 || col < 0 || col > 8){
                    System.out.println(Colors.RED+"Error: Use numbers between 1 and 9!"+Colors.RESET);
                    continue;
                }

                if (board[row][col] != 0){
                    System.out.println("This cell is already filled! Choose another one.");
                    continue;
                }

                System.out.println( "Enter your number (1-9): ");
                num = input.nextInt();

                if (check(row , col , num)){
                    board[row][col] = num;
                    System.out.println(Colors.PURPLE+"Nice move!"+Colors.RESET);
                } else {
                    printBoard();
                    board[row][col] = num;
                    System.out.println("This number is already in the row, column, or 3x3 box.");
                    lives--;
                    System.out.println(Colors.RED+"You lost a life. Remaining: " +Colors.RESET+ Colors.BG_CYAN+ lives +Colors.RESET);
                    board[row][col] = 0;
                }

                if (lives > 0){
                    System.out.println(Colors.GREEN+"Remaining lives: " +lives +Colors.RESET);
                } else {
                    System.out.println(Colors.RED+"We have a loooooooooser!!"+Colors.RESET);
                    long endTime = System.currentTimeMillis();
                    timer(startTime, endTime);
                    break;
                }

                if(isFull()){
                    printBoard();
                    System.out.println(Colors.GREEN+"Congratulations, You have WON!!!!"+Colors.RESET);
                    long endTime = System.currentTimeMillis();
                    timer(startTime, endTime);
                    break;
                }

            } catch (InputMismatchException e){
                System.out.println(Colors.RED + "Error: Please enter numbers only!" + Colors.RESET);
                input.nextLine();
            }
        }
    }

    private static void printBoard(){
        System.out.println(Colors.PURPLE + "╠═══════════════════════════════════╣" + Colors.RESET);

        for(int i = 0 ; i < 9 ; i++){
            System.out.print(Colors.PURPLE + "║ " + Colors.RESET);

            for(int j = 0 ; j < 9 ; j++){

                String colColor = ((j + 1) % 3 == 0) ? Colors.PURPLE : Colors.NAVY_BLUE;

                if(board[i][j] == 0)
                    System.out.print(colColor + "  ║ " + Colors.RESET);
                else
                    System.out.print(Colors.RESET + board[i][j] + colColor + " ║ " + Colors.RESET);
            }

            String rowColor = ((i + 1) % 3 == 0) ? Colors.PURPLE : Colors.NAVY_BLUE;
            System.out.println("\n" + Colors.PURPLE+ "║" + Colors.RESET+ rowColor + "═══════════════════════════════════"+ Colors.RESET+ Colors.PURPLE+ "║" + Colors.RESET);
        }
    }

    private static void generateBoardNumbers(int level){
        for (int col = 0; col < 9; col++){        // Filling the first row.
            boolean isPlaced = false;
            while (!isPlaced){
                int num = randomNumberGenerator() + 1;
                if (check(0, col, num)){
                    board[0][col] = num;
                    isPlaced = true;
                }
            }
        }
        solveBoard();                           //Continue filling the board according to the first row.

        int numberOfCells = 0;
        int backup;
        while(numberOfCells < level){                //Deleting some random cells
            int col = randomNumberGenerator();
            int row = randomNumberGenerator();
            if(board[row][col] == 0)
                continue;
            else{
                backup = board[row][col];
                board[row][col] = 0;
            }
            if(countSolutions()==1){
                numberOfCells++;
            }else
                board[row][col] = backup;
        }
    }

    private static boolean check(int row, int col, int num){
        for (int i = 0; i < 9; i++){
            if (board[row][i] == num || board[i][col] == num)
                return false;
    }

    int startRow = row - row % 3;
    int startCol = col - col % 3;
    for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
            if (board[i + startRow][j + startCol] == num) return false;
        }
    }

    return true;
}

    private static boolean isFull(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

    //Linear Congruential Generator (LCG)
    private static int randomNumberGenerator(){
         long seed;
         final long a = 1103515245L;
         final long c = 12345L;
         final long m = 2147483648L;
         //Seed in nanosecond to make sure it will never be the same numbers twice (probably).
        seed = System.nanoTime();
        //The function:
        seed = (a * seed + c) % m;

        /*
         * 1-Make an integer number from 1 to 9.
         * 2-(Math.abs(seed) % 9) -> to be from 0 to 8 and POSITIVE.
         */
        return (int) (Math.abs(seed) % 9 ) ;
    }

    private static boolean solveBoard(){
        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++){
                if (board[row][col] == 0){
                    for (int num = 1; num <= 9; num++){
                        if (check(row, col, num)){
                            board[row][col] = num;
                            if (solveBoard())
                                return true;

                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static int countSolutions() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Searching for an empty cell.
                if (board[row][col] == 0) {
                    int count = 0;
                    for (int num = 1; num <= 9; num++) {
                        if (check(row, col, num)) {
                            board[row][col] = num;

                            count += countSolutions(); //all possible solutions.

                            board[row][col] = 0;

                            if (count > 1){          // if there is more than 1 solution, there is no need to continue.
                                return count;
                            }
                        }
                    }
                    return count;
                }
            }
        }
        return 1;    // If execution reaches this base case, a unique solution has been verified.
    }

    private static void resetBoard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }
    }

    private static void timer(long startTime, long endTime){
        long timeTakenMillis = endTime - startTime;
        long totalSeconds = timeTakenMillis / 1000; //Converting millisecond to seconds.

        long minutes = totalSeconds / 60; //Calculate minutes.
        long seconds = totalSeconds % 60;

        System.out.println(Colors.PURPLE + "Time taken: " + Colors.BOLD + minutes + " Minutes and " + seconds + " Seconds." + Colors.RESET);
    }
}
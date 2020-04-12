
package ru.geekbrains.java_one.lesson_c.ThirdPractical;

public class TicTacToe {

package ru.geekbrains.java_one.lesson_c.ThirdPractical;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final int fieldSize = 3;
    private static char[][] field;

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';

    // init field
    private static void initMap() {
        field = new char[fieldSize][fieldSize];
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                field[y][x] = EMPTY_DOT;
            }
        }
    }

    // print field
    private static void printMap() {
        System.out.println("-------");
        for (int y = 0; y < fieldSize; y++) {
            System.out.print("|");
            for (int x = 0; x < fieldSize; x++) {
                System.out.print(field[y][x] + "|");
            }
            System.out.println();
        }
    }
    // human turn
    private static void humanTurn() {
        int x;
        int y;
        do {
            System.out.printf("Введите координаты хода X и Y (от 1 до %d) через пробел: ", fieldSize);
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!(isEmptyCell(y, x) && isValidCell(y, x)));
        field[y][x] = HUMAN_DOT;
    }

    // is cell empty
    private static boolean isEmptyCell(int y, int x) {
        return field[y][x] == EMPTY_DOT;
    }

    // is cell valid
    private static boolean isValidCell(int y, int x) {
        return x >= 0 && x < fieldSize && y >= 0 && y < fieldSize;
    }

    // ai turn
    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSize);
            y = RANDOM.nextInt(fieldSize);
        } while (!isEmptyCell(y, x));
        field[y][x] = AI_DOT;
    }
    // check win
    private static boolean checkWin(char c) {
        // horizontal
//        for (int i = 0; i < field.length; i++) {
//            if (field[i][0] == c && field[i][1] == c && field[i][2] == c) return true;
//       }
        //vertical
//        for (int i = 0; i < field.length; i++) {
//            if  (field[0][i] == c && field[1][i] == c && field[2][i] == c) return true;
//        }
        //diagonal
//        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
//        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (checkLine(i, j, 0, 1,  c)) return true;
                if (checkLine(i, j, 1, 1,  c)) return true;
                if (checkLine(i, j, 1, 0,  c)) return true;
                if (checkLine(i, j, -1, 1, c)) return true;
            }
        }
        return false;
    }

    private static boolean checkLine(int y, int x, int dy, int dx, char c) {
        int cellsForWin = 3;
        int alongX = x + (cellsForWin - 1) * dx;
        int alongY = y + (cellsForWin - 1) * dy;
        if (alongX < 0 || alongY < 0 || alongX > fieldSize - 1 || alongY > fieldSize - 1) return false;
        for (int i = 0; i < cellsForWin; i++) {
            if (field[y + i * dy][x + i * dx] != c) return false;
        }
        return true;
    }
    // check draw
    private static boolean isMapFull() {
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (isEmptyCell(y, x)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        while (true) {
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (gameChecks(HUMAN_DOT, "Human win!")) break;
                aiTurn();
                printMap();
                if (gameChecks(AI_DOT, "AI win!")) break;
            }
            System.out.println("Play again?");
            if (!SCANNER.next().equals("Y"))
                break;
        }
        SCANNER.close();
    }
    private static boolean gameChecks(char aiDot, String s) {
        if (checkWin(aiDot)) {
            System.out.println(s);
            return true;
        }
        if (isMapFull()) {
            System.out.println("draw!");
            return true;
        }
        return false;
    }
}

>>>>>>> Stashed changes

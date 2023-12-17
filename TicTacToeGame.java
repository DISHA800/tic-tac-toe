import java.util.*;
class tttg {
    char[][] board;
    Scanner sc = new Scanner(System.in);
    String p1;  // player - 1
    String p2;  // player - 2 

    tttg() {
        board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    void print() {
        for (int i = 0; i < 3; i++) {
            System.out.println(".............");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println(".............");
    }

    void mark(int r, int c, char m) {
        if (r >= 0 && r <= 2 && c >= 0 && c <= 2) {
            board[r][c] = m;
        } 
        else {
            System.out.println("Oops!! You entered an invalid input.");
        }
    }

    boolean cwin() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[0][j] == board[2][j] && board[0][j] != ' ') {
                return true;
            }
        }
        return false;
    }

    boolean rwin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true;
            }
        }
        return false;
    }

    boolean dwin() {
        if ((board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
                || (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
            return true;
        }
        return false;
    }

    boolean vmove(int r, int c) {
        if (r >= 0 && r <= 2 && c >= 0 && c <= 2) {
            if (board[r][c] == ' ') {
                return true;
            } 
            else {
                System.out.println("Oops!! You entered an invalid input, this cell is already filled with a mark.");
                return false;
            }
        } 
        else {
            System.out.println("Oops!! You entered an invalid input, please enter valid row and column numbers.");
            return false;
        }
    }

    void move(String n) {
        System.out.println("Enter the row and column number where " + n + " wants to insert the mark: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        if (vmove(r, c)) {
            char m;
            if (n.equals(p1)) {
                m = 'X';
            } 
            else {
                m = 'O';
            }
            mark(r, c, m);
        } 
        else {
            move(n);
        }
    }

    void play() {
        System.out.println("Hello, Welcome to Tic-Tac-Toe Game!");
        System.out.print("Enter name for Player 1 with mark (X): ");
        p1 = sc.next();
        System.out.print("Enter name for Player 2 with mark (O): ");
        p2 = sc.next();

        int move = 0;
        while (move < 9) {
            String cp;
            if (move % 2 == 0) {
                cp = p1;
            } 
            else {
                cp = p2;
            }

            System.out.println("It's " + cp + "'s turn ");
            move(cp);
            print();

            if (cwin() || rwin() || dwin()) {
                System.out.println("Congratulations! " + cp + " wins the game!!");
                break;
            }

            move++;
        }

        if (move == 9) {
            System.out.println("It's a tie!");
        }
    }
}

public class TicTacToeGame {
    public static void main(String[] args) {
        tttg t = new tttg();
        t.play();
    }
}


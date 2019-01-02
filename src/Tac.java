import java.util.Scanner;
import java.util.regex.Pattern;

public class Tac {

    public static void main(String [] agrs){
        new Tac().run();
    }

    private void run(){
        String player1 = "X";
        String player2 = "Y";
        int NumofBoard = 9;
        int round = 1;
        boolean isFinished = false;
        String [] board = new String[NumofBoard];
        for(int i = 0;i < board.length;i++){
            board[i] = ""+ (i + 1);
        }

        while(!isFinished && round <= NumofBoard){
            PrintBoard(board,round);
            if(round % 2 != 0){
            System.out.println("It's player 1's turn.");
                String UserInput = GetVaildString();
                if(isPositionAvailable(UserInput,board)){
                    board[Integer.parseInt(UserInput) - 1] = player1;
                    round++;
                    isFinished = haveWinner(board,player1);
                } else {
                    System.out.println("This position is unavailable, please choose another one!");
                }
            } else {
                System.out.println("It's player 2's turn.");
                String UserInput = GetVaildString();
                if(isPositionAvailable(UserInput,board)){
                    board[Integer.parseInt(UserInput) - 1] = player2;
                    round++;
                    haveWinner(board,player2);
                } else {
                    System.out.println("This position is unavailable, please choose another one!");
                }
            }
        }

        PrintBoard(board,round);
        if(isFinished){
            if(round % 2 == 0){
                System.out.println("Player 1 has won !");
            } else {
                System.out.println("Plyaer 2 has won !");
            }
        } else {
            System.out.println("Round draw!");
        }


    }

    private String GetVaildString(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Pattern pattern = Pattern.compile("[1-9]*");
        boolean b = pattern.matcher(str).matches();
        while(!b || str.isEmpty()){
            System.out.println("Please input number from 1-9");
            str = scanner.nextLine();
            b = pattern.matcher(str).matches();
        }

        return str;
    }

    private boolean isPositionAvailable(String str,String [] p){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(p[Integer.parseInt(str) - 1]).matches();
    }

    private boolean haveWinner(String[] board,String player){
        if(board[0].equals(player) && board[1].equals(player) && board[2].equals(player)){
            return true;
        } else if(board[3].equals(player) && board[4].equals(player) && board[5].equals(player)){
            return true;
        } else if(board[6].equals(player) && board[7].equals(player) && board[8].equals(player)){
            return true;
        } else if(board[0].equals(player) && board[3].equals(player) && board[6].equals(player)){
            return true;
        } else if(board[1].equals(player) && board[4].equals(player) && board[7].equals(player)){
            return true;
        } else if(board[2].equals(player) && board[5].equals(player) && board[8].equals(player)){
            return true;
        } else if(board[0].equals(player) && board[4].equals(player) && board[8].equals(player)) {
            return true;
        } else return board[2].equals(player) && board[4].equals(player) && board[6].equals(player);
    }

    private void PrintBoard(String [] board,int round){
        System.out.println("Round : " + round);
        int counter = 0;
        for (String aBoard : board) {
            System.out.print("| " + aBoard + " ");
            counter++;
            if (counter % 3 == 0) {
                System.out.print("|");
                System.out.append("\n");

            }
        }
    }

    }
package lastpencil;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pencils = getPositiveInteger(sc);

        String player1 = getValidPlayer(sc);

        String player2 = player1.equals("John") ? "Jack" : "John";

        String currentPlayer = player1;

        drawPencils(pencils);

        // game loop
        while (pencils > 0) {
            int number;
            if (currentPlayer.equals("Jack")) {
                System.out.println(currentPlayer + "'s turn!");
                number = botPlay(pencils);
                System.out.println(number);
            } else {
                System.out.println(currentPlayer + "'s turn:");
                number = getValidMove(sc, pencils);
            }

            pencils -= number;

            if(pencils == 0){
                String winner = currentPlayer.equals(player2) ? player1 : player2;
                System.out.println(winner +" won!");
            } else {
                drawPencils(pencils);
                currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
            }
        }


        sc.close();

    }

    private static int botPlay(int pencils) {
        Random rand = new Random();
        if (pencils == 1) {
            return 1;
        } else if (pencils % 4 == 0) {
            return 3;
        } else if (pencils % 4 == 3) {
            return 2;
        } else if (pencils % 4 == 2) {
            return 1;
        } else {
            return rand.nextInt(3) + 1;
        }
    }

    private static int getValidMove(Scanner sc, int pencils) {
        int move;
        while(true){
            String input = sc.nextLine();
            try {
                move = Integer.parseInt(input);
                if(move < 1 || move > 3){
                    System.out.println("Possible values: '1', '2' or '3'");
                } else if (move > pencils) {
                    System.out.println("Too many pencils were taken");
                } else {
                    return move;
                }
            } catch (NumberFormatException e){
                System.out.println("Possible values: '1', '2' or '3'");
            }
        }
    }

    private static String getValidPlayer(Scanner sc) {
        System.out.println("Who will be the first (John, Jack):");
        while(true){
            String input = sc.nextLine();
            if(input.equals("John") || input.equals("Jack")){
                return input;
            } else  {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }
    }

    private static int getPositiveInteger(Scanner sc) {
        int value;
        while (true){
            System.out.println("How many pencils would you like to use:");
            String input = sc.nextLine();
            try{
                value = Integer.parseInt(input);
                if(value > 0){
                    return value;
                } else{
                    System.out.println("The number of pencils should be positive");
                }
            } catch (NumberFormatException e){
                System.out.println("The number of pencils should be numeric");
            }
        }
    }

    private static void drawPencils(int pencils) {
        for (int i = 0; i < pencils; i++) {
            System.out.print("|");
        }
        System.out.println();
    }

}

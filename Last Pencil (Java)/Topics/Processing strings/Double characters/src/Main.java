import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            System.out.print(input.charAt(i));
            System.out.print(input.charAt(i));
        }


        scanner.close();
    }
}

    package HangmanGame;

import java.util.Scanner;

    public class HangmanMain {
        public static void main(String[] args) {
            HangmanManager game = new HangmanManager();
            Scanner sc = new Scanner(System.in);
            GameMenu menu = new GameMenu();
            System.out.println(menu.GameMenuPrint());
            System.out.print("   Press 1 or 2:  ");
            String select = sc.nextLine();
            if (select.equals("1"))
                game.GameStart();
            else if (select.equals("2")) {
                System.err.print("Do you want to leave the game?(yes/no): ");
                String confirm = sc.nextLine();
                if (confirm.equals("yes"))
                    System.exit(0);
                else {
                    game.GameStart();
                }
            } else
                System.err.println("Unavailable choice");
        }
}

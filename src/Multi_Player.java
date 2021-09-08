import java.util.Scanner;
public class Multi_Player {
    public Multi_Player() {
        Scanner stdin = new Scanner(System.in);
        int number;
        int sum = 0;
        System.out.println("Select a player to go first. (Player1/Player2)");
        String turn = stdin.nextLine();
        turn=turn.replaceAll(" ","");
        while (!((turn.equalsIgnoreCase("Player1"))||(turn.equalsIgnoreCase("Player2")))){
            System.out.println("Select a player to go first. (Player1/Player2)");
            turn=stdin.nextLine();
            turn=turn.replaceAll(" ","");
        }
        while (!Win(sum)) {
            System.out.println(turn+"'s turn.");
            System.out.println("Print a number that adds 1 or 2 until you reach 20 first.");
            number = stdin.nextInt();
            while (Over20(sum)){
                System.out.println("That number exceeds 20!!! Please add up to 20 and win!");
                number = stdin.nextInt();
            }
            while (!Checker(sum, number)) {
                System.out.println("Number does not add 1 or 2... Please add 1 or 2 to the number.");
                number = stdin.nextInt();
            }
            sum=number;
            if(!Win(sum)) turn=turn.equals("Player1")?"Player2":"Player1";
        }
        if ((Win(sum))) {
            if ((turn.equalsIgnoreCase("Player1"))) {
                System.out.println("Player1 wins!");
            } else {
                System.out.println("Player2 wins!");
            }
        }
        stdin.close();
    }
    public static boolean Win(int sum){
        return sum == 20;
    }
    public static boolean Checker(int sum, int number){
        return (number == sum + 1) || (number == sum + 2);
    }
    public static boolean Over20(int number){
        return number > 20;
    }
}

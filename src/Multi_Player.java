import java.util.Scanner;
public class Multi_Player {
    public Multi_Player() {
        Scanner stdin = new Scanner(System.in);
        boolean condition = false;
        boolean isValid = true;
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
        while (!Win(condition, sum)) {
            System.out.println("Print a number that adds 1 or 2 until you reach 20 first. "+turn+"'s turn!");
            number = stdin.nextInt();
            while (Over20(isValid, number)==false){
                System.out.println("That number exceeds 20!!! Please add up to 20 and win!");
                number = stdin.nextInt();
            }
            while (Checker(isValid, sum, number) == false) {
                System.out.println("Number does not add 1 or 2... Please add 1 or 2 to the number.");
                number = stdin.nextInt();
            }
            sum = number;
            turn=turn.equalsIgnoreCase("Player1")?"Player2":"Player1";
        }
        if ((Win(condition, sum)==true)) {
            if ((turn.equalsIgnoreCase("Player1"))) {
                System.out.println("Player2 wins!");
            } else {
                System.out.println("Player1 wins!");
            }
        }
        stdin.close();
    }
    public static boolean Win(boolean condition, int sum){
        if (sum==20){
            condition=true;
        }
        return condition;
    }
    public static boolean Checker(boolean isValid,int sum, int number){
        if ((number!=sum+1)&&(number!=sum+2)){
            isValid=false;
        }
        return isValid;
    }
    public static boolean Over20(boolean isValid,int number){
        if (number>20){
            isValid=false;
        }
        return isValid;
    }
}

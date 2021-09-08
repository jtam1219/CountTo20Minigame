import java.util.Scanner;

public class Single_Player {
    public Single_Player() {
        Scanner stdin=new Scanner(System.in);
        int number;
        int sum=0;
        String turn="Player";
        while (!Win(sum)){
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
            if(!Win(sum)) turn=turn.equals("Player")?"CPU":"Player";
            if (AIWinTurn(sum)){
                sum=AIWin(sum);
                System.out.println(sum);
            }
            else if(!(AIWinTurn(sum))&&(sum<20)){
                sum+=(int)(1+Math.random()*2);
                System.out.println(sum);
            }
            if(!Win(sum)) turn = turn.equals("CPU") ? "Player" : "CPU";
        }
        if (Win(sum)){
            if (turn.equalsIgnoreCase("Player")) {
                System.out.println("Player wins!");
            }
            else{
                System.out.println("CPU wins!");
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
    public static boolean AIWinTurn(int sum){
        if (sum<2){
            return true;
        }
        if (sum>2&&sum<5){
            return true;
        }
        if (sum>5&&sum<8){
            return true;
        }
        if (sum>8&&sum<11){
            return true;
        }
        if (sum>11&&sum<14){
            return true;
        }
        if (sum>14&&sum<17){
            return true;
        }
        if (sum>17&&sum<20){
            return true;
        }
        return false;
    }
    public static int AIWin(int sum){
        if (sum<2){
            return 2;
        }
        if (sum>2&&sum<5){
            return 5;
        }
        if (sum>5&&sum<8){
            return 8;
        }
        if (sum>8&&sum<11){
            return 11;
        }
        if (sum>11&&sum<14){
            return 14;
        }
        if (sum>14&&sum<17){
            return 17;
        }
        if (sum>17&&sum<20) {
            return 20;
        }
        return 0;
    }
}

import java.util.Scanner;
public class CountTo20 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Select a gamemode:  Single Player/ Multiplayer");
        System.out.println("Press 1 to initiate Single Player. Press 2 to initiate Multiplayer.");
        int selection=0;
        do {
            selection=stdin.nextInt();
            if ((selection != 1) && (selection != 2)) {
                System.out.println("Press 1 to initiate Single Player. Press 2 to initiate Multiplayer.");
                selection = stdin.nextInt();
            }
        }
        while((selection != 1) && (selection != 2));
        if (selection==1){
            Single_Player S1=new Single_Player();
        }
        else if (selection==2){
            Multi_Player S2=new Multi_Player();
        }
    }
}

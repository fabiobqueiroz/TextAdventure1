
import java.util.Scanner;

public class Game {

    // Variáveis
    Scanner myScanner=new Scanner(System.in);
    Scanner enterScanner=new Scanner(System.in);
    int playerHp;
    String playerName;
    String playerWeapon;
    int choice;

    public static void main(String[] args) {
        Game game;//mudei o nome da classe para ficar mais facil de usar.
        game = new Game();// game em minusculo e o novo nome da classe Game, fica mais facil para nomear e posso fazer isso para qualquer palavra

        game.playerSetUp();// neste metodo eu chamei a classe main game para rodar a subclasse playerSetUp
        game.townGate();
        game.crossRoad();


    }
    public void playerSetUp(){

        playerHp = 15;

        playerWeapon="Knife";

        System.out.println("Your HP: "+playerHp);
        System.out.println("Your Weapon: "+ playerWeapon);
        System.out.println("Please enter your name: ");
        playerName = myScanner.nextLine();
        System.out.println("Hello " + playerName + ", let's start your adventure!");


    }

    public void townGate(){

        System.out.println(" ");
        System.out.println("------------------------------------------------------------------------ ");
        System.out.println( "\n \n");
        System.out.println("You are at gate of the town");
        System.out.println("A guard is standing in front of you");
        System.out.println("What do you want to do?");
        System.out.println(" ");
        System.out.println("1: Talk to the guard");
        System.out.println("2: Attack the guard");
        System.out.println("3: Leave");
        System.out.println("------------------------------------------------------------------------ ");

        choice=myScanner.nextInt();

        if(choice==1){
            System.out.println("Guard: Hello there stranger.So your name is " + playerName + "? Sorry but we cannot enter our town.");
            enterScanner.nextLine();
            townGate();
        }
        if(choice==2){
            playerHp=playerHp-1;
            System.out.println("Guard: Hey don't be stupid. \n The guard hit you so hard and you gave up. \n(You receive 1 damage)");
            System.out.println("Your HP: "+playerHp);
            enterScanner.nextLine();
            townGate();
        }
        if(choice==3){
            crossRoad();
        }
        else {
            townGate();
        }
    }

    public void crossRoad(){
        System.out.println("------------------------------------------------------------------------ ");
        System.out.println("You are at crossroad. If you go south, you will back to the town\n\n");
        System.out.println("1: Go north");
        System.out.println("2: Go east");
        System.out.println("3: Go south");
        System.out.println("4: Go west");
        System.out.println("------------------------------------------------------------------------ ");
        choice=myScanner.nextInt();
        if(choice==1){
            north();
        }
        if(choice==2){
            east();
        }
        if(choice==3){
            townGate();
        }
        if(choice==4){
            west();
        }
        else {
            crossRoad();
        }
    }



    public void north(){
        System.out.println("------------------------------------------------------------------------ ");
        System.out.println("There is a river. You drink the water and rest at the riverside.");
        System.out.println("Your HP is recovered.");
        playerHp=playerHp+1;
        System.out.println("Your HP: "+playerHp);
        System.out.println("\n\n1: Go back to the crossroad.");
        System.out.println("------------------------------------------------------------------------ ");
        choice=myScanner.nextInt();
        if(choice==1){
            crossRoad();
        }
        else{
            north();
        }

    }
    public void east(){
        System.out.println("------------------------------------------------------------------------ ");
        System.out.println("You walked into a forest and found a Long Sword!");
        playerWeapon="Long Sword";
        System.out.println("Your weapon: "+playerWeapon);
        System.out.println("\n\n1: Go back to the crossroad.");
        System.out.println("------------------------------------------------------------------------ ");
        choice=myScanner.nextInt();
        if(choice==1){
            crossRoad();
        }
        else{
            north();
        }

    }

    public void west(){
        System.out.println("------------------------------------------------------------------------ ");
        System.out.println("------------------------------------------------------------------------ ");

    }
}

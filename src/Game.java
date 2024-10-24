import java.util.Scanner;


public class Game {

    // Variáveis
    Scanner myScanner=new Scanner(System.in);
    Scanner enterScanner=new Scanner(System.in);
    int playerHp;
    int monsterHp;
    String playerName;
    String playerWeapon;
    int choice;
    int silverRing;



    public static void main(String[] args) {
        Game game;//mudei o nome da classe para ficar mais facil de usar.
        game = new Game();// game em minusculo e o novo nome da classe Game, fica mais facil para nomear e posso fazer isso para qualquer palavra

        game.playerSetUp();// neste metodo eu chamei a classe main game para rodar a subclasse playerSetUp
        game.townGate(); // o fluxo do jogo sera controlado apartir deste ponto



    }
    public void playerSetUp(){

        playerHp = 15;
        monsterHp=15;


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
            if(silverRing==1){
                ending();

            }
            else {
                System.out.println("Guard: Hello there stranger.So your name is " + playerName + "? Sorry but we cannot enter our town.");
                enterScanner.nextLine();
                townGate();
            }
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



    public void  crossRoad(){
        System.out.println("------------------------------------------------------------------------ ");
        System.out.println("You are at the crossroad.\nIf you go to south, you will go back to the town.\n");
        System.out.println("1:Go north");
        System.out.println("2:Go east");
        System.out.println("3:Go south");
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
        System.out.println("You are at the north\nThere is a river.You drink the water and rest at the riverside.");
        System.out.println("Your HP recovered.");
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
        System.out.println("You are at the east\n You walked into a forest and found a Long Sword!");
        playerWeapon="Long Sword";
        System.out.println("You obtained a "+playerWeapon);
        System.out.println("\n\n2: Go back to the crossroad.");

        choice=myScanner.nextInt();
        if(choice==1){
            crossRoad();
        }
        else{
            north();
        }
        System.out.println("------------------------------------------------------------------------ ");

    }
    public void south(){
        System.out.println("------------------------------------------------------------------------ ");

        System.out.println("------------------------------------------------------------------------ ");

    }
    public void west(){
        System.out.println("------------------------------------------------------------------------ ");
        System.out.println("You encounter a goblin!\n");
        System.out.println("1: Fight");
        System.out.println("2: Run");
        System.out.println("------------------------------------------------------------------------ ");
        choice=myScanner.nextInt();
        if(choice==1){
            fight();
        }
        if(choice==2){
            crossRoad();
        }
        else{
            west();
        }

    }
    public void fight(){
        System.out.println("------------------------------------------------------------------------ ");
        System.out.println("Your Hp: "+playerHp);
        System.out.println("Monster Hp: "+monsterHp);
        System.out.println("\n1: Attack");
        System.out.println("2: Run");

        System.out.println("------------------------------------------------------------------------ ");
        choice=myScanner.nextInt();
        if(choice==1){
            attack();
        }
        if(choice==2){
            crossRoad();
        }
        else{
            fight();
        }
    }
    public void attack(){
        int playerDamage=0;

        if(playerWeapon.equals("Knife")){
            playerDamage=new java.util.Random().nextInt(4);
        }
        if(playerWeapon.equals("Long Sword")){
            playerDamage=new java.util.Random().nextInt(8);
        }
        System.out.println("You attacked the monster and gave "+ playerDamage+ "damage!");

        monsterHp=monsterHp-playerDamage;
        System.out.println("Your HP: "+monsterHp);

        if(monsterHp<=0){
            win();
        }
        if(monsterHp>0){
            int monsterDamage=new java.util.Random().nextInt(4);
            System.out.println("The monster attacked you and gave "+monsterDamage+ "damage!");
            playerHp=playerHp-monsterDamage;
            System.out.println("Your HP: "+playerHp);
            if(playerHp<=0){
               dead();
            }
            if(playerHp>0){
                fight();
            }
        }
    }
    public void dead(){
        System.out.println("------------------------------------------------------------------------ ");
        System.out.println("You are dead!!!");
        System.out.println("\n\nGAME OVER");
        System.out.println("------------------------------------------------------------------------ ");


    }
    public void win(){
        System.out.println("------------------------------------------------------------------------ ");
        System.out.println("You killed the monster!!!");
        System.out.println("The monster dropped a ring");
        System.out.println("You obtaind a silver ring! \n\n");
        System.out.println("1: Go east");
        System.out.println("------------------------------------------------------------------------ ");
        silverRing=1;

        choice=myScanner.nextInt();
        if(choice==1){
            crossRoad();
        }
        else{
            win();
        }
    }
    public void ending(){
        System.out.println("------------------------------------------------------------------------ ");
        System.out.println("Guard: Oh you killed that goblin??? Great!");
        System.out.println("Guard: It sens you are trustwothy guy. Welcome to our town!");
        System.out.println("\n\nTHE END.");
    }
}

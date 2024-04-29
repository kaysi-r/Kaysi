import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;


public class Game{

  private int total;
  private String player;

  public Game(int totalScore, String playerName){
   this.total = totalScore;
   this.player = playerName;
  }

public static void main(String[] args) throws IOException{
  String name1 = "";
  String name2 = "";
  String input1 = "";
  String input2 = "";
  int score1= 0;
  int score2 = 0;
  int i = 1;

  
System.out.print("Enter the first player's name:");
Scanner scnr = new Scanner(System.in);
name1 = scnr.nextLine();
System.out.print("Enter the second player's name:");
name2 = scnr.nextLine();
System.out.println();
System.out.printf("Confirming...\nPlayer 1: %s \nPlayer 2: %s\n", name1, name2);
System.out.println();

System.out.println("BEGIN!!!");
System.out.println();


while(i <= 5){
System.out.printf("Round %d:\n",i);
System.out.println("-----------------------------------------------------------");  

System.out.println("Your word must contain...");
System.out.println();
String lett = letters("wordbank.txt");
System.out.println(lett);


System.out.println();
System.out.println("-----------------------------------------------------------");
System.out.println();
System.out.println("Player 1 Enter a Word Containing the Given Letters:");
input1 = scnr.nextLine();
System.out.println();
if(!input1.contains(lett)){
  System.out.println("Doesn't contain correct letters :(");
  System.out.println();
} else{
  score1 = score1 + score(input1);

}
System.out.println();
System.out.println();
System.out.println("Player 2 Enter a Word Containing the Given Letters:");
input2 = scnr.nextLine();
System.out.println();
if(!input2.contains(lett)){
  System.out.println("Doesn't contain correct letters :(");
  System.out.println();
} else {
  score2 = score2 + score(input2);
}

System.out.printf("Current Scores: \nPlayer 1: %d \nPlayer 2: %d\n", score1, score2);


i++;
System.out.println();
}

winner(score1, score2);

}

  public static String letters(String fileName) throws IOException{
    //randomly selects an index and uses that 
    //to grab the random letter 
    //segment from the array
    String letters = "";
    Random rnd = new Random();
    int r = rnd.nextInt(70);

    FileInputStream myFile = new FileInputStream(fileName);
    Scanner myFileReader = new Scanner(myFile);

    while (r > 0){
      letters = myFileReader.nextLine();
      r--; 
    }
    myFileReader.close();
    return letters;

  }

  public static int score(String input){
    //calculates the score and returns the value
    int score = input.length();
    if(input.contains("x") || input.contains("z") || input.contains("i")){
      score = score + 4;
    }
    if(input.contains("q") || input.contains("p") || input.contains("l")){
      score = score + 3;
    }
    if(input.contains("w") || input.contains("h") || input.contains("u")){
      score = score + 2;
    }
    if(input.contains("j") || input.contains("k") || input.contains("t")){
      score = score + 1;
    }
    return score;
  }

  public int returnTotalScore(int score){
      this.total = score;
      return this.total;
  }

  public String returnPlayerStats(String playerStats){
    this.player = playerStats;
    return this.player;
  }

  public static void winner(int score1, int score2){
    //determines winner
    if(score1 > score2){
      System.out.print("Player One is the Winner!");
    } else if (score1 < score2){
      System.out.print("Player Two is the Winner!");
    } else {
      System.out.print("It's a Draw!");
    }
  }


}
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;

/**
 * Input: a data file representing a long rock, paper, scissors game with
 * the opponents play marked with A, B or C representing rock, paper, scissors,
 * and your move marked X, Y or Z.
 *
 * The program will output your score based on what move you played every round,
 * and whether you won, lost, or had a draw.
 */


public class D2rockpaperscissors {
    public static int getScore(String filename) {
        Integer score = 0;
        File f = new File(filename);
        String opptest = "";
        String youtest = "";
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String[] game = sc.nextLine().split(" ");
                String opp = game[0];
                String your = game[1];
                opptest = opptest.concat(opp);
                youtest = youtest.concat(your);
                if (opp.equals("A")) {
                    if (your.equals("X")) {
                        //draw, rock
                        score += 3;
                        score += 1;
                    } else if (your.equals("Y")) {
                        //win, paper
                        score += 6;
                        score += 2;
                    } else {
                        //lose, scissors
                        score += 3;
                    }
                } else if (opp.equals("B")) {
                    if (your.equals("X")) {
                        //lose, rock
                        score += 1;
                    } else if (your.equals("Y")) {
                        //draw, paper
                        score += 3;
                        score += 2;
                    } else {
                        //win, scissors
                        score += 6;
                        score += 3;
                    }
                } else {
                    if (your.equals("X")) {
                        //win, rock
                        score += 6;
                        score += 1;
                    } else if (your.equals("Y")) {
                        //lose, paper
                        score += 2;
                    } else {
                        //draw, scissors
                        score += 3;
                        score += 3;
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.printf("First game: %c vs %c\nLast game: %c vs %c\n", opptest.charAt(0), youtest.charAt(0), opptest.charAt(opptest.length() - 1), youtest.charAt(youtest.length() - 1));
        System.out.printf("Your score is: %d\nCHEATER! CHEATER! CHEATER!", score);
        return score;
    }
    public static void main(String[] args) {
        File f = new File("data/D2input");
        try {
            Scanner sc = new Scanner(f);
            FileWriter fw = new FileWriter("data/D2p2input");
            while (sc.hasNext()) {
                //read game
                String[] game = sc.nextLine().split(" ");
                String opp = game[0];
                String your = game[1];

                //write what you need to play to D2input
                fw.write(opp + " ");

                if(your.equals("X")){
                    if(opp.equals("A")){
                        fw.write("Z\n");
                    } else if (opp.equals("B")) {
                        fw.write("X\n");
                    } else{
                        fw.write("Y\n");
                    }
                } else if(your.equals("Y")){
                    if(opp.equals("A")){
                        fw.write("X\n");
                    } else if (opp.equals("B")) {
                        fw.write("Y\n");
                    } else{
                        fw.write("Z\n");
                    }
                } else {
                    if (opp.equals("A")) {
                        fw.write("Y\n");
                    } else if (opp.equals("B")) {
                        fw.write("Z\n");
                    } else {
                        fw.write("X\n");
                    }
                }
            }
            fw.close();
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getScore("data/D2p2input");
    }
}
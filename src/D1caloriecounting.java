import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Input: text file with groups of integers separated by new lines.
 *
 * Each Integer represents a food item with the listed calories and each group of integers
 * represents an elf who is in possession of all those food items.
 * This code reads the calories into a list of total calories and outputs the calories of the
 * elf who has the most calories.
 */
public class D1caloriecounting {
    public static void main(String[] args) {
        List<Integer> elfs = new ArrayList<Integer>();
        File f = new File("data/D1input");
        Integer x = 0;
        //Load total calories for each elf into the list of elfs
        try (Scanner sc = new Scanner(f);) {
            while(sc.hasNext()) {
                String buffer = sc.nextLine();
                while(!buffer.equals("") && sc.hasNext()) {
                    x+=Integer.parseInt(buffer);
                    buffer = sc.nextLine();
                }
                elfs.add(x);
                x = 0;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        //find Max out of list
        int max = 0;
        for(Integer i: elfs){
            if(i > max){
                max = i;
            }
        }
        System.out.printf("Maximum elf calpories: %d\n\n", max);
    }
}

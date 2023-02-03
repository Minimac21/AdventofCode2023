import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class D4chores {

    /**
     * when one and two only contain two integers: the first being the left bound of an interval
     * and the second being the right bound, this will return true if one of the intervals contains the
     * other.
     *
     * @param one
     * @param two
     * @return
     */
    public static boolean contains(int[] one, int[] two) {
        if (one[0] <= two[0] && one[1] >= two[1]) {
            return true;
        } else if (two[0] <= one[0] && two[1] >= one[1]) {
            return true;
        }
        return false;
    }

    public static boolean overlaps(int[] one, int[] two) {
        if (one[0] <= two[0] && one[1] >= two[0]) {
            return true;
        } else if (one[0] <= two[1] && one[1] >= two[1]) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        File f = new File("data/D4input");
        int[] one = new int[2];
        int[] two = new int[2];
        String currLine = "";
        String[] bounds;
        String[] oneBound;
        int count=0;
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                currLine = sc.nextLine();
                bounds = currLine.split(",");
                oneBound = bounds[0].split("-");
                one[0] = Integer.parseInt(oneBound[0]);
                one[1] = Integer.parseInt(oneBound[1]);
                oneBound = bounds[1].split("-");
                two[0] = Integer.parseInt(oneBound[0]);
                two[1] = Integer.parseInt(oneBound[1]);
                if(contains(one,two) || overlaps(one,two)){
                   count+=1;
                }
            }
            sc.close();
        } catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        System.out.printf("%d Elves will only be cleaning what their partner has already cleaned", count);
    }
}
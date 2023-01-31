
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
import static java.lang.Character.isUpperCase;
import java.lang.CharSequence;

public class D3sackstuff {

    /**
     * This method returns a String which is essentially a "set" of all chars that are in both s and t.
     * I have two different ways of holding the repeated char "currRepeat" bc I need a CharSequence to see
     * if the set of already found repeats already holds it (in such a case i don't want to add it again)
     * and I need it as a string to concatenate to the "set" (String).
     *
     * I did it this way, not returning as an array of list or something easier like that because I wanted to be
     * able to write line 67. I think the nesting is cool.
     * @param s
     * @param t
     * @return
     */
    public static String findRepeat(String s, String t){
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        String repeats = "";
        CharSequence[] currRepeat = new String[1];
        String currRepeatStr;
        for(int i=0;i<first.length;i++){
            for(int j=0;j<second.length;j++){
                if(first[i] == second[j]){
                    currRepeatStr = String.valueOf(first[i]);
                    currRepeat[0] = currRepeatStr;
                    if(!repeats.contains(currRepeat[0])) {
                        repeats = repeats.concat(currRepeatStr);
                    }
                }
            }
        }
        return repeats;
    }

    public static int getPriority(char c){
        Character x = c;
        if(isUpperCase(x)){
            int z = x;
            return z-38;
        } else {
            int z = x;
            return z-96;
        }
    }

    public static void main(String[] args){
        File f = new File("data/D3input");
        int prioritySum = 0;
        char repeat = ' ';
        String a = null;
        String b = null;
        String c = null;
        try{
            Scanner sc = new Scanner(f);
            while(sc.hasNext()){
                a=sc.nextLine();
                b=sc.nextLine();
                c=sc.nextLine();
                System.out.println(findRepeat(findRepeat(a,b),findRepeat(b,c)));
                prioritySum+=getPriority(findRepeat(findRepeat(a,b),findRepeat(b,c)).charAt(0));
            }
        } catch(FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(prioritySum);

    }


}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Character;
import java.util.Collection;
/**
 * hard-coded for 9 stacks of crates
 */
public class D5supplystacks {

    public static void readStacksByLine(String s, List<Stack<Character>> l) {
        int index = 0;
        for (int i = 0; i < 9; i++) {
            index = 1 + 4 * i;
            Character currChar = Character.valueOf(s.charAt(index));
            if (currChar.toString().equals(" ")) {

            } else {
                l.get(i).push(currChar);
            }
        }
        return;
    }
    public static List<Stack<Character>> readStacks(String file){
        File f = new File(file);
        int count = 0;
        List<Stack<Character>> stacks = new ArrayList<Stack<Character>>();
        for(int i = 0; i<9; i++){
            stacks.add(new Stack<Character>());
        }

        List<String> lines = new ArrayList<String>();
        String currLine = "";

        try{
            Scanner sc = new Scanner(f);
            while(count < 8) {
                currLine = sc.nextLine();
                lines.add(currLine);
                count+=1;
            }
            Collections.reverse(lines);
            for(String l: lines) {
                readStacksByLine(l, stacks);
            }
            sc.close();
        } catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        return stacks;
    }


    public static void main(String[] args){
        List<Stack<Character>> stacks = readStacks("data/D5input");
        for(Character c: stacks.get(1)){
            System.out.println(c);
        }
        File f = new File("data/D5input");
        try{
            //Getting sc.nextline to be past the stacks
            Scanner sc = new Scanner(f);
            for(int i=0;i<10;i++){
                sc.nextLine();
            }


            //now we read and take care of the movements
            int numToMove = 0;
            int stackToMoveFrom = 0;
            int stackToMoveTo = 0;
            String currLine = "";
            List<Character> buffer = new ArrayList<Character>();
            while(sc.hasNext()){
                currLine = sc.nextLine();
                numToMove = Integer.parseInt(currLine.split(" ")[1]);
                stackToMoveFrom = Integer.parseInt(currLine.split(" ")[3]);
                stackToMoveTo = Integer.parseInt(currLine.split(" ")[5]);
                for(int i = 0; i < numToMove; i++){
                    buffer.add(stacks.get(stackToMoveFrom-1).pop());
                }
                Collections.reverse(buffer);
                for(int i = 0; i < numToMove; i++){
                    stacks.get(stackToMoveTo-1).push(buffer.get(i));
                }
            }
        } catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        for(Stack s: stacks){
            System.out.print(s.pop());
        }
    }
}


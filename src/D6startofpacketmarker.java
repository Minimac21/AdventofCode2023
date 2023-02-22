import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Character;

/**
 * Author: Mac DePriest
 * Date: 2023/02/06
 * I'm on the frontlines frens. I had to see like 5 women today (irl).
 * This program finds the first instance of @param size (currently 14)
 * consecutive unique characters in a file that is just one long string of characters
 */
public class D6startofpacketmarker {

    /**
     * This is a recursive function that returns true if list has all unique characters
     *
     *
     * @param index the currrt char to be tested for equality against chars from index +1 to the end
     * @param size the size of the list
     * @param list
     * @return
     */
    public static boolean areDiff(int index, int size, Character[] list){
        for(int i = index+1;i<size;i++){
            if(list[index].equals(list[i])){
                return false;
            }
        }
        if(index==size-1){
            return true;
        }
        return areDiff(index+1,size,list);
    }

    /**
     * This function shifts all members of a list one to the left, and the 0th entry gets shifted to
     * the end. This is because my program reads a new character into the 0th spot, where the oldest char
     * that needs to be removed is, and this newest 0th, being the newest char it needs to go to the end
     * @param x
     * @param size
     * @return
     */
    public static Character[] rotate(Character[] x, int size){
        Character[] copy = new Character[size];
        for(int i = 0;i<size;i++){
            copy[i] = x[i];
        }
        for(int i = 0; i<size-1;i++){
            x[i] = copy[i+1];
        }
        x[size-1] = copy[0];
        return x;
    }

    public static void main (String[] args){
       File f = new File("data/D6input");
       int size = 14;
       Character[] list = new Character[size];
       try{
           Scanner sc = new Scanner(f);
           String signal = sc.next();
           for(int i = 0; i<size;i++){
               list[i] = signal.charAt(i);
           }
           for(int i = 4; i < signal.length(); i++){

               if(areDiff(0,size,list)){
                   System.out.printf("Read %d characters before start of packet marker\n", i);
                   break;
               }
               list[0] = signal.charAt(i);
               list  = rotate(list, size);
           }
       } catch(FileNotFoundException e){
           throw new RuntimeException(e);
       }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.lang.Character;
import java.util.TreeSet;

/**
 * Just add to each dir. have a currDir variable, and somehow maintain the parent dir
 *
 */
public class D7fileStructure {
    public void main(String[] args){
        File f = new File("data/D7input");
        try{
            Scanner sc = new Scanner(f);
            

            //If .. then end currDir
            //If cd String, make a child var String
        } catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }

    }
}

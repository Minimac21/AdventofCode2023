import java.io.IOException;
import java.lang.Math;
import java.util.Arrays;

public class test {
    public static void main(String[] args) throws IOException {
        int sum = 0;
        for(int i = 1; i <= args.length; i++){
            sum+=Integer.parseInt(args[i-1]) * java.lang.Math.pow(10, 2*(args.length-i));
        }
        System.out.println(sum);
    }
}

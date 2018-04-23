import java.util.Random;
public class PuzzleJavaTest {    
    public static void main(String[] args) {
        PuzzleJava test = new PuzzleJava();
        // int[] x = {3,5,1,2,7,9,8,13,25,32};
        // System.out.println(test.greaterTen(x));
        // String[] y = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        // System.out.println(test.names(y));
        String[] a = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        System.out.println(test.shuffle(a));
    }
}
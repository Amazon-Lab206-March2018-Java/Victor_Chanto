import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;
import java.util.*;

public class PuzzleJava {
    public ArrayList greaterTen(int[] arr){
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for (int i=0;i<arr.length;i++){
            if(arr[i]>10){
                System.out.println(arr[i]);
                myArray.add(arr[i]);
            }
        }
        return myArray;
    }
    public ArrayList<String> names(String[] arr){
        Random random = new Random();
        ArrayList<String> greater=new ArrayList<String>();
        for (int i = 0; i < arr.length; i++) {
            int change = i + random.nextInt(arr.length - i);
            String temp = arr[i];
            arr[i] = arr[change];
            arr[change] = temp;
        }
        for (String i : arr){
            if(i.length()>5){
                greater.add(i);
            }
        }
        System.out.println(Arrays.toString(arr));
        return greater;
    }
    public static List shuffle(String string){
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        String shuffled = "";
        for (String letter : letters) {
            shuffled += letter;
        }
        List<String> result = Arrays.asList(shuffled.split(""));
        String letter = result.get(0);
        char first = letter.charAt(0);
        System.out.println(first);
        System.out.println("The last letter is: "+result.get(25));
        System.out.println("The first letter is: "+result.get(0));
        if(first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u'){
        System.out.println("The first letter is a vowel. Yay!");
        }
        return result;
        }
    public static ArrayList<Integer> ran10(){
        ArrayList<Integer> Result = new ArrayList<Integer>();
        Random rand = new Random();
        int Low = 55;
        int High = 100;
        for (int i = 0; i<10;i++){
            int randNum = rand.nextInt(High-Low) + Low;
            Result.add(randNum);
        }
        return Result;
    }
    public static ArrayList<Integer> RanSort10(){
        ArrayList<Integer> Result = new ArrayList<Integer>();
        Random rand = new Random();
        int Low = 55;
        int High = 100;
        for (int i = 0; i<10;i++){
            int randNum = rand.nextInt(High-Low) + Low;
            Result.add(randNum);
        }
        Collections.sort(Result);
        System.out.println("The max value is: "+ Result.get(9));
        System.out.println("The min value is: "+ Result.get(0));
        return Result;
    }
    public void RandString(){
        String alphabet= "abcdefghijklmnopqrstuvwxyz";
        String s = "";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            s+= alphabet.charAt(random.nextInt(26));
        }
        System.out.println(s);
    }
    public static ArrayList<String> RandString10(){
        ArrayList<String> Result = new ArrayList<String>();
        String alphabet= "abcdefghijklmnopqrstuvwxyz";
        String s = "";
        Random random = new Random();
        for (int x = 0; x<10;x++){
            for (int i = 0; i < 5; i++) {
                s+= alphabet.charAt(random.nextInt(26));
            }
            Result.add(s);
            s = "";
        }
        return Result;
    }
}

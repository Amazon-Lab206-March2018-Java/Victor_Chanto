import java.util.ArrayList;
import java.util.Collections;

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
    public ArrayList names(String[] arr){
        ArrayList<String> myArray = new ArrayList<String>();
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
            if(arr[i].length()>5){
                myArray.add(arr[i]);
            }
        }
        return myArray;
    }
    public void shuffle(String[] arr){
        shuffle(arr);
        System.out.println(arr);
    }
}
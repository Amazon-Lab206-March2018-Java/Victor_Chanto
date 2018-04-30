import java.util.ArrayList;
import java.util.Arrays;
public class BasicJava {
    public void print255() {
        for (int i=0;i<256;i++){
            System.out.println(i);
        }
    }
    public void odds255() {
        for (int i=0;i<256;i++){
            if(i%2==1){
                System.out.println(i);
            }
        }
    }
    public void sum255() {
        Integer sum = 0;
        for (int i=0;i<256;i++){
            sum+=i;
            String result = String.format("New number: %s, Sum: %s", i,sum);
            System.out.println(result);
        }
    }
    public void iterateArr(int[] arr) {
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public void max(int[] arr) {
        int max = arr[0];
        for (int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
    public void average(int[] arr) {
        int sum = 0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        float avg = sum/arr.length;
        System.out.println(avg);
    }
    public void arrOdds() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i=0;i<126;i++){
            if (i%2==1){
                y.add(i);
            }
        }
        System.out.println(y);
    }
    public void greaterY(int[] arr, int y) {
        int greater = 0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]>y){
                greater+=1;
            }
        }
        System.out.println(greater);
    }
    public void square(int[] arr) {
        for (int i=0;i<arr.length;i++){
            arr[i] = arr[i]*arr[i];
            System.out.println(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
    }
    public void delNegatives(int[] arr) {
        for (int i=0;i<arr.length;i++){
            if(arr[i]<0){
                arr[i]=0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    public void minMaxAvg(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int sum = 0;
        for (int i=0;i<arr.length;i++){
            if(arr[i]<min){
                min = arr[i];
            }
            if(arr[i]>max){
                max = arr[i];
            }
            sum += arr[i];
        }
        int avg = sum/arr.length;
        int [] myArray ={max,min,avg};
        System.out.println(Arrays.toString(myArray));
    }
    public void shift(int[] arr) {
        for (int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
            
        }
        arr[arr.length-1]=0;
        System.out.println(Arrays.toString(arr));
    }
}

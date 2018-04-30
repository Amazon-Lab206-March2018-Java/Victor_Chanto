import java.util.HashMap;
import java.util.ArrayList;

public class ExceptionallyGenericLists {
    public void exceptions(){
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for (int x = 0; x<myList.size();x++){
            try{
                Integer castedValue = (Integer) myList.get(x);
            } catch( ClassCastException e){
                System.out.println("ERROR ON INDEX"+x);
            }
        }
    }
}
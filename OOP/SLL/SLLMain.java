public class SLLMain {    
    public static void main(String[] args) {
        SLL newList = new SLL();
        newList.add(9);
        newList.add(10);
        newList.add(5);
        newList.printValues();
        newList.remove();
        newList.printValues();
    }
}
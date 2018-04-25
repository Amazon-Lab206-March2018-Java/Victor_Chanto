public class SLL{
    private Node head;

    public SLL(){
        this.head = null; 
    }

    public SLL add(int number){
        Node newNode = new Node(number);
        Node pointer = this.head;
        if(this.head==null){
            this.head = newNode;
            return this;
        }
        while(pointer!=null){
            if(pointer.getnext()==null){
                pointer.setnext(newNode);
                return this;
            }
            pointer=pointer.getnext();
        }
        return this;
    }

    public void printValues(){
        Node pointer = this.head;
        while(pointer!=null){
            System.out.println(pointer.getvalue());
            pointer=pointer.getnext();
        }
    }

    public void remove(){
        Node pointer = this.head;
        while(pointer.getnext()!=null){
            pointer=pointer.getnext();
        }
        pointer = null;
    }
}

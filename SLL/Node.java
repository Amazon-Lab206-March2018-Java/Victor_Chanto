public class Node{
    private Integer value;
    private Node next;

    public Node(int number){
        this.value = number;
        this.next = null;
    }
    public Integer getvalue(){
        return value;
    }
    public void setvalue(Integer value){
        this.value = value;
    }
    public Node getnext(){
        return next;
    }
    public void setnext(Node next){
        this.next = next;
    }


}




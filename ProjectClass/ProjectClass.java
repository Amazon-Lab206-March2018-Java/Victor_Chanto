
public class ProjectClass{
    private String name;
    private String description;

    public ProjectClass() {
        this("No name","No description");
    }
    
    public ProjectClass(String name) {
        this(name,"No description");
    }
    
    public ProjectClass(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String elevatorPitch(){
        return this.name+":"+this.description;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDesciption(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
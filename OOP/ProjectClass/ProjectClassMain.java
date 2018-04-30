public class ProjectClassMain {    
    public static void main(String[] args) {
        ProjectClass NewProject = new ProjectClass("test1");
        System.out.println(NewProject.elevatorPitch());
        NewProject.setDescription("testing for description");
        System.out.println(NewProject.getDesciption());
    }
}
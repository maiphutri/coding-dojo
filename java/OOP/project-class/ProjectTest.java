import java.util.ArrayList;

public class ProjectTest {
  public static void main(String[] args) {
    Project project1 = new Project();
    System.out.println(project1.elavatorPitch());
    Project project2 = new Project("Tesla", "Lorem ipsum");
    System.out.println(project2.elavatorPitch());
    Project project3 = new Project("Dojo");
    System.out.println(project3.elavatorPitch());
    project1.setName("Microsoft");
    project1.setDesc("Lorem");
    project1.setInitialCost(2.5);
    project2.setInitialCost(0.5);
    project3.setInitialCost(1.5);
    System.out.println(project1.elavatorPitch());
    System.out.println(project2.elavatorPitch());
    System.out.println(project3.elavatorPitch());
    
    ArrayList<Project> projects = new ArrayList<Project>();
    projects.add(project1);
    projects.add(project2);
    projects.add(project3);
    Portfolio portfolio = new Portfolio(projects);
    portfolio.showPortfolio();
    System.out.println("Total cost: " + portfolio.getPortfolioCost());
  }
}
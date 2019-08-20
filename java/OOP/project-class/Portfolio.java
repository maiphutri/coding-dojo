import java.util.ArrayList;

public class Portfolio {
  private ArrayList<Project> projects = new ArrayList<Project>();

  public Portfolio(ArrayList<Project> projects) {
    this.projects = projects;
  }

  public ArrayList<Project> getProjects() {
    return this.projects;
  }

  public void setProjects(ArrayList<Project> projects) {
    this.projects = projects;
  }

  public double getPortfolioCost() {
    double sum = 0;
    for (Project project: this.projects) {
      sum += project.getInitialCost();
    }
    return sum;
  }

  public void showPortfolio() {
    for (Project project: this.projects) {
      System.out.println(project.elavatorPitch());
    }
  }
}
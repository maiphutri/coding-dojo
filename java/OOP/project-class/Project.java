public class Project {
  private String name;
  private String description;
  private double initialCost;

  public Project() {
    this("Admin", "Administrator");
  }

  public Project(String name) {
    this.name = name;
  }

  public Project(String name, String desciption) {
    this.name = name;
    this.description = desciption;
  }

  public String getName() {
    return this.name;
  }

  public String getDesc() {
    return this.description;
  }

  public double getInitialCost() {
    return this.initialCost;
  }

  public void setInitialCost(double cost) {
    this.initialCost = cost;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setDesc(String desc) {
    this.description = desc;
  }

  public String elavatorPitch() {
    return String.format("%s (%.2f): %s", this.name, this.initialCost, this.description);
  }
}
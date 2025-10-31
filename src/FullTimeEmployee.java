public class FullTimeEmployee implements Employee{
    public FullTimeEmployee() {}
    private int id;
    private String name;
    private double monthlySalary;
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setMonthlySalary(double monthlySalary) {this.monthlySalary = monthlySalary;}
    public int getId() {return id;}
    public String getName() {return name;}
    public double getMonthlySalary() {return monthlySalary;}
    @Override
    public double calculateSalary() {return monthlySalary;}
    @Override
    public void displayDetails() {System.out.println("ID : "+ id+"\nName : "+name+"\nSalary : "+calculateSalary());}}
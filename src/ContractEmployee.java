public class ContractEmployee implements Employee{
    public ContractEmployee() {}
    private int id;
    private String name;
    private double totalSalary;
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setTotalSalary(double totalSalary) {this.totalSalary=totalSalary;}
    public int getId() {return id;}
    public String getName() {return name;}
    public double getTotalSalary() {return totalSalary;}
    @Override
    public double calculateSalary() {return totalSalary;}
    @Override
    public void displayDetails() {
        System.out.println("ID : "+ id+"\nName : "+name+"\nSalary : "+calculateSalary());}}
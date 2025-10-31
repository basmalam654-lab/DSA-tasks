public class PartTimeEmployee implements Employee{
    public PartTimeEmployee() {}
    private int id;
    private String name;
    private double hourlyRate;
    private int hoursWorked;
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setHourlyRate(double hourlyRate) {this.hourlyRate= hourlyRate;}
    public void setHoursWorked(int hoursWorked) {this.hoursWorked = hoursWorked;}
    public int getId() {return id;}
    public String getName() {return name;}
    public double getHourlyRate() {return hourlyRate;}
    public int getHoursWorked() {return hoursWorked;}
    @Override
    public double calculateSalary() {
        double total=hourlyRate*hoursWorked;
        return total;}
    @Override
    public void displayDetails() {System.out.println("ID : "+ id+"\nName : "+name+"\nSalary : "+calculateSalary());}}
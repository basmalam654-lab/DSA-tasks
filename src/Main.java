import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        FullTimeEmployee e1=new FullTimeEmployee();
        PartTimeEmployee e2=new PartTimeEmployee();
        ContractEmployee e3=new ContractEmployee();
        System.out.println("What type of employee you are? 1-full time Employee 2-part time  Employee 3-contract Employee");
        int x= input.nextInt();
        if(x==1){
            System.out.println("enter your id");
            e1.setId(input.nextInt());
            System.out.println("enter your name");
            e1.setName(input.nextLine());
            e1.setName(input.next());
            System.out.println("enter your monthlySalary");
            e1.setMonthlySalary(input.nextDouble());
            e1.displayDetails();
        }else if(x==2){
            System.out.println("enter your id");
            e2.setId(input.nextInt());
            System.out.println("enter your name");
            e2.setName(input.nextLine());
            e2.setName(input.next());
            System.out.println("enter your Hourly Rate");
            e2.setHourlyRate(input.nextDouble());
            System.out.println("enter your hours work");
            e2.setHoursWorked(input.nextInt());
            e2.displayDetails();
        }else if(x==3){
            System.out.println("enter your id");
            e3.setId(input.nextInt());
            System.out.println("enter your name");
            e3.setName(input.nextLine());
            e3.setName(input.next());
            System.out.println("enter your predefined Salary");
            e3.setTotalSalary(input.nextDouble());
            e3.displayDetails();
        }}}
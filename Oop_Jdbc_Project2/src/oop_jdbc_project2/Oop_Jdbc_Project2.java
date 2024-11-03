
package oop_jdbc_project2;

import Dao.EmployeeInterfaceImpl;
import Model.Employee;
import java.util.Scanner;




public class Oop_Jdbc_Project2 {

    static Scanner input=new Scanner(System.in);    
    public static void main(String[] args) {
        EmployeeInterfaceImpl dao=new EmployeeInterfaceImpl();
        System.out.println("*******WELCOME TO OUR EMPLOYEE MANAGEMENT SYSTEM*********");
        while(true){
            System.out.println("1.VIEW ALL EMPLOYEES"
                    + "\n2.VIEW PARTIVULAR EMPLOYEE BY ID"
                    + "\n3.ADD EMPLOYEE \n4.UPDATE EMPLOYEE \n5.DELETE EMPLOYEE \n6.EXIT");
            System.out.println("SELECT CHOICE . . . ");
            int ch=input.nextInt();
            if(ch==1){
                dao.viewAllEmployee();
                System.out.println("---------------");
            }
            else if(ch==2){
                System.out.println("ENTER THE ID ");
                int id=input.nextInt();
                boolean ans=dao.viewEmpById(id);
                if(ans){
                    System.out.println("done");
                    System.out.println("-----");
                }else{
                    System.out.println("This Id Not Exist");
                }
            }
             else if(ch==3){
                System.out.println("Add employee . . . ");
                System.out.println("Enter Employee Name ");
                String name=input.next();
                System.out.println("Enter Employee Age ");
                int age=input.nextInt();
                System.out.println("Enter Employee Salary ");
                String salary=input.next();
                Employee e=new Employee(name , age , salary);
                boolean ans=dao.addEmployee(e);
                if(ans){
                    System.out.println("ADDED SUCCESSFULLY");
                    System.out.println("------------");
                }
                else{
                    System.out.println("SomeThing Went Wrong.");
                }
            }
             else if(ch==4){
                System.out.println("Enter Id of Employee you Want to update ");
                int id=input.nextInt();
                System.out.println("Enter new Name ");
                 String name=input.next();
                System.out.println("Enter Employee Age ");
                int age=input.nextInt();
                System.out.println("Enter Employee Salary ");
                String salary=input.next();
                Employee e=new Employee(name , age , salary);
                boolean ans=dao.updateEmployee(id, e);
                if(ans){
                    System.out.println("UPDATED SUCCESSFULLY");
                    System.out.println("------------");
                }
                else{
                    System.out.println("SomeThing Went Wrong.");
                }
            }
             else if(ch==5){
                 System.out.println("Enter Id of Employee you Want to Delete ");
                int id=input.nextInt();
                boolean ans=false;
                ans=dao.deleteEmployee(id);
                  if(ans){
                    System.out.println("Deleted SUCCESSFULLY");
                    System.out.println("------------");
                }
                else{
                    System.out.println("SomeThing Went Wrong.");
                }
            }
             else if(ch==6){
                System.out.println("Thank You For Using Our Program");
                System.exit(0);
            }
             else{
                 System.out.println("NOT VALID CHOICE.. TRY AGAIN!");
                 
             }
        }
    }
    
}

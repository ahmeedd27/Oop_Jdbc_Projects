
package Dao;

import DbConnection.DbConnection;
import Model.Employee;
import java.sql.*;


public class EmployeeInterfaceImpl implements EmployeeInterface {

    @Override
    public boolean addEmployee(Employee e) {
        boolean flag=false;
        try{
            Connection con=DbConnection.createConnection();
            String sql="insert into employee(emp_name , age , salary) values(?,?,?)";
            PreparedStatement pst=con.prepareCall(sql);
            pst.setString(1, e.getName());
             pst.setInt(2, e.getAge());
              pst.setString(3, e.getSalary());
            pst.executeUpdate();
            flag=true;
            
        }catch(SQLException ee){
            System.out.println(ee);
        }
        return flag;
    }

    @Override
    public boolean updateEmployee(int id, Employee e) {
        boolean flag=false;
        try{
            Connection con=DbConnection.createConnection();
            String sql="update employee set emp_name=? , age=? , salary=? where emp_id="+id;
            PreparedStatement pst=con.prepareCall(sql);
            pst.setString(1, e.getName());
             pst.setInt(2, e.getAge());
              pst.setString(3, e.getSalary());
            pst.executeUpdate();
            flag=true;
        }catch(SQLException ee){
            System.out.println(ee);
        }
        return flag;
    }

    @Override
    public boolean deleteEmployee(int id) {
       boolean flag=false;
       try{
           Connection con=DbConnection.createConnection();
           String sql="delete from employee where emp_id="+id;
           PreparedStatement pst=con.prepareCall(sql);
        pst.executeUpdate();
           flag=true;
       }catch(Exception e){
           
       }
       return flag;
    }

    @Override
    public void viewAllEmployee() {
       try{
           Connection con=DbConnection.createConnection();
           String sql="select * from employee";
        PreparedStatement pst=con.prepareCall(sql);
        ResultSet rs=pst.executeQuery();
        while(rs.next()){
            System.out.println("emp_id : "+rs.getInt(1)+" / "+"emp_name : "+rs.getString("emp_name")+" / "+"age : "+rs.getInt(3)+" / "+"salary : "+rs.getString("salary"));
        }
       }catch(SQLException e){
           System.out.println(e);
       }
       
    }

    @Override
    public boolean viewEmpById(int id) {
       boolean flag=false; 
        try{
            Connection con=DbConnection.createConnection();
            String sql="select * from employee where emp_id="+id;
            PreparedStatement pst=con.prepareCall(sql);
             ResultSet rs=pst.executeQuery();
        while(rs.next()){
            System.out.println("emp_id : "+rs.getInt(1)+" / "+"emp_name : "+rs.getString("emp_name")+" / "+"age : "+rs.getInt(3)+" / "+"salary : "+rs.getString("salary"));
        }
            flag=true;
        }catch(SQLException e){
            System.out.println(e);
        }
        return flag;
    }
    
}

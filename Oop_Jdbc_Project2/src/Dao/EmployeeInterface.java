/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.Employee;

/**
 *
 * @author computop
 */
public interface EmployeeInterface {
    boolean addEmployee(Employee e);
    boolean updateEmployee(int id , Employee e);
    boolean deleteEmployee(int id);
    void viewAllEmployee();
    boolean viewEmpById(int id);
    
}

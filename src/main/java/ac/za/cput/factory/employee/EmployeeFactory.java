package ac.za.cput.factory.employee;

import ac.za.cput.domain.employee.Employee;

public class EmployeeFactory {

    public static Employee createEmp(String firstName, String lastName, String idNum, String jobTitle){
        return new Employee.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .idNum(idNum)
                .jobTitle(jobTitle)
                .build();
    }
}

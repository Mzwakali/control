package ac.za.cput.service.employee.impl;

import ac.za.cput.domain.employee.Employee;
import ac.za.cput.repository.employee.EmployeeRepository;
import ac.za.cput.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeService employeeService= null;
    @Autowired
    private EmployeeRepository employeeRepository;

    private EmployeeServiceImpl(){}

    public static EmployeeService getEmployeeService(){
        if (employeeService == null)employeeService = new EmployeeServiceImpl();
        return employeeService;
    }

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee read(String id) {
        return this.employeeRepository.getOne(id);
    }

    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void delete(String id) {
        this.employeeRepository.deleteById(id);
    }
}

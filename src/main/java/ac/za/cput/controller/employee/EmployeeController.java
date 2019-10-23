package ac.za.cput.controller.employee;

import ac.za.cput.domain.ResponseObject;
import ac.za.cput.domain.employee.Employee;
import ac.za.cput.domain.request.NewEmployee;
import ac.za.cput.factory.ResponseObjectFactory;
import ac.za.cput.factory.employee.EmployeeFactory;
import ac.za.cput.service.employee.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/control/employee")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ResponseEntity createEmpl(@RequestBody NewEmployee newEmployee){
        System.out.println(newEmployee);
        ResponseObject responseObject = ResponseObjectFactory.buildResponseObject(HttpStatus.OK.toString(),"Employee Created.");
        if (newEmployee.getFirstName() == null || newEmployee.getLastName() == null){
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDesc("Please enter name and/or last namem:");
        }
        /*else{
            Employee id =
        }*/

        return ResponseEntity.ok(responseObject);
    }
    private Employee saveEmployee(NewEmployee newEmployee){
        return employeeService.create(EmployeeFactory.createEmp(newEmployee.getFirstName(), newEmployee.getLastName(), newEmployee.getIdNum(), newEmployee.getJobTitle()));
    }
}

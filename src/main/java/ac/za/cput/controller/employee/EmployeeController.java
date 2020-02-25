package ac.za.cput.controller.employee;

import ac.za.cput.domain.ResponseObject;
import ac.za.cput.domain.employee.Employee;
import ac.za.cput.domain.request.NewEmployee;
import ac.za.cput.factory.ResponseObjectFactory;
import ac.za.cput.factory.employee.EmployeeFactory;
import ac.za.cput.repository.employee.EmployeeRepository;
import ac.za.cput.service.employee.EmployeeService;
import ac.za.cput.service.employee.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/control/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable String id){
        employeeRepository.deleteById(id);
    }

    @PostMapping("/create")
    void addEmployee(@RequestBody Employee employee){
        employeeRepository.save(employee);
    }

 //   @RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
 //   public List<Employee> persist(@RequestBody final Employee employee){
 //       employeeRepository.save(employee);
 //       return employeeRepository.findAll();
 //   }
    /*public ResponseEntity<Object> createEmployee(@RequestBody Employee employee){
        Employee newEmp = employeeRepository.save(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newEmp.getEmpId()).toUri();
        return ResponseEntity.created(location).build();
    }*/

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee, @PathVariable String id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (!optionalEmployee.isPresent())
            return ResponseEntity.notFound().build();
        employee.setEmpId(id);
        employeeRepository.save(employee);

        return ResponseEntity.noContent().build();
    }


}

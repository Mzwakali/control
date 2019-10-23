package ac.za.cput.controller.employee;

import ac.za.cput.domain.employee.Nurse;
import ac.za.cput.service.employee.impl.NurseServiceImpl;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/control/nurse")
public class NurseController {

    @Autowired
    private NurseServiceImpl nurseService;

    @PostMapping(value = "/create/{nurse}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Nurse create(@RequestBody Nurse nurse){
        return nurseService.create(nurse);
    }

    @GetMapping(path = "/find/{id}")
    public Nurse findById(@PathVariable String id){
        return nurseService.read(id);
    }

    @PutMapping("/update")
    public Nurse update(@RequestBody Nurse nurse){
        return nurseService.update(nurse);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        nurseService.delete(id);
    }

    @GetMapping("/getall")
    public List<Nurse>getAll(){
        return nurseService.getAll();
    }
}

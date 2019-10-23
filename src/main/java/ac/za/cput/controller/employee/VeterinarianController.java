package ac.za.cput.controller.employee;

import ac.za.cput.domain.employee.Veterinarian;
import ac.za.cput.service.employee.impl.VeterinarianServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/control/vet")
@CrossOrigin(origins = "http://localhost:8080")
public class VeterinarianController {

    @Autowired
    private VeterinarianServiceImpl veterinarianService;

    @PostMapping(path = "/create")
    public Veterinarian create(@RequestBody Veterinarian veterinarian){
        return veterinarianService.create(veterinarian);
    }

    @GetMapping(path = "/find/{id}")
    public Veterinarian findById(@PathVariable String id){
        return veterinarianService.read(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody Veterinarian veterinarian){
        veterinarianService.update(veterinarian);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        veterinarianService.delete(id);
    }

    @GetMapping(path = "/getall")
    public List<Veterinarian> getAll(){
        return veterinarianService.getAll();
    }

}

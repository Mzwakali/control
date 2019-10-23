package ac.za.cput.service.employee;

import ac.za.cput.domain.employee.Veterinarian;
import ac.za.cput.service.IService;

import java.util.List;
import java.util.Set;

public interface VeterinarianService extends IService<Veterinarian, String> {
    List<Veterinarian> getAll();
}

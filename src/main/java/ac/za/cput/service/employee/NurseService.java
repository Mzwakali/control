package ac.za.cput.service.employee;

import ac.za.cput.domain.employee.Nurse;
import ac.za.cput.service.IService;

import java.util.List;

public interface NurseService extends IService<Nurse, String> {

    List<Nurse>getAll();
}

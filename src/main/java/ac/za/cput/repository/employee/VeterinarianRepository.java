package ac.za.cput.repository.employee;

import ac.za.cput.domain.employee.Veterinarian;
import ac.za.cput.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository("VeterinarianRepository")
public interface VeterinarianRepository extends JpaRepository<Veterinarian, String> {

}

package ac.za.cput.repository.employee;

import ac.za.cput.domain.employee.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("NurseRepository")
public interface NurseRepository extends JpaRepository<Nurse, String> {
}

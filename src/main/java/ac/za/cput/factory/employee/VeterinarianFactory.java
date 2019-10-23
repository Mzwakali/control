package ac.za.cput.factory.employee;

import ac.za.cput.domain.employee.Veterinarian;
import ac.za.cput.util.IDGenerator;

public class VeterinarianFactory {

    public static Veterinarian getVeterinarian(String firstName, String lastName, String idNum, String jobTitle, String specializing){
       return (Veterinarian) new Veterinarian.VetBuilder()
               .specializing(specializing)
               .empId(IDGenerator.generateId())
               .firstName(firstName)
               .lastName(lastName)
               .idNum(idNum)
               .jobTitle(jobTitle)
               .build();
    }
}

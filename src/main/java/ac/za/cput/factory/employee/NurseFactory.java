package ac.za.cput.factory.employee;

import ac.za.cput.domain.employee.Nurse;
import ac.za.cput.util.IDGenerator;

public class NurseFactory {

    public static Nurse getNurse(String firstName, String lastName, String idNum, String jobTitle, String type){
        return (Nurse) new Nurse.NurseBuilder()
                .type(type)
                .empId(IDGenerator.generateId())
                .firstName(firstName)
                .lastName(lastName)
                .idNum(idNum)
                .jobTitle(jobTitle)
                .build();
    }
}

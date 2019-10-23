/*package ac.za.cput.repository.employee.impl;

import ac.za.cput.domain.employee.Veterinarian;
import ac.za.cput.repository.employee.VeterinarianRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("VeterinarianInMemory")
public class VeterinarianRepositoryImpl implements VeterinarianRepository {

    private static VeterinarianRepositoryImpl veterinarianRepository = null;
    private Set<Veterinarian> veterinarians;

    public VeterinarianRepositoryImpl(){
        veterinarians = new HashSet<>();
    }

    public static VeterinarianRepositoryImpl getVeterinarianRepository(){
        if (veterinarianRepository == null){
            return new VeterinarianRepositoryImpl();
        }
        return veterinarianRepository;
    }

    @Override
    public Set<Veterinarian> getAll() {
        return veterinarians;
    }

    @Override
    public Veterinarian create(Veterinarian veterinarian) {
        veterinarians.add(veterinarian);
        return veterinarian;
    }

    @Override
    public Veterinarian read(String id) {
        return veterinarians.stream().filter(veterinarian -> veterinarian.getEmpId().equals(id)).findAny().orElse(null);
    }

    @Override
    public Veterinarian update(Veterinarian veterinarian) {
        Veterinarian vetDb = read(veterinarian.getEmpId());
        if (vetDb != null){
            veterinarians.remove(vetDb);
            veterinarians.add(veterinarian);
            return veterinarian;
        }
        return null;
    }

    @Override
    public void delete(String id) {
        Veterinarian vetDb = read(id);
        veterinarians.remove(vetDb);
    }


}*/

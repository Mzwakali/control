package ac.za.cput.service.employee.impl;

import ac.za.cput.domain.employee.Veterinarian;
import ac.za.cput.repository.employee.VeterinarianRepository;
import ac.za.cput.service.employee.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("VeterinarianServiceImpl")
public class VeterinarianServiceImpl implements VeterinarianService {

    private VeterinarianServiceImpl veterinarianService = null;

    @Autowired
    private VeterinarianRepository veterinarianRepository;

    public VeterinarianServiceImpl() {

    }

    public VeterinarianServiceImpl getVeterinarianService(){
        if (veterinarianService == null){
            return new VeterinarianServiceImpl();
        }
        return veterinarianService;
    }

    @Override
    public List<Veterinarian> getAll() {
        return this.veterinarianRepository.findAll();
    }

    @Override
    public Veterinarian create(Veterinarian veterinarian) {
        return veterinarianRepository.save(veterinarian);
    }

    @Override
    public Veterinarian read(String id) {
        return veterinarianRepository.findById(id).orElse(null);
    }

    @Override
    public Veterinarian update(Veterinarian veterinarian) {
        return veterinarianRepository.save(veterinarian);
    }

    @Override
    public void delete(String id) {
        veterinarianRepository.deleteById(id);
    }
}

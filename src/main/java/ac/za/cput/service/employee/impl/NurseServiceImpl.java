package ac.za.cput.service.employee.impl;

import ac.za.cput.domain.employee.Nurse;
import ac.za.cput.repository.employee.NurseRepository;
import ac.za.cput.service.employee.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("NurseServiceImpl")
public class NurseServiceImpl implements NurseService {

    private static NurseService nurseService = null;

    @Autowired
    private NurseRepository nurseRepository;

    private NurseServiceImpl(){
    }

    public static NurseService getNurseService(){
        if (nurseService ==  null){
            nurseService = new NurseServiceImpl();
        }
        return nurseService;
    }

    @Override
    public List<Nurse> getAll() {
        return this.nurseRepository.findAll();
    }

    @Override
    public Nurse create(Nurse nurse) {
        return this.nurseRepository.save(nurse);
    }

    @Override
    public Nurse read(String id) {
        Optional<Nurse> shift = this.nurseRepository.findById(id);
        return shift.orElse(null);
    }

    @Override
    public Nurse update(Nurse nurse) {
        return this.nurseRepository.save(nurse);
    }

    @Override
    public void delete(String id) {
        this.nurseRepository.deleteById(id);
    }
}

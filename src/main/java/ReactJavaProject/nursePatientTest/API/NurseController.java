package ReactJavaProject.nursePatientTest.API;

import ReactJavaProject.nursePatientTest.Repositories.NurseRepository;
import ReactJavaProject.nursePatientTest.Models.Nurse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NurseController {
    private final NurseRepository nurseRepository;

    public NurseController(NurseRepository repo){
        this.nurseRepository =repo;
    }

    @PostMapping("/register")
    public @ResponseBody Nurse register(@RequestBody Nurse nurse){
        Nurse aNurse=nurseRepository.save(nurse);
        return aNurse;
    }

    @GetMapping("/nurse")
    public List<Nurse> getAllNurse(){
        List<Nurse> nurses=nurseRepository.findAll();
        return nurses;
    }

    @GetMapping("/nurse/{id}")
    public Optional<Nurse> getNurseById(@PathVariable Long id){
        return nurseRepository.findById(id);
    }

    @PutMapping("/nurse/{id}")
    public Nurse updateNurseById(@PathVariable Long id, @RequestBody Nurse nurse){
        return nurseRepository.findById(id)
                .map(n->{
                    n.setFirstname(nurse.getFirstname());
                    n.setLastname(nurse.getLastname());
                    n.setDepartment(nurse.getDepartment());
                    n.setPassword(nurse.getPassword());
                    return nurseRepository.save(n);
                }).get();
//                .orElseGet(()->{
//                    return nurseRespository.save(nurse);
//                });
    }

    @DeleteMapping("/nurse/{id}")
    public void deleteNurseById(@PathVariable Long id){
//        nurseRespository.deleteById(id);
    }


}

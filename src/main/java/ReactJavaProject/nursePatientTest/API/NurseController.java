package ReactJavaProject.nursePatientTest.API;

import ReactJavaProject.nursePatientTest.Repositories.NurseRepository;
import ReactJavaProject.nursePatientTest.Models.Nurse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

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
    @PostMapping("/login")
    @ResponseBody
    public Map<String,String> login(@RequestBody Nurse loginNurse){
        AtomicReference<String> result= new AtomicReference<>("");
        AtomicReference<Boolean> isNurseExist=new AtomicReference<>(false);
        HashMap<String, String> map = new HashMap<>();
        nurseRepository.findById(loginNurse.getNurseId())
                .ifPresent(nurse -> {
                    if(nurse.getPassword().equals(loginNurse.getPassword())){
                        isNurseExist.set(true);
                        result.set("match");
                    }
                    else {
                        result.set("incorrect ID or password");
                    }
                });
        map.put("message",result.get());
        return map;
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

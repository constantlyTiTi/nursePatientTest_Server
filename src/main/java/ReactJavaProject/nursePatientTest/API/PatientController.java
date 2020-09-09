package ReactJavaProject.nursePatientTest.API;

import ReactJavaProject.nursePatientTest.Repositories.PatientRepository;
import ReactJavaProject.nursePatientTest.Models.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class PatientController {
    private PatientRepository patientRepository;

    public PatientController(PatientRepository repo){
        patientRepository=repo;
    }

    @GetMapping("/nurse/{id}/patients")
    public List<Patient> getPatientsById(@PathVariable Long id){
        return patientRepository.findPatientsBynurseId(id);
    }

    @GetMapping("/patient/{patientId}")
    public Patient getPatientById(@PathVariable Long patientId){
        return patientRepository.findById(patientId)
                .orElseThrow(()->new RuntimeException());
    }

    @PostMapping("/nurse/{id}/newPatient")
    public Patient newPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    @PutMapping("/patients/patient_{patientId}")
    public Patient updataPatient(@RequestBody Patient patient,@PathVariable Long patientId){
        return patientRepository.findById(patientId)
                .map(p->{
                    p.setDepartment(patient.getDepartment());
                    p.setFirstName(patient.getFirstName());
                    p.setLastName(patient.getLastName());
                    p.setNurseId(patient.getNurseId());
                    p.setRoom(patient.getRoom());
                    return patientRepository.save(p);
                }).get();
    }

    @DeleteMapping("/patients/paitent_{patientId}")
    public void deletePatient(@PathVariable Long patientId){
        patientRepository.deleteById(patientId);
    }

}

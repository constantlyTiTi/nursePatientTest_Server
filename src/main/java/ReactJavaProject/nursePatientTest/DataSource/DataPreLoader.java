package ReactJavaProject.nursePatientTest.DataSource;

import ReactJavaProject.nursePatientTest.Models.Nurse;
import ReactJavaProject.nursePatientTest.Models.Patient;
import ReactJavaProject.nursePatientTest.Models.Test;
import ReactJavaProject.nursePatientTest.Models.TestItem;
import ReactJavaProject.nursePatientTest.Repositories.NurseRepository;
import ReactJavaProject.nursePatientTest.Repositories.PatientRepository;
import ReactJavaProject.nursePatientTest.Repositories.TestItemRepository;
import ReactJavaProject.nursePatientTest.Repositories.TestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataPreLoader implements CommandLineRunner {
    private NurseRepository nurseRepository;
    private PatientRepository patientRepository;
    private TestRepository testRepository;
    private TestItemRepository testItemRepository;

    public DataPreLoader(NurseRepository nR,PatientRepository pR,TestRepository tR,TestItemRepository tIR){
        this.nurseRepository=nR;
        this.patientRepository=pR;
        this.testRepository=tR;
        this.testItemRepository=tIR;
    }
    @Override
    public void run(String... args) throws Exception {
        this.nurseRepository.save(new Nurse("Ann","FirstNurse","ABC","123"));
        this.patientRepository.save(new Patient("Run","FirstPatient","ABC",1l,"A-01"));
        this.patientRepository.save(new Patient("2Patient","SecondPatient","BCD",1l,"A-01"));
        this.testItemRepository.save(new TestItem("BPL","BPL description"));
        this.testItemRepository.save(new TestItem("BHL","BHL description"));
        this.testItemRepository.save(new TestItem("Temperature","Temperature description"));
        this.testRepository.save(new Test(2l,1l,4l,"bpl bpl bpl",new Date("2020/08/29")));
        this.testRepository.save(new Test(2l,1l,5l,"bHL bHL bHL",new Date("2020/08/30")));
        this.testRepository.save(new Test(2l,1l,6l,"temperature",new Date("2020/08/31")));
    }
}

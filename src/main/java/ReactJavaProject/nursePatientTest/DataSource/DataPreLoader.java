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
        this.nurseRepository.save(new Nurse("Ann","White","Cardiology","123"));
        this.patientRepository.save(new Patient("Bob","Black","Cardiology",1l,"A-01"));
        this.patientRepository.save(new Patient("Ray","Smith","BCD",1l,"A-01"));
        this.testItemRepository.save(new TestItem("BPL","Blood Pressure Level"));
        this.testItemRepository.save(new TestItem("Weight","Test Daily weight"));
        this.testItemRepository.save(new TestItem("Temperature","Temperature description"));
        this.testRepository.save(new Test(2l,1l,4l,"120/80",new Date("2020/08/29")));
        this.testRepository.save(new Test(2l,1l,5l,"70kg",new Date("2020/08/30")));
        this.testRepository.save(new Test(2l,1l,6l,"37",new Date("2020/08/31")));
    }
}

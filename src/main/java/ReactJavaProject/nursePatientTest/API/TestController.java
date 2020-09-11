package ReactJavaProject.nursePatientTest.API;

import ReactJavaProject.nursePatientTest.Models.Test;
import ReactJavaProject.nursePatientTest.Models.TestItem;
import ReactJavaProject.nursePatientTest.Repositories.TestItemRepository;
import ReactJavaProject.nursePatientTest.Repositories.TestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {
    TestRepository testRepository;
    public TestController(TestRepository repo){
        testRepository=repo;
    }
    @PostMapping("/newTest")
    public Test addNewTest(@RequestBody Test test){
        return testRepository.save(test);
    }

    @PutMapping("/tests/testId_{testId}")
    public Test updateTest(@RequestBody Test test,@PathVariable Long testId){
        return testRepository.findById(testId)
                .map(t->{
                    t.setTestItemId(test.getTestItemId());
                    t.setNurseId(test.getNurseId());
                    t.setPatientId(test.getPatientId());
                    t.setTestResult(test.getTestResult());
                    t.setDate(test.getDate());
                    return testRepository.save(t);
                }).get();
    }

    @GetMapping("/tests/patientId_{patientId}")
    public List<Test> getTestsByPatientId(@PathVariable Long patientId){
        return testRepository.getTestsByPatientId(patientId);
    }
    @GetMapping("/tests/testId_{testId}")
    public Test getTestByTestId(@PathVariable Long testId){
        return testRepository.findById(testId)
                .orElseThrow(()->new RuntimeException());
    }
    @GetMapping("/tests/nurseId_{id}")
    public List<Test> getTestsByNurseId(@PathVariable Long id){
        return testRepository.getTestsByNurseId(id);
    }

    @DeleteMapping("/tests/testId_{testId}")
    public void deleteTest(@PathVariable Long testId){
        testRepository.deleteById(testId);
    }

}

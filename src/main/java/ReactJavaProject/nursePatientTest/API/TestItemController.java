package ReactJavaProject.nursePatientTest.API;

import ReactJavaProject.nursePatientTest.Models.TestItem;
import ReactJavaProject.nursePatientTest.Repositories.TestItemRepository;
import com.sun.el.stream.Stream;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class TestItemController {
    private TestItemRepository testItemRepository;

    public TestItemController(TestItemRepository testItemRepository) {
        this.testItemRepository = testItemRepository;
    }

    @GetMapping("/TestItem/AllTestItems")
    public ArrayList<TestItem> getAllTestItems(){
        ArrayList<TestItem> allTestItems=new ArrayList<>();
        testItemRepository.findAll().iterator().forEachRemaining(allTestItems::add);
        return allTestItems;
    }
    @GetMapping("/TestItems/TestItem_{id}")
    public Optional<TestItem> getTestItemById(@PathVariable Long id){
        return testItemRepository.findById(id);
    }
}

package ReactJavaProject.nursePatientTest.Repositories;

import ReactJavaProject.nursePatientTest.Models.TestItem;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TestItemRepository extends PagingAndSortingRepository<TestItem,Long> {
}

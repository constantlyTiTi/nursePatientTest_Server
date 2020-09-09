package ReactJavaProject.nursePatientTest.Repositories;

import ReactJavaProject.nursePatientTest.Models.Test;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface TestRepository extends PagingAndSortingRepository<Test,Long> {
     List<Test> getTestsByPatientId(Long patientId);
     List<Test> getTestsByNurseId(Long nurseId);
}

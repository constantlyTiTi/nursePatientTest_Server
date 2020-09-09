package ReactJavaProject.nursePatientTest.Repositories;

import ReactJavaProject.nursePatientTest.Models.Patient;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PatientRepository extends PagingAndSortingRepository<Patient,Long>{

     List<Patient> findPatientsBynurseId(Long Id);
}

package ReactJavaProject.nursePatientTest.Repositories;

import ReactJavaProject.nursePatientTest.Models.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NurseRepository extends JpaRepository<Nurse,Long> {

}

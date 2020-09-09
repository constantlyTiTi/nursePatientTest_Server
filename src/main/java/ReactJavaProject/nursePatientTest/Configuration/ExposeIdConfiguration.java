package ReactJavaProject.nursePatientTest.Configuration;

import ReactJavaProject.nursePatientTest.Models.Nurse;
import ReactJavaProject.nursePatientTest.Models.Patient;
import ReactJavaProject.nursePatientTest.Models.Test;
import ReactJavaProject.nursePatientTest.Repositories.PatientRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class ExposeIdConfiguration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        config.exposeIdsFor(Patient.class, Test.class, Nurse.class);
    }
}

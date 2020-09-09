package ReactJavaProject.nursePatientTest.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="testId")
    private Long testId;
    @Column(name="patientId")
    private Long patientId;
    @Column(name="nurseId")
    private Long nurseId;
    @Column(name="testItemId")
    private Long testItemId;
    @Column(name="testResult")
    private String testResult;
    @Column(name="date")
    private Date date;

    public Test(){}

    public Test(Long patientId, Long nurseId, Long testItemId,String testResult,Date date) {
        this.patientId = patientId;
        this.nurseId = nurseId;
        this.testItemId=testItemId;
        this.date=date;
        this.testResult=testResult;
    }

    public Long getPatientId() {
        return patientId;
    }

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getNurseId() {
        return nurseId;
    }

    public void setNurseId(Long nurseId) {
        this.nurseId = nurseId;
    }

    public String getTestResult() {
        return testResult;
    }

    public Long getTestItemId() {
        return testItemId;
    }

    public void setTestItemId(Long testItemId) {
        this.testItemId = testItemId;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}


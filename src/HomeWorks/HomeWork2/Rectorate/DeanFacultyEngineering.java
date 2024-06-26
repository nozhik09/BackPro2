package HomeWorks.HomeWork2.Rectorate;

import HomeWorks.HomeWork2.Students.FacultyEngineering.StudentEngineer1;
import HomeWorks.HomeWork2.Students.FacultyEngineering.StudentEngineer2;
import org.springframework.beans.factory.annotation.Autowired;


public class DeanFacultyEngineering {
@Autowired
    private StudentEngineer1 studentEngineer1;
@Autowired
    private StudentEngineer2 studentEngineer2;

    public void setStudentEngineer1(StudentEngineer1 studentEngineer1) {
        this.studentEngineer1 = studentEngineer1;
    }

    public void setStudentEngineer2(StudentEngineer2 studentEngineer2) {
        this.studentEngineer2 = studentEngineer2;
    }

    public void getExam(){
        studentEngineer1.Exam();
        studentEngineer2.Exam();

    }


}

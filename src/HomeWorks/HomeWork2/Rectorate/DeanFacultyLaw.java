package HomeWorks.HomeWork2.Rectorate;

import HomeWorks.HomeWork2.Students.FacultyLaw.StudentLawyer1;
import HomeWorks.HomeWork2.Students.FacultyLaw.StudentLawyer2;
import org.springframework.beans.factory.annotation.Autowired;

public class DeanFacultyLaw {

    @Autowired
    private StudentLawyer1 studentLawyer1;
    @Autowired
    private StudentLawyer2 studentLawyer2;


    public void setStudentLawyer1(StudentLawyer1 studentLawyer1) {
        this.studentLawyer1 = studentLawyer1;
    }

    public void setStudentLawyer2(StudentLawyer2 studentLawyer2) {
        this.studentLawyer2 = studentLawyer2;
    }

    public void getExam(){
        studentLawyer1.Exam();
        studentLawyer2.Exam();


    }


}

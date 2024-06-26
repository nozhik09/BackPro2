package HomeWorks.HomeWork2;

import HomeWorks.HomeWork2.Rectorate.Rector;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {


//        StudentEngineer1 studentEngineer1 = new StudentEngineer1();
//        StudentEngineer2 studentEngineer2 = new StudentEngineer2();
//        StudentLawyer1 studentLawyer1 = new StudentLawyer1();
//        StudentLawyer2 studentLawyer2 = new StudentLawyer2();
//
//        DeanFacultyEngineering deanFacultyEngineering = new DeanFacultyEngineering();
//        deanFacultyEngineering.setStudentEngineer1(studentEngineer1);
//        deanFacultyEngineering.setStudentEngineer2(studentEngineer2);
//
//        DeanFacultyLaw deanFacultyLaw = new DeanFacultyLaw();
//        deanFacultyLaw.setStudentLawyer1(studentLawyer1);
//        deanFacultyLaw.setStudentLawyer2(studentLawyer2);
//
//        Rector rector = new Rector();
//        rector.setDeanFacultyEngineering(deanFacultyEngineering);
//        rector.setDeanFacultyLaw(deanFacultyLaw);


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(".config");
        Rector rector = context.getBean(Rector.class);
        rector.checkExam();


    }


}

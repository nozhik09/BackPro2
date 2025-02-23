package config;

import HomeWorks.HomeWork2.Rectorate.DeanFacultyEngineering;
import HomeWorks.HomeWork2.Rectorate.DeanFacultyLaw;
import HomeWorks.HomeWork2.Rectorate.Rector;
import HomeWorks.HomeWork2.Students.FacultyEngineering.StudentEngineer1;
import HomeWorks.HomeWork2.Students.FacultyEngineering.StudentEngineer2;
import HomeWorks.HomeWork2.Students.FacultyLaw.StudentLawyer1;
import HomeWorks.HomeWork2.Students.FacultyLaw.StudentLawyer2;
import Lessons.Lesson_02.administration.Director;
import Lessons.Lesson_02.administration.ProductionChief;
import Lessons.Lesson_02.administration.SalesChief;
import Lessons.Lesson_02.specialists.prodaction.MachineOperator;
import Lessons.Lesson_02.specialists.prodaction.Storekeeper;
import Lessons.Lesson_02.specialists.sales.Merchandiser;
import Lessons.Lesson_02.specialists.sales.SalesManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public Director director() {
        return new Director();
    }

    @Bean
    public ProductionChief productionChief() {
        return new ProductionChief();
    }

    @Bean
    public SalesChief salesChief() {
        return new SalesChief();
    }

    @Bean
    public MachineOperator machineOperator() {
        return new MachineOperator();
    }

    @Bean
    public Storekeeper storekeeper() {
        return new Storekeeper();
    }

    @Bean
    public Merchandiser merchandiser() {
        return new Merchandiser();
    }

    @Bean
    public SalesManager salesManager() {
        return new SalesManager();
    }

    @Bean
    public DeanFacultyEngineering deanFacultyEngineering() {
        return new DeanFacultyEngineering();
    }

    @Bean
    public DeanFacultyLaw deanFacultyLaw() {
        return new DeanFacultyLaw();
    }

    @Bean
    public Rector rector() {
        return new Rector();
    }

    @Bean
    public StudentEngineer1 studentEngineer1() {
        return new StudentEngineer1();
    }

    @Bean
    public StudentEngineer2 studentEngineer2() {
        return new StudentEngineer2();
    }


    @Bean
    public StudentLawyer1 studentLawyer1() {
        return new StudentLawyer1();
    }
    @Bean
    public StudentLawyer2 studentLawyer2() {
        return new StudentLawyer2();
    }












}

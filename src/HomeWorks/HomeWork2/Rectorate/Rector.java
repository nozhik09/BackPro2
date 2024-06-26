package HomeWorks.HomeWork2.Rectorate;

import org.springframework.beans.factory.annotation.Autowired;

public class Rector {
    @Autowired
    private DeanFacultyEngineering deanFacultyEngineering;
    @Autowired
    private DeanFacultyLaw deanFacultyLaw;

    public void setDeanFacultyEngineering(DeanFacultyEngineering deanFacultyEngineering) {
        this.deanFacultyEngineering = deanFacultyEngineering;
    }

    public void setDeanFacultyLaw(DeanFacultyLaw deanFacultyLaw) {
        this.deanFacultyLaw = deanFacultyLaw;
    }

    public void checkExam(){
        deanFacultyLaw.getExam();
        deanFacultyEngineering.getExam();

    }


}

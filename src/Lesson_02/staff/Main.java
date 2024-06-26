package Lesson_02.staff;

import Lesson_02.staff.administration.Director;
import Lesson_02.staff.administration.ProductionChief;
import Lesson_02.staff.administration.SalesChief;
import Lesson_02.staff.specialists.prodaction.MachineOperator;
import Lesson_02.staff.specialists.prodaction.Storekeeper;
import Lesson_02.staff.specialists.sales.Merchandiser;
import Lesson_02.staff.specialists.sales.SalesManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {

/*
        MachineOperator machineOperator = new MachineOperator();
        Storekeeper storekeeper = new Storekeeper();
        Merchandiser merchandiser = new Merchandiser();
        SalesManager salesManager = new SalesManager();

        ProductionChief productionChief = new ProductionChief();
        productionChief.setMachineOperator(machineOperator);
        productionChief.setStorekeeper(storekeeper);

        SalesChief salesChief = new SalesChief();
        salesChief.setMerchandiser(merchandiser);
        salesChief.setSalesManager(salesManager);


        Director director = new Director();
        director.setProductionChief(productionChief);
        director.setSalesChief(salesChief);
*/

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext() ;
        Director director = context.getBean(Director.class);
        director.manageCompany();
    }
}

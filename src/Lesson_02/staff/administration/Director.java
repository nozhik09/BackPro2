package Lesson_02.staff.administration;

import org.springframework.beans.factory.annotation.Autowired;

public class Director {


    @Autowired
    private ProductionChief productionChief;
    @Autowired
    private SalesChief salesChief;

    public void setProductionChief(ProductionChief productionChief) {
        this.productionChief = productionChief;
    }

    public void setSalesChief(SalesChief salesChief) {
        this.salesChief = salesChief;
    }
    public void manageCompany(){

        productionChief.giveOrders();
        salesChief.giveOrders();


    }


}

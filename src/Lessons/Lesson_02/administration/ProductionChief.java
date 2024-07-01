package Lessons.Lesson_02.administration;

import Lessons.Lesson_02.specialists.prodaction.MachineOperator;
import Lessons.Lesson_02.specialists.prodaction.Storekeeper;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductionChief {
    @Autowired
    private MachineOperator machineOperator;
    @Autowired
    private Storekeeper storekeeper;

    public void setStorekeeper(Storekeeper storekeeper) {
        this.storekeeper = storekeeper;
    }

    public void setMachineOperator(MachineOperator machineOperator) {
        this.machineOperator = machineOperator;
    }

    public void giveOrders() {
        machineOperator.work();
        storekeeper.work();
    }
}

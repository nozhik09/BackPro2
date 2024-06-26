package Lesson_02.staff.administration;

import Lesson_02.staff.specialists.prodaction.MachineOperator;
import Lesson_02.staff.specialists.prodaction.Storekeeper;
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

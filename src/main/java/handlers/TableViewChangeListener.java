package handlers;

import edu.step.manager.model.EmployeeModel;
import javafx.collections.ListChangeListener;

public class TableViewChangeListener implements ListChangeListener<EmployeeModel> {

    @Override
    public void onChanged(Change<? extends EmployeeModel> change) {
        while (change.next()) {
            if (change.wasUpdated()) {
                for (int i = change.getFrom(); i < change.getTo(); i++) {
                    System.out.println("Update: " + i);
                }
            }
            else if (change.wasUpdated()) {

            }
        }
    }
}

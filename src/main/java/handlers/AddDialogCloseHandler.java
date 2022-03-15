package handlers;

import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class AddDialogCloseHandler implements EventHandler<WindowEvent> {

    @Override
    public void handle(WindowEvent event) {
        System.out.println("Esti sigur ca vrei sa inchizi fereastra ?");
    }
}

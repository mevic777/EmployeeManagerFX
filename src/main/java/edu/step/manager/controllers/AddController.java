package edu.step.manager.controllers;

import edu.step.manager.model.EmployeeModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class AddController {

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private DatePicker birthdatePicker;

    private EmployeeModel result;

    public EmployeeModel getResult() {
        return result;
    }

    @FXML
    void cancel(ActionEvent event) {
        closeWindow(event);
    }

    @FXML
    void save(ActionEvent event) {
        if (idTextField.getText() != null && !idTextField.getText().isEmpty()) {
            Integer id = Integer.parseInt(idTextField.getText());
            String name = nameTextField.getText();
            LocalDate date = birthdatePicker.getValue();
            result = new EmployeeModel(id, name, date);

            System.out.println(result);
            closeWindow(event);
        }
    }

    private void closeWindow(ActionEvent event) {
        Node button = (Node) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();

        stage.close();
    }
}

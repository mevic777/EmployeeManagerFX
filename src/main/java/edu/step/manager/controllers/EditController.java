package edu.step.manager.controllers;

import edu.step.manager.model.EmployeeModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {

    @FXML
    private TextField idTextField;

    @FXML
    private TextField nameTextField;

    @FXML
    private DatePicker birthdatePicker;

    private EmployeeModel data;

    public EmployeeModel getData() {
        return data;
    }

    public void setData(EmployeeModel data) {
        this.data = data;
        idTextField.setText(String.valueOf(data.getId()));
        nameTextField.setText(data.getName());
        birthdatePicker.setValue(data.getBirthdate());
    }

    @FXML
    void cancel(ActionEvent event) {
        closeWindow(event);
    }

    @FXML
    void edit(ActionEvent event) {
        this.data.setName(nameTextField.getText());
        this.data.setBirthdate(birthdatePicker.getValue());
        closeWindow(event);
    }

    public void closeWindow(ActionEvent event) {
        Node button = (Node) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();

        stage.close();
    }
}

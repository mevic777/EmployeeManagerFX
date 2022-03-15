package edu.step.manager.controllers;

import edu.step.manager.model.EmployeeModel;
import handlers.AddDialogCloseHandler;
import handlers.TableViewChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private TableView<EmployeeModel> tableView;

    @FXML
    private TableColumn<EmployeeModel, Integer> idColumn;

    @FXML
    private TableColumn<EmployeeModel, String> nameColumn;

    @FXML
    private TableColumn<EmployeeModel, LocalDate> birthdateColumn;

    private ObservableList<EmployeeModel> employeeData = FXCollections.observableArrayList(
            new EmployeeModel(1, "Covali", LocalDate.now()),
            new EmployeeModel(2, "Cioban", LocalDate.now()),
            new EmployeeModel(3, "Ciorici", LocalDate.now()));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setItems(employeeData);
        this.employeeData.addListener(new TableViewChangeListener());
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        birthdateColumn.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
    }

    @FXML
    void openAddDialog(ActionEvent addEvent) throws IOException {
        FXMLLoader addLoader = new FXMLLoader(getClass().getResource("/fxml/add.fxml"));
        AnchorPane addContainer = addLoader.load();
        AddController addController = addLoader.getController();
        Scene addScene = new Scene(addContainer);
        Stage addStage = new Stage(StageStyle.DECORATED);

        addStage.setScene(addScene);
        addStage.setOnCloseRequest(new AddDialogCloseHandler());
        addStage.initModality(Modality.APPLICATION_MODAL);
        addStage.showAndWait();

        EmployeeModel addEmployee = addController.getResult();

        this.employeeData.add(addEmployee);
    }

    @FXML
    void openDeleteDialog(ActionEvent event) {
        int selectedRow = tableView.getSelectionModel().getSelectedIndex();

        if (selectedRow != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Ești sigur ?");
            alert.setTitle("Confirma");
            Optional<ButtonType> deleteButton = alert.showAndWait();

            if (deleteButton.get() == ButtonType.OK) {
                this.employeeData.remove(selectedRow);
            }
        }
    }

    @FXML
    void openEditDialog(ActionEvent editEvent) throws IOException {
        int selectedRow = tableView.getSelectionModel().getSelectedIndex();

        if (selectedRow != -1) {
            FXMLLoader editLoader = new FXMLLoader(getClass().getResource("/fxml/edit.fxml"));
            AnchorPane editContainer = editLoader.load();
            EditController editController = editLoader.getController();

            editController.setData(employeeData.get(selectedRow));

            Scene editScene = new Scene(editContainer);
            Stage editStage = new Stage(StageStyle.DECORATED);

            editStage.setScene(editScene);
            editStage.initModality(Modality.APPLICATION_MODAL);
            editStage.showAndWait();

            this.employeeData.get(selectedRow).setName(editController.getData().getName());
            this.employeeData.get(selectedRow).setBirthdate(editController.getData().getBirthdate());
        }
    }
}
















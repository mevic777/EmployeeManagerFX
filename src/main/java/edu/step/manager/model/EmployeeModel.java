package edu.step.manager.model;

import javafx.beans.property.*;
import java.time.LocalDate;

public class EmployeeModel {

    private IntegerProperty id;
    private StringProperty name;
    private ObjectProperty<LocalDate> birthdate;

    public EmployeeModel(Integer id, String name, LocalDate birthdate) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.birthdate = new SimpleObjectProperty<LocalDate>(birthdate);
    }

    public int getId() {
        return id.get();
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public LocalDate getBirthdate() {
        return birthdate.get();
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate.set(birthdate);
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "id=" + id +
                ", name=" + name +
                ", birthdate=" + birthdate +
                '}';
    }
}

package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Main;
import sample.modules.Person;
import sample.utils.DateUtil;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label birthdayLabel;

    private Main mainApp;

    public PersonOverviewController(){}

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        //Добавление данных
        personTableView.setItems(mainApp.getPersonData());
    }

    @FXML
    private void initialize(){
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());

        showPersonData(null);

        personTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonData(newValue)
        );
    }

    private void showPersonData(Person person) {
        if (person != null) {
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            cityLabel.setText(person.getCity());
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            postalCodeLabel.setText("");
            cityLabel.setText("");
        }
    }

    @FXML
    private void handleDeletePerson(){
        int selectedIndex = personTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTableView.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Ошибка удаления");
            alert.setContentText("Выбери человека для удаления!!!");

            alert.showAndWait();
        }
    }
}

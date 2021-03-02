package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.modules.Person;
import sample.utils.DateUtil;

import java.util.Date;

public class PersonEditController {

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField streetField;

    @FXML
    private TextField cityField;

    @FXML
    private TextField postalCodeField;

    @FXML
    private TextField birthdayField;

    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    @FXML
    private void initialize(){}

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setPerson(Person person) {
        this.person = person;

        firstNameField.setText(person.getFirstName());
        lastNameField.setText(person.getLastName());
        streetField.setText(person.getStreet());
        postalCodeField.setText(Integer.toString(person.getPostalCode()));
        cityField.setText(person.getCity());
        birthdayField.setText(DateUtil.format(person.getBirthday()));
        birthdayField.setPromptText("dd.mm.yyyy");
    }

    public boolean isOkClicked(){
        return okClicked;
    }

//    @FXML
//    private void handleOk(){
//        if (isInputValid()) {
//            person.setFirstName(firstNameField.getText());
//            person.setLastName(lastNameField.getText());
//            person.setStreet(streetField.getText());
//            person.setPostalCode(Integer.parseInt(postalCodeField.getText()));
//
//        }
//    }
}

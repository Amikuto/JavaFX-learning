package sample.modules;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {

    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty street;
    private final IntegerProperty postalCode;
    private final StringProperty city;
    private final ObjectProperty<LocalDate> birthday;


    public Person(){
        this(null, null);
    }

    public Person(String firstName, String lastName){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        this.street = new SimpleStringProperty("some test street");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.city = new SimpleStringProperty("test city");
        this.birthday = new SimpleObjectProperty<>(LocalDate.of(1999, 2, 21));
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }

    public StringProperty getFirstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName (String lastName){
        this.lastName.set(lastName);
    }

    public StringProperty getLastNameProperty(){
        return lastName;
    }

    public String getStreet() {
        return street.get();
    }

    public void setStreet (String street){
        this.street.set(street);
    }

    public StringProperty getStreetProperty(){
        return street;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public void setPostalCode(int postalCode){
        this.postalCode.set(postalCode);
    }

    public IntegerProperty getPostalCodeProperty(){
        return postalCode;
    }

    public String getCity() {
        return city.get();
    }

    public void setCity(String  city){
        this.city.set(city);
    }

    public StringProperty getCityProperty(){
        return city;
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public void setBirthday(LocalDate birthday){
        this.birthday.set(birthday);
    }

    public ObjectProperty<LocalDate> getBirthDayProperty(){
        return birthday;
    }
}

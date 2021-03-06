package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.controllers.PersonEditController;
import sample.controllers.PersonOverviewController;
import sample.modules.Person;
import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private final ObservableList<Person> personData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Address");

        initRootLayout();

        showPersonOverview();
    }

    public void initRootLayout(){
        try{
            //Корневой макет
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/RootLayout.fxml"));
            rootLayout = loader.load();

            //Сцена
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showPersonOverview(){
        try {
            // Загрузка сведений людей
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/main.fxml"));
            AnchorPane personOverview = loader.load();

            // Помещаем сведения в центр корневого макета
            rootLayout.setCenter(personOverview);

            // Даем доступ контроллеру к главному приложению
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showPersonEditDialog(Person person) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/PersonEdit.fxml"));
            AnchorPane page = loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Редактирование персонажа");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PersonEditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setPerson(person);

            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Main(){
        for (int i = 0; i<25; i++){
            personData.add(new Person("Name" + i, "Surname " + i));
        }
//        personData.add(new Person("Hans", "Muster"));
//        personData.add(new Person("Ruth", "Mueller"));
//        personData.add(new Person("Heinz", "Kurz"));
//        personData.add(new Person("Cornelia", "Meier"));
//        personData.add(new Person("Werner", "Meyer"));
//        personData.add(new Person("Lydia", "Kunz"));
//        personData.add(new Person("Anna", "Best"));
//        personData.add(new Person("Stefan", "Meier"));
//        personData.add(new Person("Martin", "Mueller"));
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

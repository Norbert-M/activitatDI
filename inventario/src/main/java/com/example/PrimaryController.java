/**
 * The `PrimaryController` class in a Java application manages the GUI interactions for adding,
 * modifying, printing, and sorting a list of `Dispositivo` objects.
 */
package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Observable;

import com.example.models.Dispositivo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;

public class PrimaryController {

    @FXML
    private Button anyadirButton;

    @FXML
    private Button imprimirButton;

    @FXML
    public ListView<Dispositivo> listViewDispositivos;

    @FXML
    private Button modificarButton;

    @FXML
    private SplitMenuButton ordenarButton;

    @FXML
    private MenuItem fechaAsc;

    @FXML
    private MenuItem fechaDesc;

    private Dispositivo dispositivo;

    

    /**
     * The function returns a Dispositivo object.
     * 
     * @return An object of type Dispositivo is being returned.
     */
    public Dispositivo getDispositivos() {
        return dispositivo;
    }

    /**
     * This Java function sets a single "Dispositivo" object for the current instance.
     * 
     * @param dispositivo The `setDispositivos` method is used to set a `Dispositivo` object for the
     * current instance. The `dispositivo` parameter is the `Dispositivo` object that will be set for
     * the current instance.
     */
    public void setDispositivos(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    /**
     * The `initialize` function sets up event handlers for sorting devices by date in ascending or
     * descending order.
     */
    @FXML
    void initialize() {
        fechaAsc.setOnAction(event -> ordenarDispositivosFecha(event, true));
        fechaDesc.setOnAction(event -> ordenarDispositivosFecha(event, false));
    }

    /**
     * The `addDispositivo` function loads a secondary FXML file in a new stage and sets a reference to
     * the primary controller.
     * 
     * @param event The `event` parameter in the `addDispositivo` method of your JavaFX controller
     * represents the action event that occurred, such as a button click, that triggered the method to
     * be executed. This parameter allows you to access information about the event that occurred, if
     * needed, within the method.
     */
    @FXML
    void addDispositivo(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = fxmlLoader.load();
            SecondaryController secondaryController = fxmlLoader.getController();
            secondaryController.setPrimaryController(this);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The function `anyadirDispositivo` adds a `Dispositivo` object to a `ListView` of devices.
     * 
     * @param dispositivo The `dispositivo` parameter in the `anyadirDispositivo` method is of type
     * `Dispositivo`, which represents a device object that you want to add to a list view
     * (`listViewDispositivos`). The method adds the specified `dispositivo` object to the items
     */
    void anyadirDispositivo(Dispositivo dispositivo) {
        listViewDispositivos.getItems().add(dispositivo);
    }

    /**
     * The function `modificarDispositivo` updates a selected item in a list view with a new
     * `Dispositivo` object.
     * 
     * @param dispositivo The `dispositivo` parameter is an object of type `Dispositivo` that
     * represents a device.
     */
    void modificarDispositivo(Dispositivo dispositivo) {
        listViewDispositivos.getItems().set(listViewDispositivos.getSelectionModel().getSelectedIndex(), dispositivo);
    }

    /**
     * The function "imprimirDispositivos" writes the list of Dispositivo objects from a JavaFX
     * ListView to a text file named "dispositivos.txt".
     * 
     * @param event ActionEvent event is an event that indicates a user action, such as clicking a
     * button or selecting an item from a list. In this case, the method "imprimirDispositivos" is
     * triggered when an action event occurs, such as clicking a button that is associated with this
     * method.
     */
    @FXML
    void imprimirDispositivos(ActionEvent event) {
        try {
            PrintWriter printWriter = new PrintWriter(new File("dispositivos.txt"));
            for (Dispositivo dispositivo : listViewDispositivos.getItems()) {
                printWriter.println(dispositivo);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

   /**
    * The initialize function sets an empty ObservableList of Dispositivo objects to a ListView
    * component.
    * 
    * @param event The `event` parameter in the `initialize` method is an `ActionEvent` object. It
    * represents the event that occurred, triggering the initialization of the controller. In this
    * case, it is used to initialize a list view with an empty list of `Dispositivo` objects.
    */
    @FXML
    void initialize(ActionEvent event) {
        ObservableList<Dispositivo> dispositivos = FXCollections.observableArrayList();
        listViewDispositivos.setItems(dispositivos);
    }

    /**
     * The `modifyDispositivo` function loads a secondary FXML file, sets the primary controller, sets
     * a selected device, creates a new stage, and displays the scene.
     * 
     * @param event The `event` parameter in the `modifyDispositivo` method is of type `ActionEvent`.
     * It represents the event that occurred, such as a button click or menu item selection, that
     * triggered the method to be called. This parameter can be used to access information about the
     * event or the source
     */
    @FXML
    void modifyDispositivo(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("secondary.fxml"));
            Parent root = fxmlLoader.load();
            SecondaryController secondaryController = fxmlLoader.getController();
            secondaryController.setPrimaryController(this);
            secondaryController.setDispositivo(listViewDispositivos.getSelectionModel().getSelectedItem());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The function `ordenarDispositivosFecha` sorts a list of `Dispositivo` objects by their purchase
     * date in either ascending or descending order.
     * 
     * @param event The `event` parameter in the `ordenarDispositivosFecha` method is of type
     * `ActionEvent`. This parameter is typically used to represent the event that triggered the
     * method, such as a button click or menu selection. It provides information about the event and
     * can be used to handle the event
     * @param ascendente The parameter `ascendente` is a boolean value that determines whether the list
     * of `Dispositivo` objects should be sorted in ascending order (`true`) or descending order
     * (`false`) based on the `fechaCompra` property of each `Dispositivo` object.
     */
    @FXML
    void ordenarDispositivosFecha(ActionEvent event, boolean ascendente) {
        ObservableList<Dispositivo> dispositivos = FXCollections.observableArrayList(listViewDispositivos.getItems());
        if (ascendente) {
            dispositivos.sort(Comparator.comparing(Dispositivo::getFechaCompra));
        } else {
            dispositivos.sort(Comparator.comparing(Dispositivo::getFechaCompra).reversed());
        }
        listViewDispositivos.setItems(dispositivos);
    }

}

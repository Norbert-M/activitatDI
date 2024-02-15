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
    private Button ordenarButton;

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

    void anyadirDispositivo(Dispositivo dispositivo) {
        listViewDispositivos.getItems().add(dispositivo);
    }

    

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

    @FXML
    void initialize(ActionEvent event) {
        ObservableList<Dispositivo> dispositivos = FXCollections.observableArrayList();
        listViewDispositivos.setItems(dispositivos);
    }

    @FXML
    void modifyDispositivo(ActionEvent event) {

    }

    @FXML
    void ordenarDispositivosFecha(ActionEvent event) {

    }

    


}

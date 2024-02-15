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

    @FXML
    void initialize() {
        fechaAsc.setOnAction(event -> ordenarDispositivosFecha(event, true));
        fechaDesc.setOnAction(event -> ordenarDispositivosFecha(event, false));
    }

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

    void modificarDispositivo(Dispositivo dispositivo) {
        listViewDispositivos.getItems().set(listViewDispositivos.getSelectionModel().getSelectedIndex(), dispositivo);
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

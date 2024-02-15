package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Observable;

import com.example.models.Dispositivo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class PrimaryController {

    @FXML
    private Button anyadirButton;

    @FXML
    private Button imprimirButton;

    @FXML
    private ListView<Dispositivo> listViewDispositivos;

    @FXML
    private Button modificarButton;

    @FXML
    private Button ordenarButton;


    void mostrarDispositivos(){

        ObservableList<Dispositivo> dispositivos = listViewDispositivos.getItems();

        listViewDispositivos.setItems(dispositivos);
    }

    @FXML
    void ordenarDispositivosFecha(int tipoOrdenacion) {
        ObservableList<Dispositivo> dispositivos = listViewDispositivos.getItems();

        Comparator<Dispositivo> comparator = Comparator.comparing(Dispositivo::getFechaCompra);
        if (tipoOrdenacion == 2) {
            comparator = comparator.reversed();
        }

        FXCollections.sort(dispositivos, comparator);

        listViewDispositivos.setItems(dispositivos);
    }

    @FXML
    void imprimirDispositivos() {
        ObservableList<Dispositivo> dispositivos = listViewDispositivos.getItems();

        try (PrintWriter writer = new PrintWriter(new File("dispositivos.txt"))) {
            for (Dispositivo dispositivo : dispositivos) {
                writer.println(
                    dispositivo.getId() + ", " +
                    dispositivo.getTipo() + ", " +
                    dispositivo.getMarca() + ", " +
                    dispositivo.getModelo() + ", " +
                    dispositivo.getFechaCompra()
                );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}

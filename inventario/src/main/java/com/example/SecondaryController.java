package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.example.models.Dispositivo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SecondaryController {

    @FXML
    private Button cancelarButton;

    @FXML
    private TextField fechaCompraText;

    @FXML
    private Button guardarButton;

    @FXML
    private TextField idText;

    @FXML
    private TextField marcaText;

    @FXML
    private TextField modeloText;

    @FXML
    private TextField precioText;

    @FXML
    private TextField tipoDispositivoText;

    PrimaryController primaryController;

    private Dispositivo dispositivo;

    @FXML
    void onHandleCancelarButton(ActionEvent event) {
        cancelarButton.getScene().getWindow().hide();

    }

    @FXML
void onHandleGuardarButton(ActionEvent event) {
    int id = Integer.parseInt(idText.getText());
    double precio = Double.parseDouble(precioText.getText());
    Dispositivo.TipoAtributo tipo = Dispositivo.TipoAtributo.valueOf(tipoDispositivoText.getText());
    String marca = marcaText.getText();
    String modelo = modeloText.getText();

    try {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = fechaCompraText.getText();
        Date fechaCompra;
        fechaCompra = formatter.parse(strDate);

        if (this.dispositivo == null) {
            // Si el dispositivo es null, creamos uno nuevo
            this.dispositivo = new Dispositivo(id, fechaCompra, precio, tipo, marca, modelo);
            primaryController.anyadirDispositivo(dispositivo);
        } else {
            // Si el dispositivo ya existe, actualizamos sus datos
            this.dispositivo.setId(id);
            this.dispositivo.setFechaCompra(fechaCompra);
            this.dispositivo.setPrecio(precio);
            this.dispositivo.setTipo(tipo);
            this.dispositivo.setMarca(marca);
            this.dispositivo.setModelo(modelo);
            primaryController.modificarDispositivo(dispositivo);
        }

    } catch (ParseException e) {
        System.out.println("Error en la fecha");
        e.printStackTrace();
    }
    
    ((Node) event.getSource()).getScene().getWindow().hide();
}

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;

        idText.setText(String.valueOf(dispositivo.getId()));
        precioText.setText(String.valueOf(dispositivo.getPrecio()));
        tipoDispositivoText.setText(dispositivo.getTipo().toString());
        marcaText.setText(dispositivo.getMarca());
        modeloText.setText(dispositivo.getModelo());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(dispositivo.getFechaCompra());
        fechaCompraText.setText(strDate);

    }

    public void setPrimaryController(PrimaryController primaryController) {
        this.primaryController = primaryController;
    }

}

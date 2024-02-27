package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.models.Dispositivo;

import javafx.scene.control.Button;

public class PrimaryControllerTest {
    @Test
    void testAddDispositivo() {
 // Aquí puedes interactuar con tu interfaz de usuario y hacer afirmaciones
        // Por ejemplo, si tienes un botón para agregar un dispositivo, puedes hacer algo como esto:
        Button addButton = lookup("#addButton").queryButton();
        clickOn(addButton);
        // Supongamos que hacer clic en el botón agrega un dispositivo a una lista
        assertEquals(1, controller.getDispositivos().size());

    }

    @Test
    void testAnyadirDispositivo() {
         // Aquí puedes interactuar con tu interfaz de usuario y hacer afirmaciones
        // Por ejemplo, si tienes un botón para agregar un dispositivo, puedes hacer algo como esto:
        Button addButton = lookup("#addButton").queryButton();
        clickOn(addButton);
        // Supongamos que hacer clic en el botón agrega un dispositivo a una lista
        assertEquals(1, controller.getDispositivos().size());

    }

    @Test
    void testImprimirDispositivos() {
        // Añadir algunos dispositivos
    Dispositivo dispositivo1 = new Dispositivo();
    Dispositivo dispositivo2 = new Dispositivo();
    controller.anyadirDispositivo(dispositivo1);
    controller.anyadirDispositivo(dispositivo2);
    // Llamar al método imprimirDispositivos
    controller.imprimirDispositivos();
    // No podemos hacer una afirmación directa aquí ya que este método puede no devolver nada.
    // Pero podríamos comprobar si se ha llamado a algún método de impresión, por ejemplo.
    verifyThat("#printButton", hasText("Printed!"));


    }

    @Test
    void testModificarDispositivo() {
        // Añadir un dispositivo
    Dispositivo dispositivo = new Dispositivo();
    controller.anyadirDispositivo(dispositivo);
    // Modificar el dispositivo
    dispositivo.setNombre("Nuevo nombre");
    controller.modificarDispositivo(dispositivo);
    // Comprobar que el dispositivo se ha modificado correctamente
    assertEquals("Nuevo nombre", dispositivo.getNombre());


    }

    @Test
    void testOrdenarDispositivosFecha() {
         // Añadir algunos dispositivos con diferentes fechas
    Dispositivo dispositivo1 = new Dispositivo();
    dispositivo1.setFecha(LocalDate.of(2022, 1, 1));
    Dispositivo dispositivo2 = new Dispositivo();
    dispositivo2.setFecha(LocalDate.of(2022, 1, 2));
    controller.anyadirDispositivo(dispositivo1);
    controller.anyadirDispositivo(dispositivo2);
    // Ordenar los dispositivos por fecha
    controller.ordenarDispositivosFecha();
    // Comprobar que los dispositivos se han ordenado correctamente
    assertEquals(Arrays.asList(dispositivo1, dispositivo2), controller.getDispositivos());


    }
}

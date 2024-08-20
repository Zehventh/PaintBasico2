package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HelloController {
    private GraphicsContext gc;
    private Color colorActual = Color.BLACK;
    boolean dibujoLibreActivado = false;
    @FXML
    private Canvas canvas;



    //Se llama automáticamente cuando el controlador se inicializa, para evitar obtener el GraphicContext2D repetidamente
    @FXML
    public void initialize() {
        if (canvas != null) {
            gc = canvas.getGraphicsContext2D();
        }
    }

    // Método para activar el dibujo libre
    @FXML
    public void activarDibujoLibre(ActionEvent event) {
        dibujoLibreActivado = true;
        // Configurar el color y grosor del lápiz
        if (gc !=null) {
            gc.setStroke(colorActual);
            gc.setLineWidth(2.0);

            // Eventos para dibujar cuando el mouse es clickeado y arrastrado
            canvas.setOnMousePressed(e -> {
                if (e.getButton() == MouseButton.PRIMARY) {
                    gc.beginPath();
                    gc.moveTo(e.getX(), e.getY());
                    gc.stroke();
                }
            });
            canvas.setOnMouseDragged(e -> {
                if (e.getButton() == MouseButton.PRIMARY) {
                    gc.lineTo(e.getX(), e.getY());
                    gc.stroke();
                }
            });

            canvas.setOnMouseReleased(e -> {
                if (e.getButton() == MouseButton.PRIMARY) {
                    gc.closePath();
                }
            });
        }
    }
    //Desactiva el dibujo libre
    @FXML
    public void desactivarDibujoLibre() {
        dibujoLibreActivado = false;
    }
    //Método activar el borrado
    @FXML
    public void borrarCanvas() {
        if (canvas != null) {
            //Esto limpia el área completa especificada por las coordenadas (0, 0) y el tamaño del canvas.
          if(gc !=null) {
              gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
          }
        } else {
            System.out.println("No has dibujado nada >:/");
        }
    }
    //Métodos para cambiar colores
    @FXML
    public void cambiarColorRojo(ActionEvent e){
        colorActual = Color.RED;
        if (gc != null) {
            gc.setStroke(colorActual);
        }
    }
    @FXML
    public void cambiarColorAzul(ActionEvent e){
        colorActual = Color.BLUE;
        if (gc != null) {
            gc.setStroke(colorActual);
        }
    }
    @FXML
    public void cambiarColorAmarillo(ActionEvent e){
        colorActual = Color.YELLOW;
        if (gc != null) {
            gc.setStroke(colorActual);
        }
    }
    @FXML
    public void cambiarColorVerde(ActionEvent e){
        colorActual = Color.GREEN;
        if (gc != null) {
            gc.setStroke(colorActual);
        }
    }

    public void cambiarColorNegro(ActionEvent e) {
        colorActual = Color.BLACK;
        if (gc != null) {
            gc.setStroke(colorActual);
        }
    }
    @FXML
    public void Rectangle (ActionEvent e){
        Rectangle r = new Rectangle();
        r.setX(50);
        r.setY(50);
        r.setWidth(200);
        r.setHeight(100);
        r.setArcWidth(20);
        r.setArcHeight(20);
    }
}
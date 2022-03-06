/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanTheGame;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import pacmanEngine.*;
import pacmanEntities.*;

public class JavafxController implements Initializable, gameConstants{
    

    @FXML
    private BorderPane borderPane;

    @FXML
    private Pane borderPaneTop;

    @FXML
    private Label lbScore;

    @FXML
    private Label lbLives;

    @FXML
    private Pane borderPaneBottom;

    @FXML
    private Label lbLevel;

    @FXML
    private Pane borderPaneCenter;
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        borderPaneCenter.setMinSize(N_CELLS_ROW*23, N_CELLS_COLUMN*23);
    }

}
    

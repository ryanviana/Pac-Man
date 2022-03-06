package pacmanTheGame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import pacmanEngine.*;

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
    

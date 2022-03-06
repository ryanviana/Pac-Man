package pacmanTheGame;

import javafx.application.Application;
import javafx.stage.Stage;
import pacmanEngine.*;

public class PacmanTheGame extends Application implements gameConstants{
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        GameView manager = new GameView();
	primaryStage = manager.getMainStage();
	primaryStage.show();
    }
   
    public static void main(String[] args) {
        launch(args);
    }
}
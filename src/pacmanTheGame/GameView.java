package pacmanTheGame;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pacmanEngine.*;

public class GameView implements gameConstants{
    
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    
    public GameView(){
    
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,GAME_WIDTH,GAME_HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        
        
        InGameView gameManager = new InGameView();
	gameManager.createNewGame();
        
    }
    
    public Stage getMainStage(){
        return mainStage;
    }
    
    
    
}

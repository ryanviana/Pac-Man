package pacmanTheGame;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pacmanEngine.*;

public class GameView implements gameConstants{
    
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private Image PlayImage;
    private DropShadow PlayImageShadow;
    private Image PacmanImage;
    
    public GameView(){
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane,GAME_WIDTH,GAME_HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createScene();
    }
    /**
     * Inicia a Tela Inicial e prepara os KeyListeners.
     */
    private void createScene(){
        mainPane.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));
        PlayImage = new Image(getClass().getResourceAsStream("/res/play.png"));
        PacmanImage = new Image(getClass().getResourceAsStream("/res/logo.gif"));
        
        ImageView playImageView = new ImageView();
        ImageView pacmanImageView = new ImageView();
        
        playImageView.setImage(PlayImage);
        pacmanImageView.setImage(PacmanImage);
        
        pacmanImageView.setLayoutX((GAME_WIDTH-playImageView.getImage().getWidth())/2);
        
        playImageView.setLayoutX((GAME_WIDTH-PlayImage.getWidth())/2);
        playImageView.setLayoutY((GAME_HEIGHT-PlayImage.getHeight())-200/2);
        playImageView.setOnMouseClicked(e->{
            InGameView gameManager = new InGameView();
            gameManager.createNewGame(mainStage);
        });
        playImageView.setOnMouseEntered(e->{
            PlayImageShadow = new DropShadow();
            PlayImageShadow.setColor(Color.YELLOW);
            playImageView.setEffect(PlayImageShadow);
        });
        playImageView.setOnMouseExited(e->{
            PlayImageShadow = new DropShadow();
            PlayImageShadow.setColor(Color.TRANSPARENT);
            playImageView.setEffect(PlayImageShadow);
        });
        mainPane.getChildren().add(pacmanImageView);
        mainPane.getChildren().add(playImageView);

    }
  
    public Stage getMainStage(){
        return mainStage;
    }
}

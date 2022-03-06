package pacmanTheGame;

import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pacmanEngine.*;

public class FinishGameView implements gameConstants{
    
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;
    private Image YouWinImage;
    private Image YouLoseImage;
    private Image PlayAgainImage;
    private Image ExitGameImage;
    private ImageView YouWinImageView;
    private ImageView YouLoseImageView;
    private ImageView PlayAgainImageView;
    private ImageView ExitGameImageView;
    private DropShadow PlayImageShadow;
    
    public FinishGameView(AnchorPane anchorPane, Scene scene, Stage stage){
        mainPane = anchorPane;
        mainScene = scene;
        mainStage = stage;
        mainStage.setScene(mainScene);
    }
 
    /**
     * Cria a cena final do Game.
     * @param game Controle do game para receber as estatística.
     */
    public void createScene(gameControl game){
        
        PlayAgainImage = new Image(getClass().getResourceAsStream("/res/playAgain.png"));
        ExitGameImage = new Image(getClass().getResourceAsStream("/res/exitGame.png"));
        PlayAgainImageView = new ImageView();
        ExitGameImageView = new ImageView();
        
        PlayAgainImageView.setImage(PlayAgainImage);
        ExitGameImageView.setImage(ExitGameImage);
        
        if(game.didWinGame()){
            YouWinImage = new Image(getClass().getResourceAsStream("/res/winner.png"));
            YouWinImageView = new ImageView();        
            YouWinImageView.setImage(YouWinImage);
            YouWinImageView.setLayoutX((GAME_WIDTH-YouWinImage.getWidth())/2);
            YouWinImageView.setLayoutY(((GAME_HEIGHT-YouWinImage.getHeight())/2)-150);
            this.mainPane.getChildren().add(YouWinImageView);
        } else {
            YouLoseImage = new Image(getClass().getResourceAsStream("/res/loser.png"));
            YouLoseImageView = new ImageView();
            YouLoseImageView.setImage(YouLoseImage);
            YouLoseImageView.setLayoutX((GAME_WIDTH-YouLoseImage.getWidth())/2);
            YouLoseImageView.setLayoutY(((GAME_HEIGHT-YouLoseImage.getHeight())/2)-150);
            this.mainPane.getChildren().add(YouLoseImageView);
        }
        playAgainAction();
        exitGameAction();

    }
    /**
     * Cria e inicia os KeyListeners para o botão de PlayAgain.
     */
    private void playAgainAction(){
        PlayAgainImage = new Image(getClass().getResourceAsStream("/res/playAgain.png"));
        PlayAgainImageView = new ImageView();
        PlayAgainImageView.setImage(PlayAgainImage);
        PlayAgainImageView.setLayoutX(((GAME_WIDTH-PlayAgainImage.getWidth())/2)-CELL_WIDTH);
        PlayAgainImageView.setLayoutY(((GAME_HEIGHT-PlayAgainImage.getHeight())/2)+100);
        PlayAgainImageView.setFitHeight(PlayAgainImage.getHeight()/2);
        PlayAgainImageView.setFitWidth(PlayAgainImage.getWidth()/2);
        this.mainPane.getChildren().add(PlayAgainImageView);
        
        PlayAgainImageView.setOnMouseClicked(e->{
            InGameView gameManager = new InGameView();
            gameManager.createNewGame(mainStage);
        });
        PlayAgainImageView.setOnMouseEntered(e->{
            PlayImageShadow = new DropShadow();
            PlayImageShadow.setColor(Color.YELLOW);
            PlayAgainImageView.setEffect(PlayImageShadow);
        });
        PlayAgainImageView.setOnMouseExited(e->{
            PlayImageShadow = new DropShadow();
            PlayImageShadow.setColor(Color.TRANSPARENT);
            PlayAgainImageView.setEffect(PlayImageShadow);
        });
    }
    /**
     * Cria e inicia os KeyListeners para o botão de Exit.
     */
    private void exitGameAction(){
        ExitGameImage = new Image(getClass().getResourceAsStream("/res/exitGame.png"));
        ExitGameImageView = new ImageView();
        ExitGameImageView.setImage(ExitGameImage);
        ExitGameImageView.setLayoutX((((GAME_WIDTH-ExitGameImage.getWidth())/2))
                                        +(ExitGameImage.getWidth()/2)
                                        +CELL_WIDTH
                                    );
        ExitGameImageView.setLayoutY(((GAME_HEIGHT-ExitGameImage.getHeight())/2)+100);
        ExitGameImageView.setFitHeight(ExitGameImage.getHeight()/2);
        ExitGameImageView.setFitWidth(ExitGameImage.getWidth()/2);
        this.mainPane.getChildren().add(ExitGameImageView);
        
        ExitGameImageView.setOnMouseClicked(e->{
            System.exit(0);
        });
        ExitGameImageView.setOnMouseEntered(e->{
            PlayImageShadow = new DropShadow();
            PlayImageShadow.setColor(Color.YELLOW);
            ExitGameImageView.setEffect(PlayImageShadow);
        });
        ExitGameImageView.setOnMouseExited(e->{
            PlayImageShadow = new DropShadow();
            PlayImageShadow.setColor(Color.TRANSPARENT);
            ExitGameImageView.setEffect(PlayImageShadow);
        });
    }
    
    public Stage getMainStage(){
        return mainStage;
    }
}

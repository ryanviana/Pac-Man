package pacmanTheGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import pacmanEngine.*;
import pacmanEntities.*;

public class InGameView implements gameConstants{
    
    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;
    private boolean isUpKeyPressed;
    private boolean isDownKeyPressed;
    
    private Timer timer;
    
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    
    
    
    private AnimationTimer gameTimer;
    
    Board gameBoard;
    gameControl GameControl;
    Waka waka;
    HunterGhost Blinky;
    HunterGhost Pinky; 
    DumbGhost Clyde; 
    DumbGhost Inky;
    Pacdot[] pacDotsArray;
    EnergyPill[] energyPillsArray;
            
    private ImageView[][] cellViews;
    private Image pacmanRightImage;
    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image ghost1Image;
    private Image ghost2Image;
    private Image blueGhostImage;
    private Image wallImage;
    private Image bigDotImage;
    private Image smallDotImage;
    private Image blank;
    
    public InGameView(){
        initializeStage();
    }
    
    public void createNewGame() {
		startTimer();
                startGame();
                createBackground();
                keyListener();
		gameStage.show();
    }
    
    private void createBackground(){
        
        gamePane.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));

        this.pacmanRightImage = new Image(getClass().getResourceAsStream("/res/pacmanRight.gif"));
        this.pacmanUpImage = new Image(getClass().getResourceAsStream("/res/pacmanUp.gif"));
        this.pacmanDownImage = new Image(getClass().getResourceAsStream("/res/pacmanDown.gif"));
        this.pacmanLeftImage = new Image(getClass().getResourceAsStream("/res/pacmanLeft.gif"));
        this.ghost1Image = new Image(getClass().getResourceAsStream("/res/redghost.gif"));
        this.ghost2Image = new Image(getClass().getResourceAsStream("/res/ghost2.gif"));
        this.blueGhostImage = new Image(getClass().getResourceAsStream("/res/blueghost.gif"));
        this.wallImage = new Image(getClass().getResourceAsStream("/res/wall.png"));
        this.bigDotImage = new Image(getClass().getResourceAsStream("/res/whitedot.png"));
        this.smallDotImage = new Image(getClass().getResourceAsStream("/res/smalldot.png"));
        this.blank = new Image(getClass().getResourceAsStream("/res/blank.png"));
        this.cellViews = new ImageView[N_CELLS_ROW][N_CELLS_COLUMN];
        
        
        for(int i=0;i<N_CELLS_ROW;i++){
            for(int j=0;j<N_CELLS_COLUMN;j++){
                ImageView imageView = new ImageView();
                imageView.setX((double)j * 30);
                imageView.setY((double)i * 30);
                imageView.setFitWidth(30);
                imageView.setFitHeight(30);
                this.cellViews[i][j] = imageView;
                if(this.gameBoard.gameBoard[i][j].getWall()==true){
                    this.cellViews[i][j].setImage(this.wallImage);
                } 
                else if(this.gameBoard.gameBoard[i][j].getWaka()){
                    this.cellViews[i][j].setImage(this.pacmanRightImage);
                }
                else if(this.gameBoard.gameBoard[i][j].getDumbGhost()){
                    this.cellViews[i][j].setImage(this.ghost1Image);
                }
                else if(this.gameBoard.gameBoard[i][j].getHunterGhost()){
                    this.cellViews[i][j].setImage(this.ghost2Image);
                }
                else if(this.gameBoard.gameBoard[i][j].getPacDot()){
                    this.cellViews[i][j].setImage(this.smallDotImage);
                }
                else if(this.gameBoard.gameBoard[i][j].getEnergyPill()){
                    this.cellViews[i][j].setImage(this.bigDotImage);
                }
                else{
                    this.cellViews[i][j].setImage(null);
                }
                this.gamePane.getChildren().add(imageView);
            }
            
        }
    }
    
    public void updateGameBoard(){
        
    gamePane.getChildren().clear();
   
    for(int i=0;i<N_CELLS_ROW;i++){
            for(int j=0;j<N_CELLS_COLUMN;j++){
                ImageView imageView = new ImageView();
                imageView.setX((double)j * CELL_WIDTH);
                imageView.setY((double)i * CELL_HEIGHT);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setFitHeight(CELL_HEIGHT);
                this.cellViews[i][j] = imageView;
                if(this.gameBoard.gameBoard[i][j].getWall()){
                    this.cellViews[i][j].setImage(this.wallImage);
                } 
                else if(this.gameBoard.gameBoard[i][j].getWaka()){
                    this.cellViews[i][j].setImage(this.pacmanRightImage);
                }
                else if(this.gameBoard.gameBoard[i][j].getDumbGhost()){
                    this.cellViews[i][j].setImage(this.ghost1Image);
                }
                else if(this.gameBoard.gameBoard[i][j].getHunterGhost()){
                    this.cellViews[i][j].setImage(this.ghost2Image);
                }
                else if(this.gameBoard.gameBoard[i][j].getPacDot()){
                    this.cellViews[i][j].setImage(this.smallDotImage);
                }
                else if(this.gameBoard.gameBoard[i][j].getEnergyPill()){
                    this.cellViews[i][j].setImage(this.bigDotImage);
                }
                else{
                    this.cellViews[i][j].setImage(this.blank);   
                }
                this.gamePane.getChildren().add(imageView);
            }
            
        }
    }
    
    private void startGame(){
    
        GameControl = new gameControl();
        GameControl.startGame();
     
        gameBoard = new Board();
        //gameBoard.startBoard();
       gameBoard.initializeLevel(levelFiles[0]);
    
        waka = gameBoard.startWaka();
        
        Blinky = gameBoard.startHunterGhost();
        Pinky = gameBoard.startHunterGhost();
        //Clyde = gameBoard.startDumbGhost();
        //nIky = gameBoard.startDumbGhost();
       
        pacDotsArray = gameBoard.startPacDots();
        //energyPillsArray = gameBoard.startEnergyPills();
			
    }
    
    private void initializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
    }
    
    
    private void startTimer() {
        this.timer = new java.util.Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        updateGameBoard();
                           moveWaka();
                           
                           Blinky.moveCell(waka, gameBoard);
                           //Pinky.moveCell(waka, gameBoard);
                           /*
                           Clyde.moveCell(gameBoard);
                           Inky.moveCell(gameBoard);
                           */
                           if(
                               ( waka.get_xPosition() == Blinky.get_xPosition()
                                 && 
                                 waka.get_yPosition() == Blinky.get_yPosition()
                               )
                               ||
                               (
                                 waka.get_xPosition() == Pinky.get_xPosition()
                                 && 
                                 waka.get_yPosition() == Pinky.get_yPosition()
                               )
                              ){ 
                               
                               pause();
                            }
                            
                    }
                });
            }
        };

        long frameTimeInMilliseconds = (long)(1000.0 / 5.0);
        this.timer.schedule(timerTask, 0, frameTimeInMilliseconds);
    }
    public void pause() {
            this.timer.cancel();
    }
    
    private void keyListener(){
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                if(event.getCode()==KeyCode.LEFT){
                    isLeftKeyPressed = true;
                }
                else if(event.getCode()==KeyCode.RIGHT){
                    isRightKeyPressed = true;
                }
                else if(event.getCode()==KeyCode.UP){
                    isUpKeyPressed = true;
                }
                else if(event.getCode()==KeyCode.DOWN){
                    isDownKeyPressed = true;
                }
            }
        });
        
        gameScene.setOnKeyReleased(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                if(event.getCode()==KeyCode.LEFT){
                    isLeftKeyPressed = false;
                }
                else if(event.getCode()==KeyCode.RIGHT){
                    isRightKeyPressed = false;
                }
                else if(event.getCode()==KeyCode.UP){
                    isUpKeyPressed = false;
                }
                else if(event.getCode()==KeyCode.DOWN){
                    isDownKeyPressed = false;
                }
            }
        });
    }
    
    private void moveWaka(){
        if(isLeftKeyPressed)
            waka.moveCell(gameBoard, "a");
        if(isRightKeyPressed)
            waka.moveCell(gameBoard, "d");
        if(isUpKeyPressed)
            waka.moveCell(gameBoard, "w");
        if(isDownKeyPressed)
            waka.moveCell(gameBoard, "s");
    }
}

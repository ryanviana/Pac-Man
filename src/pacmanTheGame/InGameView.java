package pacmanTheGame;

import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pacmanEngine.*;
import pacmanEntities.*;

public class InGameView implements gameConstants{
    
    private boolean isLeftKeyPressed;
    private boolean isRightKeyPressed;
    private boolean isUpKeyPressed;
    private boolean isDownKeyPressed;
    
    private Timer gameTimer;
    
    private Stage mainStage;
    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
   
    private int level = 1;
    private float BlinkyVelocity = 4;
    private float previousScore = 0;
    private int previousEatenDots = 0;
    private boolean wakaFirstMove = false;
    private boolean ghostsFirstMove = false;
    
    Board Board;
    gameControl GameControl;
    Waka waka;
    HunterGhost Blinky;
    HunterGhost Pinky; 
    DumbGhost Clyde; 
    DumbGhost Inky;
    Pacdot[] pacDotsArray;
    EnergyPill[] energyPillsArray;
    Fruit firstFruit, secondFruit;
            
    private Label lbScore;
    private ImageView[][] cellViews;
    private Image PacmanUpImage,PacmanDownImage,PacmanLeftImage,PacmanRightImage,PacmanDyingImage;
    private Image BlinkyUpImage,BlinkyDownImage,BlinkyLeftImage,BlinkyRightImage;
    private Image PinkyUpImage,PinkyDownImage,PinkyLeftImage,PinkyRightImage;
    private Image InkyUpImage,InkyDownImage,InkyLeftImage,InkyRightImage;
    private Image ClydeUpImage,ClydeDownImage,ClydeLeftImage,ClydeRightImage;
    private Image BlueGhost;
    private Image WallImage, BlankImage;
    private Image OrangeImage,StrawberryImage,CherryImage;
    private Image PacdotImage, EnergyPillImage;
    
    /**
     * Inicia os elementos visuais da tela.
     */
    public InGameView(){
        initializeStage();
    }
    
    /**
     * Realiza as rotinas para o ínicio de um novo jogo.
     * @param mainStage Stage da Tela de Início
     */
    public void createNewGame(Stage mainStage) {
                this.mainStage = mainStage;
                mainStage.hide();
		startGameTimer();
                startGame(level);
                createBackground();
                keyListener();
		gameStage.show();
    }
    
    /**
     * Cria o Background do tabuleiro.
     */
    private void createBackground(){
        gamePane.setBackground(new Background(new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY)));

        PacmanRightImage = new Image(getClass().getResourceAsStream("/res/PacMan_Right.gif"));
        PacmanUpImage = new Image(getClass().getResourceAsStream("/res/PacMan_Up.gif"));
        PacmanDownImage = new Image(getClass().getResourceAsStream("/res/PacMan_Down.gif"));
        PacmanLeftImage = new Image(getClass().getResourceAsStream("/res/PacMan_Left.gif"));
        PacmanDyingImage = new Image(getClass().getResourceAsStream("/res/PacMan_Dying.gif"));
        BlinkyUpImage = new Image(getClass().getResourceAsStream("/res/Blinky_Up.gif"));
        BlinkyDownImage = new Image(getClass().getResourceAsStream("/res/Blinky_Down.gif"));
        BlinkyRightImage = new Image(getClass().getResourceAsStream("/res/Blinky_Right.gif"));
        BlinkyLeftImage = new Image(getClass().getResourceAsStream("/res/Blinky_Left.gif"));
        PinkyUpImage = new Image(getClass().getResourceAsStream("/res/Pinky_Up.gif"));
        PinkyDownImage = new Image(getClass().getResourceAsStream("/res/Pinky_Down.gif"));
        PinkyRightImage = new Image(getClass().getResourceAsStream("/res/Pinky_Right.gif"));
        PinkyLeftImage = new Image(getClass().getResourceAsStream("/res/Pinky_Left.gif"));
        InkyUpImage = new Image(getClass().getResourceAsStream("/res/Inky_Up.gif"));
        InkyDownImage = new Image(getClass().getResourceAsStream("/res/Inky_Down.gif"));
        InkyRightImage = new Image(getClass().getResourceAsStream("/res/Inky_Right.gif"));
        InkyLeftImage = new Image(getClass().getResourceAsStream("/res/Inky_Left.gif"));
        ClydeUpImage = new Image(getClass().getResourceAsStream("/res/Clyde_Up.gif"));
        ClydeDownImage = new Image(getClass().getResourceAsStream("/res/Clyde_Down.gif"));
        ClydeRightImage = new Image(getClass().getResourceAsStream("/res/Clyde_Right.gif"));
        ClydeLeftImage = new Image(getClass().getResourceAsStream("/res/Clyde_Left.gif"));
        OrangeImage = new Image(getClass().getResourceAsStream("/res/Orange.png"));
        StrawberryImage = new Image(getClass().getResourceAsStream("/res/Strawberry.png"));
        CherryImage = new Image(getClass().getResourceAsStream("/res/Cherrie.png"));
        PacdotImage = new Image(getClass().getResourceAsStream("/res/PacDot.png"));
        EnergyPillImage = new Image(getClass().getResourceAsStream("/res/EnergyPill.png"));
        WallImage = new Image(getClass().getResourceAsStream("/res/wall.png"));
        BlankImage = new Image(getClass().getResourceAsStream("/res/blank.png")); 
        BlueGhost = new Image(getClass().getResourceAsStream("/res/BlueGhost.gif")); 
        cellViews = new ImageView[N_CELLS_ROW][N_CELLS_COLUMN];
        
        for(int i=0;i<N_CELLS_ROW;i++){
            for(int j=0;j<N_CELLS_COLUMN;j++){
                ImageView imageView = new ImageView();
                imageView.setX((double)j * 30);
                imageView.setY((double)i * 30);
                imageView.setFitWidth(30);
                imageView.setFitHeight(30);
                cellViews[i][j] = imageView;
                if(Board.gameBoard[i][j].getWall()==true){
                    cellViews[i][j].setImage(WallImage);
                } 
                else if(Board.gameBoard[i][j].getWaka()){
                    cellViews[i][j].setImage(PacmanRightImage);
                }
                else if(Board.gameBoard[i][j].getDumbGhost()){
                    if(i == Clyde.get_yPosition() && j == Clyde.get_xPosition())
                        cellViews[i][j].setImage(ClydeRightImage);
                    if(i == Inky.get_yPosition() && j == Inky.get_xPosition())
                        cellViews[i][j].setImage(InkyRightImage);
                }
                else if(Board.gameBoard[i][j].getHunterGhost()){
                    if(i == Blinky.get_yPosition() && j == Blinky.get_xPosition())
                        cellViews[i][j].setImage(BlinkyRightImage);
                    if(i == Pinky.get_yPosition() && j == Pinky.get_xPosition())
                        cellViews[i][j].setImage(PinkyRightImage);
                }
                else if(Board.gameBoard[i][j].getPacDot()){
                    cellViews[i][j].setImage(PacdotImage);
                }
                else if(Board.gameBoard[i][j].getEnergyPill()){
                    cellViews[i][j].setImage(EnergyPillImage);
                }
                else{
                    cellViews[i][j].setImage(null);
                }
                gamePane.getChildren().add(imageView);
            }
        }
    }
    
    /**
     * Faz o update da interface gráfica no que diz respeito ao controle do game.
     */
    public void updateGameControl(){
        
        GameControl.updateGameControl(waka, Board);
        createFruits();
        extraLife();

        if(GameControl.getInGame()==false){ 
            pause();
            finishScreen();
            showScoreScreen();
        }
        if(level!=GameControl.getLevel()){
            level = GameControl.getLevel();
            nextLevel(level);
        }
    }
    
    /**
     * Faz o update dos elementos da interface a cada novo frame.
     */
    public void updateGameView(){
        
    gamePane.getChildren().clear();
    GameControl.updateGameControl(waka, Board);
    repositionGhosts();
      
    for(int i=0;i<N_CELLS_ROW;i++){
            for(int j=0;j<N_CELLS_COLUMN;j++){
                ImageView imageView = new ImageView();
                imageView.setX((double)j * CELL_WIDTH);
                imageView.setY((double)i * CELL_HEIGHT);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setFitHeight(CELL_HEIGHT);
                cellViews[i][j] = imageView;
                if(Board.gameBoard[i][j].getWall()){
                    cellViews[i][j].setImage(WallImage);
                } 
                else if(Board.gameBoard[i][j].getBonusFruit()){
                    cellViews[i][j].setImage(getElementImage(firstFruit));
                }
                else if(Board.gameBoard[i][j].getWaka()){
                        cellViews[i][j].setImage(getElementImage(waka));
                }
                else if(Board.gameBoard[i][j].getDumbGhost()){
                    if(GameControl.getEnergyPillEffect()){
                        cellViews[i][j].setImage(BlueGhost);
                    }
                    else{
                        if(i==Clyde.get_yPosition()&&j==Clyde.get_xPosition())
                            cellViews[i][j].setImage(getElementImage(Clyde));
                        else
                            cellViews[i][j].setImage(getElementImage(Inky));
                    }
                }
                else if(Board.gameBoard[i][j].getHunterGhost()){
                    if(GameControl.getEnergyPillEffect()){
                        cellViews[i][j].setImage(BlueGhost);
                    }
                    else{
                        if(i==Blinky.get_yPosition()&&j==Blinky.get_xPosition())
                            cellViews[i][j].setImage(getElementImage(Blinky));
                        else
                            cellViews[i][j].setImage(getElementImage(Pinky));
                    }
                }
                else if(Board.gameBoard[i][j].getPacDot()){
                    cellViews[i][j].setImage(PacdotImage);
                }
                else if(Board.gameBoard[i][j].getEnergyPill()){
                    cellViews[i][j].setImage(EnergyPillImage);
                }
                else{
                    cellViews[i][j].setImage(BlankImage);   
                }
                gamePane.getChildren().add(imageView);
            }
        }
    showScoreScreen();
    }
   
    /**
     * Mostra os pontos e vidas do jogo.
     */
    private void showScoreScreen(){
    for(int i = 0; i<GameControl.getLives();i++){
            ImageView imageView = new ImageView();
            imageView.setX(3*CELL_WIDTH+(double)(i) * CELL_WIDTH);
            imageView.setY((double)(N_CELLS_COLUMN+1) * CELL_HEIGHT);
            imageView.setFitWidth(CELL_WIDTH);
            imageView.setFitHeight(CELL_HEIGHT);
            imageView.setImage(PacmanRightImage);
            gamePane.getChildren().add(imageView);
        }
    
        lbScore = new Label();
        lbScore.setText("SCORE:  "+GameControl.getScore());
        lbScore.setTranslateX((double)((N_CELLS_ROW-8) * CELL_WIDTH));
        lbScore.setTranslateY((double)(N_CELLS_COLUMN+1) * CELL_HEIGHT);
        lbScore.setTextFill(Color.WHITE);
        lbScore.setFont(new Font("Arial", CELL_HEIGHT));
        gamePane.getChildren().add(lbScore);
    }
    
    /**
     * Invoca a tela de fim de jogo, tanto para vitória como para derrota.
     */
    private void finishScreen(){
    showScoreScreen();
    blurScene();
    FinishGameView finish = new FinishGameView(gamePane,gameScene,gameStage);
    finish.createScene(GameControl);
    }
    
    /**
     * Adiciona Blur ao tabuleiro.
     */
    private void blurScene(){
        gamePane.getChildren().clear();
        
        for(int i=0;i<N_CELLS_ROW;i++){
            for(int j=0;j<N_CELLS_COLUMN;j++){
                ImageView imageView = new ImageView();
                imageView.setX((double)j * CELL_WIDTH);
                imageView.setY((double)i * CELL_HEIGHT);
                imageView.setFitWidth(CELL_WIDTH);
                imageView.setFitHeight(CELL_HEIGHT);
                cellViews[i][j] = imageView;
                if(Board.gameBoard[i][j].getWall()){
                    cellViews[i][j].setImage(WallImage);
                } 
                else if(Board.gameBoard[i][j].getBonusFruit()){
                    cellViews[i][j].setImage(getElementImage(firstFruit));
                }
                else if(Board.gameBoard[i][j].getWaka()){
                    if(!GameControl.didWinGame())
                        cellViews[i][j].setImage(PacmanDyingImage);
                    else
                        cellViews[i][j].setImage(getElementImage(waka));
                }
                else if(Board.gameBoard[i][j].getDumbGhost()){
                    if(GameControl.getEnergyPillEffect()){
                        cellViews[i][j].setImage(BlueGhost);
                    }
                    else{
                        if(i==Clyde.get_yPosition()&&j==Clyde.get_xPosition())
                            cellViews[i][j].setImage(getElementImage(Clyde));
                        else
                            cellViews[i][j].setImage(getElementImage(Inky));
                    }
                }
                else if(Board.gameBoard[i][j].getHunterGhost()){
                    if(GameControl.getEnergyPillEffect()){
                        cellViews[i][j].setImage(BlueGhost);
                    }
                    else{
                        if(i==Blinky.get_yPosition()&&j==Blinky.get_xPosition())
                            cellViews[i][j].setImage(getElementImage(Blinky));
                        else
                            cellViews[i][j].setImage(getElementImage(Pinky));
                    }
                }
                else if(Board.gameBoard[i][j].getPacDot()){
                    cellViews[i][j].setImage(PacdotImage);
                }
                else if(Board.gameBoard[i][j].getEnergyPill()){
                    cellViews[i][j].setImage(EnergyPillImage);
                }
                else{
                    cellViews[i][j].setImage(BlankImage);   
                }
                BoxBlur bb = new BoxBlur();
                bb.setWidth(2);
                bb.setHeight(2);
                bb.setIterations(2);
                imageView.setEffect(bb);
                gamePane.getChildren().add(imageView);
            }
        }
    }
    
    /**
     * Inicia um novo jogo.
     * @param runningLevel nível atual do jogo.
     */
    private void startGame(int runningLevel){
        GameControl = new gameControl();
        GameControl.startGame();
     
        Board = new Board();
        Board.initializeLevel(levelFiles[runningLevel]);
    
        waka = Board.startWaka();
        
        Blinky = Board.startHunterGhost(BLINKY);
        Pinky = Board.startHunterGhost(PINKY);
        Clyde = Board.startDumbGhost(CLYDE);
        Inky = Board.startDumbGhost(INKY);
       
        pacDotsArray = Board.startPacDots();
        energyPillsArray = Board.startEnergyPills();
        
    }
    /**
     * Vai para o próximo nível.
     * @param runningLevel nível atual do jogo.
     */
    private void nextLevel(int runningLevel){
        Board = new Board();
        Board.initializeLevel(levelFiles[runningLevel]);
    
        waka = Board.startWaka();
        
        Blinky = Board.startHunterGhost(BLINKY);
        Pinky = Board.startHunterGhost(PINKY);
        Clyde = Board.startDumbGhost(CLYDE);
        Inky = Board.startDumbGhost(INKY);
       
        pacDotsArray = Board.startPacDots();
        energyPillsArray = Board.startEnergyPills();
        firstFruit = null;
        secondFruit = null;
        System.gc();
        
        createBackground();
			
    }
    
    /**
     * Inicializa os elementos gráficos.
     */
    private void initializeStage() {
		gamePane = new AnchorPane();
		gameScene = new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
		gameStage = new Stage();
		gameStage.setScene(gameScene);
    }
    
    /**
     * Inicia o Timer e os Timertasks.
     */
    private void startGameTimer() {
        gameTimer = new Timer();
        TimerTask game = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        updateGameControl();
                        if(GameControl.getInGame()){
                            moveWaka();
                            startGhosts();
                            updateGameView();
                        }
                    }
                });
            }
        };
        
        long wakaFrameRate = (long)(1000.0 / 5.8);
        
        gameTimer.schedule(game, 0, wakaFrameRate);
        
        
    }
    
    /**
     * Inicia os fanstamas.
     */
    private void startGhosts(){
    if(wakaFirstMove && !ghostsFirstMove){
        ghostsFirstMove = true;
        TimerTask ghosts = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if(GameControl.getInGame()){
                            updateGameView();
                            moveGhosts();
                        }
                    }
                });
            }
        };
        TimerTask blinky = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if(GameControl.getInGame()){
                            updateGameView();
                            Blinky.moveCell(waka, Board,GameControl.getEnergyPillEffect());
                            changeBlinkyVelocity();
                        }
                    }
                });
            }
        };
        long ghostsFrameRate = (long)(1000.0 / 4.0);
        long blinkyFrameRate = (long)(1000.0 / BlinkyVelocity);
        gameTimer.schedule(ghosts,0,ghostsFrameRate);
        gameTimer.schedule(blinky,0,blinkyFrameRate);
    }
    }
    
    /**
     * Checa vida extra.
     */
    private void extraLife(){
    if(GameControl.getScore()==10000
                &&
           previousScore != GameControl.getScore()
          ){
            previousScore = GameControl.getScore();
            GameControl.addLives(1);
        }
    }
    
    /**
     * Altera a velocidade da Blinky de acordo com o Score.
     */
    private void changeBlinkyVelocity(){
        if(BlinkyVelocity<5.5
                &&
           previousScore != GameControl.getScore()
          ){
            previousScore = GameControl.getScore();
            BlinkyVelocity += ((GameControl.getScore())*0.000005);
        }
    }
    
    /**
     * Finaliza o Timer.
     */
    public void pause() {
            gameTimer.cancel();
    }
    
    /**
     * Movimentação do Waka de acordo com o KeyListener do teclado.
     */
    private void keyListener(){
        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent event){
                if(event.getCode()==KeyCode.LEFT||event.getCode()==KeyCode.A){
                    wakaFirstMove = true;
                    isLeftKeyPressed = true;
                }
                else if(event.getCode()==KeyCode.RIGHT||event.getCode()==KeyCode.D){
                    wakaFirstMove = true;
                    isRightKeyPressed = true;
                }
                else if(event.getCode()==KeyCode.UP||event.getCode()==KeyCode.W){
                    wakaFirstMove = true;
                    isUpKeyPressed = true;
                }
                else if(event.getCode()==KeyCode.DOWN||event.getCode()==KeyCode.S){
                    wakaFirstMove = true;
                    isDownKeyPressed = true;
                }
            }
        });
        
        gameScene.setOnKeyReleased((KeyEvent event) -> {
            if(event.getCode()==KeyCode.LEFT||event.getCode()==KeyCode.A){
                isLeftKeyPressed = false;
            }
            else if(event.getCode()==KeyCode.RIGHT||event.getCode()==KeyCode.D){
                isRightKeyPressed = false;
            }
            else if(event.getCode()==KeyCode.UP||event.getCode()==KeyCode.W){
                isUpKeyPressed = false;
            }
            else if(event.getCode()==KeyCode.DOWN||event.getCode()==KeyCode.S){
                isDownKeyPressed = false;
            }
        });
    }
    
    /**
     * Faz a movimentação do Waka.
     */
    private void moveWaka(){
        if(isLeftKeyPressed)
            waka.moveCell(Board,LEFT);
        if(isRightKeyPressed)
            waka.moveCell(Board,RIGHT);
        if(isUpKeyPressed)
            waka.moveCell(Board,UP);
        if(isDownKeyPressed)
            waka.moveCell(Board,DOWN);
    }
    /**
     * Faz a movimentação do fantasma.
     */
    private void moveGhosts(){ 
        Pinky.moveCell(waka,Board,GameControl.getEnergyPillEffect());
        Clyde.moveCell(Board);
        Inky.moveCell(Board);
    }
    
    /**
     * Cria as frutas quando o score é obtido.
     */
    private void createFruits(){
        if(GameControl.getEatenPacDots()==70
                &&
           previousEatenDots != GameControl.getEatenPacDots()
          ){
            previousEatenDots = GameControl.getEatenPacDots();
            firstFruit = Board.startFruits(level);
        }
        if(GameControl.getEatenPacDots()==170
                &&
           previousEatenDots != GameControl.getEatenPacDots()
          ){
            previousEatenDots = GameControl.getEatenPacDots();
            secondFruit = Board.startFruits(level);
        }
    }
    
    /**
     * Retorna a imagem correta para o elemento.
     * @param element Elemento que deseja-se obter a imagem.
     * @return Imagem do elemento.
     */
    private Image getElementImage(Element element){
        switch(element.getDirection()){
            case UP:
                if(element.get_id().equals(WAKA))
                    return PacmanUpImage;
                if(element.getName().equals(BLINKY))
                    return BlinkyUpImage;
                if(element.getName().equals(PINKY))
                    return PinkyUpImage;
                if(element.getName().equals(INKY))
                    return InkyUpImage;
                if(element.getName().equals(CLYDE))
                    return ClydeUpImage;
            break;
            case DOWN:
                if(element.get_id().equals(WAKA))
                    return PacmanDownImage;
                if(element.getName().equals(BLINKY))
                    return BlinkyDownImage;
                if(element.getName().equals(PINKY))
                    return PinkyDownImage;
                if(element.getName().equals(INKY))
                    return InkyDownImage;
                if(element.getName().equals(CLYDE))
                    return ClydeDownImage;
                break;
            case LEFT:
                if(element.get_id().equals(WAKA))
                    return PacmanLeftImage;
                if(element.getName().equals(BLINKY))
                    return BlinkyLeftImage;
                if(element.getName().equals(PINKY))
                    return PinkyLeftImage;
                if(element.getName().equals(INKY))
                    return InkyLeftImage;
                if(element.getName().equals(CLYDE))
                    return ClydeLeftImage;
                break;
            case RIGHT:
                if(element.get_id().equals(WAKA))
                    return PacmanRightImage;
                if(element.getName().equals(BLINKY))
                    return BlinkyRightImage;
                if(element.getName().equals(PINKY))
                    return PinkyRightImage;
                if(element.getName().equals(INKY))
                    return InkyRightImage;
                if(element.getName().equals(CLYDE))
                    return ClydeRightImage;
                break;
            case NONE:
                if(element.get_id().equals(WAKA))
                    return PacmanRightImage;
                if(element.getName().equals(BLINKY))
                    return BlinkyRightImage;
                if(element.getName().equals(PINKY))
                    return PinkyRightImage;
                if(element.getName().equals(INKY))
                    return InkyRightImage;
                if(element.getName().equals(CLYDE))
                    return ClydeRightImage;
                if(element.getName().equals(ORANGE))
                    return OrangeImage;
                if(element.getName().equals(STRAWBERRY))
                    return StrawberryImage;
                if(element.getName().equals(CHERRY))
                    return CherryImage;
                break;
        }
        return PacmanRightImage;
    }
    
    /**
     * Reposiciona os fantasmas e o waka, quando necessário.
     */
    private void repositionGhosts(){
                
        if(Board.gameBoard[Pinky.get_yPosition()][Pinky.get_xPosition()].getWaka()==true){
            Pinky.reset(Board);
            if(!GameControl.getEnergyPillEffect()&&GameControl.getInGame())
                waka.reset(Board);
        }
        if(Board.gameBoard[Blinky.get_yPosition()][Blinky.get_xPosition()].getWaka()==true){
            Blinky.reset(Board);
            if(!GameControl.getEnergyPillEffect()&&GameControl.getInGame())
                waka.reset(Board);
        }
        if(Board.gameBoard[Clyde.get_yPosition()][Clyde.get_xPosition()].getWaka()==true){
            Clyde.reset(Board);
            if(!GameControl.getEnergyPillEffect()&&GameControl.getInGame())
                waka.reset(Board);
        }
        if(Board.gameBoard[Inky.get_yPosition()][Inky.get_xPosition()].getWaka()==true){
            Inky.reset(Board);
            if(!GameControl.getEnergyPillEffect()&&GameControl.getInGame())
                waka.reset(Board);
        }
    }
}

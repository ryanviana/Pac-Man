package pacmanTheGame;

import java.awt.event.KeyEvent;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import pacmanEntities.*;
import pacmanEngine.*;

//já criei o projeto como Java FX pensando na posterior implementação da
//interface gráfica. Entretanto, ainda não mexi em nada e deixei do jeito padrão
//que veio.

public class PacmanTheGame extends Application implements gameConstants{
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        
        GameView manager = new GameView();
	primaryStage = manager.getMainStage();
	//primaryStage.show();
             
    }
   
    
    public static void main(String[] args) {
        
        launch(args);
        
        
        
        /*
        //inicia um jogo
        gameControl GameControl = new gameControl();
        GameControl.startGame();
        
        //inicia o tabuleiro
   
        Board gameBoard = new Board();
        gameBoard.startBoard();
        
        
        //inicia o pacman no tabuleiro
        Waka waka = gameBoard.startWaka();
        
        //inicia os fantasmas no tabuleiro
        HunterGhost Blinky = gameBoard.startHunterGhost();
            //HunterGhost Pinky = gameBoard.startHunterGhost();
            //DumbGhost Clyde = gameBoard.startDumbGhost();
            //DumbGhost Inky = gameBoard.startDumbGhost();
       
        //inicia os pacDots no tabuleiro. Precisar mudar a sua quantidade em "GameConstants".
        Pacdot[] pacDotsArray = gameBoard.startPacDots();
        
        //inicia as pilulas de energia no tabuleiro. Precisar mudar a sua quantidade em "GameConstants".
        EnergyPill[] energyPillsArray = gameBoard.startEnergyPills();
        
        //enquanto o jogo estiver ativo o ciclo while se repete
        while(GameControl.getInGame() == true){
        
        //imprimimos o tabuleiro
        gameBoard.printGameBoard();
        
        //movimentação do pacman, está desativada para fazer o teste de busca do fantasma.
            //System.out.println("Press w,a,s,d to move the pacman");
            //waka.moveCell(gameBoard);
        
        //movimentação dos fantasmas, apenas um está ativo.
        Blinky.moveCell(waka, gameBoard);
        //Pinky.moveCell(waka, gameBoard);
        //Inky.moveCell(gameBoard);
        //Clyde.moveCell(gameBoard);
        
        //vai terminar o jogo quando o Blinky atingir o pacman e assim finalizar o teste.
        if(waka.get_xPosition() == Blinky.get_xPosition()
           && 
           waka.get_yPosition() == Blinky.get_yPosition()){ 
           
           gameBoard.printGameBoard();
           GameControl.setInGame(false);
           
        }

        //para ajudar na "animação" no output do Netbeans.
        try
        {
            Thread.sleep(350);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        
        }
        
        //termina o programa.
        System.exit(0);
        */
    }
  
    
}
package pacmanEntities;

import java.util.Scanner;
import pacmanEngine.*;

/** Representa o pacman.
 * @author Ryan Braz Tintore Viana
 */
public class Waka extends Element implements gameConstants{
    
    /** Inicia um pacman no labirinto.
     * @param Board
     */
    public Waka(Board Board){
        super(Board);
        this.speed = 2;
        this.identity = "waka";
        Board.updateGameBoard(this);
    }
    
    //método básico que escaneia "w", "a", "s" ou "d" e movimento o waka(pacman)
    //baseado nisso.

    /** Move o pacman no labirinto.
     * @param Board labirinto em que o pacman será movimentado.
     */
    public void moveCell(Board Board, String movement){
        
    int i;
    
    this.previous_xPosition = this.xPosition;
    this.previous_yPosition = this.yPosition;
       

        switch (movement) {
            case "w":
                for(i=1;i<=speed;i++){
                    if(Board.cellValidation(this.xPosition,this.yPosition-1)){
                        this.yPosition -= 1;
                    }
                }       break;
            case "a":
                for(i=1;i<=speed;i++){
                    if(Board.cellValidation(this.xPosition-1,this.yPosition))
                        this.xPosition -= 1;
                }         break;
            case "s":
                for(i=1;i<=speed;i++){
                    if(Board.cellValidation(this.xPosition,this.yPosition+1))
                        this.yPosition += 1;
                }         break;
            case "d":
                for(i=1;i<=speed;i++){
                    if(Board.cellValidation(this.xPosition+1,this.yPosition))
                        this.xPosition += 1;
                }           break;
            default:
                break;
        }
        Board.updateGameBoard(this);

    }
    
    //método que reseta o waka(pacman) em uma posição aleatória do labirinto.

    /** Reinicia a posição do pacman no labirinto.
     * @param Board labirinto em que o pacman será reiniciado.
     */
    public void reset(Board Board){
        
        Coordinates randomCoords = new Coordinates();
        randomCoords.randomPosition();
       
        while(Board.gameBoard[randomCoords.get_y_coordinate()][randomCoords.get_x_coordinate()].getWaka() == true){
            randomCoords.randomPosition();
        }
        this.previous_xPosition = xPosition;
        this.previous_yPosition = yPosition;
        this.xPosition = randomCoords.get_x_coordinate();
        this.yPosition = randomCoords.get_y_coordinate();
        
        Board.updateGameBoard(this);
    }
    
    
}

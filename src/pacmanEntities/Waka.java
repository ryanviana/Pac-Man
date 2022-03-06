package pacmanEntities;

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
        this.speed = 1;
        this.identity = WAKA;
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
            case UP:
                for(i=1;i<=speed;i++){
                    if(Board.cellValidation(this.xPosition,this.yPosition-1)){
                        this.yPosition -= 1;
                        this.changeDirection(UP);
                    }
                }       break;
            case LEFT:
                for(i=1;i<=speed;i++){
                    if(Board.cellValidation(this.xPosition-1,this.yPosition)){
                        this.xPosition -= 1;
                        this.changeDirection(LEFT);
                    }
                }         break;
            case DOWN:
                for(i=1;i<=speed;i++){
                    if(Board.cellValidation(this.xPosition,this.yPosition+1)){
                        this.yPosition += 1;
                        this.changeDirection(DOWN);
                    }
                }         break;
            case RIGHT:
                for(i=1;i<=speed;i++){
                    if(Board.cellValidation(this.xPosition+1,this.yPosition)){
                        this.xPosition += 1;
                        this.changeDirection(RIGHT);
                    }
                }           break;
            default:
                break;
        }
        Board.updateGameBoard(this);
    }
}

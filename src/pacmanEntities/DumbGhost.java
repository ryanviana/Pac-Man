package pacmanEntities;

import java.util.Random;
import pacmanEngine.*;



/** DumbGhost se refere ao fantasma que se movimenta de forma aleatória.
 * @author Ryan Braz Tintore Viana
 */
public class DumbGhost extends Ghost{
    
    /** Inicia um DumbGhost no tabuleiro.
     * @param Board
     */
    public DumbGhost(Board Board){
    super(Board);
    this.identity = "dumbGhost";
    this.speed = 1;
    Board.updateGameBoard(this);

    }
    
    /** Movimentação de um DumbGhost.
     * O DumbGhost se movimentará para uma nova célula aleatória. 
     * @param Board
     */
    public void moveCell(Board Board){
     
    this.previous_xPosition = this.xPosition;
    this.previous_yPosition = this.yPosition;
      
    //iremos gerar um número aleatório entre 0 e 3 que posteriarmente definirão em qual
    //das quatro direções possívels (cima,baixo,direita,esquerda) o fantasma vai andar.
    Random rand = new Random();
    int nextMovement = rand.nextInt(4);
    
    //abaixo iremos fazer a movimentação, primeiro verifica-se para qual direção ir e depois 
    //se a posição é válida, ou seja, não tem uma parede ou está fora do mapa.
    
    //up
    if(nextMovement == 0
    &&
    (yPosition-this.speed) > 0
    &&
    (Board.gameBoard[this.yPosition-this.speed][this.xPosition]).getWall() == false){
        this.yPosition -= this.speed;
    } 
    //down
    else if(nextMovement == 1
    &&
    (yPosition+this.speed) < (N_CELLS_ROW-1)
    &&
    (Board.gameBoard[this.yPosition+this.speed][this.xPosition]).getWall() == false){
        this.yPosition += this.speed;
    }
    //right
    else if(nextMovement == 2
    &&
    (xPosition+this.speed) < (N_CELLS_COLUMN-1)
    &&
    (Board.gameBoard[this.yPosition][this.xPosition+this.speed]).getWall() == false){
        this.xPosition += this.speed;
    }
    //left
    else if(nextMovement == 3
    &&
    (xPosition-this.speed) > 0
    &&
    (Board.gameBoard[this.yPosition][this.xPosition-this.speed]).getWall() == false){
        this.xPosition -= this.speed;
    }
    Board.updateGameBoard(this);
    }
    
}

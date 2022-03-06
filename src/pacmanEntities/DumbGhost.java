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
        identity = DUMB_GHOST;
        speed = 1;
        Board.updateGameBoard(this);
    }
    
    /** Movimentação de um DumbGhost.
     * O DumbGhost se movimentará para uma nova célula aleatória. 
     * @param Board
     */
    public void moveCell(Board Board){
    //iremos gerar um número aleatório entre 0 e 3 que posteriarmente definirão em qual
    //das quatro direções possívels (cima,baixo,direita,esquerda) o fantasma vai andar.
    Random rand = new Random();
    int nextMovement = rand.nextInt(4);
    
    //abaixo iremos fazer a movimentação, primeiro verifica-se para qual direção ir e depois
    //se a posição é válida, ou seja, não tem uma parede ou está fora do mapa.
    switch (nextMovement) {
        case 0:
            moveUp(Board);
            break;
        case 1:
            moveDown(Board);
            break;
        case 2:
            moveRight(Board);
            break;
        case 3:
            moveLeft(Board);
            break;
        default:
            break;
        }
    Board.updateGameBoard(this);
    }
}

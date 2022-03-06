package pacmanEntities;

import pacmanEngine.*;

/** Representa um pacdot.
 * @author Ryan Braz Tintore Viana
 */
public class Pacdot extends Element{
        
    /** Instancia um pacdot no tabuleiro.
     * @param Board tabuleiro em que o pacdot será instanciado.
     */
    public Pacdot(Board Board){
        super(Board);
        this.identity = PACDOT;
        Board.updateGameBoard(this);
    }
}

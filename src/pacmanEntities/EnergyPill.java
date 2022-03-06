package pacmanEntities;

import pacmanEngine.*;

/** Representa a pílula de energia.
 * @author Ryan Braz Tintore Viana
 */
public class EnergyPill extends Element{
    
    /** Instancia uma pílula de energia no tabuleiro.
     * @param Board tabuleiro em que a pílula será instanciada.
     */
    public EnergyPill(Board Board){
        super(Board);
        this.identity = "energyPill";
        Board.updateGameBoard(this);
    }
    
}

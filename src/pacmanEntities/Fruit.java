package pacmanEntities;

import pacmanEngine.*;

/** Representa uma fruta bonus.
 * @author Ryan Braz Tintore Viana
 */
public class Fruit extends Element {
    
    //Valor que a fruta dá de score
    private int scoreValue;
    
    public Fruit(Board Board, int level){
        super(Board);
        this.identity = BONUS_FRUIT;
        Board.updateGameBoard(this);
    }
    
    /** Retorna o valor em score de uma fruta.
     * @return Quanto de score o pacman irá ganhar se comer a fruta.
     */
    public int getScoreValue(){
        return this.scoreValue;
    }
    
    /** Modifica o valor em score que uma fruta fornecerá pro pacman.
     * @param scoreValue
     */
    public void setScoreValue(int scoreValue){
        this.scoreValue = scoreValue;
    }

    /** Modifica o nome da fruta.
     * @param level Novo nome da fruta.
     */
    public void setFruitName(int level){
        if(level==1)
            this.setName(CHERRY);
        if(level==2)
            this.setName(STRAWBERRY);
        if(level==3)
            this.setName(ORANGE);
    }
}
    


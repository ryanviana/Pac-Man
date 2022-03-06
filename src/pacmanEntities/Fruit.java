package pacmanEntities;

import pacmanEngine.*;

/** Representa uma fruta bonus.
 * @author Ryan Braz Tintore Viana
 */
public class Fruit extends Element {
    
    //Valor que a fruta dá de score
    private int scoreValue;
    //nome da fruta, por exemplo: morango, cereja...
    private String fruitName;
    
    
    Fruit(Board Board){
        super(Board);
        this.identity = "bonusFruit";
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
    
    /** Retorna o nome da fruta.
     * @return Nome da fruta.
     */
    public String getFruitName(){
        return this.fruitName;
    }
    
    /** Modifica o nome da fruta.
     * @param fruitName Novo nome da fruta.
     */
    public void setFruitName(String fruitName){
        this.fruitName = fruitName;
    }
    
}

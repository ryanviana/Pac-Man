package pacmanEntities;
import pacmanEngine.*;

//classe abstrata que servirá como base para todos os elementos do game

/** A classe Elemento representa todos os elementos que estarão
 * presentes no tabuleiro.
 * @author Ryan Braz Tintore Viana
 */
public abstract class Element implements gameConstants {
    
    // a string de identidade serve para diferenciar os elementos do jogo
    // na hora de fazer algumas verificações

    /** Representa a identidade de um elemento.
     * A identidade pode ser por exemplo: "pacDot". O que significa que podemos
     * reconhecer aquele elemento como um pacdot.
     */
    protected String identity;
    
    /** Posição x (coluna) de um elemento no tabuleiro.
     */
    protected int xPosition,

    /** Posição anterior x (coluna) antes de um elemento mover-se no tabuleiro.
     */
    previous_xPosition,

    /** Posição y (linha) de um elemento no tabuleiro.
     */
    yPosition,

    /** Posição anterior y (linha) antes de um elemento mover-se no tabuleiro.
     */
    previous_yPosition,

    /** Velocidade de um elemento.
     * Quantas células um elemento anda de uma vez. Por exemplo, se a velocidade
     * for igual a 2, isso significa que o elemento consegue mover-se de 2 
     * em 2 células no tabuleiro.
     */
    speed;

    /** Estado de vida de um elemento.
     * Representa se um elemento está vivo ou morto.
     */
    protected boolean alive;
    
    /** Instanciação de um elemento no tabuleiro.
     * @param Board tabuleiro em que o elemento será inserido.
     */
    protected Element(Board Board){
        
        //O construtor irá iniciar o elemento no tabuleiro em coordenadas aleatórias e válidas
        Coordinates randomCoords = new Coordinates();
        randomCoords.randomValidPosition(Board);

        this.xPosition = randomCoords.get_x_coordinate();
        this.yPosition = randomCoords.get_y_coordinate();
        
    }
    
    /** Checa se um elemento se colidiu com outro elemento.
     * Checa se dois elementos estão na mesma célula no tabuleiro.
     * @param Element elemento que deseja-se verifica a possível colisão.
     * @return se houver colisão entre os elementos.
     */
    public boolean checkColision(Element Element){
        return(this.xPosition == Element.xPosition &&
               this.yPosition == Element.yPosition);
    }
    

    /** Retorna a posição da coluna do elemento no tabuleiro.
     * @return retorna a posição x (coluna) do elemento no tabuleiro.
     */
    public int get_xPosition(){
        return this.xPosition;
    }

     /** Retorna a posição da linha do elemento no tabuleiro.
     * @return retorna a posição y (linha) do elemento no tabuleiro.
     */
    public int get_yPosition(){
        return this.yPosition;
    }

    /** Retorna a posição da coluna antes do elemento se movimentar 
     * no tabuleiro.
     * @return retorna a posição x (coluna) antes do elemento se mover.
     */
    public int get_previous_xPosition(){
        return this.previous_xPosition;
    }

    /** Retorna a posição da linha antes do elemento se movimentar 
     * no tabuleiro.
     * @return retorna a posição y (linha) antes do elemento se mover.
     */
    public int get_previous_yPosition(){
        return this.previous_yPosition;
    }

    /** Retorna a identidade de um elemento.
     * @return Identidade de um elemento no tabuleiro.
     */
    public String get_id(){
        return this.identity;
    }

    /** Retorna se um elemento está vivo ou não
     * @return Estado de vida de um elemento.
     */
    public boolean isAlive(){
        return (this.alive == true);
    }  

    /** Modifica se um elemento está vivo ou não
     * @param alive Estado de vida de um elemento.
     */
    public void setAlive(boolean alive){
        this.alive = alive;
    }
   
}

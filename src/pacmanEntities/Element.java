package pacmanEntities;

import pacmanEngine.*;

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
    private String name;
    
    protected boolean UP_DIR = false;
    protected boolean RIGHT_DIR = false;
    protected boolean LEFT_DIR = false;
    protected boolean DOWN_DIR = false;
    
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
        
        int col = randomCoords.get_x_coordinate();
        int row = randomCoords.get_y_coordinate();
        
        while(avoidDoublePositioning(Board.gameBoard[row][col])){
            randomCoords = new Coordinates();
            randomCoords.randomValidPosition(Board);
            col = randomCoords.get_x_coordinate();
            row = randomCoords.get_y_coordinate();
        }
        
        xPosition = randomCoords.get_x_coordinate();
        yPosition = randomCoords.get_y_coordinate();
        
    }
    
    private boolean avoidDoublePositioning(BoardCell cell){
        return cell.getBonusFruit()||cell.getDumbGhost()
               ||
               cell.getHunterGhost()||cell.getEnergyPill()
               ||
               cell.getPacDot()||cell.getWaka();
    }
    
    /** Checa se um elemento se colidiu com outro elemento.
     * Checa se dois elementos estão na mesma célula no tabuleiro.
     * @param Element elemento que deseja-se verifica a possível colisão.
     * @return se houver colisão entre os elementos.
     */
    public boolean checkColision(Element Element){
        return(xPosition == Element.xPosition &&
               yPosition == Element.yPosition);
    }
    

    /** Retorna a posição da coluna do elemento no tabuleiro.
     * @return retorna a posição x (coluna) do elemento no tabuleiro.
     */
    public int get_xPosition(){
        return xPosition;
    }

     /** Retorna a posição da linha do elemento no tabuleiro.
     * @return retorna a posição y (linha) do elemento no tabuleiro.
     */
    public int get_yPosition(){
        return yPosition;
    }
    
    /** altera a posição x
     * @param x se refere a coluna do tabuleiro.
     */
    public void set_xPosition(int x){
        xPosition = x;
    }
    
    /** altera a posição y
     * @param y se refere a linha do tabuleiro.
     */
    public void set_yPosition(int y){
        yPosition = y;
    }

    /** Retorna a posição da coluna antes do elemento se movimentar 
     * no tabuleiro.
     * @return retorna a posição x (coluna) antes do elemento se mover.
     */
    public int get_previous_xPosition(){
        return previous_xPosition;
    }

    /** Retorna a posição da linha antes do elemento se movimentar 
     * no tabuleiro.
     * @return retorna a posição y (linha) antes do elemento se mover.
     */
    public int get_previous_yPosition(){
        return previous_yPosition;
    }

    /** Retorna a identidade de um elemento.
     * @return Identidade de um elemento no tabuleiro.
     */
    public String get_id(){
        return identity;
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
    
    /** Modifica o nome do elemento.
     * @name o nome a ser modificado.
     */
    public void setName(String name){
        this.name = name;
    }
    
    /** Retorna o nome do elemento.
     * @return o nome do elemento.
     */
    public String getName(){
        return name;
    }
    
    
    /** Reinicia a posição do pacman no labirinto.
     * @param Board labirinto em que o pacman será reiniciado.
     */
    public void reset(Board Board){
        
        Coordinates randomCoords = new Coordinates();
        randomCoords.randomValidPosition(Board);
       
        while(Board.gameBoard[randomCoords.get_y_coordinate()][randomCoords.get_x_coordinate()].getWaka() == true){
            randomCoords.randomValidPosition(Board);
        }
        previous_xPosition = xPosition;
        previous_yPosition = yPosition;
        xPosition = randomCoords.get_x_coordinate();
        yPosition = randomCoords.get_y_coordinate();
        
        Board.updateGameBoard(this);
    }
    
    public boolean moveUp(Board Board){  
        previous_xPosition = xPosition;
        previous_yPosition = yPosition;
        if(Board.cellValidation(xPosition, yPosition-1)){
            yPosition-=1;
            changeDirection(UP);
            return true;
        }
        else
            return false;
    }
    public boolean moveDown(Board Board){
        previous_xPosition = xPosition;
        previous_yPosition = yPosition;
        if(Board.cellValidation(xPosition, yPosition+1)){
            yPosition+=1;
            changeDirection(DOWN);
            return true;
        }
        else
            return false;
    }
    public boolean moveLeft(Board Board){
        previous_xPosition = xPosition;
        previous_yPosition = yPosition;
        if(Board.cellValidation(xPosition-1, yPosition)){
            xPosition-=1;
            changeDirection(LEFT);
            return true;
        }
        else
            return false;
    }
    
    public boolean moveRight(Board Board){
        previous_xPosition = xPosition;
        previous_yPosition = yPosition;
        if(Board.cellValidation(xPosition+1, yPosition)){
            xPosition+=1;
            changeDirection(RIGHT);
            return true;
        }
        else
            return false;
    }
    
    public void changeDirection(String direction){
        if(direction.equals(UP)){
            this.UP_DIR=true;
            this.DOWN_DIR=false;
            this.LEFT_DIR=false;
            this.RIGHT_DIR=false;
        }
        if(direction.equals(DOWN)){
            this.UP_DIR=false;
            this.DOWN_DIR=true;
            this.LEFT_DIR=false;
            this.RIGHT_DIR=false;
        }
        if(direction.equals(RIGHT)){
            this.UP_DIR=false;
            this.DOWN_DIR=false;
            this.LEFT_DIR=false;
            this.RIGHT_DIR=true;
        }
        if(direction.equals(LEFT)){
            this.UP_DIR=false;
            this.DOWN_DIR=false;
            this.LEFT_DIR=true;
            this.RIGHT_DIR=false;
        }
    }
    
    public String getDirection(){
        if(UP_DIR==true)
            return UP;
        if(RIGHT_DIR==true)
            return RIGHT;
        if(DOWN_DIR==true)
            return DOWN;
        if(LEFT_DIR==true)
            return LEFT;
        return NONE;
    }
}

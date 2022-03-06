package pacmanEngine;

import java.util.Random;

/** Objeto que representa um par ordenado (x,y) de uma célula do tabuleiro.
 * @author Ryan Braz Tintore Viana
 */
public class Coordinates implements gameConstants{
    
    private int x;
    private int y;
    
    /** Inicia um par ordenado (x,y), em que x e y são inteiros.
     * @param pX coordenada X da célula.
     * @param pY coordenada Y da célula.
     */
    public Coordinates(int pX, int pY){
    this.x = pX;
    this.y = pY;
    }
    

    /** Inicia um par ordenado (x,y) em que (x,y) ainda serão definidos.
     * Como (x,y) ainda serão definidos eles são inicializados com um valor
     * inválido, para demonstrar que não estão inicializados.
     */
    public Coordinates(){
    this.x = -1;
    this.y = -1;
    }
    
    /** Inicializa um par ordenado (x,y) aleatório.
     */
    public void randomPosition(){
       Random rand1 = new Random();
       Random rand2 = new Random();
       this.x = rand1.nextInt(N_CELLS_COLUMN);
       this.y = rand2.nextInt(N_CELLS_ROW);
    }

    /** Verifica se uma célula (x,y) aleatória é valida para se inserir um 
     * objeto no tabuleiro.
     * Verifica se existe uma parede em uma célula (x,y) aleatória do tabuleiro.
     * @param Board
     */
    public void randomValidPosition(Board Board){
       Random rand1 = new Random();
       Random rand2 = new Random();
       
       this.x = rand1.nextInt(N_CELLS_COLUMN);
       this.y = rand2.nextInt(N_CELLS_ROW);
       
       while(!Board.cellValidation(x, y)){
       rand1 = new Random();
       rand2 = new Random();
       this.x = rand1.nextInt(N_CELLS_COLUMN);
       this.y = rand2.nextInt(N_CELLS_ROW);
       }
    }
    
    /** Retorna a coordenada x de uma célula.
     * @return a posição x (coluna) de uma célula no tabuleiro.
     */
    public int get_x_coordinate(){
        return this.x;
    }
    
    /** Retorna a coordenada y de uma célula.
     * @return a posição y (linha) de uma célula no tabuleiro.
     */
    public int get_y_coordinate(){
        return this.y;
    }
    
    /** Modifica a coordenada x de uma célula
     * @param px a coordenada x (coluna) a ser modificada.
     */
    public void set_x_coordinate(int px){
        this.x = px;
    }
    
    /** Modifica a coordenada y de uma célula
     * @param py a coordenada y (linha) a ser modificada.
     */
    public void set_y_coordinate(int py){
        this.y = py;
    }
    
    }

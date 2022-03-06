package pacmanEngine;


/** Define as constantes do jogo.
 * @author Ryan Braz Tintore Viana
 */

public interface gameConstants {
    
    public int levelData[][] = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
        {1,0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        
    };
    
    public static final String[] levelFiles = {"src/level/level0.txt"};
     
    /** Número de linhas do tabuleiro.
     */
    public static final int N_CELLS_ROW = 30;
    
    /** Número de colunas do tabuleiro.
     */
    public static final int N_CELLS_COLUMN = 30;
    
    public static final int CELL_WIDTH = 20;
    public static final int CELL_HEIGHT = 20;
    
    public static final int GAME_WIDTH = N_CELLS_ROW*CELL_WIDTH;
    
    public static final int GAME_HEIGHT = N_CELLS_COLUMN*CELL_HEIGHT;

    /** Número de pacdots no tabuleiro.
     */
    public static final int N_PAC_DOTS = 10;

    /** Número de pílulas de energia no tabuleiro.
     */
    public static final int N_ENERGY_PILLS = 10;

    /** Número de fruta bonus no tabuleiro.
     */
    public static final int N_FRUITS = 0;

    /** Valor de um pacdot no tabuleiro.
     */
    public static final int PAC_DOT_SCORE_VALUE = 10;

    /** Valor de uma pílula de energia no tabuleiro.
     */
    public static final int ENERGY_PILL_SCORE_VALUE = 50;

    /** Valor de uma cereja no tabuleiro.
     */
    public static final int CEREJA_SCORE_VALUE = 100;

    /** Valor de um morango no tabuleiro.
     */
    public static final int MORANGO_SCORE_VALUE = 300;

    /** Valor de uma laranja  no tabuleiro.
     */
    public static final int LARANJA_SCORE_VALUE = 500;

    /** Número de pacdots que precisam ser comidos para o spawn da primeira 
     * fruta.
     */
    public static final int FIRST_FRUIT_SPAWN = 70;

    /** Número de pacdots que precisam ser comidos para o spawn da segunda 
     * fruta.
     */
    public static final int SECOND_FRUIT_SPAWN = 170;
    

}

package pacmanEngine;

/** Define as constantes do jogo.
 * @author Ryan Braz Tintore Viana
 */

public interface gameConstants {
    
    /** Mapa dos respectivos níveis.
     */
    public static final String[] levelFiles = {"src/level/level0.txt","src/level/level1.txt","src/level/level2.txt","src/level/level3.txt"};
     
    /** Número de linhas do tabuleiro.
     */
    public static final int N_CELLS_ROW = 31;
    
    /** Número de colunas do tabuleiro.
     */
    public static final int N_CELLS_COLUMN = 31;
    
    /** Número de níveis do jogo.
     */
    public static final int N_LEVELS = 3;
    
    /** Largura de uma célula na interface gráfica.
     */
    public static final int CELL_WIDTH = 17;
    
    /** Altura de uma célula na interface gráfica.
     */
    public static final int CELL_HEIGHT = 17;
    
    /** Tamanho da tela auxiliar para contagem de pontos e vidas..
     */
    public static final int BOTTOM_SCREEN_HEIGHT = CELL_HEIGHT*3;
    
    /** Largura de todo o jogo na interface gráfica.
     */
    public static final int GAME_WIDTH = N_CELLS_ROW*CELL_WIDTH;
    
    /** Altura de todo o jogo na interface gráfica.
     */
    public static final int GAME_HEIGHT = (N_CELLS_COLUMN*CELL_HEIGHT)+BOTTOM_SCREEN_HEIGHT;

    /** Número de pacdots no tabuleiro.
     */
    public static final int N_PAC_DOTS = 240;

    /** Número de pílulas de energia no tabuleiro.
     */
    public static final int N_ENERGY_PILLS = 4;

    /** Número de fruta bonus no tabuleiro.
     */
    public static final int N_FRUITS = 2;

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
    
    /** Pontos quando se come o primeiro fantasma.
     */
    public static final int FIRST_EATEN_GHOST = 200;
    
    /** Tempo em que os fantasmas ficam sobre efeito da Pílula do Poder.
     */
    public static final int SECONDS_TO_EAT_GHOST = 8;
    
    /** Definição de nomes.
     */
    public static final String WAKA = "waka";
    public static final String HUNTER_GHOST = "hunterGhost";
    public static final String DUMB_GHOST = "dumbGhost";
    public static final String PACDOT = "pacDot";
    public static final String ENERGY_PILL = "energyPill";
    public static final String BONUS_FRUIT = "bonusFruit";
    public static final String GHOST = "ghost";
    public static final String BLINKY = "Blinky";
    public static final String CLYDE = "Clyde";
    public static final String PINKY = "Pinky";
    public static final String INKY = "Inky";
    public static final String ORANGE = "Orange";
    public static final String STRAWBERRY = "Strawberry";
    public static final String CHERRY = "Cherry";
    public static final String UP = "UP";
    public static final String DOWN = "DOWN";
    public static final String RIGHT = "RIGHT";
    public static final String LEFT = "LEFT";
    public static final String NONE = "NONE";

}

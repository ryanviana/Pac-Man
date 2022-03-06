package pacmanEngine;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import pacmanEntities.*;

/** A classe Board manipula o labirinto do jogo
 * @author Ryan Braz Tintore Viana
 */
public class Board implements gameConstants{

    /** O atributo gameBoard refere-se literalmente ao labirinto do jogo,
     * por objetos da classe BoardCell.
     */
    public BoardCell[][] gameBoard;

    /** Verifica se uma célula do labirinto é válida para se inserir um
     * elemento.
     *
     * @param xPosition posição x em que o elemento será inserido.
     * @param yPosition posição y em que o elemento será inserido.
     * @return se a célula é valida ou não.
     */    
    public boolean cellValidation(int xPosition, int yPosition){
    return ( xPosition >= 0 && yPosition >= 0 
             &&
             xPosition < N_CELLS_COLUMN && yPosition < N_CELLS_COLUMN
             &&
             (gameBoard[yPosition][xPosition]).getWall() == false );
    }
    
    /** Inicializa um objeto Waka no labirinto.
     * @return O objeto Waka que foi inicializado.
     */
    public Waka startWaka(){
        Waka waka = new Waka(this);
        return waka;
    }
    
    
    /** Inicializa um objeto DumbGhost no labirinto.
     * @param name nome do fantasma
     * @return O objeto DumbGhost que foi inicializado.
     */
    public DumbGhost startDumbGhost(String name){
        DumbGhost dumbGhost = new DumbGhost(this);
        dumbGhost.setName(name);
        return dumbGhost;
    }
    
    /** Inicializa um objeto HunterGhost no labirinto.
     * @param name nome do fantasma
     * @return O objeto HunterGhost que foi inicializado.
     */
    public HunterGhost startHunterGhost(String name){
        HunterGhost hunterGhost = new HunterGhost(this);
        hunterGhost.setName(name);
        return hunterGhost;
    }
    
    //inicializa um array de pacdots no labirinto

    /** Inicializa uma array de Pacdots no labirinto.
     * @return O array de Pacdots que foi inicializado.
     */
    public Pacdot[] startPacDots(){
        int i;
        Pacdot[] pacDotsArray = new Pacdot[N_PAC_DOTS];
        for(i=0;i<N_PAC_DOTS;i++){
        pacDotsArray[i] = new Pacdot(this);
        }
        return pacDotsArray;
    }
    
    /** Inicializa um array de pílulas de energia no labirinto.
     * @return O array de pílulas de energia que foi inicializado.
     */
    public EnergyPill[] startEnergyPills(){
        int i;
        EnergyPill[] energyPillsArray = new EnergyPill[N_ENERGY_PILLS];
        for(i=0;i<N_ENERGY_PILLS;i++){
        energyPillsArray[i] = new EnergyPill(this);
        }
        return energyPillsArray;
    }
    
    /** Inicializa uma fruta no labirinto.
     * @param level nível atual do jogo.
     * @return retorna a fruta criada.
     */
    public Fruit startFruits(int level){
            Fruit fruit = new Fruit(this, level);
            fruit.setFruitName(level);
            return fruit;
    }
        
    
    /** Realiza o update do labirinto do jogo, tanto por movimentação ou
     * inserção de um elemento.
     * O método deve ser usado após a inserção ou movimentação de um elemento.
     * @param Element Elemento que será atualizado no labirinto.
     */
    public void updateGameBoard(Element Element){

        switch (Element.get_id()) {
            case WAKA:
                this.gameBoard[Element.get_previous_yPosition()][Element.get_previous_xPosition()].setWaka(false);
                this.gameBoard[Element.get_yPosition()][Element.get_xPosition()].setWaka(true);
                break;
            case DUMB_GHOST:
                this.gameBoard[Element.get_previous_yPosition()][Element.get_previous_xPosition()].setDumbGhost(false);
                this.gameBoard[Element.get_yPosition()][Element.get_xPosition()].setDumbGhost(true);
                break;
            case HUNTER_GHOST:
                this.gameBoard[Element.get_previous_yPosition()][Element.get_previous_xPosition()].setHunterGhost(false);
                this.gameBoard[Element.get_yPosition()][Element.get_xPosition()].setHunterGhost(true);
                break;
            case PACDOT:
                this.gameBoard[Element.get_yPosition()][Element.get_xPosition()].setPacDot(true);
                break;
            case ENERGY_PILL:
                this.gameBoard[Element.get_yPosition()][Element.get_xPosition()].setEnergyPill(true);
                break;
            case BONUS_FRUIT:
                this.gameBoard[Element.get_yPosition()][Element.get_xPosition()].setBonusFruit(true);
                break;
            default:
                break;
        }
    
    }

    /** Inicializa um nível do arquivo texto.
     * @param fileName nome do arquivo texto que contém a informação do labirinto.
     */
    public void initializeLevel(String fileName) {
        gameBoard = new BoardCell[N_CELLS_ROW][N_CELLS_COLUMN];
        
        try{
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
            for(int i=0;i<N_CELLS_ROW;i++){
                for(int j=0;j<N_CELLS_COLUMN;j++){
                    gameBoard[i][j]= new BoardCell();
                    if(scanner.nextInt()==1){
                        gameBoard[i][j].setWall(true);
                    }  
                }
            }
        }
        catch(FileNotFoundException e){
            System.exit(0);
        }
    }
}

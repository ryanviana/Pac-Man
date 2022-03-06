package pacmanEngine;


/** Controle do Game.
 *  Contabilizar o andar o jogo, por exemplo: pílulas de energia comidas, vidas
 *  restantes...
 * @author Ryan Braz Tintore Viana
 */

public class gameControl implements gameConstants{

    /** Controla se o jogo ainda está em andamento.
     */
    private boolean inGame = false;

    /** Contabiliza as vidas restantes do pacman.
     */
    private int lives;

    /** Contabiliza o score do pacman.
     */
    private int score;

    /** Contabiliza os pacdots comidos pelo pacman.
     */
    private int eatenPacDots;

    /** Contabiliza as pílulas de energia comidos pelo pacman.
     */
    private int eatenEnergyPills;
    
    /** Inicializa um novo jogo.
     *  Inicia as variáveis com valores padrão, por exemplo, 3 vidas.
     */
    public void startGame(){
        lives = 3;
        score = 0;
        eatenPacDots = 0;
        eatenEnergyPills = 0;
        inGame = true;
    }
    /** Modifica se o jogo está ativo ou não.
     * @param inGame Inicia ou finaliza um jogo.
     */
    public void setInGame(boolean inGame){
    this.inGame = inGame;
    }
    
    /** Retorna se o jogo está ativo ou não.
     * @return retorna se o jogo está em andamento.
     */
    public boolean getInGame(){
    return inGame;
    }
    
     /** Modifica o número de vidas do pacman.
     * @param lives Adiciona ou remove o número de vidas do pacman.
     */
    public void addLives(int lives){
    this.lives += lives;
    }
    
    /** Retorna o número de vidas do pacman.
     * @return a quantidade de vidas restantes do pacman.
     */
    public int getLives(){
    return lives;
    }
    
    /** Modifica a quantidade de score do pacman.
     * @param score Adiciona a contagem de score do pacman.
     */
    public void addScore(int score){
    this.score += score;
    }
    
    /** Retorna a quantidade de score do pacman.
     * @return a quantidade de score do pacman.
     */
    public int getScore(){
    return score;
    }
    
    /** Modifica a quantidade de pacdots comidos pelo pacman.
     * @param eatenPacDots Adiciona a contagem de pacdots comidos pelo pacman.
     */
    public void addEatenPacDots(int eatenPacDots){
    this.eatenPacDots += eatenPacDots;
    score += gameConstants.PAC_DOT_SCORE_VALUE;
    }
    
    /** Retorna a quantidade de pacdots comidos pelo pacman.
     * @return a quantidade de pacdots comidos pelo pacman.
     */
    public int getEatenPacDots(){
    return eatenPacDots;
    }
    
    /** Modifica a quantidade de pílulas de energia comidos pelo pacman.
     * @param eatenEnergyPills Adiciona a contagem de pílulas de energia
     * comidos pelo pacman.
     */
    public void addEatenEnergyPills(int eatenEnergyPills){
    this.eatenEnergyPills += eatenEnergyPills;
    score += gameConstants.ENERGY_PILL_SCORE_VALUE;

    }
    
    /** Retorna a quantidade de pacdots comidos pelo pacman.
     * @return a quantidade de pacdots comidos pelo pacman.
     */
    public int getEatenEnergyPills(){
    return eatenEnergyPills;
    }
}



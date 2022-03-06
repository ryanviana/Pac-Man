package pacmanEngine;

import pacmanEntities.*;
import java.util.Timer;
import java.util.TimerTask;

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
    
    private int level;
    private int eatenGhosts = 0;
    private boolean winGame;
    private boolean winLevel;
    
    private Timer energyPillEffectTimer;
    private TimerTask finishEnergyPillEffect;
    private boolean energyPillEffect;
    
    /** Inicializa um novo jogo.
     *  Inicia as variáveis com valores padrão, por exemplo, 3 vidas.
     */
    public void startGame(){
        winGame = false;
        winLevel = false;
        level = 1;
        lives = 3;
        score = 0;
        eatenPacDots = 0;
        eatenEnergyPills = 0;
        inGame = true;
    }
    
     /** Termina o jogo.
     */
    public void endGame(){
        inGame = false;
    }
    
     /** Configura a vitória do nível.
     */
    public void winLevel(){
        winLevel = true;
        eatenPacDots = 0;
        eatenEnergyPills = 0;
        addLevel(1);
    }
    
     /** Configura a vitória do jogo.
     */
    public void winGame(){
        winGame = true;
        inGame = false;
    }
    
     /** 
      * @return se o jogo foi ganho.
     */
    public boolean didWinGame(){
        return winGame;
    }
    
     /**
      * @return se o nível foi ganho.
     */
    public boolean didWinLevel(){
        return winLevel;
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
    
     /** Adiciona um nível ao jogo.
     */
    private void addLevel(int level){
    this.level += level;
    }
    
    /** Retorna a quantidade de score do pacman.
     * @return a quantidade de score do pacman.
     */
    public int getScore(){
    return score;
    }
    
     /** 
      * @return o nível atual do jogo.
     */
    public int getLevel(){
    return level;
    }
    
    /** Modifica a quantidade de pacdots comidos pelo pacman.
     * @param eatenPacDots Adiciona a contagem de pacdots comidos pelo pacman.
     */
    public void addEatenPacDots(int eatenPacDots){
    this.eatenPacDots += eatenPacDots;
    score += gameConstants.PAC_DOT_SCORE_VALUE;
    }
    
    public void addEatenGhosts(){
    this.eatenGhosts += 1;
    }
    
    public int getEatenGhosts(){
        return eatenGhosts;
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
        energyPillEffect();

    }
    
     /** Ativa o efeito da Pílula do Poder.
     */
    private void energyPillEffect(){
        energyPillEffect = true;
        if(energyPillEffectTimer!=null){
            energyPillEffectTimer.purge();
            System.gc();
        }
        energyPillEffectTimer();
    }
    
     /** Temporizador do efeito da Pílula do Poder .
     */
    private void energyPillEffectTimer() {
        this.energyPillEffectTimer = new Timer();
        createEnergyPillEffectTask();
        energyPillEffectTimer.schedule(finishEnergyPillEffect, SECONDS_TO_EAT_GHOST*1000);
    }
    
     /** Adiciona frutas comidas no contador .
     */
    public void addEatenFruits(){
        if(level==1){
            score += CEREJA_SCORE_VALUE;
        }
        if(level==2){
            score += MORANGO_SCORE_VALUE;
        }
        if(level==3){
            score += LARANJA_SCORE_VALUE;
        }
    }
    
    /** Retorna a quantidade de pacdots comidos pelo pacman.
     * @return a quantidade de pacdots comidos pelo pacman.
     */
    public int getEatenEnergyPills(){
    return eatenEnergyPills;
    }
    
    /** .Verificação se o efeito da Pílula do Poder está ativo.
     * @return retorna true se o efeito estiver ativo e, caso contrário, retorna false.
     */
    public boolean getEnergyPillEffect(){
        return energyPillEffect;
    }
    
    /** Cria a tarefa para utilização no Timer.
     */
    private void createEnergyPillEffectTask(){
        finishEnergyPillEffect = new TimerTask() {
            @Override
            public void run() {
                energyPillEffect = false;
                energyPillEffectTimer.cancel();
            }
        };
    }
    
    /** Faz o update dos controles do game com base na movimentação do labirinto.
     * @param waka fantasma.
     * @param board tabuleiro.
     */
    public void updateGameControl(Waka waka, Board board){
        int col = waka.get_xPosition();
        int row = waka.get_yPosition();
        
        if((board.gameBoard[row][col].getWaka())&&(board.gameBoard[row][col].getHunterGhost())){
            if(getEnergyPillEffect()){
                addScore((((int) Math.pow(2,getEatenGhosts())))*FIRST_EATEN_GHOST);
                addEatenGhosts();
            }
            else{
                board.gameBoard[row][col].setHunterGhost(false);
                addLives(-1);
                if(getLives()==0){
                    endGame();
                }
            }
        }
        if((board.gameBoard[row][col].getWaka())&&(board.gameBoard[row][col].getDumbGhost())){
            if(getEnergyPillEffect()){
                board.gameBoard[row][col].setDumbGhost(false);
                addScore((((int) Math.pow(2,getEatenGhosts())))*FIRST_EATEN_GHOST);
                addEatenGhosts();
            }
            else{
                board.gameBoard[row][col].setDumbGhost(false);
                addLives(-1);
                if(getLives()==0){
                    endGame();
                }
            }
        }
        if((board.gameBoard[row][col].getWaka())&&(board.gameBoard[row][col].getPacDot())){
            board.gameBoard[row][col].setPacDot(false);
            addEatenPacDots(1);
        }
        if((board.gameBoard[row][col].getWaka())&&(board.gameBoard[row][col].getEnergyPill())){
            board.gameBoard[row][col].setEnergyPill(false);
            addEatenEnergyPills(N_ENERGY_PILLS);
        }
        if((board.gameBoard[row][col].getWaka())&&(board.gameBoard[row][col].getBonusFruit())){
            board.gameBoard[row][col].setBonusFruit(false);
            addEatenFruits();
        }
        if(getEatenPacDots()==N_PAC_DOTS){
            if(getLevel()==N_LEVELS)
                winGame();
            else
                winLevel();
        }
    }
}



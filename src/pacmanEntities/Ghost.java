package pacmanEntities;

import pacmanEngine.Board;

/** Representa os fantasmas.
 * @author Ryan Braz Tintore Viana
 */
public class Ghost extends Element {
    
    private String ghostName;
    private boolean eatable;
    
    Ghost(Board Board){
    super(Board);
    this.identity = "ghost";
    this.eatable = false;
    }
    

    /**
     *
     * @param pGhostName
     */
    public void setGhostName(String pGhostName){
       this.ghostName = pGhostName;
    }
    
    /** Retorna o nome do fantasma.
     * Os fantasma tem nomes, por exemplo: Clyde, Blinky.
     * @return
     */
    public String getGhostName(){
        return this.ghostName;
    }
    
    /** Modifica a velocidade de um fantasma.
     * @param speed Quanto será adicionado ou removido da velocidade do 
     * fantasma.
     */
    public void addSpeed(int speed){
        this.speed += speed;
    }
    
    /** Ativa e desativa o efeito da pílula de energia nos fantasmas.
     * @param bool
     */
    public void setEnergyPillEffect(boolean bool){
        this.eatable = bool;
    }
}

package pacmanEngine;


/** A classe BoardCell é o elemento fundamental do tabuleiro, cada posição é 
 * representada por uma BoardCell.
 * Tem a funcionalidade de informar quais elementos estão presentes em
 * determinada posição do tabuleiro. 
 * @author Ryan Braz Tintore Viana
 */

public class BoardCell{
    private boolean waka, dumbGhost, hunterGhost, pacDot, energyPill, bonusFruit, wall;
   
    /** Inicializa uma BoardCell vazia.
     */
    public BoardCell(){
this.waka = false;
this.dumbGhost = false;
this.hunterGhost = false;
this.pacDot = false;
this.energyPill = false;
this.bonusFruit = false;
this.wall = false;
}

    /** Modifica se uma célula tem ou não uma parede.
     * @param bool
     */
    public void setWall(boolean bool){
    this.wall = bool;
}

    /** Modifica se uma célula tem ou não um pacman.
     * @param bool tem valor verdadeiro caso exista um pacman e falso se não 
     * houver.
     */
    public void setWaka(boolean bool){
    this.waka = bool;
}

    /** Modifica se uma célula tem ou não um fantasma com movimento aleatório.
     * @param bool tem valor verdadeiro caso exista um fantasma e falso se não 
     * houver.
     */
    public void setDumbGhost(boolean bool){
    this.dumbGhost = bool;
}

    /** Modifica se uma célula tem ou não um fantasma que caça o pacman.
     * @param bool tem valor verdadeiro caso exista um fantasma e falso se não 
     * houver.
     */
    public void setHunterGhost(boolean bool){
    this.hunterGhost = bool;
}

    /** Modifica se uma célula tem ou não um pacdot.
     * @param bool tem valor verdadeiro caso exista um pacdot e falso se não 
     * houver.
     */
    public void setPacDot(boolean bool){
    this.pacDot = bool;
}

    /** Modifica se uma célula tem ou não uma pílula de energia.
     * @param bool tem valor verdadeiro caso exista uma pilula de 
     * eneregia e falso se não houver
     */
    public void setEnergyPill(boolean bool){
    this.energyPill = bool;
}

    /** Modifica se uma célula tem ou não uma fruta bonus.
     * @param bool tem valor verdadeiro caso exista uma fruta e falso se não 
     * houver.
     */
    public void setBonusFruit(boolean bool){
    this.bonusFruit = bool;
}

    /** Retorna se uma célula tem ou não uma parede.
     * @return verdadeiro se houver uma parede e falso se não houver.
     */
    public boolean getWall(){
    return this.wall;
}

    /** Retorna se uma célula tem ou não um pacman.
     * @return verdadeiro se houver um pacman e falso se não houver.
     */
    public boolean getWaka(){
    return this.waka;
}

    /** Retorna se uma célula tem ou não um fantasma com movimento aleatório.
     * @return verdadeiro se houver um fantasma com movimento aleatório
     * e falso se não houver.
     */
    public boolean getDumbGhost(){
        return this.dumbGhost;
}

    /** Retorna se uma célula tem ou não um fantasma com movimento predatório.
     * @return verdadeiro se houver um fantasma com movimento predatório
     * e falso se não houver.
     */
    public boolean getHunterGhost(){
    return this.hunterGhost;
}

    /** Retorna se uma célula tem ou não um pacdot.
     * @return verdadeiro se houver um pacdot e falso se não houver.
     */
    public boolean getPacDot(){
    return this.pacDot;
}

    /** Retorna se uma célula tem ou não uma pílula de energia.
     * @return verdadeiro se houver uma pílula de energia e falso se não houver.
     */
    public boolean getEnergyPill(){
    return this.energyPill;
}

    /** Retorna se uma célula tem ou não uma fruta bonus.
     * @return verdadeiro se houver uma fruta bonus e falso se não houver.
     */
    public boolean getBonusFruit(){
    return this.bonusFruit;
}
    

}

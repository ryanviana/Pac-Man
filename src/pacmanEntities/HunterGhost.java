package pacmanEntities;

import pacmanEngine.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/** Representa o fantasma que caça o pacman.
 * @author Ryan Braz Tintore Viana
 */
public class HunterGhost extends Ghost implements gameConstants{
    
    /** Instancia o fantasma no tabuleiro.
     * @param Board tabuleiro em que o fantasma será instanciado.
     */
    public HunterGhost(Board Board){
        super(Board);
        this.identity = "hunterGhost";
        this.speed = 1;
        Board.updateGameBoard(this);
    }
    
    
    private ArrayList<Coordinates> BFS_Algorithm(BoardCell[][] Board, Waka Waka){
    //BSF Algorithm adaptado para funcionar em uma matriz.
        
        //utiliza-se duas filas para fazer o controle de quais células precisamos visitar
        int row, column;
        int i,j;
        Queue<Integer> row_queue = new LinkedList<>();
        Queue<Integer> column_queue = new LinkedList<>();

        boolean reached_waka = false;
        
        //teremos duas matrizes auxiliares, uma que irá dizer quais celulas já visitamos
        //no algoritmo e outra que vai guardar o percurso, ou seja, as coordenadas (x,y) que 
        //levam do fantasma até o pacman.
        boolean[][] visited = new boolean[N_CELLS_ROW][N_CELLS_COLUMN];
        Coordinates[][] previous_nodes = new Coordinates[N_CELLS_ROW][N_CELLS_COLUMN];
        
        //inicializando a matriz de coordenadas
        for(i=0;i<N_CELLS_ROW;i++){
            for(j=0;j<N_CELLS_COLUMN;j++){
                previous_nodes[i][j] = new Coordinates(-1,-1);
            }
        }
        
        //inicializando as direções posições para o pacman andar (esuqerda, direita, baixo, cima).
        int direction_row[] = {-1,1,0,0};
        int direction_column[] = {0,0,1,-1};
        
        //algoritmo propriamente dito. Primeiro iremos analisar a posição atual do fantasma,
        //se ele já estiver na mesma posição que o pacman, não precisaremos continuar.
        //caso não esteja, os vizinhos (cima,baixo,direita,esquerda) serão analisado em seguida.
        row_queue.add(this.yPosition);
        column_queue.add(this.xPosition);
        visited[this.yPosition][this.xPosition] = true;
        while(row_queue.size() > 0){
            
            row = row_queue.remove();
            column = column_queue.remove();
            
            if(Board[row][column].getWaka() == true){
                reached_waka = true;
                break;
            }
            
            //análise dos vizinhos.
            int r_row,c_column;
            //up,down,left,right.
            for(i=0;i<4;i++){
                
                r_row = row + direction_row[i];
                c_column = column + direction_column[i];
               
                //validação da célula
                if(r_row < 0 || c_column < 0) continue;
                if(r_row >= N_CELLS_ROW || c_column >= N_CELLS_COLUMN) continue;
                //se for uma celula ja visita, não será revisitada.
                if(visited[r_row][c_column]) continue;
                //se tiver uma parede ou outro fantasma não será visitada.
                //isso para os fantasma não se sobreporem.
                if(Board[r_row][c_column].getWall()) continue;
                if(Board[r_row][c_column].getHunterGhost()) continue;
                if(Board[r_row][c_column].getDumbGhost()) continue;
                
                //caso passe nas validações, vai adicionar o nó na fila e na matriz de percurso.
                row_queue.add(r_row);
                column_queue.add(c_column);
                visited[r_row][c_column] = true;
                previous_nodes[r_row][c_column].set_x_coordinate(column);
                previous_nodes[r_row][c_column].set_y_coordinate(row);
            }
        }
        
        //Após o algoritmo encontrar o pacman, iremos reconstruir o caminho.
        //criamos uma arraylist do tipo coordenadas para guardar o caminho.
        ArrayList<Coordinates> path = new ArrayList<>();
        
        //as coordenadas inicias devem ser a do fantasma.
        Coordinates startCoords = new Coordinates(this.xPosition,this.yPosition);
        //as coordenadas finais devem ser o pacman.
        Coordinates endCoords = new Coordinates(Waka.xPosition,Waka.yPosition);
        //variavel auxiliar para o ciclo for.
        Coordinates atualCoords;        
       
        //o caminho é reconstruido partindo do pacman até o fantasma.
        for(atualCoords = endCoords; atualCoords != startCoords;
            atualCoords = previous_nodes[atualCoords.get_y_coordinate()][atualCoords.get_x_coordinate()]){
                        
            if(atualCoords.get_x_coordinate() == -1) break;
            
            path.add(atualCoords);
        
        }

        //revertemos a arraylist para que torne-se do fantasma até o pacman.
        Collections.reverse(path);

        return path;
        
    }
    
    /** Movimentação do fantasma baseado na posição do pacman.
     * @param Waka pacman no tabuleiro.
     * @param Board tabuleiro em que está acontecendo o jogo.
     */
    public void moveCell(Waka Waka, Board Board){
    
        int i;
        
        //iniciamos um par ordenado de coordenadas (x,y) que irá definir o próximo movimento
        Coordinates nextMove;
        //a partir do método BFS encontramos o menor caminho entre o fantasma e o waka(pacman).
        ArrayList<Coordinates> path = this.BFS_Algorithm(Board.gameBoard, Waka);
        
        //baseado na velocidade do fantasma iremos movimenta-lo.
        
        //o ciclo for começa com 1 pois a primeira posição do array "path" é a posição em que o fantasma
        //já está.
        for(i=1;i<=this.speed;i++){
        nextMove = path.get(i);
        this.previous_xPosition = this.xPosition;
        this.previous_yPosition = this.yPosition;
        this.xPosition = nextMove.get_x_coordinate();
        this.yPosition = nextMove.get_y_coordinate();
        Board.updateGameBoard(this);

        }
        
    }    
    

   
    }


    
    
    
    


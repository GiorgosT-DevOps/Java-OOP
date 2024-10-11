/**
 * This class provides the methods that are required to play the Game of Life
 * 
 * @author Giorgos Tomaras
 * @version 1.0
 */
import java.util.*;
public class EPL133LifeGame{
/**
 * The method initGrid initializes the grid of cells in two cases. In 1st case, the grid is initialized
 * by the user who plays the Game of Life. In 2nd case the game is initialized automatically randomly.
 * 
 * @param rows
 * @param cols
 * @param c
 */
    public static void initGrid(int rows, int cols, Cell[][] c){
        //Option 1 or 2, initialization of grid, manually or randomly - automatically
        int option ;
        //The current situation of a random cell. Alive or dead.
        char situation ;
        Scanner s1 = new Scanner(System.in) ;
            System.out.println("Options to initialize the grid: ");
            System.out.println("Option 1: Manual Initialization");
            System.out.println("Option 2: Automate and Random Initialization");
            System.out.println("_________________");
            System.out.println("Enter 1 or 2");
            option  = s1.nextInt();
            while(option!=1 && option!=2){
                System.out.println("Wrong Input!\n");
                System.out.println("Options to initialize the grid: ");
                System.out.println("Option 1: Manual Initialization");
                System.out.println("Option 2: Automate and Random Initialization");
                System.out.println("_________________");
                System.out.println("Enter 1 or 2");
                option = s1.nextInt();
            }
            //Manual Initialization
            if(option == 1){
                for(int i=0; i<rows; i++)
                    for(int j=0; j<cols; i++){
                        System.out.println("Options to initialize a cell: ");
                        System.out.println("For alive: #");
                        System.out.println("For dead: -");
                        System.out.println("_________________");
                        System.out.println("Enter # for alive or - for dead");
                        situation = s1.next().charAt(0);
                        while(situation!='#' || situation!='-'){
                            System.out.println("Wrong Input\n");
                            System.out.println("Options to initialize a cell: ");
                            System.out.println("For alive: #");
                            System.out.println("For dead: -");
                            System.out.println("_________________");
                            System.out.println("Enter # for alive or - for dead");
                            situation = s1.next().charAt(0);
                            
                        }
                        c[i][j] = new Cell(situation);
                    }
                //Random initialization
            }
            else if(option == 2){
                for(int i=0; i<rows; i++)
                    for(int j=0; j<rows; j++){
                        c[i][j] = new Cell();
                    }
                
            }
        
    }
/**
 * The display method displays the current situation of the grid after a modify.
 *  
 * @param rows
 * @param cols
 * @param c
 */
    public static void display(int rows, int cols, Cell[][] c){
        for(int i=0; i<rows; i++){
            //Multiplied by 5, as each object takes 5 chars.
            for(int j = 0; j<cols*5; j++){
                System.out.print("-");
            }
            System.out.println();
            for(int j=0; j<cols; j++){
                System.out.print(c[i][j].toString());
                if(j==cols-1){
                    System.out.print(" | ");
                }
            }
            System.out.println(); 
        }
    }
/**
 * The method play, provides the game play, 
 * It checks how many cells have changed  from the user and if it reached the maximum number of modifications 
 * then, the program asks the user if he want to terminate the game, or play from the begin.
 * The same time it makes the appropriate compares if a cell is dead or alive.
 * 
 * @param rows
 * @param cols
 * @param c
 */
    public static void play(int rows, int cols, Cell[][] c){
        //Grid of cells to copy the (n+1)nd generation. This helps to catch afterwards the next generation.
        Cell[][] c1 = new Cell[rows][cols];
        //Initialize the c1[][] randomly
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                c1[i][j] = new Cell();
            }
        }
        //Num of neighbour alive cells
        int alive_cnt = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                //Checking inside the sides and the corners
                if(i!=0 && j!=0 && i!=rows-1 && j!=cols-1){
                    if(c[i-1][j-1].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i-1][j].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i-1][j+1].getCell()=='#')
                        alive_cnt++;

                    if(c[i][j-1].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i][j+1].getCell()=='#')
                        alive_cnt++;

                    if(c[i+1][j-1].getCell()=='#')
                        alive_cnt++;
                   
                    if(c[i+1][j].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i+1][j+1].getCell()=='#')
                        alive_cnt++;
                }
                //Checking inside corners of first row
                else if(i==0 && j!=0 && j!=cols-1){
                    if(c[i][j-1].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i][j+1].getCell()=='#')
                        alive_cnt++;

                    if(c[i+1][j-1].getCell()=='#')
                        alive_cnt++;
                   
                    if(c[i+1][j].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i+1][j+1].getCell()=='#')
                        alive_cnt++;
                }
                //Checking inside the corners of last row
                else if(i==rows-1 && j!=0 && j!=cols-1){
                    if(c[i-1][j-1].getCell()=='#')
                        alive_cnt++;
                
                    if(c[i-1][j].getCell()=='#')
                        alive_cnt++;
                
                    if(c[i-1][j+1].getCell()=='#')
                        alive_cnt++;

                    if(c[i][j-1].getCell()=='#')
                        alive_cnt++;
                
                    if(c[i][j+1].getCell()=='#')
                        alive_cnt++;
                    
                }
                //Checking inside the corners of first column.
                else if(j==0 && i!=0 && i!=rows-1){
                    if(c[i-1][j].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i-1][j+1].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i][j+1].getCell()=='#')
                        alive_cnt++;

                    if(c[i+1][j].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i+1][j+1].getCell()=='#')
                        alive_cnt++;
                    
                }
                //Checking inside the corners of last column.
                else if(j==cols-1 && i!=0 && i!=rows-1){
                    if(c[i-1][j-1].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i-1][j].getCell()=='#')
                        alive_cnt++;

                    if(c[i][j-1].getCell()=='#')
                        alive_cnt++;

                    if(c[i+1][j-1].getCell()=='#')
                        alive_cnt++;
                   
                    if(c[i+1][j].getCell()=='#')
                        alive_cnt++;
                    
                }
                //Checking the top left corner
                else if(j==0 && i==0){
                    
                    if(c[i][j+1].getCell()=='#')
                        alive_cnt++;

                    if(c[i+1][j].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i+1][j+1].getCell()=='#')
                        alive_cnt++;
                }
                //Checking the top right corner
                else if(i==0 && j==cols-1){
                    
                    if(c[i][j-1].getCell()=='#')
                        alive_cnt++;

                    if(c[i+1][j-1].getCell()=='#')
                        alive_cnt++;
                   
                    if(c[i+1][j].getCell()=='#')
                        alive_cnt++;
                }
                //Checking the bottom left corner
                else if(i==rows-1 && j==0){
                   
                    if(c[i-1][j].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i-1][j+1].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i][j+1].getCell()=='#')
                        alive_cnt++;
                   
                }
                //Checking the bottom right corner
                else if(i==rows-1 && j==cols-1){
                    if(c[i-1][j-1].getCell()=='#')
                        alive_cnt++;
                    
                    if(c[i-1][j].getCell()=='#')
                        alive_cnt++;
                
                    if(c[i][j-1].getCell()=='#')
                        alive_cnt++;
                }
                if(c[i][j].getCell() == '#'){
                    if(alive_cnt<2)
                        c1[i][j].setCell('-');
                    
                    else if(alive_cnt==2 || alive_cnt==3)
                        c1[i][j].setCell('#');

                    else if(alive_cnt>3)
                        c1[i][j].setCell('-');

                }
                else if(c[i][j].getCell() == '-'){

                    if(alive_cnt==3)
                        c1[i][j].setCell('#');
                    
                    else
                        c1[i][j].setCell('-');

                }

                alive_cnt = 0;
            }
        }

        //Update the array with the n+1 generation
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                //The (n+1)nd generation
                c[i][j].setCell(c1[i][j].getCell());
            }
        }

    }

}
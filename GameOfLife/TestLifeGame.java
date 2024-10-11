import java.util.*;
/**
 * The TestLifeGame class contains the main method that initiates and runs 
 * the Game of Life simulation. It serves as the entry point to the program, 
 * where the grid of cells is initialized, and the play method is called to 
 * simulate the evolution of the grid through multiple generations.
 * 
 * This class is responsible for setting up the initial game state and 
 * calling the necessary methods to progress through the game iterations.
 * It does not contain any other game logic or methods, as those are handled 
 * by other classes.
 * 
 * @author Giorgos Tomaras
 * @version 1.0
 */
 
public class TestLifeGame{
    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
            int NUMC ;
            int NUMR ;
            int MAXNUMC = 60, MAXNUMR = 30;
            //Max number of generations
            int MAX_MOD = 40;
            //Number of generations to create
            int modnum ;
            //index of current generation
            int current_gen=1;
            //Input of user 
            String command ;
            //input to terminate the game or restart
            String stop_game;
            System.out.println("Give the size of grid");
            System.out.println("Give the number of columns");
            NUMC = s.nextInt();
            //Input check
            while(NUMC>MAXNUMC){
                System.out.println("Value out of the allowed limit");
                System.out.println("Give the number of columns");
                NUMC = s.nextInt();
            }   System.out.println("Give the number of rows");
            NUMR = s.nextInt();
            //Input check
            while(NUMR>MAXNUMR){
                System.out.println("Value out of the allowed limit");
                System.out.println("Give the number of rows");
                NUMR = s.nextInt();
            }   Cell[][] c = new Cell[NUMR][NUMC];
            EPL133LifeGame.initGrid(NUMR, NUMC, c);
            System.out.println("Give the number of generations to create:");
            modnum = s.nextInt();
            //Input check
            while(modnum>MAX_MOD){
                System.out.println("Value out of the allowed limit\n");
                System.out.println("Give the number of generations to create:");
                modnum = s.nextInt();
            }   System.out.println("Press start, to play the Game of Life");
            command = s.next();
            //Input check
            while(!command.equals("start")){
                System.out.println("Wrong Input\n");
                System.out.println("Press start, to play the Game of Life");
                command = s.next();
            }   System.out.println("Generation " + current_gen + " computed.");
            EPL133LifeGame.display(NUMR, NUMC, c);
            while(current_gen<=modnum){
                System.out.println("Press a command");
                command = s.next();
                //Input check
                while(!command.equals("help") && !command.equals("stop") && !command.equals("next")){
                    System.out.println("Wrong Input\n");
                    System.out.println("Press a command");
                    command = s.next();
                }
                while(command.equals("help")){
                    System.out.println("Options:");
                    System.out.println("Option 1: Press <next>, for next generation");
                    System.out.println("Option 2: Press <stop>, to eliminate(y) or to play from the begin(n)");
                    command = s.next();
                }
                
                if(command.equals("next")){
                    EPL133LifeGame.play(NUMR, NUMC, c);
                    current_gen++;
                    System.out.println("Generation " + current_gen + " computed.");
                    EPL133LifeGame.display(NUMR, NUMC, c);
                    
                }
                
                if(command.equals("stop") || current_gen==modnum){
                    System.out.println("To eliminate(y) or to play from the begin(n)");
                    stop_game = s.next();
                    while(!stop_game.equals("y") && !stop_game.equals("n")){
                        System.out.println("Wrong Input\n");
                        System.out.println("To eliminate(y) or to play from the begin(n)");
                        stop_game = s.next();
                    }
                    if(stop_game.equals("y")){
                        System.out.println("Game Over!");
                        System.exit(0);
                    }
                    else if(stop_game.equals("n")){
                        current_gen = 1;
                        EPL133LifeGame.initGrid(NUMR, NUMC, c);
                        System.out.println("Give the number of generations to create:");
                        modnum = s.nextInt();
                        while(modnum>MAX_MOD){
                            System.out.println("Value out of the allowed limit\n");
                            System.out.println("Give the number of generations to create:");
                            modnum = s.nextInt();
                        }
                        System.out.println("Press start, to play the Game of Life");
                        command = s.next();
                        while(!command.equals("start")){
                            System.out.println("Wrong Input\n");
                            System.out.println("Press start, to play the Game of Life");
                            command = s.next();
                        }
                        System.out.println("Generation " + current_gen + " computed.");
                        EPL133LifeGame.display(NUMR, NUMC, c);
                        
                    }
                }
                
                
            }
        
    }
}
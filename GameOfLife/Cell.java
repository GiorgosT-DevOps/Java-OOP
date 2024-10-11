/**
 * The class Cell provides the properties of a cell in the Game of
 *  Life and the methods to access and modify them. 
 * 
 * @author Giorgos Tomaras
 * @version 1.0
 */
public class Cell {
    //Properties
     private char cell;


    //Constructors
     public Cell(){
        if(Math.random()<=0.5){
            this.cell = '#';
        }
        else{
            this.cell = '-';
        }

     }
     public Cell(char cell){
        this.cell  = cell;
     }


     //Access & get the value of cell
     public char getCell(){
        return this.cell;
     }


     //Access and modify the value of cell
     public void setCell(char cell){
        this.cell = cell;
     }

     //printing the situation of the current cell
     @Override
     public String toString(){
        return " | " + this.cell ;
     }

}

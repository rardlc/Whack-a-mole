/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whackamole;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Roby
 */
public final class WhackAMole {
    
    int score = 0;
    int molesLeft = 0;
    int attemptsLeft = 0;
    
    char[][] moleGrid;
    public WhackAMole(int numAttempts, int gridDimension, int moles){
        attemptsLeft = numAttempts;
        moleGrid = new char[gridDimension][gridDimension];
            for (int y = 0; y<moles; y++){
                place(randomInt(gridDimension),randomInt(gridDimension));
                molesLeft = molesLeft + 1;}
            
        Scanner sc=new Scanner(System.in);
        while (attemptsLeft > 0){
            System.out.println("");
            System.out.println("Enter the x coordinate of where you want to whack");
            int x=sc.nextInt() -1;
            System.out.println("Enter the y coordinate of where you want to whack");
            int y=sc.nextInt() - 1;
            if ((x == -2) && (y == -2)){
                System.out.println("You've surrendered");
                System.out.println(score);
                displayGrid();
                break;
            
            } 
            whack(x,y);
            printGridToUser();
            System.out.println("");
            System.out.println("You have " + attemptsLeft + " attempts left");
            if (molesLeft <= 0){
                System.out.println("You've wacked them all!");
                break;
                
}
        }


    }
    public boolean place(int x, int y){
        boolean ifTrue = moleGrid[x][y] == 'M';
        if (ifTrue) {
            return false;}
        else {
            moleGrid[x][y] = 'M';
            molesLeft = molesLeft + 1;
            System.out.println("Placed a mole!");
            return true;
        }
    }
    public void whack(int x, int y){
        if (moleGrid[x][y] == 'M'){
        System.out.println("You've whacked a mole!");
        moleGrid[x][y] = 'W';
        score = score + 1;
        molesLeft = molesLeft - 1;
        attemptsLeft = attemptsLeft - 1;
        }else{
        attemptsLeft = attemptsLeft - 1;
        }
    }
    public void printGridToUser(){
        for (char[] i: moleGrid){
            System.out.println("");
            for (char j: i){
                if (j == 'M'){
                    System.out.print("|");}
                else{
                    System.out.print(j + "|");
                }
            }
        }
    }

    public void displayGrid(){
        for (char[] i: moleGrid){
            System.out.println("");
            for (char j: i){
                System.out.print(j + "|");
            }
        }
    }
    public int randomInt(int gridDimension){
        Random rand = new Random();
        int  n = rand.nextInt(gridDimension);
        return n;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WhackAMole game = new WhackAMole(50,10,10);

    }
    
    private void If(char c) {
        throw new UnsupportedOperationException("Not s1upported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

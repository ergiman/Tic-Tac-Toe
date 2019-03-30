package Askisi8;

import java.util.Arrays;
import java.util.Scanner;

public class Askisi8 {
   static String[] board;
   Boolean win;
   static String WinnerCheck(){
      for(int i=0;i<8;i++){
          String check="smthing";
          switch (i) {
            case 0:
		check = board[0]+board[1]+board[2];
                    break;
            case 1:
		check = board[3]+board[4]+board[5];
                    break;
            case 2:
                check = board[6]+board[7]+board[8];
                    break;
            case 3:
		check = board[0]+board[3]+board[6];
                    break;
            case 4:
		check = board[1]+board[4]+board[7];
                    break;
            case 5:
		check = board[2]+board[5]+board[8];
                    break;
            case 6:
		check = board[0]+board[4]+board[8];
                    break;
            case 7:
                check = board[2]+board[4]+board[6];
                    break;
			}
            if (check.equals("XXX")) {
		return "X";
            }else if (check.equals("OOO")) {
		return "O";
            }
      }
            for(int i=0;i<9;i++){
                if (Arrays.asList(board).contains(String.valueOf(i+1))) {
			break;
		}
		else if (i==8) return "draw";
            }
      
      return null;
   }
      
   static void printBoard(){
    System.out.println("|---|---|---|");
    System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
    System.out.println("|-----------|");
    System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
    System.out.println("|-----------|");
    System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
    System.out.println("|---|---|---|");
   } 
    public static void main(String[] args) {
        board=new String[9];
        System.out.println("Welcome to Tic-Tac-Toe\n");
        for(int i=0;i<9;i++){
            board[i]=String.valueOf(i+1);
        }
        System.out.println("The board looks like this:");
        printBoard();
        String winner;
        int input1,input2=50,i=0; //input1=X input2=O//
        do{
            do{
           System.out.println("Player1 it's your turn,enter the slot number"
                   +" between 1 and 9 you wish to place X:");
           do{
           Scanner in=new Scanner(System.in);
           input1=in.nextInt();
           if(board[input1-1]=="X" || board[input1-1]=="O")
               System.out.println("that slot is taken,choose another one");
           }while(board[input1-1]=="X" || board[input1-1]=="O");
            }while(!(input1>0 && input1<=9));
           board[input1-1]="X";
           printBoard();
           winner=WinnerCheck();
           if(winner=="X"){
               System.out.println("The winner is...Player1!");
           }else if(winner=="draw"){
               System.out.println("Draw!");
           }
           if(!(winner=="X" || winner=="draw")){
           do{
           System.out.println("Player2 it's your turn,enter the slot number"
                   + " between 1 and 9 you wish to place 0:");
           do{
           Scanner in=new Scanner(System.in);
           input2=in.nextInt();
           if(board[input2-1]=="X" || board[input2-1]=="O")
               System.out.println("that slot is taken,choose another one");
           }while(board[input2-1]=="X" || board[input2-1]=="O");
            }while(!(input2>0 && input2<=9) && !(winner=="X" || winner=="draw"));
           board[input2-1]="O";
           printBoard();
           winner=WinnerCheck();
           if(winner=="O"){
               System.out.println("The winner is...Player2!");
           }
           }                       
         }while(winner==null);
                
        }
}
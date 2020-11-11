import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class KnockOut1{

  static int player1[] = {1,2,3,4,5,6,7,8,9,10,11,12};  //created static array for player1
  static int player2[] = {1,2,3,4,5,6,7,8,9,10,11,12}; //created static array for player1
  static int countDash1 = 0 ; //it will count dashes need to create for player1
  static int countDash2 = 0 ; ////it will count dashes need to create for player1


  // dynamic array for both the players which will keep the knocked out values.
  static ArrayList<Integer>index1 = new ArrayList<Integer>(12); 
  static ArrayList<Integer>index2 = new ArrayList<Integer>(12);
 
  static int dice1 , dice2 ; //we kept it static so that we can acccess it from static context 
 

  // this function will generate a random values from 1 to 6 and store them in dice 1 and dice2.
  static void takeTurn(int values[] )
  {
        Random rand = new Random();

             dice1 = rand.nextInt(6)+1; // 1 to 6 
             dice2 = rand.nextInt(6)+1;

        System.out.print("Rolled Dices are "+dice1+" and "+dice2);

  }
//this is the function for player1 taking names of both the palyer as paramneters 
  static boolean player1(String firstPlayer , String secondPlayer ){

//created a scanner object
    Scanner sc = new Scanner(System.in);
 
 /* it will check the size of index1 array whether is greater than or equal 12 or not 
 because if it is true that means we have knocked out all the values of the player1 so player has won 
 the game and we will return a status true so  that we can break the loop in the main method */

          if( (index1.size()) >= 12) {
              System.out.println("\n"+ firstPlayer +" has won the game...!! " ); 
              return true ; 
          }
          else if((index2.size()) >= 12)
          {
              System.out.println("\n" + secondPlayer +" has won the game...!! " );
              return true ; 
          }
//if above condition fails then first player will play his game 
    System.out.println("\n"+firstPlayer+"'s Turn....");
// calling takeTurn method for the random genatered dice values 
    takeTurn(player1);

    boolean flag1 = false ;
/*loop to the length of the player1 since at first countDash = 0 so innerloop will not be 
 executed but when it will play for next turn then countDashh will be incremented as then 
 dash will be created at the index i */
    System.out.print("\nRemaining:");
    for(int i = 0 ; i<player1.length ; i++){

          for(int j = 0 ; j < countDash1 ; j++){
               flag1 = false ;
              if(index1.get(j).equals(player1[i]) )
              {
                System.out.print(" __ ");
                flag1 = true ;
                break;
              }

       }
  /* if flag1 = true that means we have already created a dash in place of value
   So no need to print that value , that's why we will skip that index using continue statement */
       if(flag1 )continue;
         System.out.print(player1[i]+" ");
    }

    // taking a knockout value from the user   
    System.out.print("\nKnock Out "+dice1+","+dice2+" or "+(dice1+dice2)+"?? ");

    int knockOutValue1 = sc.nextInt();
    /* if the entered knockedout value is already present in the index1 array that means we have knocked 
        that value so turn will be moved to the next palyer */
    if(!(index1.contains(knockOutValue1))) {
   

    /* looping until the last element of the player1  , it will match each value of player1 with the 
    entered knocked out value , if it matches then we will push the index value exceeds by 1 in the index 
    array , for example knocked out value is 7 then it will be found at index 6 in the palyer1 array that's 
    we will store 6+1 =7 in the indexx1 array and will increment the countDash value so that next time aanother 
    value store at next position instead of replacing the already existing value */

    for(int i = 0 ; i<player1.length ; i++) {

       if(player1[i] == knockOutValue1)
         {
            index1.add( countDash1++ , i+1);
         }
    }

}

// if knocked value already present this else case will satisfy by moving the turn to next palyer 
    else{
 
      System.out.println("\nThis has been knockedOut already\n\nMoving to the next player...!!");
      player2(secondPlayer,firstPlayer);
    }
 // returning a status false , that will indicate player1 hasn't win yet so no need to terminate the loop
return false ;

  }
// similarly implemented for player2 
  static boolean player2(String secondPlayer , String firstPlayer)
  {
    
    Scanner sc = new Scanner(System.in);  // Create a Scanner object
    
           if( (index1.size()) >= 12) {
              System.out.println("\n"+firstPlayer +" has won the game...!! " ); 
              return true ; 
          }
          else if( (index2.size()) >= 12)
          {
              System.out.println("\n"+secondPlayer +" has won the game...!! " );
              return true ; 
          }
    System.out.println("\n\n"+secondPlayer+"'s Turn....");
    takeTurn(player2);

    boolean flag2 = false ;
    System.out.print("\nRemaining:");
    for(int i = 0 ; i<player2.length ; i++){

          for(int j = 0 ; j < countDash2 ; j++){
               flag2 = false ;
              if(index2.get(j).equals(player1[i]))
              {
                System.out.print(" __ ");
                flag2 = true ;
                break;
              }
       }

       if(flag2) continue;
       System.out.print(player2[i]+" ");

     }

        System.out.print("\nKnock Out "+dice1+","+dice2+" or "+(dice1+dice2)+"?? ");
    int knockOutValue2 = sc.nextInt();

    if(!(index2.contains(knockOutValue2))) {
   
    for(int i = 0 ; i<player2.length ; i++) {
    //  int j = 0 ;
       if(player2[i] == knockOutValue2)
         {
              index2.add( countDash2++ , i+1);
            //  countDash2++;
         }
    }
 }
 else{
   System.out.println("\nThis has been knockedOut already\n\nMoving to the next player...!!");
   player1(secondPlayer,firstPlayer);
 }

return false;

  }

  public static void main(String[] args) {


    Scanner sc = new Scanner(System.in);  // Create a Scanner object

    System.out.print("Enter Player 1 name : ");

    String firstPlayer = sc.nextLine();  // Read user input

    System.out.print("Enter Player 2 name : ");

    String secondPlayer = sc.nextLine();


   while(true) {
     
         if(status1 == true || status2) break ;  // if status if true either one player has won so break the loop
     
          boolean status1 = player1(firstPlayer,secondPlayer) ;
          System.out.println("List1: " + index1); // printing a list of the popped out value for player1

          boolean status2 = player2(secondPlayer,firstPlayer);
          System.out.println("List2: " + index2);  // printing a list of the popped out value for player1

        
         }
    }
}

/**
 * The HouseGameModel is the model of the project which holds the data and the methods
 * used to manipulate the data which the view class uses
 *
 * @author Osmoh && Ermira
 */
 
public class HouseGameModel
{
   private int count;       // Keeps track of the current value used for drawing the house
   private int diceValue;   // The current dice value
    
   public HouseGameModel()
   {
      count = 1;
      diceValue = 0;
   }

   // Calls the Dice class to generate a new dice value
   protected void throwDice()
   {
      Dice dice = new Dice();
      diceValue = dice.throwDice();
   } 

   // Increases the count value by one
   protected void increaseCount()
   {
      count++;
   }  

   // Used to get the current count value
   protected int getCount()
   {
      return count;
   }

   // Used to get the current dice value
   protected int getDiceValue()
   {
      return diceValue;
   }
}
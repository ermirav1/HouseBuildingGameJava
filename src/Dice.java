// The dice class where a random number between one and six is generated

public class Dice
{
   private final int maxValue = 6;  // The maximum value the dice can get
   int diceValue;                   // The current dice value
   
   public Dice()
   { 
      diceValue = 1; 
   }

   // throw the dice and generate a number between one and six
   public int throwDice()
   {
      diceValue = ( int ) ( Math.random() * maxValue ) + 1 ;    // diceValue is initialized to the generated number
      
      return diceValue;
   }
}
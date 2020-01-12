import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Class HouseGameView is the view class of the project, that inherits the JPanel, which is used to show the
 * user interface, which the user interacts with, using data provided from the model class.
 */
 
public class HouseGameView extends JPanel implements ActionListener
{
   // The field variables

   JFrame frame;
   JButton button;

   // The frame coordinates
   private int width;
   private int height;

   // Instance of the model class
   private HouseGameModel modelObj;

   // The house border coordinates
   private int houseBorderWidth;
   private int houseBorderHeight;
   private int houseBorderPosX;
   private int houseBorderPosY;

   // The points border coordinates
   private int pointsBorderWidth;
   private int pointsBorderHeight;
   private int pointsBorderPosX;
   private int pointsBorderPosY;
   private int spaceBetweenPoints;

   // Keeps track of the current drawn parts of the house
   private int keepTrackOfCount;
 
   public HouseGameView( HouseGameModel modelObjParam )
   {      
      width = 500;
      height = 440;
       
      keepTrackOfCount = 0;
       
      modelObj = modelObjParam;
       
      houseBorderWidth = 300;
      houseBorderHeight = 300;
      houseBorderPosX = 15;
      houseBorderPosY = 100;
       
      pointsBorderWidth = 150;
      pointsBorderHeight = 160;
      pointsBorderPosX = 330;
      pointsBorderPosY = 240;
      spaceBetweenPoints = 25;

      // Tells its the beginning of the game
      JOptionPane.showMessageDialog( null, "Hello and welcome to this \"House Building\" game!", "Build House Game", JOptionPane.INFORMATION_MESSAGE );

      // initializes the button and sets its bounds
      button = new JButton( "Roll Dice" );
      button.setBounds( 330 + 26, 100 + 97 , 100, 25 );
       
      button.addActionListener( this );

      // Initializes the frame and sets its data and coordinates
      frame = new JFrame();
      frame.setTitle( "House Game" );
      frame.getContentPane().add( this );
      frame.setSize( width, height );
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   // Shows the GUI of the game
   public void paintComponent( Graphics g )
   {
      g.setColor( Color.WHITE );
      g.fillRect( 0, 0, width, height );
                   
      g.setColor( Color.BLACK );
      g.setFont( new Font( "TimesRoman", Font.BOLD, 16 ) );
                
      g.drawString( "Throw the dice" , 200, 40 );
      g.drawString( "Based on the result parts of the house will be built!" , 80, 60 );
                
      this.setLayout( null );
      this.add( button );
                
      drawDiceValue( g );
      drawHouseBorder( g );
      drawDicePoints( g );

      // Checks if the dice value is equals to the count value
      if( modelObj.getDiceValue() == modelObj.getCount() )
      {
         // Uses the current count value and based on that calls the relevant methods used to draw parts of the house
         switch( modelObj.getCount() )
         {
            case 1 :
               {
                  drawFloor( g );
                  keepTrackOfCount++;
                  break;
               }
                      
            case 2 :
               {
                  drawFloor( g );
                  drawWalls( g );
                  keepTrackOfCount++;
                  break;
               }
                      
            case 3 :
               {
                  drawFloor( g );
                  drawWalls( g );
                  drawCeiling( g );
                  keepTrackOfCount++;
                  break;
               }
                      
            case 4 :
               {
                  drawFloor( g );
                  drawWalls( g );
                  drawCeiling( g );
                  drawRoof( g );
                  keepTrackOfCount++;
                  break;
               }
                      
            case 5 :
               {
                  drawFloor( g );
                  drawWalls( g );
                  drawCeiling( g );
                  drawRoof( g );
                  drawDoor( g );
                  keepTrackOfCount++;
                  break;
               }
                      
            case 6 :
               {
                  drawFloor( g );
                  drawWalls( g );
                  drawCeiling( g );
                  drawRoof( g );
                  drawDoor( g );
                  drawWindow( g );
                  keepTrackOfCount++;
                  break;
               }
                      
            default :
               {
                  break;
               }
         }
                  
         modelObj.increaseCount();
      }

      // Based on the keepTrackOfCount it draws the parts of the house previously drawn based on the current count value
      switch( keepTrackOfCount )
      {
         case 1 :
            {
               drawFloor( g );
               break;
            }
                      
         case 2 :
            {
               drawFloor( g );
               drawWalls( g );
               break;
            }
                      
         case 3 :
            {
               drawFloor( g );
               drawWalls( g );
               drawCeiling( g );
               break;
            }
                      
         case 4 :
            {
               drawFloor( g );
               drawWalls( g );
               drawCeiling( g );
               drawRoof( g );
               break;
            }
                      
         case 5 :
            {
               drawFloor( g );
               drawWalls( g );
               drawCeiling( g );
               drawRoof( g );
               drawDoor( g );
               break;
            }
                      
         case 6 :
            {
               drawFloor( g );
               drawWalls( g );
               drawCeiling( g );
               drawRoof( g );
               drawDoor( g );
               drawWindow( g );
               break;
            }
                      
         default :
            {
               break;
            }
       
      }
   }

   // Based on the button activity, uses the model object to change the current dice value
   public void actionPerformed( ActionEvent actionEvent )
   {
      if ( actionEvent.getSource() == button )
      {
         if( modelObj.getCount() < 7 )
            modelObj.throwDice();
         System.out.println( "Clicked" );
         
      }
      this.repaint();
   }

   // Draws the dice value along with its borders on the graphical window
   private void drawDiceValue( Graphics pen )
   {
      int diceValueBorderWidth = 150;
      int diceValueBorderHeight = 135;
      int diceValueBorderPosX = 330;
      int diceValueBorderPosY = 95;
       
      pen.setColor( Color.black );
      pen.fillRect( diceValueBorderPosX, diceValueBorderPosY, diceValueBorderWidth, diceValueBorderHeight );
       
      pen.setColor( Color.white );
      pen.fillRect( diceValueBorderPosX + 2, diceValueBorderPosY + 2, diceValueBorderWidth - 4, diceValueBorderHeight - 5 );
       
      pen.setColor( Color.black );      
      pen.drawString( "Dice Value:", diceValueBorderPosX + 40, diceValueBorderPosY + 24 );
      pen.drawRect( diceValueBorderPosX + diceValueBorderWidth / 2 - 26, diceValueBorderPosY + diceValueBorderHeight / 2 - 26, 52, 52 );
      pen.drawRect( diceValueBorderPosX + diceValueBorderWidth / 2 - 27, diceValueBorderPosY + diceValueBorderHeight / 2 - 27, 54, 54 );

      // Imports the images that represent the relevant dice values
      ImageIcon img1 = new ImageIcon( "C:\\Users\\Admin\\Desktop\\HouseBuildingGame\\images\\dice1.png" );
      ImageIcon img2 = new ImageIcon( "C:\\Users\\Admin\\Desktop\\HouseBuildingGame\\images\\dice2.png" );
      ImageIcon img3 = new ImageIcon( "C:\\Users\\Admin\\Desktop\\HouseBuildingGame\\images\\dice3.png" );
      ImageIcon img4 = new ImageIcon( "C:\\Users\\Admin\\Desktop\\HouseBuildingGame\\images\\dice4.png" );
      ImageIcon img5 = new ImageIcon( "C:\\Users\\Admin\\Desktop\\HouseBuildingGame\\images\\dice5.png" );
      ImageIcon img6 = new ImageIcon( "C:\\Users\\Admin\\Desktop\\HouseBuildingGame\\images\\dice6.png" );

      // Sets the coordinates of the images relevant to the dice values
      switch( modelObj.getDiceValue() )
      {
         case 1:
            {
               img1.paintIcon( this, pen, diceValueBorderPosX + diceValueBorderWidth / 2 - 25, diceValueBorderPosY + diceValueBorderHeight / 2 - 25 );
               break;
            }
          
         case 2:
            {
               img2.paintIcon( this, pen, diceValueBorderPosX + diceValueBorderWidth / 2 - 25, diceValueBorderPosY + diceValueBorderHeight / 2 - 25 );
               break;
            }
          
         case 3:
            {
               img3.paintIcon( this, pen, diceValueBorderPosX + diceValueBorderWidth / 2 - 25, diceValueBorderPosY + diceValueBorderHeight / 2 - 25 );
               break;
            }
         
         case 4:
            {
               img4.paintIcon( this, pen, diceValueBorderPosX + diceValueBorderWidth / 2 - 25, diceValueBorderPosY + diceValueBorderHeight / 2 - 25 );
               break;  
            }
          
         case 5:
            {
               img5.paintIcon( this, pen, diceValueBorderPosX + diceValueBorderWidth / 2 - 25, diceValueBorderPosY + diceValueBorderHeight / 2 - 25 );
               break;
            }
          
         case 6:
            {
               img6.paintIcon( this, pen, diceValueBorderPosX + diceValueBorderWidth / 2 - 25, diceValueBorderPosY + diceValueBorderHeight / 2 - 25 );
               break;
            }
          
         default:
            {
               break;
            }
      }
   }

   // Draws the house border
   private void drawHouseBorder( Graphics pen )
   {      
      pen.setColor( Color.black );
      pen.fillRect( houseBorderPosX, houseBorderPosY, houseBorderWidth, houseBorderHeight );
   }

   // Draws the points relevant to the dice values
   private void drawDicePoints( Graphics pen )
   {      
      pen.setColor( Color.black );
      pen.fillRect( pointsBorderPosX, pointsBorderPosY, pointsBorderWidth, pointsBorderHeight );
       
      pen.setColor( Color.white );
      pen.drawString( "1 ------> Floor", pointsBorderPosX + 20, pointsBorderPosY + spaceBetweenPoints );
      pen.drawString( "2 ------> Walls", pointsBorderPosX + 20, pointsBorderPosY + spaceBetweenPoints * 2 );
      pen.drawString( "3 ------> Ceiling", pointsBorderPosX + 20, pointsBorderPosY + spaceBetweenPoints * 3 );
      pen.drawString( "4 ------> Roof", pointsBorderPosX + 20, pointsBorderPosY + spaceBetweenPoints * 4 );
      pen.drawString( "5 ------> Door", pointsBorderPosX + 20, pointsBorderPosY + spaceBetweenPoints * 5 );
      pen.drawString( "6 ------> Window", pointsBorderPosX + 20, pointsBorderPosY + spaceBetweenPoints * 6 );
       
   }

   // Draws the floor of the house
   private void drawFloor( Graphics pen )
   {
      pen.setColor( Color.white );
      pen.drawLine( houseBorderPosX + 50, houseBorderPosY + houseBorderHeight - 25, houseBorderPosX + houseBorderWidth - 50, houseBorderPosY + houseBorderHeight - 25 );
       
      pen.drawString( "*", pointsBorderPosX + 10, pointsBorderPosY + spaceBetweenPoints );
   }

    // Draws the walls of the house
   private void drawWalls( Graphics pen )
   {
      pen.setColor( Color.white );
      pen.drawLine( houseBorderPosX + 50, houseBorderPosY + houseBorderHeight - 25, houseBorderPosX + 50, houseBorderPosY + houseBorderHeight / 2 - 20 );
      pen.drawLine( houseBorderPosX + houseBorderWidth - 50, houseBorderPosY + houseBorderHeight - 25, houseBorderPosX + houseBorderWidth - 50, houseBorderPosY + houseBorderHeight / 2 - 20 );
      
      pen.drawString( "*", pointsBorderPosX + 10, pointsBorderPosY + spaceBetweenPoints * 2 );
   }

    // Draws the ceiling of the house
   private void drawCeiling( Graphics pen )
   {
      pen.setColor( Color.white );
      pen.drawLine( houseBorderPosX + 50, houseBorderPosY + houseBorderHeight / 2 - 20, houseBorderPosX + houseBorderWidth - 50, houseBorderPosY + houseBorderHeight / 2 - 20 );
       
      pen.drawString( "*", pointsBorderPosX + 10, pointsBorderPosY + spaceBetweenPoints * 3 );
   }

    // Draws the roof of the house
   private void drawRoof( Graphics pen )
   {
      pen.setColor( Color.white );
       
      pen.drawLine( houseBorderPosX + 50, houseBorderPosY + houseBorderHeight / 2 - 20, houseBorderPosX + ( houseBorderWidth / 2 ), houseBorderPosY + houseBorderHeight / 12 );
      pen.drawLine( houseBorderPosX + ( houseBorderWidth / 2 ), houseBorderPosY + houseBorderHeight / 12, houseBorderPosX + houseBorderWidth - 50, houseBorderPosY + houseBorderHeight / 2 - 20 );
      pen.drawString( "*", pointsBorderPosX + 10, pointsBorderPosY + spaceBetweenPoints * 4 );
   }

    // Draws the door of the house
   private void drawDoor( Graphics pen )
   {
      pen.setColor( Color.white );
      pen.drawRect( houseBorderPosX + houseBorderWidth / 2 - 25, houseBorderPosY + houseBorderHeight / 2 + 50, 50, 73 );
      pen.drawLine( houseBorderPosX + houseBorderWidth / 2 - 25, houseBorderPosY + houseBorderHeight / 2 + 80, houseBorderPosX + houseBorderWidth / 2 - 18, houseBorderPosY + houseBorderHeight / 2 + 80);
       
      pen.drawString( "*", pointsBorderPosX + 10, pointsBorderPosY + spaceBetweenPoints * 5 );
   }

    // Draws the window of the house
   private void drawWindow( Graphics pen )
   {
      pen.setColor( Color.white );
      pen.drawRect( houseBorderPosX + 52, houseBorderPosY + houseBorderHeight / 2 - 10, 45, 50 );
      pen.drawRect( houseBorderPosX + houseBorderWidth - 97, houseBorderPosY + houseBorderHeight / 2 - 10, 45, 50 );
       
      pen.drawString( "*", pointsBorderPosX + 10, pointsBorderPosY + spaceBetweenPoints * 6 );
   }
}
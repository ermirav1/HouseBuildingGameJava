/**
 * Class HouseGameController is the main component of the project, which is used to connect the other two
 * components: the HouseGameView and the HouseGameModel, it is also used to set the frame to visible.
 * @author Osmon && Ermira
 *
 */

public class HouseGameController
{
   HouseGameView view;
   HouseGameModel model;
     
   public HouseGameController( HouseGameView view, HouseGameModel model )
   {
      // Initialization of the field variables
      this.view = view;
      this.model = model;
      
      this.view.frame.setVisible( true );    // Sets the frame from the view to visible
   }
}
/**
 * Class HouseGameMVC creates instances of all the components and makes the Project executable
 * @author Osmon && Ermira
 */
  
public class HouseGameMVC
{
   public static void main( String[] args )
   {
      HouseGameModel model = new HouseGameModel();       // The Model class
      HouseGameView view = new HouseGameView( model );   // The View class
      HouseGameController controller = new HouseGameController( view, model );   // The Controller class
   }
}
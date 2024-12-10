import org.code.theater.*;
import java.util.Scanner;

public class TheaterRunner {
    public static void main(String[] args) {
      
  /**
      * Reads data from the txt file to find things such as the cars' names and speeds
    */
      
     String[] autoNamesArray = FileReader.toStringArray("autoNames.txt");
     String[] manNamesArray = FileReader.toStringArray("manNames.txt");
     double[] autoSpeedsArray = FileReader.toDoubleArray("autoSpeeds.txt");
     double[] manSpeedsArray = FileReader.toDoubleArray("manSpeeds.txt");
     String[] colorsArray = { "white", "blue", "black", "red", "yellow" };

      /**
         * Creates the DataScene object for the theatre
        */

        DataScene myDataScene = new DataScene(autoSpeedsArray, autoNamesArray, manSpeedsArray, manNamesArray, colorsArray);

        /** 
           * Chooses car type and index
          */
      
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a car type: 1 for Automatic, 2 for Manual");
        int carType = scanner.nextInt();
        System.out.println("Enter the index of the car (0 to " + (autoSpeedsArray.length - 1) + "):");
        int index = scanner.nextInt();

      /** 
           * Displays the details of the car
          */
      
        if (carType == 1) {
            myDataScene.showAutoCarDetails(index);
        } else if (carType == 2) {
            myDataScene.showManCarDetails(index);
        } else {
            System.out.println("Invalid choice");
        }

      /**
     * Creates and plays the scene
     */
      
        myDataScene.createScene();
        Theater.playScenes(myDataScene);

       /**
     * Closes the scanner
     */
      
        scanner.close(); 
      
      
    }
}
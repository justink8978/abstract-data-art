import org.code.theater.*;
import java.util.Random;

/**
 * Extends the Scene class in order to visualize the car data. Using 1D arrays, it stores the car names and speeds. It also averages and finds the maximum speed.
 */

public class DataScene extends Scene {
  
    // Contains the car data
  
    private double[] autoSpeeds;
    private double[] manSpeeds;
    private String[] autoNames;
    private String[] manNames;
    private String[] textColors;

    // Variables for car speeds
  
    private double autoAverage;
    private double autoFastest;
    private double manAverage;
    private double manFastest;

    // Constants for images
  
    private static final String MAN_IMAGE = "manualcar.jpg";
    private static final String AUTO_IMAGE = "autocar.jpg";

    /**
     * Constructor for initializing the DataScene
     */
  
    public DataScene(double[] autoSpeeds, String[] autoNames, double[] manSpeeds, String[] manNames, String[] colors) {
        this.autoSpeeds = autoSpeeds;
        this.autoNames = autoNames;
        this.manSpeeds = manSpeeds;
        this.manNames = manNames;
        this.textColors = colors;
        getAverageAndFastest(); 
    }

    /**
     * Calculates the fastest and average speeds for automatic and manual cars.
     */
  
    private void getAverageAndFastest() {
        autoFastest = findMax(autoSpeeds);
        autoAverage = findAverage(autoSpeeds);
        manFastest = findMax(manSpeeds);
        manAverage = findAverage(manSpeeds);
    }

    /**
     * Finds the maximum value
     */
  
     private double findMax(double[] array) {
        double max = array[0];
        for (double value : array) {
            max = Math.max(max, value);
        }
        return max;
    }

    /**
     * Calculates the average value
     */
  
    private double findAverage(double[] array) {
        double total = 0;
        for (double value : array) {
            total += value;
        }
        return total / array.length;
    }

    /**
     * Displays details of automatic cars
     */
  
    public void showAutoCarDetails(int index) {
        String message = getAutoMessage(index);
        drawCarDetails("Automatic Car", message, autoNames[index], autoSpeeds[index], AUTO_IMAGE, "white");
    }

    /**
     * Displays details for manual cars
     */
  
    public void showManCarDetails(int index) {
        String message = getManMessage(index);
        drawCarDetails("Manual Car", message, manNames[index], manSpeeds[index], MAN_IMAGE, "white");
    }

    /**
     * Displays a message based off of car speed
     */
  
    private String getAutoMessage(int index) {
        if (autoSpeeds[index] == autoFastest) {
            return "Fastest Automatic Car";
        } else if (autoSpeeds[index] > autoAverage || autoSpeeds[index] > manFastest) {
            return "Vroom Vroom";
        } else {
            return "Skrrrrt";
        }
    }

    /**
     * Displays a message based off of car speed
     */
  
    private String getManMessage(int index) {
        if (manSpeeds[index] == manFastest) {
            return "Fastest Manual Car";
        } else if (manSpeeds[index] > manAverage || manSpeeds[index] > autoFastest) {
            return "Zooooooom";
        } else {
            return "Beep Beep";
        }
    }

    /**
     * Displays all the information of the given car
     */
  
    private void drawCarDetails(String title, String message, String name, double speed, String image, String color) {
        drawImage(image, 0, 0, 450);
        setFillColor(color);
        drawRectangle(0, 0, 410, 50);
        drawRectangle(0, 300, 410, 110);
        setTextColor("black");
        setTextHeight(34);
        drawText(title, 65, 40);
        setTextHeight(25);
        drawText(message, 20, 325);
        setTextHeight(18);
        drawText(name, 20, 350);
        drawText("Speed: " + Math.round(speed), 20, 375);
        pause(2);
    }

    /**
     * Iterates through the cars lists to make an image
     */
  
    public void createScene() {
        for (int i = 0; i < autoSpeeds.length; i++) {
            createAutoScene(i);
            createManScene(i);
        }
    }

    /**
     * Creates a scene for the manual cars
     */
  
    public void createManScene(int index) {
        drawCarDetails("Manual Car", getManMessage(index), manNames[index], manSpeeds[index], MAN_IMAGE, "white");
    }

    /**
     * Creates a scene for the automatic cars
     */
  
    public void createAutoScene(int index) {
        drawCarDetails("Automatic Car", getAutoMessage(index), autoNames[index], autoSpeeds[index], AUTO_IMAGE, "white");
    }
}
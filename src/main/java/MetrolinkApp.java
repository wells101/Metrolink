import java.util.Scanner;

/**
 * Created by Gaming on 5/5/2015.
 */
public class MetrolinkApp {
    public static void main(String[] args){
        Scanner inputScanner = new Scanner(System.in);
        Route MetroRoute = new Route();
        int selection;
        MetroRoute.outputStations();
        do {
            System.out.println("Enter the station number you are at: ");
            selection = inputScanner.nextInt();
        }while(selection < 0 && selection > 36);
        System.out.println("The next arrival at " + MetroRoute.getStationName(selection) + " is " + MetroRoute.getNextArrival(selection));
    }

}

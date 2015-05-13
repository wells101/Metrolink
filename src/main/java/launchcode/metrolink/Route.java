package launchcode.metrolink;

import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;

/**
 * Created by Gaming on 5/6/2015.
 */
@Component
public class Route {
    private List<Station> RouteStops;
    //Output list of Stations.
    //Move to launchcode.metrolink.Route Object

    public Route(){
        RouteStops = MetrolinkDAO.getInstance().getMetrolinkStops();
    }

    public void outputStations() {
        for (int i = 0; i < RouteStops.size(); i++) {
            int y = i + 1;
            System.out.print(y + " " + RouteStops.get(i).getStationName() + "  ");
            if (y % 3 == 0) {
                System.out.println();
            }
        }
    }

    public Station getStation (int key){
        return RouteStops.get(key-1);
    }
    public String getStationName(int key){
        return RouteStops.get(key - 1).getStationName();
    }

    public String getStopID(int key){
        return RouteStops.get(key - 1).getID();
    }

    public String getNextArrival(int input){
        Station PassengerStation = getStation(input);
        List<String> arrivals = MetrolinkDAO.getInstance().getArrivals(PassengerStation);
        int i = 0;
        String arrivalTime = arrivals.get(i);
        while(LocalTime.parse(arrivalTime).isBefore(LocalTime.now())){
            arrivalTime = arrivals.get(i);
            i++;
        }
        return arrivalTime;
    }
}

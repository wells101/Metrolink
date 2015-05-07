import org.junit.Before;
import org.junit.Test;

/**
 * Created by Gaming on 5/6/2015.
 */
public class MetrolinkDAOTest {

    public Route route;
    @Before
    public void setUp(){
        route = new Route();
    }

    @Test
    public void testGetStopID(){
        String result = route.getStopID(1);
        System.out.println(result);
    }
}

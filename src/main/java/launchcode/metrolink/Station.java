package launchcode.metrolink;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by Gaming on 5/6/2015.
 */
@Entity
@Table(name="stops")
public class Station {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "stop_id", unique = true, nullable = false)
    private Integer ID;

    @Column(name = "stop_name", unique = false)
    private String StopName;

    public void setName(String name) {
        this.StopName = name;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getStationName() {
        return StopName;
    }

    public Integer getID() {
        return ID;
    }
}

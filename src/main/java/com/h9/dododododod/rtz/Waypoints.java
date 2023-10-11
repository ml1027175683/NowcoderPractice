package com.h9.dododododod.rtz;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "waypoints")
@XmlType(propOrder = {})
public class Waypoints {
    @XmlElement
    private DefaultWaypoint defaultWaypoint;
    @XmlElement
    private List<Waypoint> waypointList;


}

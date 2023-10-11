package com.h9.dododododod.rtz;


import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "waypoint")
@XmlType(propOrder = {})
public class Waypoint {
    @XmlAttribute
    private int id;
    @XmlElement
    private Position position;
    @XmlElement
    private Extensions extensions;
}

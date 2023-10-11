package com.h9.dododododod.rtz;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "leg")
@XmlType(propOrder = {})
class Leg {
    @XmlAttribute
    private double starboardXTD;
    @XmlAttribute
    private double portsideXTD;
    @XmlAttribute
    private String geometryType;
}
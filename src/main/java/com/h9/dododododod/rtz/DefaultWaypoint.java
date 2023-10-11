package com.h9.dododododod.rtz;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {})
public class DefaultWaypoint {
    @XmlAttribute
    private double radius;
    @XmlElement
    private Leg leg;
}
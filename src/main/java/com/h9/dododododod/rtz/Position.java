package com.h9.dododododod.rtz;

import com.sun.org.apache.xalan.internal.lib.Extensions;
import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "position")
@XmlType(propOrder = {})
public class Position {
    @XmlAttribute
    private Double lat;
    @XmlAttribute
    private Double lon;
}

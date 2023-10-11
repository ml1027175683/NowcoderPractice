package com.h9.dododododod.rtz;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "uniquename")
@XmlType(propOrder = {})
public class Uniquename {
    @XmlAttribute
    private String value;
}

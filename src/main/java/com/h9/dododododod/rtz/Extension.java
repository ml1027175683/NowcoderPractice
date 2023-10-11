package com.h9.dododododod.rtz;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "extension")
@XmlType(propOrder = {})
public class Extension {
    @XmlAttribute
    private String manufacturer;
    @XmlAttribute
    private String name;
    @XmlElement
    private Uniquename uniquename;
}

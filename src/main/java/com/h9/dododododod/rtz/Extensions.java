package com.h9.dododododod.rtz;

import lombok.Data;

import javax.xml.bind.annotation.*;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "extensions")
@XmlType(propOrder = {})
public class Extensions {
    @XmlElement
    private Extension extension;
}

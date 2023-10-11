/**
  * Copyright 2023 json.cn 
  */
package com.h9.dododododod.xmlJavaBean;
import lombok.Data;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Date;

@Data
public class SheduleElement {

    private int waypointId;
    private int speed;
    private Date eta;
    private Date etd;

}
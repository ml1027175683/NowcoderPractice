/**
  * Copyright 2023 json.cn 
  */
package com.h9.dododododod.xmlJavaBean;
import lombok.Data;

import java.util.List;

@Data
public class Waypoints {

    private List<Waypoint> waypoint;
    private DefaultWaypoint defaultWaypoint;

}
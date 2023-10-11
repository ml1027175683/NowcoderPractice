/**
  * Copyright 2023 json.cn 
  */
package com.h9.dododododod.xmlJavaBean;


import lombok.Data;

@Data
public class Route {
    private int version;
    private Waypoints waypoints;
    private RouteInfo routeInfo;
    private String xmlns;
    private Schedules schedules;


}
package com.drone.UAV.Model;

import lombok.Data;

@Data
public class LogModel {
    /*enum type{
        USAGE,FLIGHT
    }*/
    private Integer type;
    private String timeStamp;
    private String page;
    private String action;
    private Integer userId;
}

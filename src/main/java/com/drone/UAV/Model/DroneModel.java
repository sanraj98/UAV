package com.drone.UAV.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DroneModel {

    private Double lat;
    private  Double lon;
    private  Double alti;
    private  String gcsId;
    private Long bateryPercentage;
    private Double yaw;
    private Double verticalSpeed;
    private Double distToMav;
    private String uid;
    private Double groundSpeed;
    private Double distToWp;

    @Override
    public String toString() {
        return "DroneModel{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", alti=" + alti +
                ", gcsId='" + gcsId + '\'' +
                ", bateryPercentage=" + bateryPercentage +
                ", yaw=" + yaw +
                ", verticalSpeed=" + verticalSpeed +
                ", distToMav=" + distToMav +
                ", uid='" + uid + '\'' +
                ", groundSpeed=" + groundSpeed +
                ", distToWp=" + distToWp +
                '}';
    }
}

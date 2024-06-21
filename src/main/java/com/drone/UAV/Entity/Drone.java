package com.drone.UAV.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "Latitude")
    private Double lat;

    @Column(name = "Longtitude")
    private Double lon;

    @Column(name = "altitude")
    private Double alti;

    @Column(name = "gcsid")
    private String gcsId;

    @Column(name = "battery_percentage")
    private Long bateryPercentage;

    @Column(name = "yaw")
    private Double yaw;

    @Column(name = "vertical_speed")
    private Double verticalSpeed;

    @Column(name = "dist_to_mav")
    private Double distToMav;

    @Column(name = "ground_speed")
    private Double groundSpeed;

    @Column(name = "dist_to_wp")
    private Double distToWp;

    @Override
    public String toString() {
        return "Drone{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", alti=" + alti +
                ", gcsId='" + gcsId + '\'' +
                ", bateryPercentage=" + bateryPercentage +
                ", yaw=" + yaw +
                ", verticalSpeed=" + verticalSpeed +
                ", distToMav=" + distToMav +
                ", groundSpeed=" + groundSpeed +
                ", distToWp=" + distToWp +
                '}';
    }
}

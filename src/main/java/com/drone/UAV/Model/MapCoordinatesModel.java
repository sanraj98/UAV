package com.drone.UAV.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MapCoordinatesModel {
    private Long id;
    private Double lat1;
    private Double lon1;
    private Double lat2;
    private Double lon2;

    @Override
    public String toString() {
        return "MapCoordinatesModel{" +
                "id=" + id +
                ", lat1=" + lat1 +
                ", lon1=" + lon1 +
                ", lat2=" + lat2 +
                ", lon2=" + lon2 +
                '}';
    }
}

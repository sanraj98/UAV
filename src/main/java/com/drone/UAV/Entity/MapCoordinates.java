package com.drone.UAV.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "map_coordinates")
public class MapCoordinates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "lat_1")
    private Double lat1;
    @Column(name = "lon_1")
    private Double lon1;
    @Column(name = "lat_2")
    private Double lat2;
    @Column(name = "lon_2")
    private Double lon2;
}

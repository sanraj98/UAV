package com.drone.UAV.Doa;

import com.drone.UAV.Entity.MapCoordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IapiDao extends JpaRepository<MapCoordinates,Long> {
    MapCoordinates findFirstByOrderByIdDesc(); // Assuming you have a createdAt field

}

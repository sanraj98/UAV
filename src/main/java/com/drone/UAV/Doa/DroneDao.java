package com.drone.UAV.Doa;

import com.drone.UAV.Entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneDao extends JpaRepository<Drone, Long > {

    public Drone findByUid(String uid);

}

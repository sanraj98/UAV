package com.drone.UAV.Service;

import com.drone.UAV.Entity.Drone;
import com.drone.UAV.Entity.LogData;

import java.util.List;

public interface DroneService {
    public String saveDrones(Drone drone);

    public Drone findByUid(String uid);
    public Drone findById(Long id);
    public List<Drone> listOfDrone();

    public List<LogData> findallLog();
}

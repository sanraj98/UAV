package com.drone.UAV.Service;

import com.drone.UAV.Doa.DroneDao;
import com.drone.UAV.Doa.LogDataDao;
import com.drone.UAV.Entity.Drone;
import com.drone.UAV.Entity.LogData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneServiceImp implements DroneService {

    @Autowired
    private DroneDao dronedao;

    @Autowired
    private LogDataDao logDataDao;

    public String saveDrones(Drone drone){
        String status="{\"status\":\"error\"}";
        try {
            Drone dr = dronedao.save(drone);
            if(dr!=null){
                status="{\"status\":\"ok\"}";
            }
        }catch (Exception e){
            status="{\"status\":\""+e.getMessage()+"\"}";
        }
        return status;
    }
    public Drone findByUid(String uid){
        return dronedao.findByUid(uid);
    }

    public Drone findById(Long id){
        return dronedao.findById(id).get();
    }
    public List<Drone> listOfDrone(){
        return dronedao.findAll();
    }

    public List<LogData> findallLog(){
        return logDataDao.findAll();
    }


}

package com.drone.UAV.Controller;


import com.drone.UAV.Entity.Drone;
import com.drone.UAV.Entity.LogData;
import com.drone.UAV.Entity.MapCoordinates;
import com.drone.UAV.Entity.UavUsers;
import com.drone.UAV.Model.DroneModel;
import com.drone.UAV.Model.LogModel;
import com.drone.UAV.Model.MapCoordinatesModel;
import com.drone.UAV.Service.Apiservice;
import com.drone.UAV.Service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    int count=0;
    @Autowired
    private Apiservice apiservice;

    @Autowired
    private DroneService droneserving;
    @PostMapping("/save_drone")
    public String saveDroneDetail(@RequestBody DroneModel droneml){
        count++;
        Drone newDrone;
        Drone exsistDrone=droneserving.findByUid(droneml.getUid());

        if(exsistDrone!=null){
            newDrone=exsistDrone;
        }else {
            newDrone=new Drone(); 
        }
        System.out.println(droneml);
        System.out.println(count);
        newDrone.setLat(droneml.getLat());
        newDrone.setLon(droneml.getLon());
        newDrone.setAlti(droneml.getAlti());
        newDrone.setGcsId(droneml.getGcsId());
        newDrone.setBateryPercentage(droneml.getBateryPercentage());
        newDrone.setVerticalSpeed(droneml.getVerticalSpeed());
        newDrone.setYaw(droneml.getYaw());
        newDrone.setDistToMav(droneml.getDistToMav());
        newDrone.setUid(droneml.getUid());
        newDrone.setGroundSpeed(droneml.getGroundSpeed());
        newDrone.setDistToWp(droneml.getDistToWp());
        return droneserving.saveDrones(newDrone);
    }
    @PostMapping("/save_coordinates")
    public String saveMapOrdinates(@RequestBody MapCoordinatesModel mapModel){
       String respons= apiservice.saveCoordinates(mapModel);
       return respons;
    }

    @GetMapping("/last_coordinates")
    public ResponseEntity<MapCoordinates> getLastSavedData() {
        MapCoordinates lastSavedData = apiservice.lastSavedData();
        return ResponseEntity.ok(lastSavedData);
    }
    @GetMapping("/get_drone/{id}")
    public Drone getDrone(@PathVariable("id") Long id){
        Drone dn=droneserving.findById(id);
        return dn;
    }

    @GetMapping("/get_dronelist")
    public List<Drone> getListOfDrone(){
        return droneserving.listOfDrone();
    }

    @GetMapping("/get_user")
    public String getUsers(@RequestParam("username")String userName, @RequestParam("password")String password){
        String status="{\"status\":\"invalid user\"}";
        UavUsers user=apiservice.findUser(userName,password);
        LocalDate today = LocalDate.now();

        if(user!=null){
            LocalDate usrDate=user.getActivateDate().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();;
            status="{\"status\":\"valid user\"}";
            if (usrDate.isBefore(today.minusYears(1)) || usrDate.isAfter(today)) {
                status="{\"status\":\"validity has expired\"}";
            }
        }
        return  status;
    }

    @PostMapping("/save_log")
    public String saveLogData(@RequestBody LogModel logModel){
        String response=apiservice.saveLogData(logModel);
        return response;
    }

    @GetMapping("/get_log_list")
    public List<LogData> getListByTypeAndId(@RequestParam("type") Integer typ,@RequestParam("usrid")Integer usrid){
        List<LogData> logDatabyTypid=apiservice.findByTypeAndId(typ,usrid);
        return logDatabyTypid;
    }
}

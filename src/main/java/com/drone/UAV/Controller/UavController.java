package com.drone.UAV.Controller;

import com.drone.UAV.Entity.Drone;
import com.drone.UAV.Model.DroneModel;
import com.drone.UAV.Service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/uav")
public class UavController {
    @Autowired
    private DroneService droneserving;

    @RequestMapping("/map")
    public ModelAndView showMap(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/data_simulation")
    public ModelAndView showSimulation(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("data-simulator");
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView showlogin(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("login");
        return mav;
    }


}

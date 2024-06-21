package com.drone.UAV.Controller;

import com.drone.UAV.Entity.LogData;
import com.drone.UAV.Service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private DroneService droneService;

    @RequestMapping("/log_data")
    public ModelAndView showLogData(){
        ModelAndView mv=new ModelAndView();
        List<LogData> logdatas= droneService.findallLog();
        mv.addObject("logdatas",logdatas);
        mv.setViewName("log-table");
        return  mv;
    }

}

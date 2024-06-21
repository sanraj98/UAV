package com.drone.UAV.Service;

import com.drone.UAV.Doa.IapiDao;
import com.drone.UAV.Doa.LogDataDao;
import com.drone.UAV.Doa.UavUserDao;
import com.drone.UAV.Entity.LogData;
import com.drone.UAV.Entity.MapCoordinates;
import com.drone.UAV.Entity.UavUsers;
import com.drone.UAV.Model.LogModel;
import com.drone.UAV.Model.MapCoordinatesModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServiceImp implements Apiservice{

    @Autowired
    private IapiDao iapiDao;

    @Autowired
    private UavUserDao uavUserDao;

    @Autowired
    private LogDataDao logDataDao;

    public String saveCoordinates(MapCoordinatesModel model){
        String response= "{\"status\":\"something\"}";
        try{
        MapCoordinates mapobj=new MapCoordinates();
        mapobj.setLat1(model.getLat1());
        mapobj.setLon1(model.getLon1());
        mapobj.setLat2(model.getLat2());
        mapobj.setLon2(model.getLon2());
        MapCoordinates savedMap= iapiDao.save(mapobj);
        if(savedMap.getId()!=null){
            response= "{\"status\":\"ok\"}";
        }
        }catch (Exception e){
            response=e.getMessage();
        }
        return response;
    }

    public MapCoordinates lastSavedData(){
        return iapiDao.findFirstByOrderByIdDesc();
    }

    public UavUsers findUser(String usr,String password){
        return uavUserDao.findUsers(usr,password);
    }

    public String saveLogData(LogModel logModel){
        String response="{\"status\":\"something went wrong\"}";
        LogData checkLog=null;
        try{
            if(logModel!=null){
                LogData logData=new LogData();
                logData.setType(logModel.getType());
                logData.setTimeStamp(logModel.getTimeStamp());
                logData.setPage(logModel.getPage());
                logData.setAction(logModel.getAction());
                logData.setUserId(logModel.getUserId());
                checkLog=logDataDao.save(logData);
                if(checkLog!=null){
                    response= "{\"status\":\"successfully saved\"}";
                }
            }
        }catch (Exception e){
            response=e.getMessage();
        }
        return response;
    }

    public List<LogData> findByTypeAndId(Integer type,Integer usrid){
        return logDataDao.findByTypeAndId(type,usrid);
    }

}

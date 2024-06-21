package com.drone.UAV.Service;

import com.drone.UAV.Entity.LogData;
import com.drone.UAV.Entity.MapCoordinates;
import com.drone.UAV.Entity.UavUsers;
import com.drone.UAV.Model.LogModel;
import com.drone.UAV.Model.MapCoordinatesModel;

import java.util.List;

public interface Apiservice {

    public String saveCoordinates(MapCoordinatesModel model);

    public MapCoordinates lastSavedData();

    public UavUsers findUser(String usr, String password);
    public String saveLogData(LogModel logModel);
    public List<LogData> findByTypeAndId(Integer type, Integer usrid);
}

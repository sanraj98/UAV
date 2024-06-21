package com.drone.UAV.Doa;

import com.drone.UAV.Entity.LogData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDataDao extends JpaRepository<LogData,Long> {

    @Query("from LogData ld where ld.type=:typ AND ld.userId=:usrId")
    List<LogData> findByTypeAndId(Integer typ,Integer usrId);

}

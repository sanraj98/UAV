package com.drone.UAV.Doa;

import com.drone.UAV.Entity.UavUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UavUserDao extends JpaRepository<UavUsers,Long> {

    @Query(value = "FROM UavUsers u WHERE u.userName = :userName AND u.password = :password")
    UavUsers findUsers(@Param("userName") String userName,@Param("password") String password);

    public  UavUsers findByUserName(String userName);
}

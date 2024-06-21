package com.drone.UAV.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "log_data")
@Data
public class LogData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private Integer type;
    @Column(name = "time_stamp")
    private String timeStamp;
    @Column(name = "page")
    private String page;
    @Column(name = "action")
    private  String action;
    @Column(name = "user_id")
    private Integer userId;
}

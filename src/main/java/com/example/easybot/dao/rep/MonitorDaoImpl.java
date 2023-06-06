package com.example.easybot.dao.rep;

import com.example.easybot.dao.GenericDaoImpl;
import com.example.easybot.model.Monitor;
import org.springframework.stereotype.Repository;

@Repository
public class MonitorDaoImpl extends GenericDaoImpl<Monitor, Long> {
    public MonitorDaoImpl() {
        super(Monitor.class);
    }
}

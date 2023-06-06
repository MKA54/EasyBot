package com.example.easybot.dao.rep;

import com.example.easybot.dao.GenericDaoImpl;
import com.example.easybot.model.PC;
import org.springframework.stereotype.Repository;

@Repository
public class PCDaoImpl extends GenericDaoImpl<PC, Long> {
    public PCDaoImpl() {
        super(PC.class);
    }
}

package com.example.easybot.dao.rep;

import com.example.easybot.dao.GenericDaoImpl;
import com.example.easybot.model.HDD;
import org.springframework.stereotype.Repository;

@Repository
public class HDDDaoImpl extends GenericDaoImpl<HDD, Long> {
    public HDDDaoImpl() {
        super(HDD.class);
    }
}

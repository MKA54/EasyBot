package com.example.easybot.dao.rep;

import com.example.easybot.dao.GenericDaoImpl;
import com.example.easybot.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopDaoImpl extends GenericDaoImpl<Laptop, Long> {
    public LaptopDaoImpl() {
        super(Laptop.class);
    }
}

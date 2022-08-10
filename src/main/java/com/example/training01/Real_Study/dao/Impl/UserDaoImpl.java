package com.example.training01.Real_Study.dao.Impl;

import com.alibaba.druid.pool.DruidDataSource;

public interface UseDaoImpl {
    
    private DruidDataSource druidDataSource;

    public void setDruidDataSource(DruidDataSource druidDataSource) {
        this.druidDataSource = druidDataSource;
    }

    public DruidDataSource getDruidDataSource() {
        return druidDataSource;
    }
}

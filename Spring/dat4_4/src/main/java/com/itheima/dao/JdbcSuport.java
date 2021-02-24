package com.itheima.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcSuport {
    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public JdbcTemplate getJt() {
        return jt;
    }

    public void setDataSource(DataSource dataSource) {
        if (jt == null) {
            jt = create(dataSource);
        }
    }

    private JdbcTemplate create(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
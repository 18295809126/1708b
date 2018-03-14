package com.jk.dao;

import com.jk.model.LogBean;

import java.util.List;

public interface LogDao {
    void saveLog(LogBean logBean);

    List<LogBean> getLogList(Integer skip, Integer limit);
}

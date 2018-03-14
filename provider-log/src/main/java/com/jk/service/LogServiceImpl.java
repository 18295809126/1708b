package com.jk.service;

import com.jk.dao.LogDao;
import com.jk.model.LogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    private LogDao logDao;
    @Override
    public void saveLog(LogBean logBean) {
        logDao.saveLog(logBean);
    }

    @Override
    public List<LogBean> getLogList(Integer page, Integer rows) {
        Integer skip = 0;
        Integer limit = 5;
        skip = (page-1)*rows;
        limit = rows;
        return logDao.getLogList(skip,limit);
    }
}

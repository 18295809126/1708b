package com.jk.dao;

import com.jk.model.LogBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogDaoImpl implements LogDao{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveLog(LogBean logBean) {
        mongoTemplate.insert(logBean);
    }

    @Override
    public List<LogBean> getLogList(Integer skip, Integer limit) {
        return mongoTemplate.find(new Query().skip(skip).limit(limit),LogBean.class);
    }
}

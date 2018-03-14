package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.jk.common.ConstantConf;
import com.jk.common.ResultBean;
import com.jk.model.LogBean;
import com.jk.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("log")
@RefreshScope
public class LogController {

    @Autowired
    private LogService logService;

    @Value("${content}")
    private String content;

    @RequestMapping(value = "test")
    public String test(){

        return content;
    }

    /**
     * 保持日志（新增）
     * @param log{"log":"测试","logTime":"2017-01-01 12:12:12","ip":"127.0.0.1","requestMsg":"?id=123&name=666","responseMsg":"成功","ipAddress":"局域网","name":"saveLog",}
     * @return
     */
    @RequestMapping(value = "saveLog")
    public Boolean saveLog(@RequestParam String log){
        try {
            LogBean logBean = JSON.parseObject(log, LogBean.class);

            logService.saveLog(logBean);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 查询日志列表
     * @param page 第几页（必传）
     * @param rows 每页条数（必传）
     * @return
     */
    @RequestMapping(value = "getLogList")
    public ResultBean getLogList(@RequestParam(value = "page") Integer page, @RequestParam(value = "rows") Integer rows){
        ResultBean resultBean = new ResultBean();
        try {
           List<LogBean> logList = logService.getLogList(page, rows);
            resultBean.setCode(ConstantConf.SUCCESS);
            resultBean.setData(logList);
            resultBean.setMsg("成功");
       }catch (Exception e){
            resultBean.setCode(ConstantConf.ERROR);
            resultBean.setMsg(e.getMessage());
       }
        return resultBean;
    }
}

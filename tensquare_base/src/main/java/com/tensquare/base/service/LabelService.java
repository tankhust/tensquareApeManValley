package com.tensquare.base.service;

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author tank
 * @create 2019/01/13 15:50
 */
@Service
@Transactional
public class LabelService {
    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    public List<Label> findAll() {
        return labelDao.findAll();
    }

    public Label findById(String id) {
       return labelDao.findById(id).get();//jdk1.8新特性
    }

    public void save(Label label) {
        label.setId(idWorker.nextId()+"");
        labelDao.save(label);
    }

    public void upate(Label label) {
        labelDao.save(label);//有id更新，没id保存
    }

    public void deleteById(String id) {
        labelDao.deleteById(id);
    }
}

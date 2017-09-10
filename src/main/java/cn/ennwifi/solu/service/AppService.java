package cn.ennwifi.solu.service;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ennwifi.solu.ui.shared.repository.APP_DATAObj;

@Service
public class AppService {

  @Autowired
  Dao dao;


  public APP_DATAObj appInfo() {
    return dao.fetch(APP_DATAObj.class, 1);
  }

}

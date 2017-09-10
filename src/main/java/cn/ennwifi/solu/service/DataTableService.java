package cn.ennwifi.solu.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.entity.Record;
import org.nutz.dao.pager.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ennwifi.solu.service.module.DataTableReq;
import cn.ennwifi.solu.service.module.DataTableResp;
import cn.ennwifi.solu.service.module.SimpleTableReq;
import cn.ennwifi.solu.service.module.SimpleTableResp;



@Service
public class DataTableService {

  @Autowired
  private Dao dao;

  public DataTableResp list(DataTableReq req, String tableName) throws Exception {
    DataTableResp resp = new DataTableResp();
    // 查询条件
    StringBuffer where = new StringBuffer();
    where.append(" 1 = 1");
    Map<String, String> queryMap = req.getQueryMap();
    for (String key : queryMap.keySet()) {
      if (StringUtils.isNotBlank(queryMap.get(key))) {
        String[] split = key.split(":");
        String name = split[0];
        String q = split[1];
        String value = queryMap.get(key);
        if (StringUtils.equals(q, "like")) {
          value = "%" + queryMap.get(key) + "%";
        }
        where.append(" and " + name + " " + q + " '" + value + "'");
      }

      if (StringUtils.contains(key, "is not null") || StringUtils.contains(key, "is null")) {
        String[] split = key.split(":");
        String name = split[0];
        String q = split[1];
        where.append(" and " + name + " " + q);
      }
    }
    // 排序
    where.append(" order by " + req.getOrderFiled() + " " + req.getOrder());
    System.out.println(where.toString());
    Condition cnd = Cnd.wrap(where.toString());
    // 分页
    Integer recordsFiltered = dao.count(tableName, cnd);

    Pager pager = new Pager();
    pager.setPageNumber(req.getStart() / req.getLength() + 1);
    pager.setPageSize(req.getLength());
    pager.setRecordCount(recordsFiltered);

    // 查询结果
    List<Record> query = dao.query(tableName, cnd, pager);
    // 填充返回bean
    resp.setStart(req.getStart());
    resp.setLength(req.getLength());
    resp.setRecordsFiltered(recordsFiltered);
    resp.setData(query);

    return resp;
  }

  public SimpleTableResp simpleList(SimpleTableReq req, String tableName) throws Exception {
    SimpleTableResp resp = new SimpleTableResp();
    // 查询条件
    StringBuffer where = new StringBuffer();
    where.append(" 1 = 1");
    Map<String, String> queryMap = req.getQueryMap();
    for (String key : queryMap.keySet()) {
      if (StringUtils.isNotBlank(queryMap.get(key))) {
        String[] split = key.split(":");
        String name = split[0];
        String q = split[1];
        String value = queryMap.get(key);
        if (StringUtils.equals(q, "like")) {
          value = "%" + queryMap.get(key) + "%";
        }
        where.append(" and " + name + " " + q + " '" + value + "'");
      }
    }
    System.out.println(where.toString());
    Condition cnd = Cnd.wrap(where.toString());
    // 查询结果
    List<Record> query = dao.query(tableName, cnd);
    // 填充返回bean
    resp.setData(query);

    return resp;
  }


}

package cn.ennwifi.solu.ui.shared.module;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.IsSerializable;


/**
 * The Class SearchReq.
 */
public class SearchReq implements IsSerializable {

  /**
   * Instantiates a new search req.
   */
  public SearchReq() {
    this(1, 10, -1);
  }

  /** 查询的排序. */
  public String orderSql;

  /** 查询条件. */
  public String cnd = "";

  /**
   * Instantiates a new search req.
   *
   * @param pageNumber the page number
   * @param pageSize the page size
   * @param count the count
   */

  public SearchReq(int pageNumber, int pageSize, Integer count) {
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
    this.count = count;
    filters = new ArrayList<DataFilter>();
  }

  /** The page number. */
  // 页数
  private int pageNumber;

  /** The page size. */
  // 每页的条数
  private int pageSize;

  /** The count. */
  // 数据总条数
  private Integer count;

  /**
   * Gets the page number.
   *
   * @return the page number
   */
  public int getPageNumber() {
    return pageNumber;
  }

  /**
   * Sets the page number.
   *
   * @param pageNumber the new page number
   */
  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  /**
   * Gets the page size.
   *
   * @return the page size
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * Sets the page size.
   *
   * @param pageSize the new page size
   */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  /**
   * Gets the count.
   *
   * @return the count
   */
  public Integer getCount() {
    return count;
  }

  /**
   * Sets the count.
   *
   * @param count the new count
   */
  public void setCount(Integer count) {
    this.count = count;
  }

  public List<DataFilter> filters;

  public void addFilter(String name, String op, String value) {
    DataFilter df = new DataFilter();
    df.name = name;
    df.op = op;
    df.value = value;
    filters.add(df);
  }

  public void clearFilters() {
    filters.clear();
  }

  public void removeFilter(String name) {
    for (DataFilter df : filters) {
      if (df.name.equals(name)) {
        filters.remove(df);
        break;
      }
    }
  }
}

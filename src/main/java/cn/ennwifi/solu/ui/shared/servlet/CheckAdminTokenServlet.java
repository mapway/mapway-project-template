package cn.ennwifi.solu.ui.shared.servlet;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.dao.Cnd;
import org.nutz.dao.Dao;

import cn.ennwifi.solu.service.SpringService;
import cn.ennwifi.solu.ui.shared.module.RpcInfo;
import cn.ennwifi.solu.ui.shared.repository.USERObj;

import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class CheckAdminTokenServlet extends RemoteServiceServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;


  /**
   * 
   */
  public CheckAdminTokenServlet() {
    excludesMethod = new ArrayList<String>();
    extendCheckToken(excludesMethod);
  }

  private final static String SESSION_ADMIN_USER = "SESSION_ADMIN_USER";

  private Dao dao;

  /**
   * @return
   */
  public synchronized Dao getDao() {
    if (dao == null) {
      dao = SpringService.getBean(Dao.class);
    }
    return dao;
  }

  /**
   * 检查TOKEN
   */
  @Override
  public String processCall(RPCRequest rpcRequest) throws SerializationException {
    this.log(rpcRequest.getMethod().getName());
    boolean canCall = checkToken(rpcRequest);
    if (canCall == false) {
      throw new SerializationException("非法TOKEN");
    }
    String r = "";
    try {
      r = super.processCall(rpcRequest);
    } catch (Exception e) {
      throw new SerializationException(e.getMessage());
    }

    return r;
  }


  /**
   * @param rpcRequest
   * @return
   */
  public boolean checkToken(RPCRequest rpcRequest) {

    boolean excluded = excludeFromCheckToken(rpcRequest);
    if (excluded == true) {
      return true;
    } else {
      // 需要检查TOKEN
      HttpServletRequest request = this.getThreadLocalRequest();
      String token = request.getHeader(RpcInfo.RPC_TOKEN);
      USERObj user = findUserByToken(token);
      if (user == null) {
        return false;
      }
      request.setAttribute(SESSION_ADMIN_USER, user);
      return true;
    }
  }

  /**
   * 从Request中获取用户信息.
   * 
   * @return
   */
  public USERObj requestUser() {
    HttpServletRequest request = this.getThreadLocalRequest();
    USERObj user = (USERObj) request.getAttribute(SESSION_ADMIN_USER);
    return user;
  }

  /**
   * 从数据库中获取用户信息
   * 
   * @param token
   * @return
   */
  private USERObj findUserByToken(String token) {

    USERObj user = getDao().fetch(USERObj.class, Cnd.where(USERObj.FLD_TOKEN, "=", token));

    return user;
  }

  private ArrayList<String> excludesMethod;

  /**
   * 检查过滤的TOKEN
   * 
   * @param rpcRequest
   * @return
   */
  private boolean excludeFromCheckToken(RPCRequest rpcRequest) {
    String name = rpcRequest.getMethod().getName();
    for (String excludeName : excludesMethod) {
      if (excludeName.equalsIgnoreCase(name)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 子类重构
   * 
   * @param methodList
   */
  public void extendCheckToken(List<String> methodList) {

  }

  public final String getBasePath() {
    String path = getThreadLocalRequest().getContextPath();
    String basePath =
        getThreadLocalRequest().getScheme() + "://" + getThreadLocalRequest().getServerName() + ":"
            + getThreadLocalRequest().getServerPort() + path + "/";
    return basePath;
  }
}

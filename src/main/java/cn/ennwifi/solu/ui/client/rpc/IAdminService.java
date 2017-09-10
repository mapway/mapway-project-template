package cn.ennwifi.solu.ui.client.rpc;

import java.rmi.ServerException;
import java.util.List;

import cn.ennwifi.solu.ui.shared.module.AdminLoginResponse;
import cn.ennwifi.solu.ui.shared.module.PagerData;
import cn.ennwifi.solu.ui.shared.module.SearchReq;
import cn.ennwifi.solu.ui.shared.repository.APP_DATAObj;
import cn.ennwifi.solu.ui.shared.repository.METAObj;
import cn.ennwifi.solu.ui.shared.repository.RESOURCEObj;
import cn.ennwifi.solu.ui.shared.repository.ROLEObj;
import cn.ennwifi.solu.ui.shared.repository.ROLE_RESOURCEObj;
import cn.ennwifi.solu.ui.shared.repository.USERObj;
import cn.ennwifi.solu.ui.shared.repository.USER_ROLEObj;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The Interface IUiServer.
 */
@RemoteServiceRelativePath("adminserver")
public interface IAdminService extends RemoteService {

  AdminLoginResponse adminLogin(String username, String pwd, String type) throws ServerException;

  List<RESOURCEObj> getAllMenu() throws ServerException;

  RESOURCEObj saveMenu(RESOURCEObj resource) throws ServerException;

  void deleteResource(Long resourceId) throws ServerException;

  List<ROLEObj> getAllRole() throws ServerException;

  ROLEObj saveAdminRole(ROLEObj role) throws ServerException;

  boolean deleteAdminRole(Long roleid) throws ServerException;

  Boolean updateAdminRoleMenu(Long roleid, Long resourceId, boolean addOrRemove)
      throws ServerException;

  USERObj saveAdminUser(USERObj user) throws ServerException;

  boolean updateAdminUserRole(Long userid, Long roleid, Boolean addOrRemove) throws ServerException;

  List<USER_ROLEObj> getAdminUserRole(Long userid) throws ServerException;

  PagerData<RESOURCEObj> adminUserMainMenu() throws ServerException;

  List<RESOURCEObj> adminSubMenu(int menuId) throws ServerException;

  AdminLoginResponse getUserByToken(String token) throws ServerException;

  PagerData<USERObj> findUserByQuery(String query, PagerData<USERObj> pager) throws ServerException;

  PagerData<USERObj> searchUserList(SearchReq req) throws ServerException;

  List<RESOURCEObj> adminAllMenu(int rootMenuId) throws ServerException;

  List<ROLE_RESOURCEObj> getRoleResource(Long roleId);

  boolean updateRoleResource(Long roleId, List<Long> resourceIds);

  Boolean isUserOwnResource(Long resid) throws ServerException;

  List<METAObj> fetchMetaData() throws ServerException;

  METAObj saveOrUpdateMetaData(METAObj meta) throws ServerException;

  List<METAObj> getMetaData(String catalog, Boolean includeSub) throws ServerException;

  APP_DATAObj getAppConfigure() throws ServerException;

  APP_DATAObj saveOrUpdateAppConfigure(APP_DATAObj app);

  Boolean deleteMetaData(Integer metaId) throws ServerException;

  RESOURCEObj getMenuInfo(Integer id) throws ServerException;


}

package cn.ennwifi.solu.ui.client.rpc;

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

import com.google.gwt.user.client.rpc.AsyncCallback;


/**
 * The Interface IUiServerAsync.
 */
public interface IAdminServiceAsync {

  void adminLogin(String username, String pwd, String type,
      AsyncCallback<AdminLoginResponse> callback);

  void getAllMenu(AsyncCallback<List<RESOURCEObj>> callback);

  void adminSubMenu(int menuId, AsyncCallback<List<RESOURCEObj>> callback);

  void adminAllMenu(int rootMenuId, AsyncCallback<List<RESOURCEObj>> callback);

  void adminUserMainMenu(AsyncCallback<PagerData<RESOURCEObj>> callback);

  void deleteAdminRole(Long roleid, AsyncCallback<Boolean> callback);

  void deleteResource(Long resourceId, AsyncCallback<Void> callback);

  void fetchMetaData(AsyncCallback<List<METAObj>> callback);

  void findUserByQuery(String query, PagerData<USERObj> pager,
      AsyncCallback<PagerData<USERObj>> callback);

  void getAllRole(AsyncCallback<List<ROLEObj>> callback);

  void getAdminUserRole(Long userid, AsyncCallback<List<USER_ROLEObj>> callback);

  void getMetaData(String catalog, Boolean includeSub, AsyncCallback<List<METAObj>> callback);

  void getRoleResource(Long roleId, AsyncCallback<List<ROLE_RESOURCEObj>> callback);

  void getUserByToken(String token, AsyncCallback<AdminLoginResponse> callback);

  void getAppConfigure(AsyncCallback<APP_DATAObj> callback);

  void saveAdminRole(ROLEObj role, AsyncCallback<ROLEObj> callback);

  void isUserOwnResource(Long resid, AsyncCallback<Boolean> callback);

  void saveAdminUser(USERObj user, AsyncCallback<USERObj> callback);

  void saveOrUpdateAppConfigure(APP_DATAObj app, AsyncCallback<APP_DATAObj> callback);

  void saveMenu(RESOURCEObj resource, AsyncCallback<RESOURCEObj> callback);

  void saveOrUpdateMetaData(METAObj meta, AsyncCallback<METAObj> callback);

  void searchUserList(SearchReq req, AsyncCallback<PagerData<USERObj>> callback);

  void updateAdminUserRole(Long userid, Long roleid, Boolean addOrRemove,
      AsyncCallback<Boolean> callback);

  void updateAdminRoleMenu(Long roleid, Long resourceId, boolean addOrRemove,
      AsyncCallback<Boolean> callback);

  void updateRoleResource(Long roleId, List<Long> resourceIds, AsyncCallback<Boolean> callback);

  void deleteMetaData(Integer metaId, AsyncCallback<Boolean> callback);

  void getMenuInfo(Integer id, AsyncCallback<RESOURCEObj> callback);


}

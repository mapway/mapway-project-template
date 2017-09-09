package cn.ennwifi.solu.ui.client;

import cn.mapway.ui.client.widget.common.ButtonEx;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * 后台管理界面入口
 * 
 * @author zhangjianshe
 *
 */
public class AdminEntry implements EntryPoint {

  @Override
  public void onModuleLoad() {
    ButtonEx btn = new ButtonEx();
    btn.setText("zjs");
    RootPanel.get().add(btn);
  }

}

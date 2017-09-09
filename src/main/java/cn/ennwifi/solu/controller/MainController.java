package cn.ennwifi.solu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class MainController {

  /**
   * 主页面
   * 
   * @return
   */
  @RequestMapping(value = "/", method = {RequestMethod.GET})
  public String index() {
    return "index";
  }

  @RequestMapping(value = "/admin", method = {RequestMethod.GET})
  public String adminIndex() {
    return "admin/index";
  }
}

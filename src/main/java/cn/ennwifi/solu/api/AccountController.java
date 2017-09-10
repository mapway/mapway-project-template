package cn.ennwifi.solu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ennwifi.solu.api.module.AccountInfoReq;
import cn.ennwifi.solu.api.module.AccountInfoResp;
import cn.ennwifi.solu.api.module.AccountLoginReq;
import cn.ennwifi.solu.api.module.AccountLoginResp;
import cn.ennwifi.solu.service.AccountService;
import cn.mapway.document.annotation.ApiField;
import cn.mapway.document.annotation.DevelopmentState;
import cn.mapway.document.annotation.Doc;

/**
 * 账户控制接口
 * 
 * @author zhangjianshe
 *
 */
@RequestMapping(value = "/api/v1/account")
@Doc(value = "账户API接口", group = "账户接入", author = "zhangjianshe", state = DevelopmentState.FINISH,
    refs = {"docref/account.html"})
@Controller
public class AccountController extends BaseController {

  @Autowired
  AccountService accountService;


  @Doc(value = "账户登录-POST", order = 1, state = DevelopmentState.FINISH)
  @RequestMapping(value = "/login", method = {RequestMethod.POST})
  @ResponseBody
  public AccountLoginResp accountLogin(@RequestBody AccountLoginReq req) {
    return accountService.accountLogin(req);
  }

  @Doc(value = "账户登录-GET", order = 2, state = DevelopmentState.FINISH)
  @RequestMapping(value = "/login", method = {RequestMethod.GET})
  @ResponseBody
  public AccountLoginResp accountLoginGet(
      @ApiField(value = "用户名", example = "zhangjsf") @RequestParam(value = "userName",
          required = true) String userName, @ApiField(value = "密码", example = "123") @RequestParam(
          value = "password", required = true) String password, @ApiField(
          value = "账户类型 0 集团账号 1 注册账号", example = "0") @RequestParam(value = "accountType",
          required = true, defaultValue = "0") String accountType, @ApiField(
          value = "第三方设置，此值会原值返回到返回值中", example = "extradata") @RequestParam(value = "url",
          required = true, defaultValue = "") String url) {
    AccountLoginReq req = new AccountLoginReq();
    req.accountType = accountType;
    req.userName = userName;
    req.password = password;
    req.url = url;
    return accountService.accountLogin(req);
  }

  @Doc(value = "账户信息-POST", order = 3, state = DevelopmentState.FINISH)
  @RequestMapping(value = "/info", method = {RequestMethod.POST})
  @ResponseBody
  public AccountInfoResp accountInfo(@RequestBody AccountInfoReq req) {
    return accountService.accountInfo(req);
  }

  @Doc(value = "账户信息-GET", order = 4, state = DevelopmentState.FINISH)
  @RequestMapping(value = "/info", method = {RequestMethod.GET})
  @ResponseBody
  public AccountInfoResp accountInfoGet(@ApiField(value = "用户TOKEN,从登录接口获取",
      example = "0cbd1a60-38b5-43b9-b751-fe580b9e7908") @RequestParam(value = "token",
      required = true) String token) {
    AccountInfoReq req = new AccountInfoReq();
    req.token = token;
    return accountService.accountInfo(req);
  }


}

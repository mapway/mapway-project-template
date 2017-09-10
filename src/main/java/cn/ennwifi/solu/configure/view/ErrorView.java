package cn.ennwifi.solu.configure.view;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import cn.ennwifi.solu.api.module.Resp;
import cn.ennwifi.solu.codes.CodeException;
import cn.ennwifi.solu.codes.ErrorCode;



/**
 * 展示系统错误视图 // JSON视图.
 *
 * @author zhangjianshe
 */
public class ErrorView extends ModelAndView {

  /**
   * Gen view.
   *
   * @return the mapping jackson 2 json view
   */
  private MappingJackson2JsonView genView() {
    MappingJackson2JsonView view = new MappingJackson2JsonView();
    // 设置返回的文档类型
    view.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
    // 近提取一个属性
    view.setExtractValueFromSingleKeyModel(true);

    return view;
  }

  /**
   * Instantiates a new error view.
   *
   * @param msg the msg
   */
  public ErrorView(String msg) {
    Resp data = new Resp();
    data.fail(1, msg);
    this.setView(genView());
    this.addObject("error", data);
  }

  /**
   * Instantiates a new error view.
   *
   * @param code the code
   * @param msg the msg
   */
  public ErrorView(Integer code, String msg) {
    Resp data = new Resp();
    data.fail(code, msg);
    this.setView(genView());
    this.addObject("error", data);
  }

  /**
   * Instantiates a new error view.
   *
   * @param ex the ex
   */
  public ErrorView(Exception ex) {
    Resp data = new Resp();
    data.fail(1, ex.getMessage());
    this.setView(genView());
    this.addObject("error", data);
  }

  /**
   * Instantiates a new error view.
   *
   * @param ex the ex
   */
  public ErrorView(CodeException ex) {
    Resp data = new Resp();
    data.fail(ex.getCode(), ex.getMessage());
    this.setView(genView());
    this.addObject("error", data);
  }

  /**
   * Instantiates a new error view.
   *
   * @param ex the ex
   */
  public ErrorView(ErrorCode ex) {
    Resp data = new Resp();
    data.fail(ex.code, ex.message);
    this.setView(genView());
    this.addObject("error", data);
  }
}

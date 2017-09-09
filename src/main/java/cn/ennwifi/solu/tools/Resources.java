package cn.ennwifi.solu.tools;

import java.io.IOException;

import cn.mapway.document.helper.Scans;

/**
 * 资源处理类
 * 
 * @author zhangjianshe
 *
 */
public class Resources {
  /**
   * 读取编译信息
   * 
   * @return
   * @throws IOException
   */
  public static String readCompileInformation() throws IOException {

    String compile = "";
    try {
      compile = Scans.readResource("cn.ennwifi.datahub", "compile.txt");
    } catch (Exception e) {
      compile = "本地编译";
    }
    return compile;
  }

  public static String getTempDir() {
    return System.getProperty("java.io.tmpdir");
  }
}

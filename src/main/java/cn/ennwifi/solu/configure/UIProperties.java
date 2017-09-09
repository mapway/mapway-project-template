package cn.ennwifi.solu.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ui")
public class UIProperties {
  private String imagePrefix;
  private String imageUploadProxyUrl;
  private String apiServer;
  private String mqttServer;
  private String mqttPort;
  private String mqttWsPath;


  public String getMqttServer() {
    return mqttServer;
  }

  public void setMqttServer(String mqttServer) {
    this.mqttServer = mqttServer;
  }

  public String getMqttPort() {
    return mqttPort;
  }

  public void setMqttPort(String mqttPort) {
    this.mqttPort = mqttPort;
  }

  public String getImagePrefix() {
    return imagePrefix;
  }

  public void setImagePrefix(String imagePrefix) {
    this.imagePrefix = imagePrefix;
  }

  public String getImageUploadProxyUrl() {
    return imageUploadProxyUrl;
  }

  public void setImageUploadProxyUrl(String imageUploadProxyUrl) {
    this.imageUploadProxyUrl = imageUploadProxyUrl;
  }

  public String getApiServer() {
    return apiServer;
  }

  public void setApiServer(String apiServer) {
    this.apiServer = apiServer;
  }

  public String getMqttWsPath() {
    return mqttWsPath;
  }

  public void setMqttWsPath(String mqttWsPath) {
    this.mqttWsPath = mqttWsPath;
  }


}

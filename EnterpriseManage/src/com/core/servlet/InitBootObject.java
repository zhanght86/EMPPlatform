package com.core.servlet;
import java.io.*;
import java.util.*;

import java.net.*;

import com.core.core.BootClassLoader;
import com.core.core.TopThreadGroup;
import com.core.update.UpdateObject;
import com.core.xml.JBOFClass;

import esyt.framework.com.core.xml.PackageStub;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class InitBootObject {
  public static final java.util.Map EASystem = new java.util.Hashtable();
  protected boolean isBoot = false;
  protected boolean isBootClass = false;
//  public static final String CODE_SPACE = "CodeSpace";
  public static final String ENTERPRISE = "JEnterprise";
  public static String LocalUserHome = null;
  public static ClassLoader loader = null;
  protected static InitBootObject initBootObject = null;
  /**
   *
   */
  protected InitBootObject() {

  }
  static {
    initBootObject = new InitBootObject();
  }
  /**
   * ClassLoader
   */
  public static void initClassLoader() {
    try {
      if (loader != null )
        Thread.currentThread().setContextClassLoader(loader);
    } catch ( Exception e ) {
      e.printStackTrace();
    }
  }
  /**
   *
   * @return InitBootObject
   */
  public static InitBootObject getDefault() {
    return initBootObject;
  }
  /**
   *
   * @throws Exception
   */
  public void initBootObject() throws Exception {
    initBootObject(true);
  }
  protected void updateService() throws Exception {
    Hashtable PropertyList = new Hashtable();
    String updateurl = (String)ServerConfig.get("updateURL",null);
    PropertyList.put("application","JEnterprise");
    PropertyList.put("product","");
    PropertyList.put("user.home",LocalUserHome);
    if ( updateurl == null ) return;
    PropertyList.put("updateurl",updateurl);
    
    UpdateService.updateService(PropertyList);
  }
  /**
   *
   * @param bootClass boolean
   * @throws Exception
   */
  public void initBootObject(boolean bootClass) throws Exception {
    ClassLoader cl = Thread.currentThread().getContextClassLoader();
    try {
      System.setProperty("EAT", "server");
      initClassLoader();
      if (isBoot) return;
      isBoot = true;
      InitLocal();
      initEAIHOME();

      //
      updateService();
      //

      initBoot();
      initMETA_INF();
      if (bootClass && !isBootClass) {
        initEAI();
        isBootClass = true;
      }
    } catch ( Exception ex ) {
      ex.printStackTrace();
    } finally {
      Thread.currentThread().setContextClassLoader(cl);
    }
  }
  private void initEAI() throws Exception {
    String DCom = "com.efounder.server.EAIActiveComp";
    Class eaiClass = null;
    eaiClass = loader.loadClass(DCom);//this.getClass().forName(DCom);//
    JBOFClass.CallClassMethod(eaiClass,"InitEAIComp");
  }
  /**
   *
   * @throws Exception
   */
  private void InitLocal() throws Exception {
    //
    ServerConfig.initMainConfig(null);

    String File = "file:";String WEB_INF = "WEB-INF";
    String PathName = "/Registry/root.xml";
    URL url = this.getClass().getResource(PathName);
    if ( url == null ) return;
    String URI = url.toString();//this.getClass().getResource(PathName).toString();
    //System.err.println(URI);
    if ( URI == null ) return;
    if ( URI.startsWith(File) && URI.indexOf(WEB_INF) != -1 ) {
      LocalUserHome = URI.substring(File.length(),URI.indexOf(WEB_INF));
      File dirFile = new File(LocalUserHome);
      LocalUserHome = dirFile.getPath()+System.getProperty("file.separator");
      EASystem.put("LocalUserHome",LocalUserHome);
      System.setProperty ("LocalUserHome",LocalUserHome);
      //System.err.println("LocalUserHome:"+LocalUserHome);
    }
  }
  /**
   *
   * @throws Exception
   */
  private void initBoot () throws Exception {
    try {

      String updateurl = (String)ServerConfig.get("classLoader","1");
      // 如果设置了0，则直接返回，不使用自定义的classloader
      if ( "0".equals(updateurl) ) return;
      // ��ʼ��ClassLoader
      Vector pathList = new Vector();
      getPathList(pathList);
      for (int i = 0; i < pathList.size(); i++) {
        //System.err.println("path" + i + ":" + pathList.get(i));
      }
//      loader = Thread.currentThread().getContextClassLoader(); //BootClassLoader.initClassLoader(pathList, false);
      loader = BootClassLoader.initClassLoader(pathList, false);
      // ����Loader
//      System.getProperties().put("BootClassLoader", loader);
      Thread.currentThread().setContextClassLoader(loader);
      TopThreadGroup.setContextClassLoader(loader);



    } catch ( Exception e ) {
      loader = this.getClass().getClassLoader();
      e.printStackTrace();
    }
  }
  /**
   *
   */
  private void initEAIHOME() {
//    String Separator = System.getProperty("file.separator");
    String PathName = LocalUserHome;//+UpdateObject.CODE_SPACE+Separator+ENTERPRISE+Separator;
    EASystem.put("eai.home",PathName);
    System.setProperty ("eai.home",PathName);
    //System.err.println("eai.home="+PathName);
  }
  /**
   *
   * @param pathList Vector
   */
  private void getPathList(Vector pathList) {
    String Separator = System.getProperty("file.separator");
    String PathName = PathName = LocalUserHome+UpdateObject.CODE_SPACE+Separator+ENTERPRISE+Separator;
    String home = PathName;//+"lib";
    File dirFile = new File(PathName);
    File[] files = dirFile.listFiles();
    if ( files == null ) return;
    File file = null;
    for(int i=0;i<files.length;i++) {
      file = files[i];
      if ( file.isDirectory() ) {
          home = file.getPath() + Separator;// + "lib";
          pathList.add(home);
      }
    }
  }
  private void initMETA_INF() {
    if ( loader == null )
      loader = this.getClass().getClassLoader();
    PackageStub.initMETA_INF(loader);
  }

}

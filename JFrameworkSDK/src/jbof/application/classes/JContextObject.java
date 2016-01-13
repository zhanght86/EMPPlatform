package jbof.application.classes;

import jbof.gui.window.classes.style.mdi.JBOFMDIChildWindow;
import jbof.gui.window.classes.style.mdi.JBOFMDIMainWindow;

import com.efounder.eai.application.classes.JBOFApplication;

import jframework.foundation.classes.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */
//--------------------------------------------------------------------------------------------------
//描述:
//设计: Skyline(2001.04.22)
//实现: Skyline
//修改:
//--------------------------------------------------------------------------------------------------
public class JContextObject {
  public JBOFApplication Application    = null;
  public JBOFMDIMainWindow  MainWindow     = null;
  public JBOFMDIChildWindow ChildWindow    = null;
  public JActiveObject   ActiveObject   = null;
  public Object          ParamObject    = null;
  public Object          DataObject     = null;
  public Object          CustomObject   = null;
  public Object          AdditiveObject = null;
  //------------------------------------------------------------------------------------------------
  //描述:
  //设计: Skyline(2001.12.29)
  //实现: Skyline
  //修改:
  //------------------------------------------------------------------------------------------------
  public JContextObject() {
  }
}
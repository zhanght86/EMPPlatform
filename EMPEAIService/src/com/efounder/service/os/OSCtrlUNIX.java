package com.efounder.service.os;

import java.io.*;

import com.core.servlet.*;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2004</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class OSCtrlUNIX implements IOSCtrl {

  /**
   *
   */
  public OSCtrlUNIX() {
  }

  /**
   *
   * @param jvmStub JVMStub
   * @return boolean
   */
  public boolean isValidJVM(JVMStub jvmStub) {
    Process p = null;
    String pid = jvmStub.getString("PID", "");
    try {
      p = Runtime.getRuntime().exec("ps -e");
      return OSCtrlUtil.containPID(p, pid);
    } catch (IOException ex) {
    }
    return false;
  }

}

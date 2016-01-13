package jfoundation.application.classes;

import jdcom.foundation.classes.*;
import jfoundation.gui.window.classes.*;
import javax.swing.*;
import java.awt.*;
import jbof.gui.window.classes.JBOFMainWindow;
/**
 * <p>Title: Java Framework</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author Skyline
 * @version 1.0
 */
//--------------------------------------------------------------------------------------------------
//描述:
//     (在应用中可以设置当前应用的资源文件)
//设计: Skyline(2001.04.22)
//实现: Skyline
//修改:
//--------------------------------------------------------------------------------------------------
public class JApplication extends JDComObject {
  public JBOFMainWindow   MainWindow    = null;       // ���
  protected String        strRegistryKey  = null;       // ע����е����
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public JApplication() {
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public void setMainWindow(JBOFMainWindow mwMainWindow) {
    this.MainWindow = mwMainWindow;
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public JMainWindow getMainWindow() {
    return MainWindow;
  }
  //----------------------------------------------------------------------------------------------
  //:
  //: Skyline(2001.12.29)
  //: Skyline
  //:
  //----------------------------------------------------------------------------------------------
  public void BeginWaitCursor() {
    if ( MainWindow != null) MainWindow.BeginWaitCursor();
  }
  //----------------------------------------------------------------------------------------------
  //
  // Skyline(2001.12.29)
  // Skyline
  //
  //----------------------------------------------------------------------------------------------
  public void EndWaitCursor() {
    if ( MainWindow != null ) MainWindow.EndWaitCursor();
  }
  /**
   *
   * @param title String
   * @param icon Icon
   * @param tip String
   * @param comp Component
   * @return Component
   */
  public Component OpenObjectWindow(String title,Icon icon, String tip,Component comp) {
    return null;
  }
  /**
   *
   * @param comp Component
   */
  public void CloseObjectWindow(Component comp) {

  }
  //------------------------------------------------------------------------------------------------
  //
  //  Key
  //
  //------------------------------------------------------------------------------------------------
  public void setRegistryKey(String strRegistryKey) {
    this.strRegistryKey = strRegistryKey;
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public String getRegistryKey() {
    return this.strRegistryKey;
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public boolean InitApplication() {
    return true;
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public boolean InitInstance() {
    return true;
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public int ExitInstance() { // return app exit code
    return 0;
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public int ExitApplication() {
    return 0;
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public boolean SaveAllModified() { // save before exit
    return true;
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public void HideApplication() {
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public void CloseAllWindows(boolean bEndSession) { // close documents before exiting
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public int Run(String Param,int WindowStyle) {
    return 0;
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public void About() {
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public void TipOfTheDay() {
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public boolean OnIdle(long lCount) { // return TRUE if more idle processing
    return true;
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public void ApplicationHelp(long dwData, int nCmd) {
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public void OnContextHelp() {   // shift-F1
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public void OnHelp() {           // F1 (uses current context)
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public void OnHelpIndex() {     // ID_HELP_INDEX
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public void OnHelpFinder() {    // ID_HELP_FINDER, ID_DEFAULT_HELP
  }
  //------------------------------------------------------------------------------------------------
  //
  //
  //
  //------------------------------------------------------------------------------------------------
  public void OnHelpUsing() {     // ID_HELP_USING
  }
}

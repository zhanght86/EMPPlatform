package com.efounder.pfc.window;

import java.awt.event.*;

import sun.awt.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class ChildWindowEvent {

  /**
   * The first number in the range of ids used for window events.
   */
  public static final int WINDOW_FIRST        = 200;

  /**
   * The window opened event.  This event is delivered only
   * the first time a window is made visible.
   */
  public static final int WINDOW_OPENED	= WINDOW_FIRST; // 200

  /**
   * The "window is closing" event. This event is delivered when
   * the user attempts to close the window from the window's system menu.
   * If the program does not explicitly hide or dispose the window
   * while processing this event, the window close operation will be
   * cancelled.
   */
  public static final int WINDOW_CLOSING	= 1 + WINDOW_FIRST; //Event.WINDOW_DESTROY

  /**
   * The window closed event. This event is delivered after
   * the window has been closed as the result of a call to dispose.
   */
  public static final int WINDOW_CLOSED	= 2 + WINDOW_FIRST;

  /**
   * The window iconified event. This event is delivered when
   * the window has been changed from a normal to a minimized state.
   * For many platforms, a minimized window is displayed as
   * the icon specified in the window's iconImage property.
   * @see java.awt.Frame#setIconImage
   */
  public static final int WINDOW_ICONIFIED	= 3 + WINDOW_FIRST; //Event.WINDOW_ICONIFY

  /**
   * The window deiconified event type. This event is delivered when
   * the window has been changed from a minimized to a normal state.
   */
  public static final int WINDOW_DEICONIFIED	= 4 + WINDOW_FIRST; //Event.WINDOW_DEICONIFY

  /**
   * The window-activated event type. This event is delivered when the Window
   * becomes the active Window. Only a Frame or a Dialog can be the active
   * Window. The native windowing system may denote the active Window or its
   * children with special decorations, such as a highlighted title bar. The
   * active Window is always either the focused Window, or the first Frame or
   * Dialog that is an owner of the focused Window.
   */
  public static final int WINDOW_ACTIVATED	= 5 + WINDOW_FIRST;

  /**
   * The window-deactivated event type. This event is delivered when the
   * Window is no longer the active Window. Only a Frame or a Dialog can be
   * the active Window. The native windowing system may denote the active
   * Window or its children with special decorations, such as a highlighted
   * title bar. The active Window is always either the focused Window, or the
   * first Frame or Dialog that is an owner of the focused Window.
   */
  public static final int WINDOW_DEACTIVATED	= 6 + WINDOW_FIRST;

  /**
   * The window-gained-focus event type. This event is delivered when the
   * Window becomes the focused Window, which means that the Window, or one
   * of its subcomponents, will receive keyboard events.
   */
  public static final int WINDOW_GAINED_FOCUS = 7 + WINDOW_FIRST;

  /**
   * The window-lost-focus event type. This event is delivered when a Window
   * is no longer the focused Window, which means keyboard events will no
   * longer be delivered to the Window or any of its subcomponents.
   */
  public static final int WINDOW_LOST_FOCUS   = 8 + WINDOW_FIRST;

  /**
   * The window-state-changed event type.  This event is delivered
   * when a Window's state is changed by virtue of it being
   * iconified, maximized etc.
   * @since 1.4
   */
  public static final int WINDOW_STATE_CHANGED = 9 + WINDOW_FIRST;

  /**
   * The last number in the range of ids used for window events.
   */
  public static final int WINDOW_LAST         = WINDOW_STATE_CHANGED;

  /**
   * The other Window involved in this focus or activation change. For a
   * WINDOW_ACTIVATED or WINDOW_GAINED_FOCUS event, this is the Window that
   * lost activation or focus. For a WINDOW_DEACTIVATED or WINDOW_LOST_FOCUS
   * event, this is the Window that gained activation or focus. For any other
   * type of WindowEvent, or if the focus or activation change occurs with a
   * native application, a Java application in a different VM, or with no
   * other Window, null is returned.
   *
   * @see #getOppositeWindow
   * @since 1.4
   */
  transient IView   opposite;
  transient IWindow source;

  /**
   * TBS
   */
  int oldState;
  int newState;


  /*
   * JDK 1.1 serialVersionUID
   */
  private static final long serialVersionUID = -1567959133147912127L;


  /**
   * Constructs a <code>WindowEvent</code> object.
   *
   * @param source	the <code>Window</code> object
   *                    that originated the event
   * @param id        an integer indicating the type of event.
   * @param opposite  the other window involved in the focus or activation
   *                      change, or <code>null</code>
   * @param oldState  previous state of the window for window state
   *                      change event
   * @param newState  new state of the window for window state change event
   * @since 1.4
   */
  public ChildWindowEvent(JChildWindow source, IView opposite,
                     int oldState, int newState)
  {
    this.source = source;
    this.opposite = opposite;
    this.oldState = oldState;
    this.newState = newState;
  }

  /**
   * Constructs a <code>WindowEvent</code> object with the
   * specified opposite <code>Window</code>. The opposite
   * <code>Window</code> is the other <code>Window</code>
   * involved in this focus or activation change.
   * For a <code>WINDOW_ACTIVATED</code> or
   * <code>WINDOW_GAINED_FOCUS</code> event, this is the
   * <code>Window</code> that lost activation or focus.
   * For a <code>WINDOW_DEACTIVATED</code> or
   * <code>WINDOW_LOST_FOCUS</code> event, this is the
   * <code>Window</code> that gained activation or focus.
   * If this focus change occurs with a native application, with a
   * Java application in a different VM, or with no other
   * <code>Window</code>, then the opposite Window is <code>null</code>.
   * <p>Note that passing in an invalid <code>id</code> results in
   * unspecified behavior.
   *
   * @param source     the <code>Window</code> object that
   *                   originated the event
   * @param id         <code>WINDOW_ACTIVATED</code>,
   *                   <code>WINDOW_DEACTIVATED</code>,
   *                   <code>WINDOW_GAINED_FOCUS</code>,
   *                   or <code>WINDOW_LOST_FOCUS</code>. It is
   *                   expected that this constructor will not be used for
   *                   other <code>WindowEvent</code> types because the
   *                   opposite <code>Window</code> of such events
   *                   will always be <code>null</code>
   * @param opposite   the other <code>Window</code> involved in the
   *                   focus or activation change, or <code>null</code>
   */
  public ChildWindowEvent(JChildWindow source, IView opposite) {
      this(source, opposite, 0, 0);
  }

  /**
   * Constructs a <code>WindowEvent</code> object with the specified
   * previous and new window states.
   *
   * @param source	the <code>Window</code> object
   *                  that originated the event
   * @param id	<code>WINDOW_STATE_CHANGED</code> event type.
   *                  It is expected that this constructor will not
   *                  be used for other <code>WindowEvent</code>
   *                  types, because the previous and new window
   *                  states are meaningless for other event types.
   * @param oldState	an integer representing the previous window state
   * @param newState	an integer representing the new window state
   * @since 1.4
   */
  public ChildWindowEvent(JChildWindow source, int oldState, int newState) {
      this(source, null, oldState, newState);
  }

  /**
   * Constructs a <code>WindowEvent</code> object.
   * <p>Note that passing in an invalid <code>id</code> results in
   * unspecified behavior.
   *
   * @param source the <code>Window</code> object that originated the event
   * @param id     an integer indicating the type of event
   */
  public ChildWindowEvent(JChildWindow source) {
      this(source, null, 0, 0);
  }

  /**
   * Returns the originator of the event.
   *
   * @return the Window object that originated the event
   */
  public IWindow getWindow() {
      return (source instanceof IWindow) ? (IWindow)source : null;
  }

  /**
   * Returns the other Window involved in this focus or activation change.
   * For a WINDOW_ACTIVATED or WINDOW_GAINED_FOCUS event, this is the Window
   * that lost activation or focus. For a WINDOW_DEACTIVATED or
   * WINDOW_LOST_FOCUS event, this is the Window that gained activation or
   * focus. For any other type of WindowEvent, or if the focus or activation
   * change occurs with a native application, with a Java application in a
   * different VM or context, or with no other Window, null is returned.
   *
   * @return the other Window involved in the focus or activation change, or
   *         null
   * @since 1.4
   */
  public IView getView() {
    return this.opposite;
  }

  /**
   * For <code>WINDOW_STATE_CHANGED</code> events returns the
   * previous state of the window. The state is
   * represented as a bitwise mask.
   * <ul>
   * <li><code>NORMAL</code>
   * <br>Indicates that no state bits are set.
   * <li><code>ICONIFIED</code>
   * <li><code>MAXIMIZED_HORIZ</code>
   * <li><code>MAXIMIZED_VERT</code>
   * <li><code>MAXIMIZED_BOTH</code>
   * <br>Concatenates <code>MAXIMIZED_HORIZ</code>
   * and <code>MAXIMIZED_VERT</code>.
   * </ul>
   *
   * @return a bitwise mask of the previous window state
   * @see java.awt.Frame#getExtendedState()
   * @since 1.4
   */
  public int getOldState() {
      return oldState;
  }

  /**
   * For <code>WINDOW_STATE_CHANGED</code> events returns the
   * new state of the window. The state is
   * represented as a bitwise mask.
   * <ul>
   * <li><code>NORMAL</code>
   * <br>Indicates that no state bits are set.
   * <li><code>ICONIFIED</code>
   * <li><code>MAXIMIZED_HORIZ</code>
   * <li><code>MAXIMIZED_VERT</code>
   * <li><code>MAXIMIZED_BOTH</code>
   * <br>Concatenates <code>MAXIMIZED_HORIZ</code>
   * and <code>MAXIMIZED_VERT</code>.
   * </ul>
   *
   * @return a bitwise mask of the new window state
   * @see java.awt.Frame#getExtendedState()
   * @since 1.4
   */
  public int getNewState() {
      return newState;
  }

  /**
   * Returns a parameter string identifying this event.
   * This method is useful for event-logging and for debugging.
   *
   * @return a string identifying the event and its attributes
   */

}

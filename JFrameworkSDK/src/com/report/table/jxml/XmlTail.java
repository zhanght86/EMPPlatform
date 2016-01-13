package com.report.table.jxml;

import java.awt.Font;

/**
 * 2007-8-29 fengbo。
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class XmlTail
    extends XmlElement {

  public XmlTail() {
  }

  private String align;
  private String fontname;
  private String fontsize;
  private java.util.Vector labels;
  private String fontstyle;
  public String getAlign() {
    return align;
  }

  public void setAlign(String align) {
    this.align = align;
  }

  public void setFontname(String fontname) {
    this.fontname = fontname;
  }

  public String getFontname() {
    return fontname;
  }

  public void setFontsize(String fontsize) {
    this.fontsize = fontsize;
  }

  public String getFontsize() {
    return fontsize;
  }

  public void setLabels(java.util.Vector labels) {
    this.labels = labels;
  }

  public java.util.Vector getLabels() {
    return labels;
  }

  public void setFontstyle(String fontstyle) {
    this.fontstyle = fontstyle;
  }

  public String getFontstyle() {
    return fontstyle;
  }

  public java.awt.Font getFont() {
    int Style = 0, Size = 0;
//    Style = Integer.parseInt(fontstyle);
    Size = Integer.parseInt(fontsize);
    Font f = new java.awt.Font(fontname, Style, Size);
    return f;
  }

  public XmlLabel getLabelById(String id) {
    return (XmlLabel) XmlManager.getElementById(this.getLabels(), id);
  }
}

package com.report.table.jxml;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author Lubo
 * @version 1.0
 */

public class XmlColumn
    extends XmlElement {

  public String no = "";
  public String caption = "";
  public String width = "";
  public String fontname = "";
  public String fontsize = "";
  public String viewctrl = "";
  public String editctrl = "";
  public String lock = "";
  public String change = "";
  public String datatype = "";
  public String fontstyle = "";
  public String format = "";
  public String align = "";
  public String showmask = "";
  public Object relation = "";

  public XmlColumn() {
  }

  public String getCaption() {
    return caption;
  }

  public String getChange() {
    return change;
  }

  public String getDatatype() {
    return datatype;
  }

  public String getEditctrl() {
    return editctrl;
  }

  public String getFontname() {
    return fontname;
  }

  public String getFontsize() {
    return fontsize;
  }

  public String getLock() {
    return lock;
  }

  public String getNo() {
    return no;
  }

  public String getViewctrl() {
    return viewctrl;
  }

  public String getWidth() {
    return width;
  }

  public String getShowMask(){
    return showmask;
  }
  public static void main(String[] args) {
    XmlColumn column1 = new XmlColumn();
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }

  public void setChange(String change) {
    this.change = change;
  }

  public void setDatatype(String datatype) {
    this.datatype = datatype;
  }

  public void setEditctrl(String editctrl) {
    this.editctrl = editctrl;
  }

  public void setFontname(String fontname) {
    this.fontname = fontname;
  }

  public void setFontsize(String fontsize) {
    this.fontsize = fontsize;
  }

  public void setLock(String lock) {
    this.lock = lock;
  }

  public void setNo(String no) {
    this.no = no;
  }

  public void setViewctrl(String viewctrl) {
    this.viewctrl = viewctrl;
  }

  public void setWidth(String width) {
    this.width = width;
  }

  public void setFontstyle(String fontstyle) {
    this.fontstyle = fontstyle;
  }

  public String getFontstyle() {
    return fontstyle;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getFormat() {
    return format;
  }

  public void setAlign(String align) {
    this.align = align;
  }

  public void setShowMask(String showmask){
    this.showmask = showmask;
  }

  public String getAlign() {
    return align;
  }

  public java.awt.Font getFont() {
    return null;
  }

  public void setRelationObject(Object relationobj) {
    relation = relationobj;
  }

}

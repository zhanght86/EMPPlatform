package com.report.table.jxml;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class XmlElement {
  public XmlElement() {
  }

  protected String id = "";
  protected String name = "";

     public String getId() {
         return id;
     }
     public String getName() {
         return name;

     }
     public void setId(String newId) {
         id = newId;
     }
     public void setName(String newName) {
         name = newName;
     }

}
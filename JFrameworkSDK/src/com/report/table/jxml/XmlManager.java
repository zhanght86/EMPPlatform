package com.report.table.jxml;

import org.jdom.*;
import java.util.List;
import java.util.Vector;
import org.jdom.filter.ElementFilter;
import java.util.AbstractList;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class XmlManager extends XmlPhysicalObject{
  public XmlManager() {

  }

  public XmlManager(String s){
    super(s);
  }
  /**
   * 获得以名字NodeName的结点
   * @param NodeName
   * @return
   */
  public List getElementsByTagName(String  NodeName) {
    return this.getChildrenNodes( this.getRootElement(),NodeName);
  }

  public boolean InsertBefore(Element ParentNode, Element NewNode, int IndexBefore) {
    List list = ParentNode.getChildren();
    Vector Children = new Vector();

    for ( int i = 0; i < list.size(); i ++){
      Children.add(list.get(i) );
    }

    if (ParentNode.removeChildren() && list != null) {
      Children.add(IndexBefore, NewNode);
      ParentNode.setChildren(Children);
    }
    else {
      ParentNode.addContent(NewNode);
    }

    return true;
  }

  public boolean RemoveAt(Element ParentNode, int Index) {
    List list = ParentNode.getChildren();
    if  ( list != null &&  list.size() > Index ){
      list.remove(Index);
      return true;
    }
    else {
      return false;
    }

  }

  /**
   * 获得指定的下级所有
   * @param StartElement
   * @param NodeName
   * @return
   */
  public List getChildrenNodes(Element StartElement,String  NodeName) {
    Element ResE = null,node;
    List nodelist;
    Element Start = StartElement;
    ElementFilter Fil = new ElementFilter(NodeName);
    if ( Start != null ){
      List  Child = Start.getChildren();
      Vector RES = new Vector();

      for ( int i = 0; i < Child.size(); i ++){
        Element EL = (Element)Child.get(i);
        if ( EL.getName().equals(NodeName)){
          RES.add(EL);
        }
      }
      return RES;
    }
    else
      return null;
  }

  /**
   * 获得文档对象
   * @return
   */
  public Document getDocment(){
    return Doc;
  }

  /**
   * 获得根元素
   * @param name
   * @return
   */
  public Element getRootElement(){
    return Root;
  }


  public java.util.List getNodeByTagName(String name){
      return  this.getElementsByTagName(name);
  }

  public static void setAttribute(Element node, String attrName ,String attrValue){
    Attribute abu =   node.getAttribute(attrName);
    if ( abu != null ){
      abu.setValue(attrValue);
    }
  }

  public static String getAttribute(Element node, String attrName){
      if(node == null || attrName == null){
          return "";
      }

      Attribute abu =   node.getAttribute(attrName);
      if ( abu != null ){
        return  abu.getValue();
      }
      else
        return "";

  }

  public static void printAttribute(Element node, String attrName) {
    //System.out.println(getAttribute(node,attrName));
  }

  //通过一个元素的id返回这个元素
  public static XmlElement getElementById(Vector v, String id) {
      for (int i = 0; i < v.size(); i++) {
          XmlElement element = (XmlElement) v.elementAt(i);
          if (element.getId().equals(id)) {
              return element;
          }
      }
      return null;
  }

  public static void printNode(Element node) {
    //System.out.println("方法printNode已被禁用.");

  }

  public static void printNodeList(List list) {
    //System.out.println("方法PrintNodeList已被禁用.");
  }

  public String printDOMTree() {
    return super.GetXMLString( getDocment());
  }


}

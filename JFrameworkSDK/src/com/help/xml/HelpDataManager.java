package com.help.xml;

import org.jdom.*;

import com.report.table.jxml.XmlManager;

import java.util.Vector;
import java.util.List;
/**
 * <p>Title: 帮助数据的XML.非公用类</p>
 * <p>Description: 特定类</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: Pansoft</p>
 * @author chaor
 * @version 1.0
 */

public class HelpDataManager extends XmlManager{

    private Element     Table;
    private Element     TableData;
    private Element     Rows;

    private void Init(){
      Table = super.getRootElement();
      TableData = super.GetElementByName( Table,"TableData");
      Rows      = super.GetElementByName( TableData,"Rows");

    }
    public HelpDataManager() {
        super();

        Table = super.CreateElement("Table");
        TableData = super.CreateElement("TableData");
        Rows = super.CreateElement("Rows");

        super.Root = Table;
        super.getDocment().setRootElement(Root);

        TableData.addContent(Rows);

        Table.addContent(TableData);

    }
    public HelpDataManager(java.io.InputStream is) {
        super();
        super.InitXMLStream(is);

        Init();
    }
    public HelpDataManager(String s) {
      super(s);
      //System.out.println(s);
      Init();
    }
    public Object[][] getTableDatas(Object[] colIds){
        int colMax = colIds.length;
        List rowList = super.getChildrenNodes( Rows,"Row");
        //计算行数
        int rowMax = 0;
        for(int i=0;i<rowList.size();i++){
            Element rowNode = (Element)rowList.get(i);
            //if(rowNode.getNodeType() == Node.ELEMENT_NODE){
                rowMax++;
            //}
        }
        Object[][] tableDatas = new Object[rowMax][colMax];
        int ip = 0;
        for(int i=0; i<rowList.size(); i++) {
            Element rowNode = (Element)rowList.get(i);
            //if(rowNode.getNodeType() == Node.ELEMENT_NODE){
                for(int j=0; j<colMax; j++){
                    tableDatas[ip][j] = getAttribute(rowNode,(String)colIds[j])==null?"":getAttribute(rowNode,(String)colIds[j]);
                }
                ip++;
            //}
        }
        return tableDatas;
    }
    //参数是一个数据行的属性列表
    //列表中的元素是2维字符串数组，一个属性名，一个属性值
    public void addDataRow(Vector v){
        Element Row;
        Row = super.CreateElement("Row");

        for(int i=0; i<v.size(); i++){
            String[] attr =  (String[])v.elementAt(i);
            Row.setAttribute(attr[0],attr[1]);
        }
        Rows.addContent(Row);
    }
}
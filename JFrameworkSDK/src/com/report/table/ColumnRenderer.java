package com.report.table;

import java.text.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.ResourceBundle;
/**
 * <p>Title: </p>
 * <p>Description:列的绘制器 </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: pansoft</p>
 * @author Lubo
 * @version 1.0
 */

public class ColumnRenderer extends DefaultTableCellRenderer {

  static ResourceBundle res = ResourceBundle.getBundle("com.pansoft.report.table.Language");
  private static final String DEFAULT_FORMAT = ",##0.00";
  public ColumnRenderer() {
    super();
  }
  public void init(){
    if(align.equalsIgnoreCase("left")){
      this.setHorizontalAlignment(SwingConstants.LEFT);
    }
    if(align.equalsIgnoreCase("right")){
      this.setHorizontalAlignment(SwingConstants.RIGHT);
    }
    if(align.equalsIgnoreCase("center")){
      this.setHorizontalAlignment(SwingConstants.CENTER);
    }

  }
public void setValue(Object value) {
    //  //System.out.println("to this "+ value.getClass());
    //
    //    if(datatype.equalsIgnoreCase("n") && value != null && !((String)value).trim().equals("")){ //&& (value != null) && (value instanceof Number)
    //        if(isDouble(value)){
    //            if((format == null) || format.trim().equals("")){
    //                format = DEFAULT_FORMAT;
    //            }
    //            NumberFormat formatter = new DecimalFormat(format);
    //          value = formatter .format(new Double((String)value).doubleValue());
    //        }
    //    }
    //    setText((value == null) ? "" : value.toString());
    //    super.setValue(value);
    //  //System.out.println("to this "+ value.getClass());

    if (datatype.equalsIgnoreCase("n")
        && value != null
        && !((String) value).trim().equals(
            "")) { //&& (value != null) && (value instanceof Number)
        if (isDouble(value)) {
            double v = Double.parseDouble((String) value);
            if (Math.abs(v) < 0.005) { //<0.01)
                value = "";
            } else {
                if ((format == null) || format.trim().equals("")) {
                    format = DEFAULT_FORMAT;
                }
                NumberFormat formatter = new DecimalFormat(format);
                value = formatter.format(v);
            }
        }
    }
    //    setText((value == null) ? "" : value.toString());
    super.setValue(value);

}
  private boolean isDouble(Object value){
      char c[] = ((String)value).toCharArray();
      for(int i=0 ; i<c.length; i++){
          if(c[i]<'0' || c[i]>'9'){
              if(c[i]!='.' && c[i]!='-' && c[i]!='e' && c[i]!='E'){
                  return false;
              }
          }
      }
      return true;
  }
  private String format;
  private String align;
  private String datatype;
  public void setFormat(String format) {
    this.format = format;
  }
  public String getFormat() {
    return format;
  }
  public void setAlign(String align) {
    this.align = align;
  }
  public String getAlign() {
    return align;
  }
  public void setDatatype(String datatype) {
    this.datatype = datatype;
  }
  public String getDatatype() {
    return datatype;
  }
}

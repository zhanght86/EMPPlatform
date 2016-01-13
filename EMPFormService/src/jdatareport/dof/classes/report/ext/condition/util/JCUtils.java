package jdatareport.dof.classes.report.ext.condition.util;

import java.util.*;

import javax.swing.*;

import jdatareport.dof.classes.report.ext.condition.ui.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Pansoft</p>
 * @author Stephen Zhao
 * @version 1.0
 */

public class JCUtils
    implements JCConstants {

    /**
     *
     * @param talle
     * @return
     */
    public static String getStoreExp(JCTable talle) {
        String expStr = "";
        JCTableModel model = (JCTableModel) talle.getModel();
        Vector exps = model.getExps();
        for (Enumeration e = exps.elements(); e.hasMoreElements(); ) {
            JCExpressionItem info = (JCExpressionItem) e.nextElement();
            expStr += info.toStoreString();
        }
        return expStr;
    }

    /**
     *
     * @param talle
     * @return
     */
    public static String getShowExp(JCTable talle) {
        String expStr = "";
        JCTableModel model = (JCTableModel) talle.getModel();
        Vector exps = model.getExps();
        for (Enumeration e = exps.elements(); e.hasMoreElements(); ) {
            JCExpressionItem info = (JCExpressionItem) e.nextElement();
            expStr += info.toShowString();
        }
        return expStr;
    }

    /**
     *
     * @return
     */
    public static boolean checkBeforeOk(JCTable table) {
        table.editingStopped(null);
        int[] checkIndexs = new int[] {
            1, 2, 5};
        String[] msgs = new String[] {
            "比较项目", "比较符", "连接符"};
        boolean flag = false;
        String msg = "";
        int rowCount = table.getRowCount();
        if (rowCount == 0) {
            return true;
        }
        //只有一行,不校验连接符
        if (rowCount == 1) {
            checkIndexs = new int[] {
                1, 2};
            for (int j = 0; j < checkIndexs.length; j++) {
                String value = table.getValueAt(0, checkIndexs[j]).toString();
                if (value == null || (value != null && value.length() == 0)) {
                    flag = true;
                    msg = msgs[j];
                    break;
                }
            }
        }
        else {
            for (int i = 0; i < table.getRowCount() - 1; i++) {
                for (int j = 0; j < checkIndexs.length; j++) {
                    String value = table.getValueAt(i, checkIndexs[j]).toString();
                    if (value == null || (value != null && value.length() == 0)) {
                        flag = true;
                        msg = msgs[j];
                        break;
                    }
                }
            }
            //多行不校验最后一行的连接符
            checkIndexs = new int[] {
                1, 2};
            for (int j = 0; j < checkIndexs.length; j++) {
                String value = table.getValueAt(table.getRowCount() - 1, checkIndexs[j]).toString();
                if (value == null || (value != null && value.length() == 0)) {
                    flag = true;
                    msg = msgs[j];
                    break;
                }
            }

        }

        if (flag) {
            JOptionPane.showMessageDialog(table, "缺少必要的" + msg + ",请修改" + msg, "系统提示", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return checkBracketMatch(table);
    }

    /**
     *
     * @return
     */
    public static boolean checkBeforeInsert(JCTable table) {
        table.editingStopped(null);
        int[] checkIndexs = new int[] {
            1, 2, 5};
        String[] msgs = new String[] {
            "比较项目", "比较符", "连接符"};
        boolean flag = false;
        String msg = "";
//        for (int i = 0; i < table.getRowCount(); i++) {
        int i = table.getSelectedRow();
        if (i != -1) {
            for (int j = 0; j < checkIndexs.length; j++) {
                String value = table.getValueAt(i, checkIndexs[j]).toString();
                if (value == null || (value != null && value.length() == 0)) {
                    flag = true;
                    msg = msgs[j];
                    break;
                }
            }
        }
//        }
        if (flag) {
            JOptionPane.showMessageDialog(table, "缺少必要的" + msg + ",请修改" + msg, "系统提示", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public static boolean checkBracketMatch(JCTable table) {        
        int leftCount = 0;
        int rightCount = 0;
        
        for (int i = 0; i < table.getRowCount(); i++) {
            String leftBracket = table.getValueAt(i, 0).toString();
            String rightBracket = table.getValueAt(i, 4).toString();
            if (leftBracket.equals("(")) {
            	leftCount++;
            }
            if (rightBracket.equals(")")) {
            	rightCount++;
            }
        }
        if (leftCount != rightCount) {
            JOptionPane.showMessageDialog(table, "左右括号不匹配,请修改左右括号", "系统提示", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
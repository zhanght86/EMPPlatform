package jdatareport.dof.classes.report.ext.condition.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import jdatareport.dof.classes.report.ext.condition.util.*;
import jfoundation.gui.window.classes.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: Pansoft</p>
 * @author Stephen Zhao
 * @version 1.0
 */

public class JCNameDialog
    extends JFrameDialog
    implements ActionListener {
    /**
     *
     */
    private JCExpression mExp = null;
    /**
     *
     */
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private BorderLayout borderLayout1 = new BorderLayout();
    private JPanel jPanel3 = new JPanel();
    private Border border1;
    private JButton mOkBtn = new JButton();
    private JButton mCancelBtn = new JButton();
    private FlowLayout flowLayout1 = new FlowLayout();
    private JPanel jPanel4 = new JPanel();
    private BorderLayout borderLayout2 = new BorderLayout();
    private JPanel jPanel5 = new JPanel();
    private Border border2;
    private TitledBorder titledBorder1;
    private Border border3;
    private TitledBorder titledBorder2;
    private JTextField mNameTf = new JTextField();
    private BorderLayout borderLayout3 = new BorderLayout();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JTextArea mExpTa = new JTextArea();
    private BorderLayout borderLayout4 = new BorderLayout();
    /**
     *
     */
    public JCNameDialog(Dialog parent, String title, boolean isModal) {
        super(parent, title, isModal);
        try {
            jbInit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
        border1 = BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.white, Color.white, new Color(118, 118, 114), new Color(169, 169, 164));
        border2 = BorderFactory.createEmptyBorder();
        titledBorder1 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(169, 169, 164)), "条件名称");
        border3 = BorderFactory.createEmptyBorder();
        titledBorder2 = new TitledBorder(BorderFactory.createEtchedBorder(Color.white, new Color(169, 169, 164)), "条件内容");
        jPanel1.setLayout(borderLayout1);
        jPanel2.setBorder(border1);
        jPanel2.setLayout(borderLayout2);
        mOkBtn.setText("确定");
        mOkBtn.addActionListener(this);
        mCancelBtn.setText("取消");
        mCancelBtn.addActionListener(this);
        jPanel3.setLayout(flowLayout1);
        flowLayout1.setAlignment(FlowLayout.RIGHT);
        jPanel5.setBorder(titledBorder1);
        jPanel5.setLayout(borderLayout4);
        jPanel4.setBorder(titledBorder2);
        jPanel4.setLayout(borderLayout3);
        mNameTf.setPreferredSize(new Dimension(200, 24));
        mNameTf.setText("");
        mExpTa.setEditable(false);
        mExpTa.setText("");
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        jPanel1.add(jPanel2, BorderLayout.CENTER);
        jPanel2.add(jPanel4, BorderLayout.CENTER);
        jPanel4.add(jScrollPane1, BorderLayout.CENTER);
        jScrollPane1.getViewport().add(mExpTa, null);
        jPanel2.add(jPanel5, BorderLayout.NORTH);
        jPanel5.add(mNameTf, BorderLayout.CENTER);
        jPanel1.add(jPanel3, BorderLayout.SOUTH);
        jPanel3.add(mOkBtn, null);
        jPanel3.add(mCancelBtn, null);
        this.setSize(300, 200);
        this.setMinimumSize(300, 200);
        this.CenterWindow();
    }

    /**
     *
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.mOkBtn) {
            onOk();
        }
        else if (e.getSource() == this.mCancelBtn) {
            onCancel();
        }
    }

    /**
     *
     * @param exp
     */
    public void setExpression(JCExpression exp) {
        if (exp != null) {
            this.mExp = exp;
            this.mExpTa.setText(exp.mShowValue);
        }
    }

    /**
     *
     */
    private void onOk() {
        if (checkBeforeOk()) {
            super.OnOk();
        }
    }

    /**
     *
     */
    private void onCancel() {
        super.OnCancel();
    }

    public String getName() {
        return this.mNameTf.getText().trim();
    }

    /**
     *
     * @return
     */
    private boolean checkBeforeOk() {
        String name = getName();
        if (name.length() == 0) {
            return false;
        }
        return true;
    }
}
package com.efounder.dctbuilder.event.plugin;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.borland.dx.dataset.DataSetView;
import com.core.xml.StubObject;
import com.efounder.bz.dbform.datamodel.ColumnModel;
import com.efounder.bz.dbform.datamodel.DictModel;
import com.efounder.bz.dbform.datamodel.column.Column;
import com.efounder.dbc.ClientDataSet;
import com.efounder.dbc.DictMetadataManager;
import com.efounder.dbc.blob.BlobDataSet;
import com.efounder.dbc.swing.editor.DictTableCellEditorWrapper;
import com.efounder.dbc.swing.help.IHelpCallBack;
import com.efounder.dbc.swing.render.DictTableCellRendererWrapper;
import com.efounder.dbc.swing.table.ICellEditable;
import com.efounder.dctbuilder.data.ColumnMetaData;
import com.efounder.dctbuilder.data.DctContext;
import com.efounder.dctbuilder.data.DictMetaDataEx;
import com.efounder.dctbuilder.event.DataLoaderCltAdapter;
import com.efounder.dctbuilder.util.MetaDataUtil;
import com.efounder.dctbuilder.view.DictView;
import com.efounder.service.meta.db.DictMetadata;
import com.pub.util.ESPKeyValueUtil;
import com.pub.util.StringFunction;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class DataSetMetaDataProcess extends DataLoaderCltAdapter implements Serializable {

	public DataSetMetaDataProcess() {
    }

    //load完以后要设备dataSet的column属性
    //column 设置列名 列类
    public void beforeDataLoad(DictModel dm, DctContext context) throws Exception {
    	
	}

    public void afterDataLoad(DictModel dm, DctContext context) throws Exception {
    	ICellEditable                 ice = dm.getICellEditable();
		DictView                     view = (DictView) ice;
		ColumnModel           columnModel = view.getTable().getColModel();
		DictMetaDataEx           metaData = dm.getMetaData();
//	    List                      colList = metaData.getUsedColList();
		List                      colList = metaData.getOrdinalMetadata().getTableMetadata().getColList();
	    ColumnMetaData        colMetaData = null;

	    if(dm.getColModel().getColumnCount() == 0) {
	    	columnModel = new ColumnModel();
			view.getTable().setColModel(columnModel);
			dm.setColModel(columnModel);
			for(int i = 0; i < colList.size(); i++) {
				colMetaData = (ColumnMetaData) colList.get(i);
				if(colMetaData.isVisible()) columnModel.addColumn(colMetaData);
			}
			dm.getDataSet().setColumnModel(columnModel);	
	    }
		initFKeyCellRenderer1(dm);
	}
    
    public void afterDataSave(DictModel dm, DctContext context) throws Exception {
    	ICellEditable                 ice = dm.getICellEditable();
		DictView                     view = (DictView) ice;
		ColumnModel           columnModel = view.getTable().getColModel();

		dm.getDataSet().setColumnModel(columnModel);	
	}
    
	/**
	 *
     * @param dm DictModel
     */
	private void setInitColumns(DictModel dm) {
		if (dm.getNodeStub() == null) return;
		DictMetaDataEx dmd = dm.getMetaData();
		String initColumns = dm.getNodeStub().getString("initColumns", "");
		String[]   columns = StringFunction.split(initColumns, ",");
		for (int i = 0; columns != null && i < columns.length; i++) {
			ColumnMetaData cmd = (ColumnMetaData) dmd.getUsedColInfo(columns[i]);
			if (cmd != null)
				cmd.setString("COL_VISIBLE", "1");
		}
	}

	/**
	 *
	 *
	 * @param dm DictModel
	 */
	private void initFKeyCellRenderer1(DictModel dm) {
		DictMetaDataEx dmd = dm.getMetaData();
		List          list = dmd.getUsedColList();
		for (int i = 0; i < list.size(); i++) {
			ColumnMetaData cmd = (ColumnMetaData) list.get(i);
			//格式如：HELPFOBJ=@DCT_ID@、HELPFOBJ=ACBKZD
			if (cmd.getHelpFObj().trim().length() > 0) {
				processColumn1(dm, cmd);
			}
		}
	}

	/**
	 *
	 * @param  dm DictModel
	 * @param cmd ColumnMetaData
	 */
	private void processColumn1(DictModel dm, ColumnMetaData cmd) {
		String     fobjid = cmd.getHelpFObj().trim();
		ClientDataSet cds = dm.getDataSet();
		//如果是变量，从数据中获取
		if (fobjid.startsWith("@") && fobjid.endsWith("@")) {
			fobjid = fobjid.substring(1, fobjid.length() - 1);
//			fobjid = getObjID(cds, fobjid);
		}
		cmd.setString("COL_FOBJ", fobjid);
		cmd.setString("COL_ISFKEY",  "1");
//		setFKeyCellRenderer(cds, cmd.getColid(), fobjid);
	}

	/**
	 * 从加载的数据中获取值
	 */
//	private String getObjID(ClientDataSet cds, String fobjid) {
//		if (cds.hasColumn(fobjid) == null) return "";
//		ClientDataSet cdss = DictUtil.copyDataSet(cds, true);
//		for (int i = 0,  n = cdss.getRowCount(); i < n; i++) {
//			cdss.goToRow(i);
//			String value = cdss.format(fobjid);
//			if (value.trim().length() > 0) {
//				return value;
//			}
//		}
//		return "";
//	}
//
//	/**
//	 *
//	 */
//	private void setFKeyCellRenderer(ClientDataSet cds, String column, String fobjid){
//		Column pcolumn = cds.getColumn(column);
//		Object painter = pcolumn.getItemPainter();
//		if (painter != null && painter instanceof FkeyCellRenderer) {
//			( (FkeyCellRenderer) painter).setDctKey(fobjid);
//		}
//	}

	public void SetColumnPropery(DictModel dm, DctContext context) throws  Exception {
		try {
			if (!(dm.getView() instanceof DictView)){
				return;
			}
			DictView      view = (DictView) dm.getView();
			ClientDataSet  cds = dm.getDataSet();
			DictMetaDataEx dmd = dm.getMetaData();
			List          list = dmd.getUsedColList();
			String colid;
//			for (int i = 0; i < cds.getColumnCount(); i++)
//				cds.getColumn(i).setVisible(false);
           //
			setInitColumns(dm);
			StubObject nodeStub = null;
			try {
				nodeStub = dm.getNodeStub();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			for (int i = 0; i < list.size(); i++) {
				ColumnMetaData cmd = (ColumnMetaData) list.get(i);
				colid = cmd.getColid();
				if (cds.hasColumn(colid) == null) continue;
				Column col = cds.getColumn(colid);
				String cap = cmd.getColMc();
				col.setInternalDataSetID(dmd.getDctid());
				col.setDataSetColID(cmd.getColid());
//				if (!cmd.isNull())
//					cap += "(*)";
				//如果关键指标中定义了ALLOWNULL则以关键指标为准，如果没有则以列定义为准
				String allownull = "";
				if(cmd.isNull()){
					allownull = "1";
				}else{
					allownull = "0";
          	    }
				String srccont = cmd.getString("F_SRCCONT", "");
				if(srccont != null && srccont.length()>0){
					srccont = srccont.toUpperCase();
				}
				allownull = ESPKeyValueUtil.getValueByKey("ALLOWNULL", allownull, srccont);
				if (!"1".equals(allownull))
					cap += "(*)";
				col.setTitle(cap);
				if (cmd.isFKEY()) {
					Object o1 = context.getFKEYMetaData(cmd.getFOBJ());
					if(o1 == null){
						o1 = DictMetadataManager.getDefault().getMetaData(cmd.getFOBJ(), "");
						context.setFKEYMetaData(cmd.getFOBJ(), o1);
					}
					if (o1 != null) {
						cmd.setFKMetaData(o1);
					}
					Object o2 = context.getFKEYDataSet(cmd.getFOBJ());
					if (o2 == null) {
//                       JParamObject PO = JParamObject.Create();
//                       PO.setEAIServer(colServerName);
//                       o2 = MDMDataUtil.getMainDctData(PO, cmd.getFOBJ(), false);
//                       context.setFKEYDataSet(cmd.getFOBJ(), o2);
					}
					if (o2 != null) {
						cmd.setFKDataSet(o2);
					}
					//设置菜单上定义的字段外键字典帮助条件(在菜单上的key为colid + "_FHelpWhere")
					if (nodeStub != null){
						String NodeFHelpWhere = nodeStub.getString(colid + "_FHelpWhere", "");
						cmd.setString("NodeFHelpWhere",NodeFHelpWhere);
					}
				}
				//把DataModel作为一个对象传给列的元数据，帮助的时候用
				cmd.setLostValue("DictModelObject", dm);
				Object o = MetaDataUtil.getColumnEditor(cmd);
				if(o == null && cds instanceof BlobDataSet && cmd.getColType().equals("B")){
					o = MetaDataUtil.getColumnBlobEditor((BlobDataSet)cds,cmd);
				}
				if (o != null && view != null) {
					col.setCellEditor(new DictTableCellEditorWrapper( (TableCellEditor) o, view.getTable()));
				}
				String key = dm.getUserPluginKey();
				String  editGray = cmd.getExtAttriValue("COL_OPT", "=", ";", "editGray"); // 不可编辑时显示灰色 1:按此规则处理;0:不处理
				if (editGray == null || editGray.trim().length() == 0)
					editGray = "0";
				boolean readOnly = dm.getCdsParam().isReadOnly() || "0".equals(editGray);
				o = MetaDataUtil.getColumnRender(cmd);
				if (o != null)
                   col.setCellRenderer(new DictTableCellRendererWrapper((TableCellRenderer)o, view.getTable(), key, readOnly));
				col.setVisible(cmd.isVisible() ? true : false);
				String pattern = cmd.getDispPattern();
//				if (pattern != null)
//					col.setDisplayMask(pattern);
//				pattern = cmd.getEditPattern();
//				if (pattern != null) {
//					col.setEditMask(pattern);
//				}
//				if (cmd.getColDispLen() > 50) {
//					col.setWidth(50);
//				} else {
//				col.setMaxWidth(cmd.getColDispLen());
//				col.setMinWidth(cmd.getColDispLen());
				col.setPreferredWidth(cmd.getColDispLen());
				col.setWidth(cmd.getColDispLen());
//				}
			}
			/**
			 * 分级的字典编码才使用
			 */
//			if (dmd.isGradeDict() && !dmd.getDctBmCol().trim().equals("")) {
//				cds.getColumn(dmd.getDctBmCol()).setItemPainter(new GradeBmCellRenderer(dmd));
//				if (view != null)
//					cds.getColumn(dmd.getDctBmCol()).setItemEditor( (new DictTableCellEditorWrapper(new GradeBmCellEditor(dmd), view.getTable())));
//			}
			//设置特殊的外键帮助字段的显示
			initFKeyCellRenderer2(dm);
			//因为行号，所以需要updateUI一下，否则行号出不来
			view.updateUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 *
	 *
	 * @param dm DictModel
	 */
	private void initFKeyCellRenderer2(DictModel dm) {
		DictMetaDataEx dmd = dm.getMetaData();
		List          list = dmd.getUsedColList();
		for (int i = 0; i < list.size(); i++) {
			ColumnMetaData cmd = (ColumnMetaData) list.get(i);
			//格式如：helpClass=com.pansoft.....
			if (cmd.getHelpClass().trim().length() > 0) {
				processColumn2(dm, cmd);
			}
		}
	}

	/**
	 *
	 * @param dm DictModel
	 * @param cmd ColumnMetaData
	 */
	private void processColumn2(DictModel dm, ColumnMetaData cmd) {
		if (cmd.getLostValue("IHelpCallback", null) == null) return;
		IHelpCallBack callback = (IHelpCallBack) cmd.getLostValue("IHelpCallback", null);
//		setFKeyCellRenderer(dm.getDataSet(), cmd.getColid(), callback.getHelpFKey());
	}

	/**
	 *
	 * @param o1 DictModel
	 * @param context DctContext
	 * @return Object
	 * @throws Exception
	 */
	public Object beforeDataSave(DictModel dictModel, DctContext context) throws Exception {
		Map map = new HashMap();
		DictMetaDataEx dmd = dictModel.getMetaData();
		String dctid = dmd.getDctid();
		java.util.List colList = dictModel.getMetaData().getUsedColList();
		if(colList == null || colList.size() == 0){
			return null;
		}
		ColumnMetaData cmd = null;
		for (int i = 0, n = colList.size(); i < n; i++) {
			cmd = (ColumnMetaData) colList.get(i);
			String colid = cmd.getString("COL_ID", "");
	        if (cmd == null) return null;
	        int edittype = cmd.getColEditType();
	        if(edittype != 15){
	        	continue;
	        }
	        String view = cmd.getColView();
	 		context.setValue(dctid + "-" + colid + "-ColView", view);
		}
       return null;
	}

	/**
	 * 将所有的主键列为空的改为一个空格
	 * @param  dsvInserted DataSetView
	 * @param dictMetadata DictMetadata
	 */
	protected void processDCTKeyColumn(DataSetView dsview, DictMetadata dictMetadata) {
//		if (dictMetadata == null) return;
//		DictMetaDataEx dmd = new DictMetaDataEx(dictMetadata);
//		if (dmd == null) return;
//		java.util.List key = dmd.getKeyColumnName();
//		for (int i = 0; key != null && i < key.size(); i++) {
//			String col = (String) key.get(i);
//			if (col == null || col.trim().length() == 0) continue;
//			Column column = dsview.hasColumn(col);
//			if (column == null) continue;
//			String val = DictUtil.getVariantValue(dsview, col);
//			if (val == null || val.length() == 0) {
//				val = " ";
//				DictUtil.setVariantValue(dsview, col, val);
//			}
//		}
	}
}

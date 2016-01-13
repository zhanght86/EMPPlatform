package com.efounder.manager.meta.client.fctmodel;

import com.efounder.builder.meta.*;
import com.efounder.builder.base.util.ESPContext;
import com.efounder.eai.EAI;
import com.efounder.eai.data.JParamObject;
import com.efounder.builder.base.util.ESPClientContext;
import com.efounder.eai.data.JResponseObject;
import com.core.xml.PackageStub;
import com.core.xml.StubObject;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2009</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class DOFFCTMetaDataManager
    extends ClientMetaDataManager {
  public DOFFCTMetaDataManager() {
  }
  /**
   *
   * @param objid String
   * @return MetaData
   */
  public MetaData getMetaData(String objid)  throws Exception {
    java.util.List modelList = PackageStub.getContentVector("BIZFCTList");
    JParamObject po = JParamObject.Create();
    for(int i=0;(modelList!=null && i<modelList.size());i++) {
      StubObject stub = (StubObject)modelList.get(i);
      if ( !objid.equals(stub.getID()) ) continue;
      po.setEAIServer(stub.getString("eaiServer",null));
    }
    ESPContext espContext = ESPClientContext.getInstance(po);
    return getMetaData(espContext,objid);
  }
  /**
   *
   * @param ctx MetaContext
   * @param objid String
   * @return MetaData
   * @todo Implement this com.efounder.builder.meta.MetaDataManager method
   */
  protected MetaData getMetaDataModel(ESPContext ctx, String objid,MetaData metaData) throws Exception {
    JParamObject paramObject = ((ESPClientContext)ctx).getParamObject();
    paramObject.setValue("OBJ_ID",objid);
    paramObject.setValue("META_TYPE",MetaDataManager._FCTObject_);
    JResponseObject ro = (JResponseObject)EAI.DOF.IOM("BZMetaDataService","getMetaData",paramObject);
    if(ro==null)return null;
//    MetaData metaData = null;
    metaData = (MetaData)ro.getResponseObject();
    return metaData;
  }

  /**
   *
   * @param metaData MetaData
   * @return Object
   * @throws Exception
   */
  public Object updateMetaData(MetaData metaData) throws Exception {
    java.util.List modelList = PackageStub.getContentVector("BIZFCTList");
    JParamObject po = JParamObject.Create();
    for(int i=0;(modelList!=null && i<modelList.size());i++) {
      StubObject stub = (StubObject)modelList.get(i);
      if (!metaData.getObjID().equals(stub.getID()) ) continue;
      po.setEAIServer(stub.getString("eaiServer",null));
    }
    ESPContext espContext = ESPClientContext.getInstance(po);
    return updateMetaData(espContext, metaData);
  }
  /**
   *
   * @param metaData MetaData
   * @return Object
   * @throws Exception
   */
  public Object updateMetaData(ESPContext ctx, MetaData metaData) throws Exception {
    return updateMetaData(MetaDataManager._FCTObject_, ctx, metaData);
  }
}
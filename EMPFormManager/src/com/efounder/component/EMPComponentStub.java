package com.efounder.component;

import java.util.List;
import java.util.Map;

public class EMPComponentStub {
	private    List                      childList = null;
	protected   Map                 refCompStubMap = null;
	private  String                      compClazz = "";
	private  String                         compID = "";
	private  String                       compName = "";
	private  String                      compScope = "";
	
	public static String                   prepare = "prepare";
	
	public static String                   execute = "execute";
	
	public static String                    finish = "finish";
	
	public static String                prepareKey = "prepareServiceComponent";
	
	public static String                processKey = "processServiceComponent";
	
	public static String                 finishKey = "finishServiceComponent";
	
	public static String               builderKey  = "serviceContextBuilder";
	
	public static String         servicePluginList = "servicePluginList";
	
	public EMPComponentStub() {
		
	}
	
	public EMPComponentStub(EMPComponentStub stub) {
		this.compID = stub.getCompID();
		this.compName = stub.getCompName();
		this.compClazz = stub.getCompClazz();
	}
	
	public List getChildList() {
		return childList;
	}
	public void setChildList(List childList) {
		this.childList = childList;
	}
	public Map getRefCompStubMap() {
		return refCompStubMap;
	}
	public void setRefCompStubMap(Map refCompStubMap) {
		this.refCompStubMap = refCompStubMap;
	}
	public String getCompClazz() {
		return compClazz;
	}
	public void setCompClazz(String compClazz) {
		this.compClazz = compClazz;
	}
	public String getCompID() {
		return compID;
	}
	public void setCompID(String compID) {
		this.compID = compID;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompScope() {
		return compScope;
	}
	public void setCompScope(String compScope) {
		this.compScope = compScope;
	}
}

package esyt.framework.com.component;

import dwz.dal.object.AbstractDO;

public class EMPComposeFormInfo extends AbstractDO{
	protected EMPComponentStub dataContainerStub = null;
	private             String            FormID;
	private             String          FormName;
	private             String          FormType;
	
	public EMPComponentStub getDataContainerStub() {
		return dataContainerStub;
	}
	public void setDataContainerStub(EMPComponentStub dataContainerStub) {
		this.dataContainerStub = dataContainerStub;
	}
	public String getFormID() {
		return FormID;
	}
	public void setFormID(String FormID) {
		this.FormID = FormID;
	}
	public String getFormName() {
		return FormName;
	}
	public void setFormName(String FormName) {
		this.FormName = FormName;
	}
	public String getFormType() {
		return FormType;
	}
	public void setFormType(String FormType) {
		this.FormType = FormType;
	}
}

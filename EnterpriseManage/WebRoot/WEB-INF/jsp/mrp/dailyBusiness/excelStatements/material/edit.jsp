<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../../../../include.inc.jsp"%>

<div class="pageContent">
<form method="post" action="${ctx}/dailyBusiness/excelStatements/material/update/${hyxmmxObject.f_XMBH}?navTabId=statementsMateialLiNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
	<div class="pageFormContent" layoutH="56">
		<p>
			<label>材料编号: </label>
			<input type="text" name="F_CLBH" value="${hyxmmxObject.f_CLBH}" readonly="readonly" class="required"/>
		</p>
		<p>
			<label>材料名称: </label>
			<input type="text" name="F_CLMC" value="${hyxmmxObject.f_CLMC}" readonly="readonly" class="required"/>
		</p>
		<div class="divider"></div>
		<p>
			<label>数量: </label>
			<input type="text" name="F_SL" value="${hyxmmxObject.f_SL}" class="required"/>
		</p>	
		<p>
			<label>库存情况: </label>
			<input type="text" name="F_KCQK" value="${hyxmmxObject.f_KCQK}"/>
		</p>	
		<p>
			<label>备注: </label>
			<input type="text" name="F_BZ" value="${hyxmmxObject.f_BZ}"/>
		</p>				
		<div class="divider"></div>
		<p>
			<label>创建时间: </label>
			<fmt:formatDate value="${hyxmmxObject.f_CRDATE}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</p>
		<p>
			<label>修改时间: </label>
			<fmt:formatDate value="${hyxmmxObject.f_CHDATE}" pattern="yyyy-MM-dd HH:mm:ss"/>
		</p>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
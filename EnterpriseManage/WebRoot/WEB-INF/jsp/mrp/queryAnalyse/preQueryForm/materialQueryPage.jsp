<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../../../include.inc.jsp"%>

<style type="text/css">
	ul.rightTools {float:right; display:block;}
	ul.rightTools li{float:left; display:block;}
</style>

<form method="post" action="${ctx}/queryAnalyse/materialDetails" navTabId="materialDetailsLiNav" title="材料明细查询" callbackType="closeCurrent" class="pageForm required-validate" onsubmit="return validateDialogCallback(this, dialogAjaxNavTab);">
	<div class="pageFormContent" layoutH="56" style="height: 1000px;">
		<p style="width:300px;padding: 10px;">
			<label style="width:100px;padding: 0px;">查询起始日期：</label>
			<input type="text" id="beginDate" name="beginDate" value="${beginDate}" class="date" readonly="true"/>
			<a class="inputDateButton" href="javascript:;" style="width:20px;padding: 0px;">选择</a>
		</p>
		<p style="width:300px;padding: 10px;">
			<label style="width:100px;padding: 0px;">查询截止日期：</label>
			<input type="text" id="endDate" name="endDate" value="${endDate}" class="date" readonly="true"/>
			<a class="inputDateButton" href="javascript:;" style="width:30px;padding: 0px;">选择</a>
		</p>
		
		<p id="outBoundPreForm" style="width:300px;padding: 10px;">
			<label style="width:100px;padding: 0px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;仓库编号：</label>
			<input id="F_CKBH" name="F_CKBH" type="text" postField="keyword" suggestFields="F_CKBH" lookupGroup="org1"/>
			<a class="btnLook" href="${ctx}/dictHelp/deportHelp"" lookupGroup="">查找带回</a>	
			<span class="info"></span>
		</p>
		
		<p id="outBoundPreForm" style="width:300px;padding: 10px;">
			<label style="width:100px;padding: 0px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;项目编号：</label>
			<input id="F_XMBH" name="F_XMBH" type="text" postField="keyword" suggestFields="F_XMBH" lookupGroup="org1"/>
			<a class="btnLook" width="1000" href="${ctx}/queryAnalyse/help/project?beginDate={beginDate}&endDate={endDate}&F_XMZT=-1&F_XMBH=" lookupGroup="">查找带回</a>	
			<span class="info"></span>
		</p>
		
		<p id="outBoundPreForm" style="width:300px;padding: 10px;">
			<label style="width:100px;padding: 0px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;材料编号：</label>
			<input name="F_CLBH" type="text" postField="keyword" suggestFields="F_CLBH" lookupGroup="org1"/>
			<a class="btnLook" href="${ctx}/queryAnalyse/help/material/helpMaterial?F_XMBH={F_XMBH}&beginDate={beginDate}&endDate={endDate}&F_CLBH=" isCheck="false" lookupGroup="">查找带回</a>	
			<span class="info"></span>
		</p>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">确定</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
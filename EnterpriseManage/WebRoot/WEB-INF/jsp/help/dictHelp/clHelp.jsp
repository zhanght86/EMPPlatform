<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../../include.inc.jsp"%>


<form id="pagerForm" action="demo/database/dwzOrgLookup.html">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="${ctx}/dailyBusiness/excelStatements/material/search" onsubmit="return dwzSearch(this, 'dialog');">
	<div class="searchBar" >
		<ul class="searchContent">
			<li>
				<label>材料编号:</label>
				<input class="textInput" name="keywords" value="${param.keywords}" type="text">
			</li>	  		
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
		</ul>
	</div>
	</form>
</div>
<div class="pageContent">

	<table class="table" layoutH="98" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th orderfield="orgName">序号</th>
				<th orderfield="orgName">材料编号</th>
				<th orderfield="orgNum">材料名称</th>
				<th orderfield="orgNum">型号规格</th>
				<th orderfield="orgNum">单位</th>
				<th orderfield="orgNum">供应商编号</th>
				<th width="80">查找带回</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${hyclList}" varStatus="s">
				<tr target="slt_objId" rel="${item.f_CLBH}">
					<td>${s.index + 1}</td>
					<td>${item.f_CLBH}</td>
					<td>${item.f_CLMC}</td>		
					<td>${item.f_GGXH}</td>
					<td>${item.f_JLDW}</td>		
					<td>${item.f_DWBH}</td>		
					<td>
						<a class="btnSelect" href="javascript:$.bringBack({F_CLMC:'${item.f_CLMC}', F_CLBH:'${item.f_CLBH}', F_DWBH:'${item.f_DWBH}', F_DWMC:'${item.f_DWMC}'})" title="查找带回">选择</a>
					</td>
				</tr>	
			</c:forEach>
		</tbody>
	</table>

	<div class="panelBar">
		<div class="pages">
			<span>每页</span>

			<select name="numPerPage" onchange="dwzPageBreak({targetType:dialog, numPerPage:'10'})">
				<option value="10" selected="selected">10</option>
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
			</select>
			<span>条，共2条</span>
		</div>
		<div class="pagination" targetType="dialog" totalCount="2" numPerPage="10" pageNumShown="1" currentPage="1"></div>
	</div>
</div>
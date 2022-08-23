<%-- 
    Document   : them-sua-moi
    Author     : hv
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page2" class="main">
    <div class="col1 thuc-don">
        <%@include  file="thuc-don.jsp" %>
    </div>
    <div class="col2">
        <form name="frmThemSua" action="trang-them-sua-moi.jsp" method="post">
        <table border="1">
            <tbody>
                <tr>
                    <td>Mã sữa: </td>
                    <td><input type="text" name="txtMaSua" value="${param.txtMaSua }" /></td>
                </tr>
                <tr>
                    <td>Tên sữa: </td>
                    <td><input type="text" name="txtTenSua" value="${param.txtTenSua }" /></td>
                </tr>
                <tr>
                    <td>Hãng sữa: </td>
                    <td><select name="cboHangSua">
                            <c:forEach items="${dshs}" var="hs">
                            <option value="${hs.maHangSua}" >${hs.tenHangSua}</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>Lọai sữa: </td>
                    <td><select name="cboLoaiSua">
                            <c:forEach items="${dsls}" var="ls">
                            <option value="${ls.maLoaiSua}">${ls.tenLoai }</option>
                            </c:forEach>
                        </select></td>
                </tr>
                <tr>
                    <td>Trọng lượng: </td>
                    <td><input type="text" name="txtTrongLuong" value="${param.txtTrongLuong }" /></td>
                </tr>
                <tr>
                    <td>Đơn giá: </td>
                    <td><input type="text" name="txtDonGia" value="${param.txtDonGia }" /></td>
                </tr>
                <tr>
                    <td>TP dinh dưỡng: </td>
                    <td><textarea name="txtTPDinhDuong" rows="4" cols="20">
                            ${param.txtTPDinhDuong }
                        </textarea></td>
                </tr>
                <tr>
                    <td>Lợi ích: </td>
                    <td><textarea name="txtLoiIch" rows="4" cols="20">
                            ${param.txtLoiIch }
                        </textarea></td>
                </tr>
                
                <tr>
                    <td>Hình ảnh: </td>
                    <td><input type="file" name="txtHinh" value="" width="50" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Thêm mới" name="btnThemMoi" />
                    </td>
                </tr>
            </tbody>
	        <c:if test="${i>1}">
	        	<h1>Thêm thành công </h1>
	        </c:if>
        </table>
        
        </form>                 
    </div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body onload="InvoiceCalculate();">
<div id="invoice">
    <div class="toolbar hidden-print">
        <div class="text-right">
            <button id="printInvoice" class="btn btn-info"><i class="fa fa-print" onclick="printInvoice();"></i> Print</button>
            <button class="btn btn-info"><i class="fa fa-file-pdf-o"></i> Export as PDF</button>
        </div>
        <hr>
    </div>
    <div class="invoice overflow-auto">
        <div style="min-width: 600px">
            <header>
                <div class="row">
                    <div class="col">
                        <a target="_blank" href="#">
                            <img src="resources/file/${salesVal.com_logo}" data-holder-rendered="true" />
                        </a>
                    </div>
                    <div class="col company-details">
                        <h2 class="name">
                            <a target="_blank" href="#">
                           ${sessionScope.loginMember.m_id}
                            </a>
                        </h2>
                        <div>${salesVal.com_eaddr}</div>
                        <div>${salesVal.com_etel}</div>
                        <div>${salesVal.com_email}</div>
                    </div>
                </div>
            </header>
            <div>
                <div class="row contacts">
                    <div class="col invoice-to">
                        <div class="text-gray-light">INVOICE TO:</div>
                        <h2 class="to">${salesVal.s_cus}</h2>
                        <div class="address">${salesVal.cus_addr }</div>
                        <div class="email"><a href="mailto:${salesVal.cus_email}">${salesVal.cus_email}</a></div>
                    </div>
                    <div class="col invoice-details">
                        <h1 class="invoice-id">INVOICE ${salesVal.s_no}</h1>
                        <div class="date">Date of Invoice: ${d}/${m}/${y}</div>
                        <div class="date">Due Date: ${d2}/${m2}/${y2}</div>
                    </div>
                </div>
                <table style="border=0; cellspacing=0; cellpadding=0;">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th class="text-left">DESCRIPTION</th>
                            <th class="text-left">HS CODE</th>
                            <th class="text-left">QUANTITY</th>
                            <th class="text-right">PRICE</th>
                            <th class="text-right">AMOUNT</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<c:forEach var="i" items="${salesVal.s_subSales}" varStatus="status">
		                        <tr>
		                            <td class="no">${status.count}</td>
		                            <td class="text-left">
		                                <h3>${i.sb_pro_no }</h3>${i.pro_name }&nbsp;&nbsp;${i.pro_unit } 
		                            </td>
		                            <td class="hscode">xx</td>
		                            <td class="qty"><fmt:formatNumber value="${i.sb_qty }" pattern="#,###" /></td>
		                            <td class="unit"><fmt:formatNumber value="${i.sb_pro_price }" pattern="#,###" /></td>
		                            <td class="total">${i.sb_sum }</td>
		                        </tr>
		                  </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="2"></td>
                            <td colspan="2">SUBTOTAL</td>
                            <td colspan="2" id="subtotal"></td>
                        </tr>
                        <tr>
                            <td colspan="2"></td>
                            <td colspan="2">TAX 25%</td>
                            <td colspan="2" id="tax"></td>
                        </tr>
                        <tr>
                            <td colspan="2"></td>
                            <td colspan="2">GRAND TOTAL</td>
                            <td colspan="2" id="grandtotal"></td>
                        </tr>
                    </tfoot>
                </table>
                <div class="thanks">Thank you!</div>
                <div class="notices">
                    <div>NOTICE:</div>
                    <div class="notice">A finance charge of 1.5% will be made on unpaid balances after 30 days.</div>
                </div>
            </div>
            <footer>
                Invoice was created on a computer and is valid without the signature and seal.
            </footer>
        </div>
        <!--DO NOT DELETE THIS div. IT is responsible for showing footer always at the bottom-->
        <div></div>
    </div>
</div>

</body>
</html>
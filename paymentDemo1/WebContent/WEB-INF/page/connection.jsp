<%@ page language="java" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>����֧������</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body onload="javascript:document.forms[0].submit()">
  	<!-- �ױ�֧���Ĳ�������: http://tech.yeepay.com:8080/robot/debug.action -->
  	<!-- �ױ�֧������ʽ����: https://www.yeepay.com/app-merchant-proxy/node -->
	<form name="yeepay" action="https://www.yeepay.com/app-merchant-proxy/node" method='post'>	
		<input type='hidden' name='p0_Cmd'   value="${p0_Cmd}"> <!-- ��������,����֧���̶�ΪBuy -->
		<input type='hidden' name='p1_MerId' value="${p1_MerId}"> <!-- �̼�ID -->
		<input type="hidden" name="p2_Order" value="${p2_Order}"> <!-- �̼ҵĽ��׶����� -->
		<input type='hidden' name='p3_Amt'   value="${p3_Amt}"> <!-- ������� -->
		<input type='hidden' name='p4_Cur'   value="${p4_Cur}"> <!-- ���ҵ�λ -->
		<input type='hidden' name='p5_Pid'   value="${p5_Pid}"> <!-- ��ƷID -->
		<input type='hidden' name='p6_Pcat'  value="${p6_Pcat}"> <!-- ��Ʒ���� -->
		<input type='hidden' name='p7_Pdesc' value="${p7_Pdesc}"> <!-- ��Ʒ���� -->
		<input type='hidden' name='p8_Url'   value="${p8_Url}"> <!-- ���׽��֪ͨ��ַ -->
		<input type='hidden' name='p9_SAF'   value="${p9_SAF}"> <!-- ��Ҫ��д�ͻ���Ϣ 0������Ҫ 1:��Ҫ -->
		<input type='hidden' name='pa_MP'    value="${pa_MP}"> <!-- �̼���չ��Ϣ -->
		<input type='hidden' name='pd_FrpId' value="${pd_FrpId}"> <!-- ����ID -->
		<!-- Ӧ����� Ϊ��1��: ��ҪӦ�����;Ϊ��0��: ����ҪӦ����� -->
		<input type="hidden" name="pr_NeedResponse"  value="0">
		<input type='hidden' name='hmac' value="${md5hmac}"><!-- MD5-hmac��֤�� -->
	</form>
  </body>
</html>

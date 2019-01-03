package cn.itcast.util;
public class PanymentUtil {
	
	/**
	 * 
	 * @param p0_Cmd: 业务类型
	 * @param p1_MerId: 商家ID
	 * @param p2_Order: 商品订单号
	 * @param p3_Amt: 支付金额
	 * @param p4_Cur: 交易币种
	 * @param p5_Pid: 商品名称(可选),注意:可选不是为null,而是为空字符串
	 * @param p6_Pcat: 商品种类(可选),注意:可选不是为null,而是为空字符串
	 * @param p7_Pdesc: 商品描述(可选),注意:可选不是为null,而是为空字符串
	 * @param p8_Url: 商品接收支付成功数据的地址
	 * @param p9_SAF: 送货地址
	 * @param pa_MP: 商户扩展信息
	 * @param pd_FrpId: 银行编码
	 * @param pr_NeedResponse: 反应应答机制
	 * @param keyValue: 商户秘钥
	 * @return
	 */
	public static String buildHmac(String p0_Cmd,String p1_MerId,
			String p2_Order, String p3_Amt, String p4_Cur,String p5_Pid, String p6_Pcat,
			String p7_Pdesc,String p8_Url, String p9_SAF,String pa_MP,String pd_FrpId,
			String pr_NeedResponse,String keyValue) {
		StringBuffer sValue = new StringBuffer();
		// 业务类型
		sValue.append(p0_Cmd);
		// 商家ID
		sValue.append(p1_MerId);
		// 商品订单号
		sValue.append(p2_Order);
		// 支付金额
		sValue.append(p3_Amt);
		//交易币种
		sValue.append(p4_Cur);
		//商品名称(可选),注意:可选不是为null,而是为空字符串
		sValue.append(p5_Pid);
		//商品种类(可选),注意:可选不是为null,而是为空字符串
		sValue.append(p6_Pcat);
		//商品描述(可选),注意:可选不是为null,而是为空字符串
		sValue.append(p7_Pdesc);
		//商品接收支付成功数据的地址
		sValue.append(p8_Url);
		//送货地址
		sValue.append(p9_SAF);
		//商户扩展信息
		sValue.append(pa_MP);
		//银行编码
		sValue.append(pd_FrpId);
		//反应应答机制
		sValue.append(pr_NeedResponse);
		
		String sNewString = DigestUtil.hmacSign(sValue.toString(), keyValue);
		return sNewString;
	}
	
	
	public static boolean verifyCallback(String hmac, String p1_MerId,
			String r0_Cmd, String r1_Code, String r2_TrxId, String r3_Amt,
			String r4_Cur, String r5_Pid, String r6_Order, String r7_Uid,
			String r8_MP, String r9_BType, String keyValue) {
		StringBuffer sValue = new StringBuffer();
		//
		sValue.append(p1_MerId);
		//
		sValue.append(r0_Cmd);
		// 
		sValue.append(r1_Code);
		//
		sValue.append(r2_TrxId);
		//
		sValue.append(r3_Amt);
		//
		sValue.append(r4_Cur);
		//
		sValue.append(r5_Pid);
		//
		sValue.append(r6_Order);
		//
		sValue.append(r7_Uid);
		//
		sValue.append(r8_MP);
		//
		sValue.append(r9_BType);
		String sNewString = DigestUtil.hmacSign(sValue.toString(), keyValue);

		if (hmac.equals(sNewString)) {
			return true;
		}
		return false;
	}
}

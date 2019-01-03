package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.util.ConfigInfo;
import cn.itcast.util.PanymentUtil;



public class PaymentRequest extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("gbk");
		//获取页面提交的订单号
		String p2_Order = request.getParameter("orderid");
		//获取页面提交的支付金额
		String p3_Amt = request.getParameter("amount");
		//获取页面提交的支付银行
		String pd_FrpId = request.getParameter("pd_FrpId");
		
		//从配置文件读取商家ID 
		String p1_MerId = ConfigInfo.getValue("p1_MerId");
		//从配置文件中读取秘钥
		String keyValue = ConfigInfo.getValue("keyValue");
		//从配置文件中读取交易结果通知地址
		String p8_Url = ConfigInfo.getValue("merchantCallbackURL");
		
		//请求命令(业务类型),在线支付固定为"buy"
		String p0_Cmd = "buy";
		//货币单位(交易币种)
		String p4_Cur = "CNY";
		//商品描述
		String p7_Pdesc = "";
		//商品种类
		String p6_Pcat = "";
		//商品ID
		String p5_Pid = "";
		//是否需要填写送货地址: 0:不需要, 1:需要
		String p9_SAF = "0";
		//商家扩展信息
		String pa_MP = "";
		//反应应答机制
		String pr_NeedResponse = "0";
		
		String md5hmac = PanymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);
		
		/**
		 * 将这些参数传递到易宝支付的表单参数
		 * 
		 */
		request.setAttribute("p0_Cmd", p0_Cmd);
		request.setAttribute("p1_MerId", p1_MerId);
		request.setAttribute("p2_Order", p2_Order);
		request.setAttribute("p3_Amt", p3_Amt);
		request.setAttribute("p4_Cur", p4_Cur);
		request.setAttribute("p5_Pid", p5_Pid);
		request.setAttribute("p6_Pcat", p6_Pcat);
		request.setAttribute("p7_Pdesc", p7_Pdesc);
		request.setAttribute("p8_Url", p8_Url);
		request.setAttribute("p9_SAF", p9_SAF);
		request.setAttribute("pa_MP", pa_MP);
		request.setAttribute("pd_FrpId", pd_FrpId);
		request.setAttribute("pr_NeedResponse", pr_NeedResponse);
		request.setAttribute("md5hmac", md5hmac);
		
		//转发
		request.getRequestDispatcher("/WEB-INF/page/connection.jsp").forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		this.doPost(req, resp);
	}
	
}

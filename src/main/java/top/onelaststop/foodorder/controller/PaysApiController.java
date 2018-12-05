package top.onelaststop.foodorder.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.onelaststop.foodorder.dataobject.PaySaPi;
import top.onelaststop.foodorder.util.paysapi.PayUtil;

@Controller
@RequestMapping("/pays")
public class PaysApiController {

	@RequestMapping("/pay")
	@ResponseBody
	public Map<String, Object> pay(HttpServletRequest request, Float price, Integer istype, String orderid) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> remoteMap = new HashMap<String, Object>();
		remoteMap.put("price", price);
		remoteMap.put("istype", istype);
		remoteMap.put("orderid", orderid);
		remoteMap.put("orderuid", PayUtil.getOrderIdByUUId());
		remoteMap.put("goodsname", "");
		resultMap.put("data", PayUtil.payOrder(remoteMap));

		return resultMap;
	}

	@RequestMapping("/notifyPay")
	public void notifyPay(HttpServletRequest request, HttpServletResponse response, PaySaPi paySaPi) {
		// 保证密钥一致性
		if (PayUtil.checkPayKey(paySaPi)) {
			// TODO 如果检查支付键一致
//			return "redirect:http://foodorder.s1.natapp.cc/pays/returnPay";
		} else {
			// TODO 如果检查支付键不一致
		}
	}

	@RequestMapping("/returnPay")
	public ModelAndView returnPay(HttpServletRequest request, HttpServletResponse response, String orderid) {
		boolean isTrue = true;
		ModelAndView view = null;
		// 根据订单号查找相应的记录:根据结果跳转到不同的页面
		if (isTrue) {
			view = new ModelAndView("pay/success");
		} else {
			view = new ModelAndView("pay/failed");
		}
		return view;
	}
}

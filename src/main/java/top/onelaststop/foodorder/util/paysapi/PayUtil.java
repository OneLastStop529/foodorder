package top.onelaststop.foodorder.util.paysapi;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.LogManager;
import top.onelaststop.foodorder.dataobject.PaySaPi;

@Slf4j
public class PayUtil {

//	private static log log = LogManager.

	public static String UID = "301c6a2a0087a85997b50101";

	public static String NOTIFY_URL = "http://foodorder.s1.natapp.cc/pays/notifyPay";

	public static String RETURN_URL = "http://foodorder.s1.natapp.cc/pays/returnPay";

	public static String BASE_URL = "https://pay.paysapi.com";

	public static String TOKEN = "f362a4fdb5e5a116c6c7104418d69744";

	public static Map<String, Object> payOrder(Map<String, Object> remoteMap) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("uid", UID);
		paramMap.put("notify_url", NOTIFY_URL);
		paramMap.put("return_url", RETURN_URL);
		paramMap.putAll(remoteMap);
		paramMap.put("key", getKey(paramMap));
		return paramMap;
	}

	public static String getKey(Map<String, Object> remoteMap) {
		String key = "";
		if (null != remoteMap.get("goodsname")) {
			key += remoteMap.get("goodsname");
		}
		if (null != remoteMap.get("istype")) {
			key += remoteMap.get("istype");
		}
		if (null != remoteMap.get("notify_url")) {
			key += remoteMap.get("notify_url");
		}
		if (null != remoteMap.get("orderid")) {
			key += remoteMap.get("orderid");
		}
		if (null != remoteMap.get("orderuid")) {
			key += remoteMap.get("orderuid");
		}
		if (null != remoteMap.get("price")) {
			key += remoteMap.get("price");
		}
		if (null != remoteMap.get("return_url")) {
			key += remoteMap.get("return_url");
		}
		key += TOKEN;
		if (null != remoteMap.get("uid")) {
			key += remoteMap.get("uid");
		}
		return MD5Util.encryption(key);
	}

	public static boolean checkPayKey(PaySaPi paySaPi) {
		String key = "";
		if (!StringUtils.isBlank(paySaPi.getOrderid())) {
			log.info("支付回来的订单号：" + paySaPi.
					getOrderid());
			key += paySaPi.getOrderid();
		}
		if (!StringUtils.isBlank(paySaPi.getOrderuid())) {
			log.info("支付回来的支付记录的ID：" + paySaPi.getOrderuid());
			key += paySaPi.getOrderuid();
		}
		if (!StringUtils.isBlank(paySaPi.getPaysapi_id())) {
			log.info("支付回来的平台订单号：" + paySaPi.getPaysapi_id());
			key += paySaPi.getPaysapi_id();
		}
		if (!StringUtils.isBlank(paySaPi.getPrice())) {
			log.info("支付回来的价格：" + paySaPi.getPrice());
			key += paySaPi.getPrice();
		}
		if (!StringUtils.isBlank(paySaPi.getRealprice())) {
			log.info("支付回来的真实价格：" + paySaPi.getRealprice());
			key += paySaPi.getRealprice();
		}
		log.info("支付回来的Key：" + paySaPi.getKey());
		key += TOKEN;
		log.info("我们自己拼接的Key：" + MD5Util.encryption(key));
		return paySaPi.getKey().equals(MD5Util.encryption(key));
	}

	public static String getOrderIdByUUId() {
		int machineId = 1;// 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}
		// 0 代表前面补充0;d 代表参数为正数型
		return machineId + String.format("%01d", hashCodeV);
	}

}

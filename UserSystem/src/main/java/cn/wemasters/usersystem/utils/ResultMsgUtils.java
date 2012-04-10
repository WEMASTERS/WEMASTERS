package cn.wemasters.usersystem.utils;

import cn.wemasters.usersystem.constant.ReturnCode;
import cn.wemasters.usersystem.view.ResultMsg;

public class ResultMsgUtils {
	
	public static ResultMsg createSuccess() {
		ResultMsg result = new ResultMsg();
		result.setCode(String.valueOf(ReturnCode.SUCCESS));
		return result;
	}
	
	public static ResultMsg createSuccess(Object object) {
		ResultMsg result = new ResultMsg();
		result.setCode(String.valueOf(ReturnCode.SUCCESS));
		result.setObject(object);
		return result;
	}
	
	public static ResultMsg createResultMsg(int code) {
		ResultMsg result = new ResultMsg();
		result.setCode(String.valueOf(code));
		return result;
	}

}

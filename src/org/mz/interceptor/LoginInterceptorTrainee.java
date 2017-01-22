package org.mz.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptorTrainee implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		Map<String, Object> sessionAttributes=invocation.getInvocationContext().getSession();
		if(sessionAttributes==null||sessionAttributes.get("traineeUid")==null){
			return "loginTrainee";
		}
		return invocation.invoke();
}
}

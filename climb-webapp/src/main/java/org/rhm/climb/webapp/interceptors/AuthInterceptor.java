package org.rhm.climb.webapp.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Interceptor controling access using session and role
 */
public class AuthInterceptor extends AbstractInterceptor {

    private static final long serialVersionUID = 7995153741671857846L;

    @Override
    public String intercept(ActionInvocation pInvocation) throws Exception {
        String vResult;
        if (pInvocation.getInvocationContext().getSession().get("user") != null) {
            vResult = pInvocation.invoke();
        } else {
            vResult = "error-forbidden";
        }
        return vResult;
    }
}
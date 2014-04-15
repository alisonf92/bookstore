package interceptors;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.TextParseUtil;

public class ShopcartSessionTracker  implements Interceptor{
    Map<String, Object>session;
    private Set<String> excludeMethods=Collections.EMPTY_SET;
    private Set<String> includeMethods=Collections.EMPTY_SET;
    
    public void setExcludeMethods(String excludeMethods) {
        this.excludeMethods =
                TextParseUtil.commaDelimitedStringToSet(excludeMethods);
                System.out.println("+++++++++++ EX +++++++"+excludeMethods);
    }
    public void setIncludeMethods(String includeMethods) {
        this.includeMethods = 
                TextParseUtil.commaDelimitedStringToSet(includeMethods);
        System.out.println("++++++++++++In ++++"+includeMethods);
    }
    @Override
    public void destroy() {
        System.out.println("++++++++++ destroy ++++++++++++");
        
    }
    @Override
    public void init() {
        System.out.println("+++++++++++ init++++++++++++++");
        
    }
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        String result="";
        String className=invocation.getAction().getClass().getName();
        String method=invocation.getProxy().getMethod();
        System.out.println("Pre Process for "+className+"    "+method);
        session=ActionContext.getContext().getSession();
        String trackerId=(String)session.get("trackerId");
        if(excludeMethods.contains(method)){
            result=invocation.invoke();
        }else if(includeMethods.contains(method)){
            if(trackerId==null){
                result="nosession";
            }else{
                result=invocation.invoke();
                System.out.println("Post Process for "+className+"   "+method);
            }
        }
        return result;
    }
}

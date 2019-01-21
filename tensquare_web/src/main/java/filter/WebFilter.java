package filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tank
 * @create 2019/01/21 11:42
 */
public class WebFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //得到request上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        //得到request域
        HttpServletRequest request = currentContext.getRequest();
        //获得头信息
        String header = request.getHeader("Authorization");
        //判断是否有头信息
        if (header!= null && !"".equals(header)) {
            //把头信息继续传下去（加到request上下文中）
            currentContext.addZuulRequestHeader("Authorization",header);
        }
        return null;
    }
}

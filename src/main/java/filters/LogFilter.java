package filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.code.services.UserService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import antlr.collections.List;

@Component
@WebFilter(filterName = "myFilter", urlPatterns = "/user/*")
public class LogFilter implements Filter {

	@Autowired
	private UserService userService;
	
	
	
//	public LogFilter(UserService userService) {
//		this.userService = userService;
//	}

	public LogFilter() {
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		WebApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig.getServletContext());
		Arrays.stream(appContext.getBeanDefinitionNames()).forEach(s->System.out.println("-----------"+s+"-------------"));
		userService = appContext.getBean(UserService.class);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res =(HttpServletResponse) response;
//		String userEmail = request.getParameter("email");
//		String userPassword = request.getParameter("password");
		HttpSession session = req.getSession(false);


			if (session != null) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath()+"/error");
			}

	}

	@Override
	public void destroy() {
	}

}



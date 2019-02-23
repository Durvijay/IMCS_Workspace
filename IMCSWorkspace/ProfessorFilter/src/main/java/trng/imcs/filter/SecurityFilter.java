package trng.imcs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SecurityFilter
 */
public class SecurityFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SecurityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		HttpSession session = httpRequest.getSession(false);
		if (isSecuredUrl(httpRequest) && ! isValidSession(session)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
			dispatcher.forward(request, response);			
			return;
		}	
					
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	private boolean isValidSession(HttpSession session) {
		return session != null && session.getAttribute("user") != null; 
	}

	private boolean isSecuredUrl(HttpServletRequest httpRequest) {
		String requestUrl = httpRequest.getRequestURL().toString();
		return !requestUrl.contains("/login");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

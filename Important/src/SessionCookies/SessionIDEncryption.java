package SessionCookies;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.junit.runner.Request;


public class SessionIDEncryption implements Filter {

    /**
     * Default constructor. 
     */
    public SessionIDEncryption() {
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
	
//		System.out.println("@@@@@@@@@@@@@@@@Filter@@@@@@@@@@@@@@@@@@@@@@");
//		
//		HttpServletRequest httprequest=	(HttpServletRequest) request;
//		HttpSession httpSession = httprequest.getSession();
//		
//	   System.out.println("taking sessionId "+httpSession.getAttribute("JSESSIONID"));
//		
//		getSessionFromCookie((HttpServletRequest) request);
//		
		chain.doFilter(request, response);
//		
//	    storeSessionInCookie((HttpServletRequest) request, (HttpServletResponse)response);
//	    
//		
//	    response.flushBuffer();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private void getSessionFromCookie(HttpServletRequest httpServletRequest) throws IOException {
	  
	 
	    Cookie sessionCookie = getSessionCookie(httpServletRequest);
	    // Kill existing session and get a fresh one
	    HttpSession session = httpServletRequest.getSession();
	    session.invalidate();
	    session = httpServletRequest.getSession();
	    if (null != sessionCookie) {
	        String serialisedSession = sessionCookie.getValue();
	        try {
	        	System.out.println("222222222222222222Filter2222222222222222222");
	        	System.out.println(serialisedSession);
	             HttpSession cookieSession = (HttpSession) fromString(serialisedSession);
	         //    session.setAttribute("", "");

	        } catch (Exception e) {
	            
	        }
	    }
	}
	
	 
	private Cookie getSessionCookie(HttpServletRequest request) {
	    Cookie[] cookies = request.getCookies();
	    if (cookies != null)
	        for (Cookie cookie : cookies) {
	        	System.out.println(cookie.getName());
	            if ("JSESSIONID".equals(cookie.getName())) {
	                return cookie;
	            }
	        }
	    return null;
	}
	
	
	
	
	
	private void storeSessionInCookie(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
	  
	 
	    HttpSession session = httpServletRequest.getSession(false);
	 
	    Enumeration attributeNames = session.getAttributeNames();
	    Map<String, Object> attributes = new HashMap<String, Object>();
	    while (attributeNames.hasMoreElements()) {
	        String attributeName = (String) attributeNames.nextElement();
	        attributes.put(attributeName, session.getAttribute(attributeName));
	    }
	    HttpSession cookieSession = httpServletRequest.getSession();
	    cookieSession.setAttribute("", new String ());
	    try {
	        String serialisedCookieSession = toString((Serializable) cookieSession);
	        Cookie newSessionCookie = new Cookie("session", serialisedCookieSession);
	        newSessionCookie.setPath("/");
	        httpServletResponse.addCookie(newSessionCookie);
	    } catch (Exception e) {
	       
	    }
	}
	
	private String toString(Serializable object) throws IOException {
	    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
	    objectOutputStream.writeObject(object);
	    objectOutputStream.close();
	    return new String(DatatypeConverter.printBase64Binary(byteArrayOutputStream.toByteArray()));
	}
	
	private Object fromString(String string) throws IOException, ClassNotFoundException {
	    byte[] data = DatatypeConverter.parseBase64Binary(string);
	    ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data));
	    Object object = objectInputStream.readObject();
	    objectInputStream.close();
	    return object;
	}
}

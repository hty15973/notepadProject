package kr.co.team.listener;

import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import kr.co.team.controller.BackController;

/**
 * Application Lifecycle Listener implementation class ServerListener
 *
 */
@WebListener
public class ServerListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("server dead");

    }

    public void contextInitialized(ServletContextEvent sce)  { 
       	ServletContext sc=sce.getServletContext();
       	Enumeration<String> names=sc.getInitParameterNames();
 
    	System.out.println("server start");
		while(names.hasMoreElements()) {
			String name=names.nextElement();

			try {
				Class cls=Class.forName(sc.getInitParameter(name));//해당클레스를 메모리에 올림.
				DAOManager.addDAO(name,(Object)(cls.newInstance()));
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
    	
    }
	
}

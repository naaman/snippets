package com.force.sample.snippets.launcher;

import java.net.URL;
import java.security.ProtectionDomain;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.webapp.WebAppContext;

public class Launcher {
	public static void main(String[] args) throws Exception {
		final Server server = new Server(Integer.valueOf(System.getProperty("httpPort", "8080")));
		
		ProtectionDomain protectionDomain = Launcher.class.getProtectionDomain();
		URL webInf = protectionDomain.getCodeSource().getLocation();
		System.out.println(webInf);
		
		WebAppContext context = new WebAppContext(webInf.toExternalForm(), "/");
		context.setDescriptor(webInf.toExternalForm() + "WEB-INF/web.xml");
		server.setHandler(context);
		server.start();
		server.join();
	}
}

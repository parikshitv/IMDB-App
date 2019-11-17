package com.wicket.wipro;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class InitClass extends WebApplication{

	@Override
	public Class<? extends Page> getHomePage() {
		// TODO Auto-generated method stub
		return HomePage.class;
	}

}

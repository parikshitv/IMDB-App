package com.wicket.wipro;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

public abstract class BasePage extends WebPage{
	
	public BasePage(){
		
		
		Link movieLink = new Link("movies"){
			@Override
			public void onClick() {
				setResponsePage(MoviesPage.class);
			}
		};
		Link tvLink = new Link("television"){
			@Override
			public void onClick() {
				setResponsePage(TvPage.class);
			}
		};
		Link eventLink = new Link("events"){
			@Override
			public void onClick() {
				setResponsePage(EventsPage.class);
			}
		};
		Link loginLink = new Link("login-link"){
			@Override
			public void onClick() {
				setResponsePage(LoginPage.class);
			}
		};
		add(movieLink);
		add(tvLink);
		add(eventLink);
		add(loginLink);
	}

	
}

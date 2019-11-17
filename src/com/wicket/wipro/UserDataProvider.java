package com.wicket.wipro;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

public class UserDataProvider extends SortableDataProvider<User> {

	List<User> userdb = new ArrayList<User>();
	public UserDataProvider() {
		for(int i =1; i<=100; i++){
			User u = new User();
			u.setUsername("User-"+i);
			u.setPassword("pass-"+i);
			userdb.add(u);
		}
	}
	
	
	@Override
	public Iterator<? extends User> iterator(int first, int count) {
		List<User> newList = new ArrayList<User>(userdb);
		return newList.subList(first, first+count).iterator();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return userdb.size();
	}

	@Override
	public IModel<User> model(User object) {
		
		return new LoadableDetachableModel<User>(){

			@Override
			protected User load() {
				// TODO Auto-generated method stub
				return object;
			}
			
		};
	}

}

package com.wicket.wipro;

import javax.swing.DefaultBoundedRangeModel;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.DataGridView;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.PropertyPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.DefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

public class LoginPage extends BasePage{
	public LoginPage(){
		
		
		ModalWindow helpWindow = new ModalWindow("help");
		helpWindow.setTitle(new Model("Help"));
		helpWindow.setOutputMarkupId(true);
		helpWindow.setPageCreator(new ModalWindow.PageCreator() {
			
			@Override
			public Page createPage() {
				// TODO Auto-generated method stub
				return new CopyrightPage();
			}
		});
		AjaxLink help_ajax = new AjaxLink("help_link"){
			@Override
			public void onClick(AjaxRequestTarget target) {
				helpWindow.show(target);
				
			}
		};		
		User user = new User();
		//EveryForm requires feedback panel
		FeedbackPanel feedbackPanel = new FeedbackPanel("feedback-error");
		Form loginForm = new Form("loginForm");
		Label username = new Label("username_label", "username");
		Label password = new Label("password_label", "password");
		TextField uname = 
				new TextField("uname_txt", new PropertyModel(user, "username"));
		uname.add(new UseranmeValidator());
		PasswordTextField pass = 
				new PasswordTextField("pass_txt", new PropertyModel(user, "password"));
		uname.setRequired(true);
		pass.setRequired(true);
		Button loginBtn = new Button("login_btn"){
			@Override
			public void onSubmit() {
				super.onSubmit();
				System.out.println("Handle all the login concerns here and redirect to the home page");
				System.out.println(user.getUsername()+"  -- "+user.getPassword());
				getApplication().getSessionStore().setAttribute(getRequest(), "logged_in", "logged_in");
				setResponsePage(HomePage.class);
			};
			
		};
		loginForm.add(username);
		loginForm.add(password);
		loginForm.add(uname);
		loginForm.add(pass);
		loginForm.add(loginBtn);
		add(loginForm);
		add(feedbackPanel);
		add(helpWindow);
		add(help_ajax);
		
		IColumn[] columns = new IColumn[2];
		columns[0] = new PropertyColumn(new Model("Username"), "Username", "Username");
		columns[1] = new PropertyColumn(new Model("Password"), "Password", "Password");
		DefaultDataTable table = new DefaultDataTable("datatable", columns, new UserDataProvider(), 10);
		add(table);
		
		ICellPopulator[] column = new ICellPopulator[2];
		 column[0] = new PropertyPopulator("username");
		 column[1] = new PropertyPopulator("password");
		DataGridView<User> dgv = new DataGridView<>("rows", column, new UserDataProvider());
		add(dgv);
	}
}

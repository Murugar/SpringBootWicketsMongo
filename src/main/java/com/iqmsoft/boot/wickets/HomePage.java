package com.iqmsoft.boot.wickets;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.iqmsoft.boot.wickets.model.Admin;
import com.iqmsoft.boot.wickets.repos.AdminRepository;

import java.util.List;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

import org.wicketstuff.annotation.mount.MountPath;


@WicketHomePage
@MountPath("home")
@AuthorizeInstantiation("USER")
public class HomePage extends BasePage {
	
	@SpringBean
	AdminRepository arepos;
	
	
	
    public HomePage(PageParameters parameters) {
        super(parameters);
        
        add(new Label("test1", "Spring Boot Wickets!!!"));
        add(new Label("test2", "Welcome "));
        add(new Label("test3", "Persistence using MongoDB"));
        
        add(new Label("size", "Users Size   :   " + arepos.count()));
        
       
        ListView<Admin> listview = new ListView<Admin>("listview", arepos.findAll()) {
           
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(ListItem<Admin> item) {
				 item.add(new Label("user", item.getModel().getObject().getName()));
				 item.add(new Label("pwd", item.getModel().getObject().getPwd()));
			}
        };
        
        add(listview);
        
        
       
    }
    
    
}

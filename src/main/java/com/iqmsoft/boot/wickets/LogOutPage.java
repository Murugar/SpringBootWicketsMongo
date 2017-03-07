package com.iqmsoft.boot.wickets;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class LogOutPage extends WebPage {

	private static final long serialVersionUID = 1L;

	private Link<Void> logout = new Link<Void>("logOut") {
		private static final long serialVersionUID = 1L;

		AuthenticatedWebSession session = AuthenticatedWebSession.get();

		@Override
		public void onClick() {
			session.signOut();
			// setResponsePage(LoginPage.class);
		}
	};

	public LogOutPage(PageParameters parameters) {
		super(parameters);

		add(logout);
	}

	@Override
	protected void onBeforeRender() {
		super.onBeforeRender();
		getRequestCycle().setResponsePage(LoginPage.class);

	}

}

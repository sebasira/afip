package ar.com.system.afip.wsaa.business.impl;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import ar.com.system.afip.wsaa.service.api.Credentials;


@Root(name = "loginTicketResponse")
public class LoginTicketResponse {
	@Element
	private Header header;
	@Element
	private Credentials credentials;

	public Header getHeader() {
		return header;
	}

	public Credentials getCredentials() {
		return credentials;
	}

}

package ar.com.system.afip.wsaa.service.api;

import javax.jws.WebService;

import retrofit2.http.Headers;
import retrofit2.http.POST;

@WebService
public interface LoginCMS {
	@Headers({"Content-Type: text/xml;charset=UTF-8"})
	@POST("/LoginCms")
	String loginCms(String cms);
}

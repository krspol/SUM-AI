package pl.pjatk.sum.webapp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path(value = "/")
public class App {

	@GET
	public String helloWorld() {
		return "Hello world";
	}
}

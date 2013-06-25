package json;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

//http://192.168.1.19:8080/RestWebserviceExample/rest/json/movie/get
@Path("/json/movie")
public class JSONService {

	@BadgerFish
	@GET
	@Path("/get")
	@Produces("application/json")
	public Movie getMovieInJSON() {

		Movie movie = new Movie();
		movie.setName("Transformers: Dark of the Moon");
		movie.setDirector("Michael Bay");
		movie.setYear(2011);
		
		return movie; 

	}

}
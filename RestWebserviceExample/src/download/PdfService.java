package download;

import java.io.File;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
 
@Path("/pdf")
public class PdfService {
 
	private static final String FILE_PATH = "/home/ganesan/git/Treasure/RestWebserviceExample/src/download/ganesan.pdf";

 
	@GET
	@Path("/get")
	@Produces("application/pdf")
	public Response getFile() {
 
		File file = new File(FILE_PATH);
 
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=new-android-book.pdf");
		return response.build();
 
	}
 
}
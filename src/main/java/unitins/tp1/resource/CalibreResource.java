package unitins.tp1.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unitins.tp1.dto.acabamento.AcabamentoDTO;
import unitins.tp1.dto.acabamento.AcabamentoResponseDTO;
import unitins.tp1.dto.calibre.CalibreDTO;
import unitins.tp1.dto.calibre.CalibreResponseDTO;
import unitins.tp1.service.acabamento.AcabamentoService;
import unitins.tp1.service.calibre.CalibreService;

@Path("/calibres")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalibreResource {
    @Inject
    CalibreService service;

    @Inject
    JsonWebToken jwt;

    @Transactional
    @POST
//    @RolesAllowed({"Admin"})
    public Response insert(CalibreDTO dto) {
        try {
            
            CalibreResponseDTO responseDTO = service.insert(dto);
            return Response.status(Response.Status.CREATED).entity(responseDTO).build();
        } catch (Exception e) {
            Log.error("Erro ao cadastrar o calibre: ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar o calibre.").build();
        }
    }

    @PUT
    @Transactional
    @Path("/{id}")
//    @RolesAllowed({"User","Admin"})
    public CalibreResponseDTO update(CalibreDTO dto, @PathParam("id") Long id) {
        Log.info("Atualizando um calibre: "+id);
        return service.update(dto, id);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
//    @RolesAllowed({"User","Admin"})
    public void delete(@PathParam("id") Long id) {
        Log.info("Deletando um calibre:" +id);
        service.delete(id);
    }

    @GET
//    @RolesAllowed({"User","Admin"})
    public Response findAll(){
        Log.info("Buscando todos os calibres cadastrados.");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
//    @RolesAllowed({"Admin"})
    public Response findById(@PathParam("id") Long id){
        Log.info("Buscando um calibre expecificado pelo id: "+id);
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
//    @RolesAllowed({"User","Admin"})
    public Response findByNome(@PathParam("nome") String nome){
        Log.info("Buscando um calibre expecificado pelo nome: "+nome);
        return Response.ok(service.findByNome(nome)).build();
    }

}

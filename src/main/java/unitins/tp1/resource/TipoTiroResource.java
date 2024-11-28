package unitins.tp1.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unitins.tp1.dto.tipoTiro.TipoTiroDTO;
import unitins.tp1.dto.tipoTiro.TipoTiroResponseDTO;
import unitins.tp1.service.TipoTiro.TipoTiroService;

@Path("/tipotiros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoTiroResource {

    @Inject
    TipoTiroService service;

    @Inject
    JsonWebToken jwt;

    @Transactional
    @POST
//    @RolesAllowed({"Admin"})
    public Response insert(TipoTiroDTO dto) {
        try {
            
            TipoTiroResponseDTO responseDTO = service.insert(dto);
            return Response.status(Response.Status.CREATED).entity(responseDTO).build();
        } catch (Exception e) {
            Log.error("Erro ao cadastrar ", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao cadastrar").build();
        }
    }

    @PUT
    @Transactional
    @Path("/{id}")
//    @RolesAllowed({"User","Admin"})
    public TipoTiroResponseDTO update(TipoTiroDTO dto, @PathParam("id") Long id) {
        Log.info("Atualizando um Tipo de Tiro: "+id);
        return service.update(dto, id);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
//    @RolesAllowed({"User","Admin"})
    public void delete(@PathParam("id") Long id) {
        Log.info("Deletando um Tipo de Tiro: " +id);
        service.delete(id);
    }

    @GET
//    @RolesAllowed({"User","Admin"})
    public Response findAll( 
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("30") int pageSize){

        Log.info("Buscando todos os tipos de tiro cadastrados.");
        return Response.ok(service.findByAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
//    @RolesAllowed({"Admin"})
    public Response findById(@PathParam("id") Long id){
        Log.info("Buscando o tipo de tiro expecificado pelo id: "+id);
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
//    @RolesAllowed({"User","Admin"})
    public Response findByNome(
            @PathParam("nome") String nome,
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("pageSize") @DefaultValue("30") int pageSize){

        Log.info("Buscando um acabamento expecificado pelo nome: "+nome);
        return Response.ok(service.findByNome(nome, page, pageSize)).build();
    }

    @GET
    @Path("/count")
    public long count() {
        return service.count();
    }

    @GET
    @Path("/search/{nome}/count")
    public long count(@PathParam("nome") String nome) {
        return service.countByNome(nome);
    }
}
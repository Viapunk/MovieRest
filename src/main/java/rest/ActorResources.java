package rest;

import domain.Actor;
import domain.DataTemplate;
import domain.Movie;
import domain.service.AbstractService;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by vpnk on 03.05.17.
 */
@Path("/actor")
public class ActorResources implements IResources<Actor> {
    private static AbstractService<Actor> db = new AbstractService();


    @Override
    public Response get(int id) {
        if(db.get(id) == null)
            return Response.status(404).build();
        return Response.ok(db.get(id)).build();
    }

    @Override
    public List<Actor> getAll() {
        return db.getAll();
    }

    @Override
    public Response add(Actor element) {
        db.add(element);
        return Response.ok(element.getId()).build();
    }
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Actor element) {
        Actor result = db.get(id);
        if(result == null)
            return Response.status(404).build();
        element.setId(id);
        db.update(element);
        return Response.ok().build();
    }

    @Override
    public Response delete(int id) {
        Actor result = db.get(id);
        if(result == null)
            return Response.status(404).build();
        db.delete(result);
        return Response.ok().build();
    }

    @PUT
    @Path("{id}/addmovie")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMovie(@PathParam("id")int id, Movie movie){
        Actor result = db.get(id);
        if (result == null)
            return Response.status(404).build();
        MovieResources movieResource = new MovieResources();
        Movie movieResult = movieResource.getDb().get(movie.getId());
        if(movieResult == null)
            return Response.status(404).build();
        movieResult.addActor(result);
        return Response.ok().build();
    }
}

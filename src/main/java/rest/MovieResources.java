package rest;

import domain.Comment;
import domain.Movie;
import domain.service.AbstractService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by vpnk on 03.05.17.
 */
@Path("/movie")
public class MovieResources implements IResources<Movie>{
    private static AbstractService<Movie> data = new AbstractService();
    private static int uniqueCommentid = 1;


    @Override
    public Response get(int id) {
        Movie result = data.get(id);
        if(result == null)
            return Response.status(404).build();
        return Response.ok(result).build();
    }

    @Override
    public List<Movie> getAll() {
        return data.getAll();
    }

    @Override
    public Response add(Movie element) {
        data.add(element);
        return Response.ok(element.getId()).build();
    }

    @Override
    public Response update(int id, Movie element) {
        if(data.get(id) == null)
            return Response.status(404).build();
        element.setId(id);
        data.update(element);
        return Response.ok(element.getId()).build();
    }

    @Override
    public Response delete(int id) {
        Movie result = data.get(id);
        if(result == null)
            return Response.status(404).build();
        data.delete(result);
        return Response.ok().build();
    }
    @GET
    @Path("{id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Comment> getAllComments(@PathParam("id") int id){
        Movie result = data.get(id);
        if(result == null)
            return null;
        return result.getComments();
    }
    @POST
    @Path("{id}/addcomment")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addComment(@PathParam("id")int id, Comment comment){
        Movie result = data.get(id);
        if(result == null)
            return Response.status(404).build();
        comment.setId(result.getComments().size());
        result.getComments().add(comment);
        data.update(result);
        return Response.ok().build();
    }
    @DELETE
    @Path("{id}/removecomment/{comment_id}")
    public Response removeComment(@PathParam("id")int id, @PathParam("comment_id") int commentId){
        Movie result = data.get(id);
        if(result == null)
            return Response.status(404).build();
        Comment resultComment = result.getComments().get(commentId);
        if (result == null)
            return Response.status(404).build();
        result.getComments().remove(commentId);
        data.update(result);
        return Response.ok().build();
    }
    @PUT
    @Path("{id}/addrating/{rating}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRating(@PathParam("id") int id, @PathParam("rating") int rating){
        Movie result = data.get(id);
        if(result == null)
            return Response.status(404).build();
        result.addRating(rating);
        data.update(result);
        return Response.ok().build();
    }

    public AbstractService<Movie> getDb() {
        return data;
    }

    public void setDb(AbstractService<Movie> db) {
        this.data = db;
    }
}

package services;

import entity.Person;
import model.Json;
import provider.PersonProvider;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("Votacion")
public class CandidateService{

    @GET
    @Path("Candidatos")
    @Produces("application/json")
    public Response getCandidates() {
        try {
            PersonProvider provider = new PersonProvider();
            ArrayList<Person> candidates = provider.getCandidates();
            return Response.status(200).header("Access-Control-Allow-Origin","*").entity(candidates).build();
        } catch (SQLException ex) {
            Json m = new Json("SQL Exception", ex.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(m).build();
        } catch (ClassNotFoundException ex) {
            Json m = new Json("Class not found Except", ex.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(m).build();
        }

    }
    @PUT
    @Path("Actualizar")
    @Produces("application/json")
    public Response updateVotes(Person candidate){
        PersonProvider provider = new PersonProvider();
        try {
            provider.updateTotalVotes(candidate);

            Json m2 = new Json("SQL Sucess","Sucess");
            return Response.status(200).header("Access-Control-Allow-Origin","*").entity(m2).build();
        } catch (SQLException e) {
            Json m = new Json("SQL Exception", e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(m).build();
        } catch (ClassNotFoundException ex) {
            Json m = new Json("Class not found Except", ex.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(m).build();
        }

    }

}
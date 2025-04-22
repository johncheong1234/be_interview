package com.example;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @POST
    @Transactional
    public Response createPerson(Person person) {
        personRepository.persist(person);
        return Response.status(Response.Status.CREATED).entity(person).build();
    }

    @GET
    public List<Person> getAllPersons() {
        return personRepository.listAll();
    }

    @GET
    @Path("/search/{name}")
    public List<Person> searchByName(@PathParam("name") String name) {
        return personRepository.list("name", name);
    }
}
package com.example;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @POST
    @Transactional
    public void createPerson(Person person) {
        personRepository.persist(person);
    }

    @GET
    public List<Person> getAllPersons() {
        return personRepository.listAll();
    }

    @GET
    @Path("/search/{name}")
    public List<Person> findByName(@PathParam("name") String name) {
        return personRepository.find("name", name).list();
    }
}

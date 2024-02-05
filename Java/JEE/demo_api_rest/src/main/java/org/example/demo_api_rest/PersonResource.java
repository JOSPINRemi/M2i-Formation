package org.example.demo_api_rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.demo_api_rest.entity.Person;
import org.example.demo_api_rest.service.PersonService;

import java.util.List;

@Path("/person")
public class PersonResource {
//    @Inject
    private final PersonService personService;

    /*public PersonResource() {
        personService.save("toto", "tata");
    }*/

    @Inject
    public PersonResource(PersonService personService) {
        this.personService = personService;
    }


    @POST
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Person postPerson(@FormParam("firstname") String firstName, @FormParam("lastname") String lastName) {
//        Insertion dans la base de données
        return personService.save(firstName, lastName);
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Person postPerson(Person person) {
//        Insertion dans la base de données
        return person;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons() {
        return List.of(new Person(), new Person());
    }

    @DELETE
    @Path("{id}")
    public int deletePerson(@PathParam("id") int id) {
        return id;
    }
}

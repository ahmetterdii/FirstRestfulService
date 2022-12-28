package com.garanti.endpoints;

import com.garanti.model.Ogrenci;
import com.garanti.repo.OgrenciRepo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;

@Path(value = "/ogrenci")
public class OgrenciEndpoints {
    private OgrenciRepo repo;

    public OgrenciEndpoints() {
        this.repo = new OgrenciRepo();
    }

    //getAll
    @GET
    @Path(value = "getAll")
    @Produces(value = MediaType.APPLICATION_JSON)
    public ArrayList<Ogrenci> getAll()
    {
        // localhost:9090/FirstRestfulService/ogrenci/getAll
        return repo.getAll();
    }

    @GET
    @Path(value = "/getById/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogrenci getByIdPathParam(@PathParam(value = "id") Integer id) {
        // localhost:9090/FirstRestfulService/ogrenci/getById/1
        return repo.getById(id);
    }

    //save
    @POST
    @Path(value = "save")
    @Consumes(value = MediaType.APPLICATION_JSON)
    public String save(Ogrenci ogrenci)
    {
        // localhost:9090/FirstRestfulService/ogrenci/save
        repo.save(ogrenci);
        return "Başarı ile kaydedildi";
    }

    //delete
    @DELETE
    @Path(value = "deleteById/{id}")
    public String deleteById(@PathParam(value = "id") Integer id) {
        // localhost:9090/FirstRestfulService/ogrenci/deleteById/1
        if (repo.deleteById(id)) {
            return "Başarı ile silindi.";
        } else {
            return "Başarı ile silinemedi.";
        }
    }

    //header
    @GET
    @Path(value = "getByIdHeader")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Ogrenci getByIdHeader(@HeaderParam(value = "id") Integer id) {
        return repo.getById(id);
    }

}

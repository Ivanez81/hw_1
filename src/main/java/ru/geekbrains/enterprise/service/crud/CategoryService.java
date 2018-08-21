package ru.geekbrains.enterprise.service.crud;

import org.jetbrains.annotations.NotNull;
import ru.geekbrains.enterprise.dao.CategoryDAO;
import ru.geekbrains.enterprise.dto.ResultDTO;
import ru.geekbrains.enterprise.entity.Category;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebService
@Path("/CategoryService")
public class CategoryService {

    @Inject
    private CategoryDAO categoryDAO;

    @GET
    @NotNull
    @Path("/createCategory")
    @WebMethod(operationName = "createCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO createCategory() {
        categoryDAO.persist(new Category("WebService Category", "WebService - OK"));
        return new ResultDTO();
    }


}

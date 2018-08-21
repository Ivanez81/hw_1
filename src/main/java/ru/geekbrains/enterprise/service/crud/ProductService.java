package ru.geekbrains.enterprise.service.crud;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.geekbrains.enterprise.dao.ProductDAO;
import ru.geekbrains.enterprise.dto.ProductDTO;
import ru.geekbrains.enterprise.dto.ResultDTO;
import ru.geekbrains.enterprise.entity.Product;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

@WebService
@Path("/ProductService")
public class ProductService {

    @Inject
    private ProductDAO productDAO;

    @GET
    @NotNull
    @WebMethod
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO ping() {
        return new ResultDTO();
    }

    @GET
    @NotNull
    @Path("/getListProduct")
    @WebMethod(operationName = "getListProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> getListProduct() {
        return productDAO.getListProduct().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @GET
    @NotNull
    @Path("/createProduct")
    @WebMethod(operationName = "createProduct")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO createProduct() {
        productDAO.persist(new Product("WebService Product", "WebService - OK"));
        return new ResultDTO();
    }

    @GET
    @Nullable
    @Path("/getProductById")
    @WebMethod(operationName = "getProductById")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getProductById(
            @QueryParam(value = "id")
            @WebParam(name = "id", partName = "id")
            @Nullable final String id
    ) {
        @Nullable final Product product = productDAO.getProductById(id);
        if (product == null) return null;
        return new ProductDTO(product);
    }

    @POST
    @NotNull
    @Path("/setProductName")
    @WebMethod(operationName = "setProductName")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO setProductName(
            @FormParam(value = "id")
            @WebParam(name = "id", partName = "id")
            @NotNull final String id,

            @FormParam(value = "name")
            @WebParam(name = "name", partName = "name")
            @NotNull final String name
    ) {
        @Nullable Product product = productDAO.getProductById(id);
        if (product == null) return new ResultDTO(false);
        product.setName(name);
        productDAO.merge(product);
        return new ResultDTO();
    }

    @POST
    @NotNull
    @Path("removeProductById")
    @WebMethod(operationName = "removeProductById")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultDTO removeProductById(
            @FormParam(value = "id")
            @WebParam(name = "id", partName = "id")
            @NotNull final String id
    ) {
        try {
            productDAO.removeProductById(id);
            return new ResultDTO();
        } catch (@NotNull final Exception e) {
            return new ResultDTO(false, e.getMessage());
        }
    }

    @GET
    @Nullable
    @Path("/getProductByName")
    @WebMethod(operationName = "getProductByName")
    @Produces(MediaType.APPLICATION_JSON)
    public ProductDTO getProductByName(
            @QueryParam(value = "name")
            @WebParam(name = "name", partName = "name")
            @Nullable final String name
    ) {
        @Nullable final Product product = productDAO.getProductByName(name);
        if (product == null) return null;
        return new ProductDTO(product);
    }

    @GET
    @NotNull
    @Path("/getListProductByCategoryId")
    @WebMethod(operationName = "getListProductByCategoryId")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> getListProductByCategoryId(
            @QueryParam(value = "id")
            @WebParam(name = "id", partName = "id")
            @Nullable final String id
    ) {
        return productDAO.getProductsByCategoryId(id).stream().map(ProductDTO::new).collect(Collectors.toList());
    }

}
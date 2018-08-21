package ru.geekbrains.enterprise.service.test;

import ru.geekbrains.enterprise.dto.ResultDTO;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class TestSOAPService {
    @WebMethod
    public ResultDTO ping() {
        return new ResultDTO();
    }
}

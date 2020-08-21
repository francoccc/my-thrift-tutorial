package com.franco.controller;

import com.franco.TRpcUserClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Thrift Controller for rpc service
 *
 * @author chenxy
 */
@RestController
@RequestMapping("/thrift")
public class RpcThriftController {

    private static final Logger log = LoggerFactory.getLogger(RpcThriftController.class);

    @Autowired
    private TRpcUserClient tRpcUserClient;

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser(HttpServletRequest request, HttpServletResponse response, @RequestParam("userId") int userId) {
        try {
            tRpcUserClient.open();
            return tRpcUserClient.getRpcThriftService().getUserById(userId).toString();
        } catch (Exception e) {
            log.error("Rpc调用失败", e);
            return "error";
        } finally {
            tRpcUserClient.close();
        }
    }
}

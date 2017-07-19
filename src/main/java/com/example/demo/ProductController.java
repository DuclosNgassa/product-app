package com.example.demo;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by ndanji-ngassa on 04.07.2017.
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "/products")
    public String getProducts(Model model){
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder
                        .currentRequestAttributes()).getRequest();
        AccessToken accessToken = ((KeycloakPrincipal<KeycloakSecurityContext>) request.getUserPrincipal())
                .getKeycloakSecurityContext().getToken();

        System.out.println("Username: " + accessToken.getPreferredUsername());

        model.addAttribute("products", productService.getProducts());
        return "product";

    }

    @GetMapping(path = "/logout")
    public String logout(HttpServletRequest request) throws ServletException{
        request.logout();

        return "/";
    }

}

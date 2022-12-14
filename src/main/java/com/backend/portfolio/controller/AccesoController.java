package com.backend.portfolio.controller;
import com.backend.portfolio.model.Acceso;
import com.backend.portfolio.service.IAccesoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "https://front-portfolio-angular.web.app")
public class AccesoController {
    
    @Autowired
    private IAccesoService acceServ;
  
     
    @PostMapping(
           path="/acceso",
           consumes = MediaType.APPLICATION_JSON_VALUE,
           produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RespuestaJSON> solicitarAcceso(@RequestBody Acceso acces){
	
        long id = 1;
                
        if (acces.getClave().equals(acceServ.findAcceso(id).getClave()) && 
            acces.getUsuario().equals(acceServ.findAcceso(id).getUsuario())) {
            
            String token = getJWTToken(acces.getUsuario());
            RespuestaJSON tokenDeAcceso = new RespuestaJSON(token);
            return new ResponseEntity<>(tokenDeAcceso, HttpStatus.OK);
            
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }      
    }    
    
    private String getJWTToken(String username) {
        String secretKey = "fhdjsk345!TH2$%2";
        List<GrantedAuthority> grantedAuthorities =
                AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
		
	String token = Jwts.builder().setId("Portfolio").setSubject(username).claim("authorities",
                       grantedAuthorities.stream().map(GrantedAuthority::getAuthority)								.collect(Collectors.toList()))
		       .setIssuedAt(new Date(System.currentTimeMillis()))
                       .setExpiration(new Date(System.currentTimeMillis() + 600000))
		       .signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();
        return token;
    }

}

package com.backend.portfolio.controller;
import com.backend.portfolio.model.Acceso;
import com.backend.portfolio.service.IAccesoService;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccesoController {
    
     @Autowired
    private IAccesoService acceServ;
    /*
    @GetMapping("/acceso")
    public List<Acceso> verAccesos(){
    return acceServ.getAccesos();
    }
    */
     
     
    @PostMapping(
           path="/acceso", 
           consumes = MediaType.APPLICATION_JSON_VALUE, 
           produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public RespuestaJSON agregarAcceso(@RequestBody Acceso acces){
	
	String token = getJWTToken(acces.getUsuario());
            
        long id = 1;
        Acceso  x = acceServ.findAcceso(id);
        String y = x.getClave();
        String z = x.getUsuario();
        
        if(acces.getClave().equals(y) && acces.getUsuario().equals(z)){          
            return new RespuestaJSON(token);
        } else {
            return new RespuestaJSON("");
        }      

    }
    
    
    private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("Portfolio")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return token;
	}
   /* 
    @DeleteMapping("/acceso/{id}")
    public String borrarAcceso(@PathVariable Long id){
        acceServ.deleteAcceso(id);
        return "El registro fue eliminado correctamente";    
    }
       
    @PutMapping("/acceso/{id}")
    public Acceso editarAcceso(@PathVariable Long id,
                                 @RequestParam("usuario") String nuevoUsuario,
                                 @RequestParam("clave") String nuevaClave) {
        
        Acceso acces = acceServ.findAcceso(id);
        acces.setUsuario(nuevoUsuario);
        acces.setClave(nuevaClave);
        
        
        acceServ.saveAcceso(acces);
        return acces;
    }    */
}

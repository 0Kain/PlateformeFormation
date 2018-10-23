package com.mycompany.myapp.web.rest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import com.mycompany.myapp.security.AuthoritiesConstants;
import com.mysql.jdbc.*;

@RestController
//@Secured(AuthoritiesConstants.ADMIN)
@RequestMapping("/api/db")
public class DBConnection {
    
}
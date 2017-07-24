package com.karsun.kic;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RestController provides response to the root path for the 
 * demo spring boot app 
 * @author Karsun Solutions LLC
 *
 */
@RestController
public class RootRestController {
    
	/**
     * Provides a REST API response mapping for the "/" path
     * @return String
     */
    @RequestMapping("/")
    public String createIndexFile() {
        return "Hello World!";
    }
    
}

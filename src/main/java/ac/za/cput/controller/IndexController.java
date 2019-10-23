package ac.za.cput.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class IndexController {

    @RequestMapping(value = {"/", "/control"})
    public ResponseEntity<String> home(){
        return new ResponseEntity<>("Welcome To the Game Reserve Management App", HttpStatus.OK);

    }

    @GetMapping("/admin")
    public String admin(){
        return ("<h1> Welcome Animal Control Admin<h1>");
    }

    @GetMapping("/user")
    public String user(){
        return ("<h1> Welcome Guest<h1>");
    }
}

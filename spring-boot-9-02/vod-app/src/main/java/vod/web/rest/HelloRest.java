package vod.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
public class HelloRest {
//    @RequestMapping(value="/hello", method= RequestMethod.GET)
//    @ResponseBody
    @GetMapping("/hello")
    String sayHello() {
        return "Hey Universe!";
    }
}

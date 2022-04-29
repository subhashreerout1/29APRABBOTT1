package netgloo.controllers;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

  @GetMapping("/main")
  public ResponseEntity index() {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("index");
	  ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
	  map.put("101","my name");
	  map.put("102","ur name");
	  
      return new ResponseEntity<>(map, HttpStatus.OK);
  }

}

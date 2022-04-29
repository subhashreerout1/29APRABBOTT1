package netgloo.controllers;
/*http://localhost:9070/user-portal/api/getALL
*/import java.util.List;

import netgloo.models.Category;
import netgloo.models.User;
import netgloo.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api"})
public class UserController  implements ErrorController {

  @Autowired
  private UserDao _userDao;
  
  //@GetMapping(value="/getALL",produces= {"application/xml","application/json"})
  @GetMapping(value="/getALL",produces= {"application/json"})
  public ResponseEntity getAll() {
	  List<Category> user = null;
    try {
     user = _userDao.getAll();
      //return Strings;
    }
    catch(Exception ex) {
     System.out.println();
    }
    return new ResponseEntity<>( user,HttpStatus.OK);
  }
  
  @RequestMapping(value="/delete")
  public String delete(int id) {
    try {
      User user = new User(id);
      _userDao.delete(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully deleted!";
  }
  
  @RequestMapping(value="/get-by-email")
  public String getByEmail(String email) {
    String userId;
    try {
      User user = _userDao.getByEmail(email);
      userId = String.valueOf(user.getId());
    }
    catch(Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }

  @RequestMapping(value="/save")
  public String create(String email, String name) {
    try {
      User user = new User(email, name);
      _userDao.save(user);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "User succesfully saved!";
  }
  private static final String PATH = "/error";

  @RequestMapping(value = PATH)
  public String error() {
      return "Error handling";
  }

  @Override
  public String getErrorPath() {
      return PATH;
  }
} // class UserController

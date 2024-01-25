package dambi.relationaldata;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // This means that this class is a Controller
@RequestMapping(path = "/hasi") // This means URL's start with /demo (after Application path)
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @PostMapping(path = "/gehitu") // Map ONLY POST Requests
  public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
    return "Gordeta";
  }

  @PutMapping(value = "/update/{userId}")
	public ResponseEntity updateContact(@Valid @RequestBody User user, @PathVariable int userId) {
		try {
			user.setId(userId);
			userRepository.save(user);

			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}

  @DeleteMapping(path = "/delete/{userId}")
  public ResponseEntity deleteUserById(@PathVariable int userId) {
    try {
      userRepository.deleteById(userId);
      return ResponseEntity.ok().build();

    } catch (Exception ex) {
      System.out.println("Errorea " + userId + " userra ezabatzerakoan. ");
      return ResponseEntity.notFound().build();

    }
  }

  @GetMapping(path = "/denak")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
}

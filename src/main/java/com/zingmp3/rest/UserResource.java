package com.zingmp3.rest;

import com.zingmp3.dto.CustomUserDetails;
import com.zingmp3.entity.User;
import com.zingmp3.jwt.JwtTokenProvider;
import com.zingmp3.repository.UserRepository;
import com.zingmp3.service.MailService;
import com.zingmp3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserResource {

    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    private final MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody User user) throws URISyntaxException {
        Optional<User> users = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        System.out.println(users);
        if(users.isPresent() == false){
            return ResponseEntity.status(401)
                    .body(null);
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(users.get());
        String token = jwtTokenProvider.generateToken(customUserDetails);
        return ResponseEntity
                .created(new URI("/api/authen/" ))
                .body(token);
    }

    public UserResource(UserRepository userRepository, JwtTokenProvider jwtTokenProvider, UserService userService, MailService mailService) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
        this.mailService = mailService;
    }
    @GetMapping("/getall")
    public Page<User> activateAccount(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @GetMapping("/admin/getUserNotAdmin")
    public List<User> findUserNotAdmin() {
        return userRepository.findUserNotAdmin("ROLE_USER");
    }

    @GetMapping("/admin/getUserNotUser")
    public List<User> getUserNotUser() {
        return userRepository.findUserNotAdmin("ROLE_ADMIN");
    }

    @PostMapping("/register")
    public ResponseEntity<Integer> save(@RequestBody User user) throws URISyntaxException {
        if(userService.checkEmailexist(user.getEmail())){
            HttpHeaders headers = new HttpHeaders();
            headers.add("email already exist ", user.getEmail());
            return ResponseEntity.status(300).headers(headers)
                    .body(1);
        }
        else if(userRepository.findByUsername(user.getUsername()).isPresent() == true){
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.status(500).headers(headers)
                    .body(2);
        }
        user.setActived(1);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreated_date(new Timestamp(System.currentTimeMillis()));
        User result = userRepository.save(user);
        System.out.println(result);
        return ResponseEntity
                .created(new URI("/api/save/" + result.getId()))
                .body(0);
    }

    @PostMapping("/userlogged")
    public User getUserLogged(){
        return userService.getUserWithAuthority();
    }



    @PostMapping("/admin/activeUser")
    public void activeOrUnactiveUser(@RequestParam("id") Long id){
        User user = userRepository.findById(id).get();
        if(user.getActived() == 1){
            user.setActived(0);
        }
        else{
            user.setActived(1);
        }
        userRepository.save(user);
    }

}

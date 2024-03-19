package com.website.ecommerce.api;

import com.website.ecommerce.dto.RegisterRequest;
import com.website.ecommerce.dto.UserDTO;
import com.website.ecommerce.entity.User;
import com.website.ecommerce.service.UserService;
import com.website.ecommerce.utils.Roles;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/")
public class AdminApi {


    private final UserService userService;

    public AdminApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> result = userService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/lockOrUnlock")
    public void lockOrUnlock(@RequestParam("username") String username){
        userService.lockOrUnlockAccount(username);
    }

    @GetMapping("/findAllByRole")
    public ResponseEntity<List<UserDTO>> findAllByRole(@RequestParam("role") Roles roles){
        List<UserDTO> result = userService.findAllByRole(roles);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/findAllUserLockOrUnlock")
    public ResponseEntity<List<UserDTO>> findAllUserLockOrUnlock(@RequestParam("active") Boolean active){
        List<UserDTO> result = userService.findAllUserLockOrUnlock(active);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/addAdmin")
    public ResponseEntity<User> addAdmin(@RequestBody RegisterRequest request){
        User result = userService.registerAdmin(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

package com.mesh.userauth.controller;


import com.mesh.userauth.config.jwt.JwtProvider;
import com.mesh.userauth.entity.Phone;
import com.mesh.userauth.entity.User;
import com.mesh.userauth.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Tag(name = "registration", description = "The registration API")
@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @Operation(summary = "Registration", tags = "registration")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "OK",
                    description = "show the requests",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = User.class)))
                    })
    })
    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        User user = new User();
        user.setPassword(registrationRequest.getPassword());
        user.setEmail(registrationRequest.getEmail());
        userService.saveUser(user);
        return "OK";
    }

    @Operation(summary = "Auth", tags = "auth")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "OK",
                    description = "show the auth",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = User.class)))
                    })
    })
    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        User user= userService.findByEmailAndPassword(request.getEmail(), request.getPassword());
        String token = jwtProvider.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
    @Operation(summary = "Find user by id", tags = "id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "OK",
                    description = "find user by id",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = User.class)))
                    })
    })
    @GetMapping("/getUser/{id}")
    public ResponseEntity<?> getRequestByCarId(@PathVariable("id") Long id){

        Optional<User> user = userService.getUserById(id);

        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @Operation(summary = "Find user by email", tags = "email")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "OK",
                    description = "Find user by email",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = User.class)))
                    })
    })
    @GetMapping("/{email}")
    public ResponseEntity<?> getRequestByEmail(@PathVariable("email") String email){
        User user  = userService.findByEmail(email);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}

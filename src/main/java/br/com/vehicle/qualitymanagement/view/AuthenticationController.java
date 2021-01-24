package br.com.vehicle.qualitymanagement.view;

import br.com.vehicle.qualitymanagement.security.TokenService;
import br.com.vehicle.qualitymanagement.view.resource.LoginRequest;
import br.com.vehicle.qualitymanagement.view.resource.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenResponse> authenticate(@RequestBody LoginRequest login) {
        UsernamePasswordAuthenticationToken loginData = login.toUsernamePasswordAuthenticationToken();
        try {
            Authentication authentication = authenticationManager.authenticate(loginData); // consume auth service
            String token = tokenService.generateToken(authentication);
            String typeAuthentication = "Bearer";
            TokenResponse tokenResponse = new TokenResponse(token, typeAuthentication);
            return ResponseEntity.ok(tokenResponse);
        } catch (AuthenticationException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}

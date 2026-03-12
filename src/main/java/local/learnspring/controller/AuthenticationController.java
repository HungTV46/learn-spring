package local.learnspring.controller;

import com.nimbusds.jose.JOSEException;
import local.learnspring.dto.request.AuthenticationRequest;
import local.learnspring.dto.request.IntrospectRequest;
import local.learnspring.dto.response.ApiResponse;
import local.learnspring.dto.response.AuthenticationResponse;
import local.learnspring.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/token")
    ApiResponse<?> authenticate(@RequestBody AuthenticationRequest request) throws JOSEException {
        var result = authenticationService.authenticate(request);
        return ApiResponse.builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<?> introspect(@RequestBody IntrospectRequest request) throws JOSEException, ParseException {
        var result = authenticationService.introspect(request);
        return ApiResponse.builder()
                .result(result)
                .build();
    }
}

package eric.beta.web3j.controller;

import eric.beta.web3j.sample.ConnectionSample;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class CommonController {

    private final ConnectionSample connectionSample;

    @GetMapping("/common/client-version")
    public String getVersion() throws IOException {
        return connectionSample.getClientVersion();
    }
}

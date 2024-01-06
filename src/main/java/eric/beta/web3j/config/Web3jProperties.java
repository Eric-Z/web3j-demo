package eric.beta.web3j.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "web3j")
@Getter
@Setter
public class Web3jProperties {

    private String httpServiceUrl;
}

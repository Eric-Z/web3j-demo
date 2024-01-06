package eric.beta.web3j.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.http.HttpService;

@EnableConfigurationProperties(Web3jProperties.class)
@Configuration(proxyBeanMethods = false)
@RequiredArgsConstructor
@Getter
@Setter
public class Web3jConfig {

    private final Web3jProperties properties;

    @Primary
    @Bean
    public Web3j initWeb3j() {
        return Web3j.build(new HttpService(properties.getHttpServiceUrl()));
    }

    @Bean
    public Admin initAdmin() {
        return Admin.build(new HttpService(properties.getHttpServiceUrl()));
    }
}

package eric.beta.web3j.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WalletDTO {

    private String address;

    private String password;

    private String privateKey;

    private String publicKey;
}

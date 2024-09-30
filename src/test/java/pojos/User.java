package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("username")
    @NotNull
    private String username;

    @JsonProperty("firstname")
    @NotNull
    private String firstname;

    @JsonProperty("id")
    @NotNull
    private int id;

    @JsonProperty("lastname")
    @NotNull
    private String lastname;

    @JsonProperty("email")
    @NotNull
    private String email;

    @JsonProperty("password")
    @NotNull
    private String password;

    @JsonProperty("phone")
    @NotNull
    private String phone;

    @JsonProperty("userStatus")
    @NotNull
    private int userStatus;

}


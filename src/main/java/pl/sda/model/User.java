
package pl.sda.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    String login;
    String password;
    String email;
}
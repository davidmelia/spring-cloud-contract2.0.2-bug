package uk.gw.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
public class UpdateDomain {
  @NotEmpty
  private final String email;

  @JsonCreator
  public UpdateDomain(@JsonProperty String email) {
    this.email = email;
  }


}

package uk.gw.controller.viewmodel.save;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotEmpty;
import lombok.ToString;
import lombok.Value;

@ToString
@Value
public class UpdateViewModel {
  @NotEmpty
  private final String email;

  @JsonCreator
  public UpdateViewModel(@JsonProperty String email) {
    this.email = email;
  }
}

package uk.gw.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import uk.gw.controller.viewmodel.save.UpdateViewModel;

@RestController
@RequestMapping("/api")
@Slf4j
public class MyController {

  private final RestTemplate restTemplate;

  public MyController(RestTemplateBuilder rtb) {
    this.restTemplate = rtb.build();
  }


  @PutMapping(value = "/2/root", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> update(@RequestBody @Valid UpdateViewModel viewModel) {
    log.debug("update():: {}", viewModel);
    restTemplate.put("http://localhost:6980/my-service/api/2/root/email", new UpdateDomain(viewModel.getEmail()));
    return ResponseEntity.noContent().build();
  }

}

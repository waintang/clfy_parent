package xyz.clfy.consumer.infra.maskant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import xyz.clfy.consumer.dto.EmployeeDTO;

import java.util.List;

@FeignClient(name = "provider", url = "http://localhost:8000")
public interface ProviderFeignClient {
    @GetMapping("/v1/{organizationId}/provider/{id}")
    ResponseEntity<String> getEmployeeById(@PathVariable ("organizationId") Long organizationId, @PathVariable("id") Long id);

    @PostMapping("/v1/{organizationId}/provider/save")
    ResponseEntity<String> saveEmployee(@PathVariable ("organizationId") Long organizationId, @RequestBody List<EmployeeDTO> employeeDTO);
}

package xyz.clfy.consumer.infra.maskant;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import xyz.clfy.consumer.dto.EmployeeDTO;
import xyz.clfy.consumer.infra.maskant.feign.ProviderFeignClient;

import java.util.List;

@Component
@Slf4j
public class ProviderAdaptor {

    @Autowired
    private ProviderFeignClient providerFeignClient;

    public String getEmployeeById(Long tenantId, Long id) {
        log.info("requestParam tenantId:{},id:{}",tenantId,id);
        ResponseEntity<String> responseEntity = providerFeignClient.getEmployeeById(tenantId,id);
        log.info(JSONObject.toJSONString(responseEntity));
        return responseEntity.getBody();
    }

    public String saveEmployee(Long tenantId, List<EmployeeDTO> employees) {
        log.info("requestParam tenantId:{},employees:{}",tenantId,JSONObject.toJSONString(employees));
        ResponseEntity<String> responseEntity = providerFeignClient.saveEmployee(tenantId,employees);
        log.info(JSONObject.toJSONString(responseEntity));
        return responseEntity.getBody();
    }
}

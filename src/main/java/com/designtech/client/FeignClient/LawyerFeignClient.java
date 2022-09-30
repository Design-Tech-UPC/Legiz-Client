package com.designtech.client.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "lawyer-service", url="http://localhost:30004")
@RequestMapping("lawyer")
public interface LawyerFeignClient {

}

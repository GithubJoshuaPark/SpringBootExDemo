package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.MemberDTO;

@RestController
@RequestMapping("/api/vi-get/api")
public class GetController {

  @GetMapping("/hello")
  public String getHello() {
    return "Hello, Spring Boot!";
  }

  // http://localhost:8080/api/vi-get/api/name
  @GetMapping("/name")
  public String getName() {
    return "Hello, Joshua Park";
  }

  // http://localhost:8080/api/vi-get/api/variable1/{variable}
  @GetMapping("/variable1/{id}")
  public String getVariable1(@PathVariable String id) {
    return id;
  }

  // http://localhost:8080/api/vi-get/api/variable2/{variable}
  @GetMapping("/variable2/{variable}")
  public String getVariable2(@PathVariable("variable") String var) {
    return var;
  }

  // http://localhost:8080/api/vi-get/api/request-param1?name=Joshua&email=joshua%40gmail.com&organization=Kakao
  @GetMapping("/request-param1")
  public String getRequestParam1(
    @RequestParam String name,
    @RequestParam String email,
    @RequestParam String organization
  ) {
    return name + ", " + email + " , " + organization;
  }

  // http://localhost:8080/api/vi-get/api/request-param2?name=Joshua&email=joshua%40gmail.com&organization=Kakao
  @GetMapping("/request-param2")
  public String getRequestParam2(@RequestParam Map<String, String> param) {
    StringBuffer sb = new StringBuffer();

    param.entrySet().forEach(map -> {
      sb.append(map.getKey() + " : " + map.getValue() + "\n");
    });

    return sb.toString();
  }

    // http://localhost:8080/api/vi-get/api/request-param3?name=Joshua&email=joshua%40gmail.com&organization=Kakao
    @GetMapping("/request-param3")
    public String getMemberDTO(MemberDTO memberDTO) {
      return memberDTO.toString();
    }

}

package com.konex.demo.infrastructure;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientFeignConfiguration {

  public Integer getReadTimeOutMillis() {
    return 2000;
  }

}

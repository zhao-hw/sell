package pers.zhw.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "projecturl")
public class ProjectUrlConfig {
    private String sell;
}

package kr.soft.shopping.config;

import kr.soft.shopping.config.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web에 대한 설정을 모아두는 공간
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)//모든 mapping
                .addPathPatterns("/api/**")
                .excludePathPatterns(
                        "/api/member/**",
                        "/api/board/**"
                );
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//모든 mapping
                .allowedOrigins("http://localhost:5173") //Client접속되는 도메인 여러개 사용가능
                .allowedMethods("GET","POST") //접근 방식
                .allowedHeaders("*") //header에다가 어떤 기능만 허용
                .allowCredentials(true)
                .maxAge(3600);
    }

}

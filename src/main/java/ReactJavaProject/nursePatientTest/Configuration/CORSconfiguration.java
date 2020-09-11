package ReactJavaProject.nursePatientTest.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.UrlBasedViewResolverRegistration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSconfiguration {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedHeaders("*")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                ;
            }
        };
    }

//    @Bean
//    public CorsFilter corsFilter(){
//        final UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
//        final CorsConfiguration config=new CorsConfiguration();
//        config.setAllowCredentials(true);
//
//        config.addAllowedOrigin("*");
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        source.registerCorsConfiguration("/**",config);
//        return new CorsFilter(source);
//    }
}

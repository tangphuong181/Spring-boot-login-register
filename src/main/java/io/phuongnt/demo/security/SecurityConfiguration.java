package  io.phuongnt.demo.security;

import io.phuongnt.demo.service.UserService;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

   /// Chi tiet ve DaoAuthenticationProvider.
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userService);
         provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain filter(HttpSecurity http /*, AuthenticationProvider authenticationProvider*/) throws Exception{

        http.authorizeHttpRequests(
                        configurer ->
                                configurer.requestMatchers("/static/**","/css/**","/img/**").permitAll()
                                        .requestMatchers("/showLoginPage", "/authenticateTheUser").permitAll()
                                        .requestMatchers("/register/**").permitAll()
                                        .requestMatchers("/register/process").permitAll()
                                        .requestMatchers("/register/register-success").permitAll()
                                      //  .requestMatchers("/").permitAll()
                                        .anyRequest().authenticated()

                ).formLogin(form -> form.loginPage("/showLoginPage")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
                ).logout(logout ->logout.permitAll())
                .exceptionHandling(
                        configurer ->
                                configurer.accessDeniedPage("/showPage403")
                );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
      //  http.authenticationProvider(authenticationProvider);

        return http.build();

    }



}

package com.example.exam.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails khawla= User.builder()
                .username("khawla")
                .password("{noop}khawla")
                .roles("Administrateur").build();
        UserDetails ahlam= User.builder()
                .username("ahlam")
                .password("{noop}ahlam")
                .roles("Patient").build();
        return new InMemoryUserDetailsManager(khawla,ahlam);

    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->configurer
                .requestMatchers(HttpMethod.POST,"/consultation").hasRole("Administrateur")
                .requestMatchers(HttpMethod.POST,"/prescription").hasRole("Administrateur")
                .requestMatchers(HttpMethod.POST,"/dossierMedical").hasRole("Administrateur")
                .requestMatchers(HttpMethod.POST,"/ficheConsultation").hasRole("Administrateur")
                .requestMatchers(HttpMethod.POST,"/ficheDeSoin").hasRole("Administrateur")
                .requestMatchers(HttpMethod.POST,"/fichePayement").hasRole("Administrateur")
                .requestMatchers(HttpMethod.POST,"/operationAnalyse").hasRole("Administrateur")
                .requestMatchers(HttpMethod.POST,"/patient").hasRole("Administrateur")
                .requestMatchers(HttpMethod.GET,"/consultation").hasRole("Administrateur")
                .requestMatchers(HttpMethod.GET,"/prescription").hasRole("Administrateur")
                .requestMatchers(HttpMethod.GET,"/dossierMedical").hasRole("Administrateur")
                .requestMatchers(HttpMethod.GET,"/ficheConsultation").hasRole("Administrateur")
                .requestMatchers(HttpMethod.GET,"/ficheDeSoin").hasRole("Administrateur")
                .requestMatchers(HttpMethod.GET,"/fichePayement").hasRole("Administrateur")
                .requestMatchers(HttpMethod.GET,"/operationAnalyse").hasRole("Administrateur")
                .requestMatchers(HttpMethod.GET,"/patient").hasRole("Administrateur")


        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();

    }
}

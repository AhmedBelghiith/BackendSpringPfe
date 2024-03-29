package com.bandsmile.crud.Config;
import com.bandsmile.crud.security.JwtAuthenticationEntryPoint;
import com.bandsmile.crud.security.JwtAuthorizationTokenFilter;
import com.bandsmile.crud.service.security.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    // Custom JWT based security filter
    @Autowired
    JwtAuthorizationTokenFilter authenticationTokenFilter;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.route.authentication.path}")
    private String authenticationPath;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoderBean());
    }

    @Bean
    public PasswordEncoder passwordEncoderBean() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.config.annotation.web.configuration.
     * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
     * annotation.web.builders.HttpSecurity)
     */
    // please don't touche this
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //httpSecurity.authorizeRequests().antMatchers("/").permitAll(). antMatchers(HttpMethod.POST, "/").permitAll();
        httpSecurity
                // we don't need CSRF because our token is invulnerable
                .csrf().disable()

                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

                // don't create session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests()

                // Un-secure H2 Database
                .antMatchers("/commentChat/**").permitAll() //StompEndpoint
                .antMatchers("/h2-console/**/**")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/register/**")
                .permitAll()
                .antMatchers("/authenticate/**")
                .permitAll()
                .antMatchers("Access-Control-Allow-Origin", "*")
                .permitAll()
                .antMatchers("Access-Control-Allow-Methods",
                        "GET, POST, PUT, DELETE, OPTIONS")
                .permitAll()
                .antMatchers("Access-Control-Max-Age", "3600")
                .permitAll()
                .antMatchers("Access-Control-Allow-Headers",
                        "authorization," + "xsrf-token", "Origin", "Accept",
                        "X-Requested-With", "Content-Type",
                        "Access-Control-Request-Method",
                        "Access-Control-Request-Headers").permitAll()
                .antMatchers("Access-Control-Expose-Headers", "xsrf-token")
                .permitAll()
        ;

        httpSecurity.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // disable page caching
        httpSecurity
                .headers()
                .frameOptions().sameOrigin()  // required to set for H2 else H2 Console will be blank.
                .cacheControl();




    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // AuthenticationTokenFilter will ignore the below paths
        web
                // allow anonymous resource requests
                .ignoring()
                .antMatchers(HttpMethod.GET, "/*",
                        "/*.html", "/favicon.ico",
                        "/**/*.html", "/**/*.css",
                        "/**/*.js")

                // Un-secure H2 Database (for testing purposes, H2 console shouldn't be
                // unprotected in production)
                .and()
                .ignoring().antMatchers("/h2-console/**/**");
    }

}



package org.eshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

/**
 * Created by ltaoj on 2017/9/7.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/eshop");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("");
        return driverManagerDataSource;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select user_id, password, true from signon where user_id=?")
                .authoritiesByUsernameQuery("select user_id, authorities from signon where user_id=?");
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/myInfo").access("hasRole('USER')")
                .antMatchers("/upMyInfo").access("hasRole('USER')")
                .antMatchers("/addressModal").access("hasRole('USER')")
                .antMatchers("/addHarvAddr").access("hasRole('USER')")
                .antMatchers("/delHarvAddr").access("hasRole('USER')")
                .antMatchers("/addrList").access("hasRole('USER')")
                .antMatchers("/upHarvAddr").access("hasRole('USER')")
                .antMatchers("/setDefAddr").access("hasRole('USER')")
                .antMatchers("/changePwd").access("hasRole('USER')")
                .antMatchers("/addToCart").access("hasRole('USER')")
                .antMatchers("/removeFromCart").access("hasRole('USER')")
                .antMatchers("/removeCartItemList").access("hasRole('USER')")
                .antMatchers("/cartItemIncreasing").access("hasRole('USER')")
                .antMatchers("/cartItemDescending").access("hasRole('USER')")
                .antMatchers("/viewCart").access("hasRole('USER')")
                .antMatchers("/createOrder").access("hasRole('USER')")
                .antMatchers("/orderDetail").access("hasRole('USER')")
                .antMatchers("/orderList").access("hasRole('USER')")
                .antMatchers("/cancelOrder").access("hasRole('USER')")
                .antMatchers("/delOrder").access("hasRole('USER')")
                .anyRequest().permitAll()
                .and().formLogin().loginPage("/login")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout").invalidateHttpSession(true)
                .and().csrf().disable()
                .headers().frameOptions().sameOrigin();
    }
}

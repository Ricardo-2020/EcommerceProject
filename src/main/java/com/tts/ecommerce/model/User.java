package com.tts.ecommerce.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

        
    @Length(min = 3, message = "Your username must have at least 3 characters")
    @Length(max = 15, message = "Your username cannot have more than 15 characters")
    @Pattern(regexp="[^\\s]+", message="Your username cannot contain spaces")
    private String username;
        
    @Length(min = 5, message = "Your password must have at least 5 characters")
    private String password;
        

    @ElementCollection
    private Map<Product, Integer> cart = new HashMap<Product, Integer>();

    public User(){
    }

    public User(Long id,
            @Length(min = 3, message = "Your username must have at least 3 characters") @Length(max = 15, message = "Your username cannot have more than 15 characters") @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces") String username,
            @Length(min = 5, message = "Your password must have at least 5 characters") String password,
            Map<Product, Integer> cart) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cart = cart;
    }
    

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<Product, Integer> cart2) {
        this.cart = cart2;
    }

    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    return null;
    }

    @Override
    public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return true;
    }

    @Override
    public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
    }

    @Override
    public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
    }

    @Override
    public String toString() {
        return "User [cart=" + cart + ", id=" + id + ", password=" + password + ", username=" + username + "]";
    }

    

    

    



    

    

    

    




    
}

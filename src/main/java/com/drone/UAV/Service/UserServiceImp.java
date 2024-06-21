package com.drone.UAV.Service;

import com.drone.UAV.Doa.UavUserDao;
import com.drone.UAV.Entity.Role;
import com.drone.UAV.Entity.UavUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UavUserDao userdao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UavUsers usr = userdao.findByUserName(username);

        if (usr == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        Collection<SimpleGrantedAuthority> authorities = mapRolesToAuthorities(usr.getRoles());

        return new org.springframework.security.core.userdetails.User(usr.getUserName(), usr.getPassword(), authorities
        );
    }

    private Collection<SimpleGrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role tempRole : roles) {
            SimpleGrantedAuthority tempAuthority = new SimpleGrantedAuthority(tempRole.getName());
            authorities.add(tempAuthority);
        }

        return authorities;
    }
}

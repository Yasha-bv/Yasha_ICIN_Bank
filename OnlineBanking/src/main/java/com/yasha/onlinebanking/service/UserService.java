package com.yasha.onlinebanking.service;

import com.yasha.onlinebanking.entity.User;
import com.yasha.onlinebanking.security.UserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * Project : online-banking
 * User: yasha
 * Email: yasha@gmail.com
 * Telegram : @yasha34
 * Date: 09/08/18
 * Time: 04.34
 * To change this template use File | Settings | File Templates.
 */
@Service("userDetailsService")
public interface UserService {

    User findByUsername(String username);

    User findByEmail(String email);

    boolean checkUserExists(String username, String email);

    boolean checkUsernameExists(String username);

    boolean checkEmailExists(String email);

    void save(User user);

    User createUser(User user, Set<UserRole> userRoles);

    User saveUser(User user);

    List<User> findUserList();

    void enableUser(String username);

    void disableUser(String username);

}
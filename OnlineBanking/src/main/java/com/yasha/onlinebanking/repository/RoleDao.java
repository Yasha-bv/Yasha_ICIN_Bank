package com.yasha.onlinebanking.repository;

import com.yasha.onlinebanking.security.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : online-banking
 * User: yasha
 * Email: yasha@gmail.com
 * Telegram : @yasha34
 * Date: 08/08/18
 * Time: 06.06
 * To change this template use File | Settings | File Templates.
 */
public interface RoleDao extends CrudRepository<Role, Integer> {

    Role findByName(String name);
}
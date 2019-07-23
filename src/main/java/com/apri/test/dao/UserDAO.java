/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apri.test.dao;
import com.apri.test.entity.User;
import java.util.List;

public interface UserDAO extends BaseDAO<User> {

    List<User> findByUsername(User param);

}

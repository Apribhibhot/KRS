/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apri.test.service;

import com.apri.test.entity.User;
import java.util.List;

public interface UserService extends BaseService<User> {

    List<User> findByUsername(User param);
}

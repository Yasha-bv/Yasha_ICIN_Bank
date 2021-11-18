package com.yasha.onlinebanking.service;

import com.yasha.onlinebanking.entity.PrimaryAccount;
import com.yasha.onlinebanking.entity.SavingsAccount;

import java.security.Principal;

/**
 * Created by IntelliJ IDEA.
 * Project : online-banking
 * User: yasha
 * Email: yasha@gmail.com
 * Telegram : @yasha34
 * Date: 09/08/18
 * Time: 04.32
 * To change this template use File | Settings | File Templates.
 */
public interface AccountService {

    PrimaryAccount createPrimaryAccount();

    SavingsAccount createSavingsAccount();

    void deposit(String accountType, double amount, Principal principal);

    void withdraw(String accountType, double amount, Principal principal);

}
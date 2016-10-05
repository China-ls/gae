package com.ls.wechat.repositories;

import com.ls.wechat.core.repositories.BasicRepository;
import com.ls.wechat.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends BasicRepository<Account, Integer> {


}

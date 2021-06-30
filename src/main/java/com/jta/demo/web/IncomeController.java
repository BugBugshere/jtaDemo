package com.jta.demo.web;

import com.jta.demo.domain.Income;
import com.jta.demo.domain.mapper.income.IncomeMapper;
import com.jta.demo.domain.User;
import com.jta.demo.domain.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;


/**
 * @author Freud
 */
@RestController
@RequestMapping("/income")
public class IncomeController {

    public static final String RESULT_SUCCESS = "success";
    public static final String RESULT_FAILED = "failed";

    @Autowired
    private IncomeMapper incomeMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/addincome/1")
    @Transactional
    public String addIncome1(@RequestParam("name") String name, @RequestParam("amount") double amount) {

        try {
            User user = new User();
            user.setName(name);
            userMapper.insert(user);

            Income income = new Income();
            income.setUserId(user.getId());
            income.setAmount(amount);
            income.setOperateDate(new Timestamp(System.currentTimeMillis()));
            incomeMapper.insert(income);

            return RESULT_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return RESULT_FAILED + ":" + e.getMessage();
        }
    }

    @GetMapping("/addincome/2")
    @Transactional
    public String addIncome2(@RequestParam("name") String name, @RequestParam("amount") double amount) throws Exception {
        try {
            User user = new User();
            user.setName(name);
            userMapper.insert(user);

            this.throwRuntimeException();

            Income income = new Income();
            income.setUserId(user.getId());
            income.setAmount(amount);
            income.setOperateDate(new Timestamp(System.currentTimeMillis()));
            incomeMapper.insert(income);

            return RESULT_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
            // return RESULT_FAILED + ":" + e.getMessage();
        }
    }

    public void throwRuntimeException() {
        throw new RuntimeException("User defined exceptions");
    }
}
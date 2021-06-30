package com.jta.demo.domain.mapper.income;

import com.jta.demo.domain.Income;
import org.apache.ibatis.annotations.Insert;


/**
 * @author Freud
 */
public interface IncomeMapper {

    @Insert("INSERT INTO INCOME(userId,amount,operateDate) VALUES(#{userId},#{amount},#{operateDate})")
    public void insert(Income income);

}
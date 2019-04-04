package com.xkc.learn.mybatis.dao;

import com.xkc.learn.mybatis.domain.EmpModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    EmpModel findEmpById(@Param("id") int id);

    List<EmpModel> findEmpByEmpName(String name);

    int insertEmp(EmpModel emp);

    int deleteEmp(String name);

    int updateEmp(EmpModel emp);

    int getPrimaryKey(EmpModel emp);

}

package org.cbioportal.persistence.mysql.mapper;

import java.util.List;

import org.cbioportal.model.TestModel;
import org.cbioportal.persistence.mysql.MySQLConnMapper;

@MySQLConnMapper
public interface TestModelMySQLMapper {
	List<TestModel> findAllModels();
}

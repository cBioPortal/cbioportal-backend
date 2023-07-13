package org.cbioportal.service.impl.mysql;

import java.util.List;

import org.cbioportal.model.TestModel;
import org.cbioportal.persistence.mysql.mapper.TestModelMySQLMapper;
import org.cbioportal.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mysql")
public class TestServiceMySQL implements TestService {
	
	@Autowired
	TestModelMySQLMapper testMySQLMapper;

	@Override
	public String getName() {
		List<TestModel> returns = testMySQLMapper.findAllModels();
		return "mySQL " + returns.size();
	}

}

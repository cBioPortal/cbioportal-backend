package org.cbioportal.service.impl.clickhouse;

import java.util.List;

import org.cbioportal.model.TestModel;
import org.cbioportal.persistence.clickhouse.mapper.TestModelClickHouseMapper;
import org.cbioportal.service.api.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("clickhouse")
public class TestServiceClickHouse implements TestService {
	
	@Autowired
	TestModelClickHouseMapper testClickhouseMapper;
	
	@Override
	public String getName() {
		List<TestModel> returns = testClickhouseMapper.findAllModels();
		return "clickhouse " + returns.size();
	}

}
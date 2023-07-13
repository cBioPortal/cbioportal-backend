package org.cbioportal.persistence.clickhouse.mapper;

import java.util.List;

import org.cbioportal.model.TestModel;
import org.cbioportal.persistence.clickhouse.ClickHouseConnMapper;

@ClickHouseConnMapper
public interface TestModelClickHouseMapper {
	List<TestModel> findAllModels();
}

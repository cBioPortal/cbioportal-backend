package org.cbioportal.persistence.mysql.mapper;

import java.util.Collection;
import java.util.List;

import org.cbioportal.model.AlterationCountByGene;
import org.cbioportal.persistence.mysql.MySQLConnMapper;

@MySQLConnMapper
public interface SampleServiceSQLMapper {

	Collection<AlterationCountByGene> fetchSamples(List<String> studyIds, List<String> sampleIds, String name);

}

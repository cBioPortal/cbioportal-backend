package org.cbioportal.model;

import java.io.Serializable;
import java.util.List;

public class DataFilter implements Serializable {

	private static final long serialVersionUID = 5797860653080711815L;
	
	private List<DataFilterValue> values;

    public List<DataFilterValue> getValues() {
        return values;
    }

    public void setValues(List<DataFilterValue> values) {
        this.values = values;
    }

}

package ch.marcoforster.libraries.hubspot.models.crm.companies.requests;

import ch.marcoforster.libraries.hubspot.models.search.FilterGroup;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCompaniesRequest implements Serializable {

    @SerializedName("filterGroups")
    private List<FilterGroup> filterGroups;

    @SerializedName("sorts")
    private List<String> sorts;

    @SerializedName("query")
    private String query;

    @SerializedName("properties")
    private List<String> properties;

    @SerializedName("limit")
    private int limit;

    @SerializedName("after")
    private int after;

    public SearchCompaniesRequest(List<FilterGroup> filterGroups, List<String> sorts, List<String> properties, int limit, int after) {
        this.filterGroups = filterGroups;
        this.sorts = sorts;
        this.query = null;
        this.properties = properties;
        this.limit = limit;
        this.after = after;
    }
}

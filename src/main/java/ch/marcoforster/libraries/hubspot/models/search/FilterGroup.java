package ch.marcoforster.libraries.hubspot.models.search;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterGroup implements Serializable {

    @SerializedName("filters")
    private List<Filter> filters;
}

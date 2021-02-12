package ch.marcoforster.libraries.hubspot.models.crm.companies;

import ch.marcoforster.libraries.hubspot.models.paging.Paging;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompaniesByPaging implements Serializable {

    @SerializedName("results")
    private List<Company> companies;

    @SerializedName("paging")
    private Paging paging;
}

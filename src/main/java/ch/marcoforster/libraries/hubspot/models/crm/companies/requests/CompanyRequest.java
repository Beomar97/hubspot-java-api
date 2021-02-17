package ch.marcoforster.libraries.hubspot.models.crm.companies.requests;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest implements Serializable {

    @SerializedName("properties")
    private Map<String, String> properties;
}

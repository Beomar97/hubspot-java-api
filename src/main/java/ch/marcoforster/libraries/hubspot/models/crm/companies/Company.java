package ch.marcoforster.libraries.hubspot.models.crm.companies;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("properties")
    private Map<String, String> properties;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("updatedAt")
    private String updatedAt;

    @SerializedName("archived")
    private boolean archived;
}

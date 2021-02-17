package ch.marcoforster.libraries.hubspot.models.search;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filter implements Serializable {

    @SerializedName("value")
    private String value;

    @SerializedName("propertyName")
    private String propertyName;

    @SerializedName("operator")
    private Operator operator;

    public Filter(String propertyName, Operator operator) {
        this.value = null;
        this.propertyName = propertyName;
        this.operator = operator;
    }
}

package ch.marcoforster.libraries.hubspot.models.paging;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Next implements Serializable {

    @SerializedName("after")
    private String after;

    @SerializedName("link")
    private String link;
}

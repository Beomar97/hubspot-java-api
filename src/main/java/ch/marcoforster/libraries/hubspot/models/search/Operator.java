package ch.marcoforster.libraries.hubspot.models.search;

import com.google.gson.annotations.SerializedName;

public enum Operator {
    @SerializedName("EQ")
    EQUALS,

    @SerializedName("NEQ")
    NOT_EQUALS,

    @SerializedName("LT")
    LESS_THAN,

    @SerializedName("LTE")
    LESS_THAN_EQUALS,

    @SerializedName("GT")
    GREATER_THAN,

    @SerializedName("GTE")
    GREATER_THAN_EQUALS,

    @SerializedName("HAS_PROPERTY")
    HAS_PROPERTY,

    @SerializedName("NOT_HAS_PROPERTY")
    HAS_NO_PROPERTY,

    @SerializedName("CONTAINS_TOKEN")
    CONTAINS_TOKEN,

    @SerializedName("NOT_CONTAINS_TOKEN")
    CONTAINS_NO_TOKEN
}

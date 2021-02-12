package ch.marcoforster.libraries.hubspot.api;

import ch.marcoforster.libraries.hubspot.models.crm.companies.CompaniesByPaging;
import ch.marcoforster.libraries.hubspot.models.crm.companies.Company;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CrmApi {

    @GET("crm/v3/objects/companies")
    Call<CompaniesByPaging> listCompanies();

    @GET("crm/v3/objects/companies")
    Call<CompaniesByPaging> listCompanies(
            @Query("limit") Integer limit,
            @Query("after") String after,
            @Query("properties") String[] properties,
            @Query("associations") String[] associations,
            @Query("archived") Boolean archived
    );

    @GET("crm/v3/objects/companies/{companyId}")
    Call<Company> readCompany(@Path("companyId") String companyId);
}

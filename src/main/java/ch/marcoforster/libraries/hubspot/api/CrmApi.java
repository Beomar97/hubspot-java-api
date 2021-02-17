package ch.marcoforster.libraries.hubspot.api;

import ch.marcoforster.libraries.hubspot.models.crm.companies.CompaniesByPaging;
import ch.marcoforster.libraries.hubspot.models.crm.companies.Company;
import ch.marcoforster.libraries.hubspot.models.crm.companies.requests.CompanyRequest;
import retrofit2.Call;
import retrofit2.http.*;

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

    @POST("crm/v3/objects/companies")
    Call<Company> createCompany(
            @Body CompanyRequest companyToCreate
    );

    @GET("crm/v3/objects/companies/{companyId}")
    Call<Company> readCompany(
            @Path("companyId") String companyId
    );

    @GET("crm/v3/objects/companies/{companyId}")
    Call<Company> readCompany(
            @Path("companyId") String companyId,
            @Query("properties") String[] properties,
            @Query("associations") String[] associations,
            @Query("archived") Boolean archived,
            @Query("idProperty") String idProperty
    );

    @PATCH("crm/v3/objects/companies/{companyId}")
    Call<Company> updateCompany(
        @Path("companyId") String companyId,
        @Body CompanyRequest companyToUpdate
    );
}

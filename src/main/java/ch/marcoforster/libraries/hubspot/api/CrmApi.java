package ch.marcoforster.libraries.hubspot.api;

import ch.marcoforster.libraries.hubspot.models.crm.companies.CompaniesByPaging;
import ch.marcoforster.libraries.hubspot.models.crm.companies.Company;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CrmApi {

    @GET("crm/v3/objects/companies")
    Call<CompaniesByPaging> listCompanies();

    @GET("crm/v3/objects/companies/{companyId}")
    Call<Company> readCompany(@Path("companyId") String companyId);
}

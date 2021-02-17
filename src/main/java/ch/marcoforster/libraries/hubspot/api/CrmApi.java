package ch.marcoforster.libraries.hubspot.api;

import ch.marcoforster.libraries.hubspot.models.crm.companies.CompaniesByPaging;
import ch.marcoforster.libraries.hubspot.models.crm.companies.CompaniesBySearch;
import ch.marcoforster.libraries.hubspot.models.crm.companies.Company;
import ch.marcoforster.libraries.hubspot.models.crm.companies.requests.CompanyRequest;
import ch.marcoforster.libraries.hubspot.models.crm.companies.requests.SearchCompaniesRequest;
import ch.marcoforster.libraries.hubspot.models.search.Filter;
import ch.marcoforster.libraries.hubspot.models.search.FilterGroup;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface CrmApi {

    /**
     * <p>
     *     Read a page of companies.
     * </p>
     *
     * @return  A list of companies by paging. {@link CompaniesByPaging}
     * @see     <a href="https://developers.hubspot.com/docs/api/crm/companies">Companies</a>
     * @since   0.0.1
     */
    @GET("crm/v3/objects/companies")
    Call<CompaniesByPaging> listCompanies();

    /**
     * <p>
     *     Read a page of companies with optional parameters.
     *     Control what is returned via the properties query param.
     * </p>
     *
     * @param limit         The maximum number of results to display per page ({@default 10}).
     * @param after         The paging cursor token of the last successfully read resource will be returned as the
     *                      paging.next.after JSON property of a paged response containing more results.
     * @param properties    A comma separated list of the properties to be returned in the response.
     *                      If any of the specified properties are not present on the requested object(s),
     *                      they will be ignored.
     * @param associations  A comma separated list of object types to retrieve associated IDs for. If any of
     *                      the specified associations do not exist, they will be ignored.
     * @param archived      Whether to return only results that have been archived ({@default false}).
     * @return              A list of companies by paging {@link CompaniesByPaging}.
     * @see                 <a href="https://developers.hubspot.com/docs/api/crm/companies">Companies</a>
     * @since               0.0.1
     */
    @GET("crm/v3/objects/companies")
    Call<CompaniesByPaging> listCompanies(
            @Query("limit") Integer limit,
            @Query("after") String after,
            @Query("properties") String[] properties,
            @Query("associations") String[] associations,
            @Query("archived") Boolean archived
    );

    /**
     * <p>
     *     Create a company with the given properties and return a copy of the object, including the ID.
     * </p>
     *
     * @param companyToCreate   A custom request object {@link CompanyRequest},
     *                          specifying the properties of the to created company.
     * @return                  The just created company {@link Company}.
     * @see                     <a href="https://developers.hubspot.com/docs/api/crm/companies">Companies</a>
     * @since                   0.0.1
     */
    @POST("crm/v3/objects/companies")
    Call<Company> createCompany(
            @Body CompanyRequest companyToCreate
    );

    /**
     * <p>
     *     Read an Object identified by {companyId}.
     * </p>
     *
     * @param companyId The ID of the company to read.
     * @return          The company {@link Company} specified by {@param companyId}.
     * @see             <a href="https://developers.hubspot.com/docs/api/crm/companies">Companies</a>
     * @since           0.0.1
     */
    @GET("crm/v3/objects/companies/{companyId}")
    Call<Company> readCompany(
            @Path("companyId") String companyId
    );

    /**
     * <p>
     *     Read an Object identified by {companyId} with optional parameters.
     *     {companyId} refers to the internal object ID by default,
     *     or optionally any unique property value as specified by the idProperty query param.
     *     Control what is returned via the properties query param.
     * </p>
     *
     * @param companyId     The ID of the company to read.
     * @param properties    A comma separated list of the properties to be returned in the response.
     *                      If any of the specified properties are not present on the requested object(s),
     *                      they will be ignored.
     * @param associations  A comma separated list of object types to retrieve associated IDs for.
     *                      If any of the specified associations do not exist, they will be ignored.
     * @param archived      Whether to return only results that have been archived ({@default false}).
     * @param idProperty    The name of a property whose values are unique for this object type.
     * @return              The company {@link Company} specified by {@param companyId}.
     * @see                 <a href="https://developers.hubspot.com/docs/api/crm/companies">Companies</a>
     * @since               0.0.1
     */
    @GET("crm/v3/objects/companies/{companyId}")
    Call<Company> readCompany(
            @Path("companyId") String companyId,
            @Query("properties") String[] properties,
            @Query("associations") String[] associations,
            @Query("archived") Boolean archived,
            @Query("idProperty") String idProperty
    );

    /**
     * <p>
     *     Perform a partial update of an Object identified by {companyId}.
     *     Provided property values will be overwritten.
     *     Read-only and non-existent properties will be ignored.
     *     Properties values can be cleared by passing an empty string.
     * </p>
     *
     * @param companyId         The ID of the company to update.
     * @param companyToUpdate   A custom request object {@link CompanyRequest},
     *                          specifying the properties to update for the company.
     * @return                  The just updated company {@link Company} specified by {@param companyId}.
     */
    @PATCH("crm/v3/objects/companies/{companyId}")
    Call<Company> updateCompany(
        @Path("companyId") String companyId,
        @Body CompanyRequest companyToUpdate
    );

    /**
     * <p>
     *     Move an Object identified by {companyId} to the recycling bin.
     * </p>
     *
     * @param companyId The ID of the company to archive.
     * @return          A void response will be returned (HTTP 204: No content).
     */
    @DELETE("crm/v3/objects/companies/{companyId}")
    Call<Void> archiveCompany(
      @Path("companyId") String companyId
    );

    /**
     * <p>
     *     Filter, Sort, and Search CRM Objects
     * </p>
     *
     * @param companiesToSearch A custom request object {@link SearchCompaniesRequest},
     *                          defines filter groups {@link List<FilterGroup>} with filters {@link List<Filter>},
     *                          properties to sort by {@param sorts}, an optional query {@param query},
     *                          and has paging capabilities with {@param limit} and {@param after}.
     * @return                  A list of companies found by the search {@link CompaniesBySearch}.
     */
    @POST("crm/v3/objects/companies/search")
    Call<CompaniesBySearch> searchCompanies(
        @Body SearchCompaniesRequest companiesToSearch
    );
}

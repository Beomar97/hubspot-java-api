package ch.marcoforster.libraries.hubspot.api;

import ch.marcoforster.libraries.hubspot.HubSpot;
import ch.marcoforster.libraries.hubspot.models.crm.companies.requests.CompanyRequest;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static config.EnvironmentVariables.API_KEY;
import static config.EnvironmentVariables.COMPANY_ID;

class CrmApiTest {

    private static CrmApi crmApi;

    @BeforeAll
    static void initializeApi() {
        crmApi = new HubSpot(API_KEY).crmApi();
    }

    @Test
    void listCompanies() throws IOException {
        val request = crmApi.listCompanies();
        val response = request.execute();

        val companies = response.body();
    }

    @Test
    void listCompaniesWithOptionalParameters() throws IOException {
        val request = crmApi.listCompanies(
                5,
                COMPANY_ID,
                new String[]{"name", "phone"},
                null,
                null
        );
        val response = request.execute();

        val companies = response.body();
    }

    @Test
    void readCompany() throws IOException {
        val request = crmApi.readCompany(COMPANY_ID);
        val response = request.execute();

        val company = response.body();
    }

    @Test
    void readCompanyWithOptionalParameters() throws IOException {
        val request = crmApi.readCompany(
                COMPANY_ID,
                new String[]{"name", "phone"},
                null,
                null,
                null
        );
        val response = request.execute();

        val company = response.body();
    }

    @Test
    void createCompany() throws IOException {
        val request = crmApi.createCompany(
                new CompanyRequest(
                        new HashMap<>() {{
                            put("city", "Cambridge");
                            put("domain", "biglytics.net");
                            put("industry", "Technology");
                            put("name", "Biglytics");
                            put("phone", "(877) 929-0687");
                            put("state", "Massachusetts");
                        }}
                )
        );
        val response = request.execute();

        val createdCompany = response.body();
    }

    @Test
    void updateCompany() throws IOException {
        val request = crmApi.updateCompany(
                COMPANY_ID,
                new CompanyRequest(
                        new HashMap<>() {{
                            put("city", "London");
                        }}
                )
        );
        val response = request.execute();

        val updatedCompany = response.body();
    }

    @Test
    void archiveCompany() throws IOException {
        val request = crmApi.archiveCompany(COMPANY_ID);
        val response = request.execute();

        val voidResponse = response.body();
    }
}
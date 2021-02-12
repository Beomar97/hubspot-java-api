package ch.marcoforster.libraries.hubspot.api;

import ch.marcoforster.libraries.hubspot.HubSpot;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static config.EnvironmentVariables.API_KEY;

class CrmApiTest {

    private static final String COMPANY_ID = "2875309706";

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
    void readCompany() throws IOException {
        val request = crmApi.readCompany(COMPANY_ID);
        val response = request.execute();

        val company = response.body();
    }
}
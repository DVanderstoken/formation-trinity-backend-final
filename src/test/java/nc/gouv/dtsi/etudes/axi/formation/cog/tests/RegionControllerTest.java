package nc.gouv.dtsi.etudes.axi.formation.cog.tests;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import nc.gouv.dtsi.etudes.axi.formation.FormationTrinityBackendAbstractTest;

@WebAppConfiguration
public class RegionControllerTest extends FormationTrinityBackendAbstractTest {

	private MockMvc lMockMvc;

	@Autowired
	private WebApplicationContext lContext;

	@Before
	public void setUp() {
		lMockMvc = MockMvcBuilders.webAppContextSetup(lContext).build();
	}

	@Test
	public void shouldReturnNonEmptyRegionListWithHttpCode200()
			throws Exception {

		lMockMvc.perform(get("/api/v1/regions")).andExpect(status().isOk())
				.andExpect(
						content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}

}

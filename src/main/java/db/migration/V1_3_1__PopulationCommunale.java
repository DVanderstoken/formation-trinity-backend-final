package db.migration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.flywaydb.core.api.migration.spring.SpringJdbcMigration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import db.migration.utils.ClassAttributeSpy;
import nc.gouv.dtsi.etudes.axi.formation.cog.commune.population.PopulationCommunale;

public class V1_3_1__PopulationCommunale implements SpringJdbcMigration {

	@Override
	public void migrate(JdbcTemplate jdbcTemplate) {

		final String query = "INSERT INTO popcom(code_region, nom_region, code_departement, code_arrondissement, code_canton, code_commune, nom_commune, pop_municipale, pop_a_part, pop_totale) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		ICsvBeanReader reader = null;

		try {

			reader = new CsvBeanReader(
					new InputStreamReader(
							this.getClass().getClassLoader()
									.getResourceAsStream("pop_com_2015.csv"),
							"ISO-8859-1"),
					CsvPreference.TAB_PREFERENCE);

			final String[] header = ClassAttributeSpy.getInstance()
					.getAttributesList(PopulationCommunale.class);

			final CellProcessor[] processors = getProcessors();

			List<PopulationCommunale> list = new ArrayList<PopulationCommunale>();
			PopulationCommunale p;
			while ((p = reader.read(PopulationCommunale.class, header,
					processors)) != null) {
				list.add(p);
			}

			for (Object o : list) {
				final PopulationCommunale pc = (PopulationCommunale) o;

				jdbcTemplate.execute(query,
						new PreparedStatementCallback<Boolean>() {
							@Override
							public Boolean doInPreparedStatement(
									PreparedStatement ps)
									throws SQLException, DataAccessException {

								ps.setString(1, pc.getCodeRegion());
								ps.setString(2, pc.getNomRegion());
								ps.setString(3, pc.getCodeDepartement());
								ps.setString(4, pc.getCodeArrondissement());
								ps.setString(5, pc.getCodeCanton());
								ps.setString(6, pc.getCodeCommune());
								ps.setString(7, pc.getNomCommune());
								ps.setString(8, pc.getPopMunicipale());
								ps.setString(9, pc.getPopAPart());
								ps.setString(10, pc.getPopTotale());

								return ps.execute();

							}
						});

			}

		} catch (IOException e) {

			System.out.println(e);

			if (e.getCause() != null) {
				System.out.println(e.getCause());
			}

		}

	}

	private static CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional(), new Optional(), new Optional(), new Optional(),
				new Optional()

		};

		return processors;
	}

}

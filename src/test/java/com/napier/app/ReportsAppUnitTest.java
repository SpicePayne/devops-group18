package com.napier.app;

import com.napier.app.Sql.LanguageReport;
import com.napier.app.Sql.Country;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReportsAppUnitTest {

    // existing test stays here...

    @Test
    void continentPopulation_bindsContinentAndReturnsScalar() throws Exception {
        Connection conn = mock(Connection.class);
        PreparedStatement ps = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(conn.prepareStatement(anyString())).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true);
        when(rs.getLong(1)).thenReturn(555L);

        Dao dao = new Dao(conn);
        long pop = dao.continentPopulation("Europe");

        assertEquals(555L, pop);
        verify(ps).setObject(1, "Europe");                  // parameter binding
        verify(conn).prepareStatement(contains("Continent=?")); // correct SQL intent
    }

    @Test
    void topCountriesWorld_mapsRowsAndUsesLimitParam() throws Exception {
        Connection conn = mock(Connection.class);
        PreparedStatement ps = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(conn.prepareStatement(anyString())).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(rs);

        // one row then end
        when(rs.next()).thenReturn(true, false);

        when(rs.getString("Code")).thenReturn("AAA");
        when(rs.getString("Name")).thenReturn("Aland");
        when(rs.getString("Continent")).thenReturn("Europe");
        when(rs.getString("Region")).thenReturn("Test Region");
        when(rs.getLong("Population")).thenReturn(1000L);
        when(rs.getString("Capital")).thenReturn(null);

        Dao dao = new Dao(conn);
        List<Country> result = dao.topCountriesWorld(3);

        assertEquals(1, result.size());
        assertEquals("Aland", result.get(0).name());
        verify(ps).setObject(1, 3);                         // LIMIT parameter
        verify(conn).prepareStatement(contains("LIMIT ?"));
    }

    @Test
    void languageReport_mapsMultipleRows() throws Exception {
        Connection conn = mock(Connection.class);
        PreparedStatement ps = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);

        when(conn.prepareStatement(anyString())).thenReturn(ps);
        when(ps.executeQuery()).thenReturn(rs);

        // two rows then end
        when(rs.next()).thenReturn(true, true, false);

        when(rs.getString("Language")).thenReturn("Chinese", "English");
        when(rs.getLong("Speakers")).thenReturn(1000L, 900L);
        when(rs.getDouble("WorldPct")).thenReturn(20.0, 18.0);

        Dao dao = new Dao(conn);
        List<LanguageReport> reports = dao.languageReport();

        assertEquals(2, reports.size());
        assertEquals("Chinese", reports.get(0).language());
        assertEquals(1000L, reports.get(0).speakers());
        assertEquals("English", reports.get(1).language());

        verify(conn).prepareStatement(contains("countrylanguage"));
        verify(conn).prepareStatement(contains("IN ('Chinese','English','Hindi','Spanish','Arabic')"));
    }
}

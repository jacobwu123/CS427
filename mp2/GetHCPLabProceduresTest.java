package edu.ncsu.csc.itrust.unit.dao.labprocedure;

import java.util.List;

import junit.framework.TestCase;
import edu.ncsu.csc.itrust.beans.LabProcedureBean;
import edu.ncsu.csc.itrust.dao.mysql.LabProcedureDAO;
import edu.ncsu.csc.itrust.exception.DBException;
import edu.ncsu.csc.itrust.unit.datagenerators.TestDataGenerator;
import edu.ncsu.csc.itrust.unit.testutils.TestDAOFactory;
import org.junit.Test;

public class GetHCPLabProceduresTest extends TestCase {
    private LabProcedureDAO lpDAO = TestDAOFactory.getTestInstance().getLabProcedureDAO();
    private TestDataGenerator gen;

    @Override
    protected void setUp() throws Exception {

        gen = new TestDataGenerator();
        gen.clearAllTables();
        gen.standardData();
    }


    @Test public void testGetHCPLabProcedures() throws Exception{
        List<LabProcedureBean> procedures = lpDAO.getHCPLabProcedures(9000000000L);
        assertEquals(7, procedures.size());
        assertEquals("10763-1", procedures.get(0).getLoinc());
        assertEquals("10666-6", procedures.get(1).getLoinc());
        assertEquals("10640-1", procedures.get(2).getLoinc());
        assertEquals("10640-1", procedures.get(3).getLoinc());
        assertEquals("10763-1", procedures.get(4).getLoinc());
        assertEquals("10763-1", procedures.get(5).getLoinc());
        assertEquals("10763-1", procedures.get(6).getLoinc());

    }
    @Test public void testFailGetHCPLabProcedures() throws Exception {
        try {
            lpDAO.getHCPLabProcedures(0L);
            fail("Exception should have been thrown");
        } catch (DBException e) {
            assertEquals("HCP id cannot be null", e.getExtendedMessage());
        }
    }
}

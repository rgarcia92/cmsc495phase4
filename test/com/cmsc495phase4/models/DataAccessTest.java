/*
 * Copyright (C) 2017 Rob Garcia at rgarcia92.student.umuc.edu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.cmsc495phase4.models;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rob Garcia at rgarcia92.student.umuc.edu
 */
public final class DataAccessTest {
    
    public DataAccessTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of selectAllMedications method, of class DataAccess.
     */
    @Test
    public void testSelectAllMedications_0args() throws Exception {
        System.out.println("selectAllMedications");
        ArrayList<Medications> expResult = null;
        ArrayList<Medications> result = DataAccess.selectAllMedications();
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllMedications method, of class DataAccess.
     */
    @Test
    public void testSelectAllMedications_int() throws Exception {
        System.out.println("selectAllMedications");
        int keypadLetterGroup = 0;
        ArrayList<Medications> expResult = null;
        ArrayList<Medications> result = DataAccess.selectAllMedications(keypadLetterGroup);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectMedicationsByGenericName method, of class DataAccess.
     */
    @Test
    public void testSelectMedicationsByGenericName() throws Exception {
        System.out.println("selectMedicationsByGenericName");
        ArrayList<Medications> expResult = null;
        ArrayList<Medications> result = DataAccess.selectMedicationsByGenericName();
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectMedicationDetails method, of class DataAccess.
     */
    @Test
    public void testSelectMedicationDetails() throws Exception {
        System.out.println("selectMedicationDetails");
        int medID = 0;
        Medications expResult = null;
        Medications result = DataAccess.selectMedicationDetails(medID);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllConditions method, of class DataAccess.
     */
    @Test
    public void testSelectAllConditions_0args() throws Exception {
        System.out.println("selectAllConditions");
        ArrayList<Conditions> expResult = null;
        ArrayList<Conditions> result = DataAccess.selectAllConditions();
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllConditions method, of class DataAccess.
     */
    @Test
    public void testSelectAllConditions_int() throws Exception {
        System.out.println("selectAllConditions");
        int keypadLetterGroup = 0;
        ArrayList<Conditions> expResult = null;
        ArrayList<Conditions> result = DataAccess.selectAllConditions(keypadLetterGroup);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectConditionDetails method, of class DataAccess.
     */
    @Test
    public void testSelectConditionDetails() throws Exception {
        System.out.println("selectConditionDetails");
        int conID = 0;
        Conditions expResult = null;
        Conditions result = DataAccess.selectConditionDetails(conID);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectMedicationsInCondition method, of class DataAccess.
     */
    @Test
    public void testSelectMedicationsInCondition() throws Exception {
        System.out.println("selectMedicationsInCondition");
        int conID = 0;
        ArrayList<Medications> expResult = null;
        ArrayList<Medications> result = DataAccess.selectMedicationsInCondition(conID);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectUser method, of class DataAccess.
     */
    @Test
    public void testSelectUser() throws Exception {
        System.out.println("selectUser");
        String userName = "";
        Users expResult = null;
        Users result = DataAccess.selectUser(userName);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserLastLogin method, of class DataAccess.
     */
    @Test
    public void testUpdateUserLastLogin() throws Exception {
        System.out.println("updateUserLastLogin");
        int userID = 0;
        String lastLogin = "";
        String newLogin = "";
        DataAccess.updateUserLastLogin(userID, lastLogin, newLogin);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllUsers method, of class DataAccess.
     */
    @Test
    public void testSelectAllUsers() throws Exception {
        System.out.println("selectAllUsers");
        ArrayList<Users> expResult = null;
        ArrayList<Users> result = DataAccess.selectAllUsers();
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserPassword method, of class DataAccess.
     */
    @Test
    public void testUpdateUserPassword() throws Exception {
        System.out.println("updateUserPassword");
        int userID = 0;
        String newPasswordHash = "";
        Boolean expResult = null;
        Boolean result = DataAccess.updateUserPassword(userID, newPasswordHash);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertUser method, of class DataAccess.
     */
    @Test
    public void testInsertUser() throws Exception {
        System.out.println("insertUser");
        String userName = "";
        int roleID = 0;
        Boolean expResult = null;
        Boolean result = DataAccess.insertUser(userName, roleID);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserRole method, of class DataAccess.
     */
    @Test
    public void testUpdateUserRole() throws Exception {
        System.out.println("updateUserRole");
        int userID = 0;
        String role = "";
        Boolean expResult = null;
        Boolean result = DataAccess.updateUserRole(userID, role);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class DataAccess.
     */
    @Test
    public void testDeleteUser() throws Exception {
        System.out.println("deleteUser");
        int userID = 0;
        Boolean expResult = null;
        Boolean result = DataAccess.deleteUser(userID);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectAllRoles method, of class DataAccess.
     */
    @Test
    public void testSelectAllRoles() throws Exception {
        System.out.println("selectAllRoles");
        ArrayList<Roles> expResult = null;
        ArrayList<Roles> result = DataAccess.selectAllRoles();
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertMedication method, of class DataAccess.
     */
    @Test
    public void testInsertMedication() throws Exception {
        System.out.println("insertMedication");
        String gName = "";
        String bName = "";
        String action = "";
        int btFlag = 0;
        int dea = 0;
        String side_effects = "";
        String interactions = "";
        String warnings = "";
        Boolean expResult = null;
        Boolean result = DataAccess.insertMedication(gName, bName, action, btFlag, dea, side_effects, interactions, warnings);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateMedication method, of class DataAccess.
     */
    @Test
    public void testUpdateMedication() throws Exception {
        System.out.println("updateMedication");
        int medID = 0;
        String gName = "";
        String bName = "";
        String action = "";
        int dea = 0;
        int btFlag = 0;
        String side_effects = "";
        String interactions = "";
        String warnings = "";
        Boolean expResult = null;
        Boolean result = DataAccess.updateMedication(medID, gName, bName, action, dea, btFlag, side_effects, interactions, warnings);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteMedication method, of class DataAccess.
     */
    @Test
    public void testDeleteMedication() throws Exception {
        System.out.println("deleteMedication");
        int medID = 0;
        Boolean expResult = null;
        Boolean result = DataAccess.deleteMedication(medID);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertCondition method, of class DataAccess.
     */
    @Test
    public void testInsertCondition() throws Exception {
        System.out.println("insertCondition");
        String condition = "";
        String description = "";
        Boolean expResult = null;
        Boolean result = DataAccess.insertCondition(condition, description);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCondition method, of class DataAccess.
     */
    @Test
    public void testUpdateCondition() throws Exception {
        System.out.println("updateCondition");
        int conID = 0;
        String condition = "";
        String description = "";
        Boolean expResult = null;
        Boolean result = DataAccess.updateCondition(conID, condition, description);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCondition method, of class DataAccess.
     */
    @Test
    public void testDeleteCondition() throws Exception {
        System.out.println("deleteCondition");
        int conID = 0;
        Boolean expResult = null;
        Boolean result = DataAccess.deleteCondition(conID);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertIntoMedConTable method, of class DataAccess.
     */
    @Test
    public void testInsertIntoMedConTable() throws Exception {
        System.out.println("insertIntoMedConTable");
        int conID = 0;
        Boolean expResult = null;
        Boolean result = DataAccess.insertIntoMedConTable(conID);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateMedConTable method, of class DataAccess.
     */
    @Test
    public void testUpdateMedConTable() throws Exception {
        System.out.println("updateMedConTable");
        int medID = 0;
        int conID = 0;
        Boolean expResult = null;
        Boolean result = DataAccess.updateMedConTable(medID, conID);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteFromMedConTable method, of class DataAccess.
     */
    @Test
    public void testDeleteFromMedConTable() throws Exception {
        System.out.println("deleteFromMedConTable");
        int medID = 0;
        Boolean expResult = null;
        Boolean result = DataAccess.deleteFromMedConTable(medID);
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

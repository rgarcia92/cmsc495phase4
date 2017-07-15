/*
 * Copyright (C) 2017 Joe Green at jgreen123 (GitHub)
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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joe Green
 */
public class DataAccessTest {

    /**
     * Test of selectAllMedications method, of class DataAccess.
     *
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    @Test
    public void testSelectAllMedications_0args() throws ClassNotFoundException, SQLException {

        ArrayList<Medications> medList = DataAccess.selectAllMedications();

//       Checking to see if not null return.
        ArrayList<Medications> expResult = null;
        assertNotEquals(expResult, medList);

//        Checking the count.
        int expectedCount = 400;
        assertEquals(expectedCount, medList.size());

//        Retrieves the first generic name from the ArrayList
        String expectedgName = "Abilify (B)";
        assertEquals(expectedgName, medList.get(0).gName);

//        Retrieves the first brand name from the ArrayList
        String expectedBName = "Aripiprazole (G)";
        assertEquals(expectedBName, medList.get(0).getBName());

//        Retrieves the first condition from the first medication on the ArrayList
        String expectedCond1 = "Autism";
        assertEquals(expectedCond1, medList.get(0).getCond1());

//        Retrieves the second condition from the first medication on the ArrayList
        String expectedCond2 = "Bipolar Disorder";
        assertEquals(expectedCond2, medList.get(0).getCond2());

//        Retrieves the third condition from the first medication on the ArrayList
        String expectedCond3 = "Schizophrenia";
        assertEquals(expectedCond3, medList.get(0).getCond3());

//        Retrieves the BTFlag from the first medication on the ArrayList
        int expectedBTFlag = 0;
        assertEquals(expectedBTFlag, medList.get(0).getBTFlag());

//        Retrieves the MedID from the first medication on the ArrayList
        int expectedMedID = 12;
        assertEquals(expectedMedID, medList.get(0).getMedID());
    }

    /**
     * Test of selectAllMedications method, of class DataAccess.
     *
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    @Test
    public void testSelectAllMedications_int() throws ClassNotFoundException, SQLException {

        int keypadLetterGroup;
        boolean results;
        Pattern pattern;
        Matcher matcher;

//        int 1 only returns a-c medications
        keypadLetterGroup = 1;
        ArrayList<Medications> medList = DataAccess.selectAllMedications(keypadLetterGroup);

        pattern = Pattern.compile("^[A-Ca-c]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }

            matcher = pattern.matcher(medicine.getBName());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 1 should not return d-z medications
        pattern = Pattern.compile("^[D-Zd-z]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 2 only returns d-f medications
        keypadLetterGroup = 2;
        medList = DataAccess.selectAllMedications(keypadLetterGroup);

        pattern = Pattern.compile("^[D-Fd-f]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }

            matcher = pattern.matcher(medicine.getBName());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 2 should not return generic and brand names outside of d-f
        pattern = Pattern.compile("^[A-Za-z&&[^D-Fd-f]]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 3 only returns g-i medications
        keypadLetterGroup = 3;
        medList = DataAccess.selectAllMedications(keypadLetterGroup);

        pattern = Pattern.compile("^[G-Ig-i]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }

            matcher = pattern.matcher(medicine.getBName());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 3 should not return generic and brand names outside of g-i
        pattern = Pattern.compile("^[A-Za-z&&[^G-Ig-i]]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 4 only returns j-l medications
        keypadLetterGroup = 4;
        medList = DataAccess.selectAllMedications(keypadLetterGroup);

        pattern = Pattern.compile("^[J-Lj-l]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }

            matcher = pattern.matcher(medicine.getBName());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 4 should not return generic and brand names outside of d-f
        pattern = Pattern.compile("^[A-Za-z&&[^J-Lj-l]]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 5 only returns m-o medications
        keypadLetterGroup = 5;
        medList = DataAccess.selectAllMedications(keypadLetterGroup);

        pattern = Pattern.compile("^[M-Om-o]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }

            matcher = pattern.matcher(medicine.getBName());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 5 should not return generic and brand names outside of m-o
        pattern = Pattern.compile("^[A-Za-z&&[^M-Om-o]]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            results = matcher.lookingAt();
            assertFalse(results);
        }

        //        int 6 only returns m-o medications
        keypadLetterGroup = 6;
        medList = DataAccess.selectAllMedications(keypadLetterGroup);

        pattern = Pattern.compile("^[P-Rp-r]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }

            matcher = pattern.matcher(medicine.getBName());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 6 should not return generic and brand names outside of p-r
        pattern = Pattern.compile("^[A-Za-z&&[^P-Rp-r]]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            results = matcher.lookingAt();
            assertFalse(results);
        }

        //        int 7 only returns s-u medications
        keypadLetterGroup = 7;
        medList = DataAccess.selectAllMedications(keypadLetterGroup);

        pattern = Pattern.compile("^[S-Us-u]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }

            matcher = pattern.matcher(medicine.getBName());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 7 should not return generic and brand names outside of s-u
        pattern = Pattern.compile("^[A-Za-z&&[^S-Us-u]]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 8 only returns v-x medications
        keypadLetterGroup = 8;
        medList = DataAccess.selectAllMedications(keypadLetterGroup);

        pattern = Pattern.compile("^[V-Xv-x]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }

            matcher = pattern.matcher(medicine.getBName());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 8 should not return generic and brand names outside of v-x
        pattern = Pattern.compile("^[A-Za-z&&[^V-Xv-x]]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 9 only returns v-x medications        
        keypadLetterGroup = 9;
        medList = DataAccess.selectAllMedications(keypadLetterGroup);

        pattern = Pattern.compile("^[Y-Zy-z]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }

            matcher = pattern.matcher(medicine.getBName());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 9 should not return generic and brand names outside of v-x
        pattern = Pattern.compile("^[A-Za-z&&[^Y-Zy-z]]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 10 only returns all medication
        keypadLetterGroup = 10;
        medList = DataAccess.selectAllMedications(keypadLetterGroup);

        pattern = Pattern.compile("^[A-Za-z]");
        for (Medications medicine : medList) {

            matcher = pattern.matcher(medicine.gName);
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }

            matcher = pattern.matcher(medicine.getBName());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }
    }

    /**
     * Test of selectMedicationsByGenericName method, of class DataAccess.
     *
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    @Test
    public void testSelectMedicationsByGenericName() throws ClassNotFoundException, SQLException {

        ArrayList<Medications> medList = DataAccess.selectMedicationsByGenericName();

//        Checking if not null
        ArrayList<Medications> expResult = null;
        assertNotEquals(expResult, medList);

        //        Checking the count.
        int expectedCount = 200;
        assertEquals(expectedCount, medList.size());

//        Retrieves the first generic name from the ArrayList
        String expectedgName = "Acyclovir (G)";
        assertEquals(expectedgName, medList.get(0).gName);

//        Retrieves the first brand name from the ArrayList
        String expectedBName = "Zovirax (B)";
        assertEquals(expectedBName, medList.get(0).getBName());

//        Retrieves the first condition from the first medication on the ArrayList
        String expectedCond1 = "Cold Sores";
        assertEquals(expectedCond1, medList.get(0).getCond1());

//        Retrieves the second condition from the first medication on the ArrayList
        String expectedCond2 = "Herpes";
        assertEquals(expectedCond2, medList.get(0).getCond2());

//        Retrieves the third condition from the first medication on the ArrayList
        String expectedCond3 = null;
        assertEquals(expectedCond3, medList.get(0).getCond3());

//        Retrieves the BTFlag from the first medication on the ArrayList
        int expectedBTFlag = 0;
        assertEquals(expectedBTFlag, medList.get(0).getBTFlag());

//        Retrieves the MedID from the first medication on the ArrayList
        int expectedMedID = 1;
        assertEquals(expectedMedID, medList.get(0).getMedID());
    }

    /**
     * Test of selectMedicationDetails method, of class DataAccess.
     */
    @Test
    public void testSelectMedicationDetails() throws Exception {
        int medID = 1;
        Medications medList = DataAccess.selectMedicationDetails(medID);

        assertNotNull(medList);

//        med id is returned
        assertEquals(medID, medList.getMedID());

//        generic name of medication object is returned
        String gName = "Acyclovir";
        assertEquals(gName, medList.getGName());

//        brand name of medication object is returned
        String bName = "Zovirax";
        assertEquals(bName, medList.getBName());

//        medication action object is returned
        String action = "Antiviral";
        assertEquals(action, medList.getAction());

//        first condition of medication object is returned
        String cond1 = "13,Cold Sores";
        assertEquals(cond1, medList.getCond1());

//        second conditon of medication object is returned
        String cond2 = "32,Herpes";
        assertEquals(cond2, medList.getCond2());

//        third condition of medication object is returned
        String cond3 = "0,null";
        assertEquals(cond3, medList.getCond3());

//        brand name of medication object is returned
        int dea = 0;
        assertEquals(dea, medList.getDEA());

//        blood thinner info returns
        int btFlag = 0;
        assertEquals(btFlag, medList.getBTFlag());

        String sideEffects = "Overdosage may result in agitation, coma, seizures, lethargy, "
                + "and/or elevated BUN/serum creatinine with subsequent renal failure. "
                + "Precipitation of acyclovir in renal tubules may occur. "
                + "Patient may benefit from hemodialysis until renal function is restored.";
        assertEquals(sideEffects, medList.getSide_Effects());

        String interactions = "Serious allergic reactions including angioedema and "
                + "anaphylaxis have occurred. Seizures, hallucinations, agitation, "
                + "confusion, coma, thrombocytopenia, hepatitis, renal failure, "
                + "Stevens-Johnson syndrome, toxic epidermal necrolysis have been "
                + "noted. Thrombotic thrombocytopenic purpura/hemolytic uremic "
                + "syndrome, resulting in death, has occurred in "
                + "immunocompromised patients.";
        assertEquals(interactions, medList.getInteractions());

        String warnings = "Contraindicated in patients with hypersensitivity to "
                + "acyclovir or valacyclovir. Dosage adjustment required for "
                + "impaired renal function. Maintain hydration. Mental status "
                + "changes are known to occur and may be marked, particularly "
                + "in older adults or in patients with renal impairment.";
        assertEquals(warnings, medList.getWarnings());
    }

    /**
     * Test of selectAllConditions method, of class DataAccess.
     */
    @Test
    public void testSelectAllConditions_0args() throws Exception {
        ArrayList<Conditions> condList = DataAccess.selectAllConditions();

//        Checking to make sure array is not nill
        assertNotNull(condList);

//        Retrieves the first condition
        String expectedCond = "ADHD";
        assertEquals(expectedCond, condList.get(0).condition);

//        Retrieves the first description
        String expectedDesc = "A disorder in which a person is unable to control "
                + "behavior due to difficulty in processing neural stimuli, "
                + "accompanied by an extremely high level of motor activity.";
        assertEquals(expectedDesc, condList.get(0).getDescription());
    }

    /**
     * Test of selectAllConditions method, of class DataAccess.
     */
    @Test
    public void testSelectAllConditions_int() throws Exception {
        int keypadLetterGroup;
        Pattern pattern;
        Matcher matcher;
        boolean results;

//        int 1 only returns a-c conditions
        keypadLetterGroup = 1;
        ArrayList<Conditions> condList = DataAccess.selectAllConditions(keypadLetterGroup);

        pattern = Pattern.compile("^[A-Ca-c]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 1 should not return d-z conditions
        pattern = Pattern.compile("^[D-Zd-z]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 2 only returns d-f conditions
        keypadLetterGroup = 2;
        condList = DataAccess.selectAllConditions(keypadLetterGroup);

        pattern = Pattern.compile("^[D-Fd-f]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 2 should not return d-z conditions
        pattern = Pattern.compile("^[A-Za-z&&[^D-Fd-f]]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 3 only returns g-i conditions
        keypadLetterGroup = 3;
        condList = DataAccess.selectAllConditions(keypadLetterGroup);

        pattern = Pattern.compile("^[G-Ig-i]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            if (matcher.lookingAt()) {
                results = matcher.lookingAt();
                assertTrue(results);
            }
        }

//        int 3 should not return conditions starting with g-i
        pattern = Pattern.compile("^[A-Za-z&&[^G-Ig-i]]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 4 only returns j-l conditions
        keypadLetterGroup = 4;
        condList = DataAccess.selectAllConditions(keypadLetterGroup);

        pattern = Pattern.compile("^[J-Lj-l]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertTrue(results);
        }

//        int 4 should not return conditions starting with d-f
        pattern = Pattern.compile("^[A-Za-z&&[^J-Lj-l]]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 5 only returns m-o conditions
        keypadLetterGroup = 5;
        condList = DataAccess.selectAllConditions(keypadLetterGroup);

        pattern = Pattern.compile("^[M-Om-o]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertTrue(results);
        }

//        int 5 should not return conditions starting with m-o
        pattern = Pattern.compile("^[A-Za-z&&[^M-Om-o]]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertFalse(results);
        }

        //        int 6 only returns m-o conditions
        keypadLetterGroup = 6;
        condList = DataAccess.selectAllConditions(keypadLetterGroup);

        pattern = Pattern.compile("^[P-Rp-r]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertTrue(results);
        }

//        int 6 should not return conditions starting with p-r
        pattern = Pattern.compile("^[A-Za-z&&[^P-Rp-r]]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertFalse(results);
        }

        //        int 7 only returns s-u conditions
        keypadLetterGroup = 7;
        condList = DataAccess.selectAllConditions(keypadLetterGroup);

        pattern = Pattern.compile("^[S-Us-u]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertTrue(results);
        }

//        int 7 should not return conditions starting with s-u
        pattern = Pattern.compile("^[A-Za-z&&[^S-Us-u]]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 8 only returns v-x conditions
        keypadLetterGroup = 8;
        condList = DataAccess.selectAllConditions(keypadLetterGroup);

        pattern = Pattern.compile("^[V-Xv-x]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 8 should not return conditions starting with v-x
        pattern = Pattern.compile("^[A-Za-z&&[^V-Xv-x]]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 9 only returns v-x conditions      
        keypadLetterGroup = 9;
        condList = DataAccess.selectAllConditions(keypadLetterGroup);

        pattern = Pattern.compile("^[Y-Zy-z]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 9 should not return conditions starting with v-x
        pattern = Pattern.compile("^[A-Za-z&&[^Y-Zy-z]]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertFalse(results);
        }

//        int 10 only returns all conditions
        keypadLetterGroup = 10;
        condList = DataAccess.selectAllConditions(keypadLetterGroup);

        pattern = Pattern.compile("^[A-Za-z]");
        for (Conditions condition : condList) {

            matcher = pattern.matcher(condition.getCondition());
            results = matcher.lookingAt();
            assertTrue(results);
        }
    }

    /**
     * Test of selectConditionDetails method, of class DataAccess.
     */
    @Test
    public void testSelectConditionDetails() throws Exception {
        int conID = 1;
        Conditions condList = DataAccess.selectConditionDetails(conID);
        
        String conditionResult = "Addiction";
        assertEquals(conditionResult, condList.getCondition());
        
        String descResult = "Compulsive physiological need for and use of a "
                + "habit-forming substance (i.e. heroin, nicotine, or alcohol) "
                + "characterized by tolerance and by well-defined physiological "
                + "symptoms upon withdrawal.";
        assertEquals(descResult, condList.getDescription());
    }

    /**
     * Test of selectMedicationsInCondition method, of class DataAccess.
     */
    @Test
    public void testSelectMedicationsInCondition() throws Exception {
        int conID = 1;
        ArrayList<Medications> medList = DataAccess.selectMedicationsInCondition(conID);
        
        String gNameResult = "Methadone";
        assertEquals(gNameResult, medList.get(conID).gName);
        
        String bNameResult = "Dolophine";
        assertEquals(bNameResult, medList.get(conID).getBName());
    }

    /**
     * Test of selectAllUsers method, of class DataAccess.
     */
    @Test
    public void testSelectAllUsers() throws Exception {
        System.out.println("selectAllUsers");
        ArrayList<Users> expResult = null;
        ArrayList<Users> condList = DataAccess.selectAllUsers();
        assertEquals(expResult, condList.get(5).userName);
    }
//
//    /**
//     * Test of insertUser method, of class DataAccess.
//     */
//    @Test
//    public void testInsertUser() throws Exception {
//        System.out.println("insertUser");
//        String userName = "";
//        int roleID = 0;
//        Boolean expResult = null;
//        Boolean condList = DataAccess.insertUser(userName, roleID);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateUserRole method, of class DataAccess.
//     */
//    @Test
//    public void testUpdateUserRole() throws Exception {
//        System.out.println("updateUserRole");
//        int userID = 0;
//        String role = "";
//        Boolean expResult = null;
//        Boolean condList = DataAccess.updateUserRole(userID, role);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteUser method, of class DataAccess.
//     */
//    @Test
//    public void testDeleteUser() throws Exception {
//        System.out.println("deleteUser");
//        int userID = 0;
//        Boolean expResult = null;
//        Boolean condList = DataAccess.deleteUser(userID);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of selectAllRoles method, of class DataAccess.
//     */
//    @Test
//    public void testSelectAllRoles() throws Exception {
//        System.out.println("selectAllRoles");
//        ArrayList<Roles> expResult = null;
//        ArrayList<Roles> condList = DataAccess.selectAllRoles();
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of insertMedication method, of class DataAccess.
//     */
//    @Test
//    public void testInsertMedication() throws Exception {
//        System.out.println("insertMedication");
//        String gName = "";
//        String bName = "";
//        String action = "";
//        int btFlag = 0;
//        int dea = 0;
//        String side_effects = "";
//        String interactions = "";
//        String warnings = "";
//        Boolean expResult = null;
//        Boolean condList = DataAccess.insertMedication(gName, bName, action, btFlag, dea, side_effects, interactions, warnings);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateMedication method, of class DataAccess.
//     */
//    @Test
//    public void testUpdateMedication() throws Exception {
//        System.out.println("updateMedication");
//        int medID = 0;
//        String gName = "";
//        String bName = "";
//        String action = "";
//        int dea = 0;
//        int btFlag = 0;
//        String side_effects = "";
//        String interactions = "";
//        String warnings = "";
//        Boolean expResult = null;
//        Boolean condList = DataAccess.updateMedication(medID, gName, bName, action, dea, btFlag, side_effects, interactions, warnings);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteMedication method, of class DataAccess.
//     */
//    @Test
//    public void testDeleteMedication() throws Exception {
//        System.out.println("deleteMedication");
//        int medID = 0;
//        Boolean expResult = null;
//        Boolean condList = DataAccess.deleteMedication(medID);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of insertCondition method, of class DataAccess.
//     */
//    @Test
//    public void testInsertCondition() throws Exception {
//        System.out.println("insertCondition");
//        String condition = "";
//        String description = "";
//        Boolean expResult = null;
//        Boolean condList = DataAccess.insertCondition(condition, description);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateCondition method, of class DataAccess.
//     */
//    @Test
//    public void testUpdateCondition() throws Exception {
//        System.out.println("updateCondition");
//        int conID = 0;
//        String condition = "";
//        String description = "";
//        Boolean expResult = null;
//        Boolean condList = DataAccess.updateCondition(conID, condition, description);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteCondition method, of class DataAccess.
//     */
//    @Test
//    public void testDeleteCondition() throws Exception {
//        System.out.println("deleteCondition");
//        int conID = 0;
//        Boolean expResult = null;
//        Boolean condList = DataAccess.deleteCondition(conID);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of insertIntoMedConTable method, of class DataAccess.
//     */
//    @Test
//    public void testInsertIntoMedConTable() throws Exception {
//        System.out.println("insertIntoMedConTable");
//        int conID = 0;
//        Boolean expResult = null;
//        Boolean condList = DataAccess.insertIntoMedConTable(conID);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateMedConTable method, of class DataAccess.
//     */
//    @Test
//    public void testUpdateMedConTable() throws Exception {
//        System.out.println("updateMedConTable");
//        int medID = 0;
//        int conID = 0;
//        Boolean expResult = null;
//        Boolean condList = DataAccess.updateMedConTable(medID, conID);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteFromMedConTable method, of class DataAccess.
//     */
//    @Test
//    public void testDeleteFromMedConTable() throws Exception {
//        System.out.println("deleteFromMedConTable");
//        int medID = 0;
//        Boolean expResult = null;
//        Boolean condList = DataAccess.deleteFromMedConTable(medID);
//        assertEquals(expResult, condList);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}

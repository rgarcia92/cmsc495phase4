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
}

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
public final class RolesTest {
    
    public RolesTest() {
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
     * Test of getRoleID method, of class Roles.
     */
    @Test
    public void testGetRoleID() {
        System.out.println("getRoleID");
        Roles instance = new Roles();
        int expResult = 0;
        int result = instance.getRoleID();
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRole method, of class Roles.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Roles instance = new Roles();
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Roles.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Roles instance = new Roles();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoleID method, of class Roles.
     */
    @Test
    public void testSetRoleID() {
        System.out.println("setRoleID");
        int roleID = 0;
        Roles instance = new Roles();
        instance.setRoleID(roleID);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRole method, of class Roles.
     */
    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        Roles instance = new Roles();
        instance.setRole(role);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Roles.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Roles instance = new Roles();
        instance.setDescription(description);
        // Review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

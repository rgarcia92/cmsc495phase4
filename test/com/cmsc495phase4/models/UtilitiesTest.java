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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joe Green
 */
public class UtilitiesTest {

    /**
     * Test of getPattern method, of class Utilities.
     */
    @Test
    public void testGetPattern() {
        int keypadLetterGroup;

        keypadLetterGroup = 0;
        String patternResult = Utilities.getPattern(keypadLetterGroup);

        String expResult = "^[A-Za-z]";
        assertEquals(expResult, patternResult);

        keypadLetterGroup = 1;
        patternResult = Utilities.getPattern(keypadLetterGroup);

        expResult = "^[A-Ca-c]";
        assertEquals(expResult, patternResult);

        keypadLetterGroup = 2;
        patternResult = Utilities.getPattern(keypadLetterGroup);
        expResult = "^[D-Fd-f]";
        assertEquals(expResult, patternResult);

        keypadLetterGroup = 3;
        patternResult = Utilities.getPattern(keypadLetterGroup);
        expResult = "^[G-Ig-i]";
        assertEquals(expResult, patternResult);

        keypadLetterGroup = 4;
        patternResult = Utilities.getPattern(keypadLetterGroup);
        expResult = "^[J-Lj-l]";
        assertEquals(expResult, patternResult);

        keypadLetterGroup = 5;
        patternResult = Utilities.getPattern(keypadLetterGroup);
        expResult = "^[M-Om-o]";
        assertEquals(expResult, patternResult);

        keypadLetterGroup = 6;
        patternResult = Utilities.getPattern(keypadLetterGroup);
        expResult = "^[P-Rp-r]";
        assertEquals(expResult, patternResult);

        keypadLetterGroup = 7;
        patternResult = Utilities.getPattern(keypadLetterGroup);
        expResult = "^[S-Us-u]";
        assertEquals(expResult, patternResult);

        keypadLetterGroup = 8;
        patternResult = Utilities.getPattern(keypadLetterGroup);
        expResult = "^[V-Xv-x]";
        assertEquals(expResult, patternResult);

        keypadLetterGroup = 9;
        patternResult = Utilities.getPattern(keypadLetterGroup);
        expResult = "^[Y-Zy-z]";
        assertEquals(expResult, patternResult);
    }
}

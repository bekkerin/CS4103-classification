/*
 * ClassesTest - ep
 */
package eost;

import static org.testng.Assert.*;
import org.testng.annotations.*;

import eost.Classes;
import eost.Classes.Classification;
import eost.Classes.Classification;
import static eost.Classes.Classification.*;

public class ClassesTest {

   // EP test data followed by BVA test data and then by DT test data and then by the BC test data
   private static Object[][] testData1 = new Object[][] {
      //  test,         credits,     graduated,     expected
        { "TEP1",         20,         true,       Classification.ERROR },
        { "TEP2",         50,         false,       Classification.SOPHOMORE },
        { "TEP3",         70,         false,       Classification.JUNIOR },
        { "TEP4",         100,         false,       Classification.SENIOR },
        { "TEP5",         130,         false,       Classification.SENIOR },
        { "TEP6*",         -10,         false,       Classification.ERROR },

        { "TBV1",         0,         true,       Classification.ERROR },
        { "TBV2",         29,         false,       Classification.FRESHMAN },
        { "TBV3",         30,         false,       Classification.SOPHOMORE },
        { "TBV4",         59,         false,       Classification.SOPHOMORE },
        { "TBV5",         60,         false,       Classification.JUNIOR },
        { "TBV6",         89,         false,       Classification.JUNIOR },
        { "TBV7",         90,         false,       Classification.SENIOR },
        { "TBV8",         Long.MAX_VALUE,         false,       Classification.SENIOR },
        { "TBV9*",         Long.MIN_VALUE,         false,       Classification.ERROR },
        { "TBV10*",        -1,         false,       Classification.ERROR },

        { "TDT1",         20,         false,       Classification.FRESHMAN },
        { "TDT2",         50,         true,       Classification.ERROR },
        { "TDT3",         70,         true,       Classification.ERROR },
        { "TDT4",         100,         true,       Classification.ERROR },


   };

    // Method to return the EP test data
    @DataProvider(name="dataset1")
    public Object[][] getTestData() {
       return testData1;
    }

    // Method to execute the EP tests
    @Test(dataProvider="dataset1")
    public void test_classify( String id, long credits, boolean graduated, Classification expected)
    {
       assertEquals( Classes.classify( credits, graduated ), expected );
    }

}




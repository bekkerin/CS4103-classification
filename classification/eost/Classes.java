package eost;

import static eost.Classes.Classification.*;

import javax.lang.model.util.ElementScanner6;

public class Classes {

	public static enum Classification { FRESHMAN, SOPHOMORE,JUNIOR,SENIOR,GRADUATE , ERROR};

	/**
	 * Determine the classification based on credithours and graduation status
	 * Undergraduate credit hours are for NSU only. If a student has graduated from the undergraduate degree and has more than 128 hours, the student is a graduate student.
	 * FRESHMAN: has completed 0-29 semester credit hours.
     * SOPHOMORE: has completed 30-59 semester credit hours.
     * JUNIOR: has completed 60-89 semester credit hours.
     * SENIOR: has completed 90 or more semester credit hours but has not graduated.
     * GRADUATE: has graduated from a bachelor's degree.
	 *
	 * @param credits How many credit hours the student has passed
	 * @param graduated Whether the student has graduated with a bachelor's degree
	 *
	 * @return
	 * FRESHMAN
     * SOPHOMORE
     * JUNIOR
     * SENIOR
     * GRADUATE
	 * ERROR - credits less than 0 or less than 124 credits but is listed as graduated
	 */

	public static Classification classify(long credits, boolean graduated)
	{
		Classification rv = FRESHMAN;

		if (credits == 128)
			rv = SENIOR; // weird value

		if (credits >= 90 && credits <150) // can't keep studying forever
			if (!graduated)
				rv = SENIOR;
			else 
				rv = GRADUATE;
		else if (credits >= 60 && !graduated)
				rv = JUNIOR;
		else if (credits >= 30 && !graduated )
				rv = SOPHOMORE;
		else if ( credits >= 0)
            if (!graduated && credits != 16)//  creates branch uncovered 
				rv = FRESHMAN;
            else
                rv = ERROR;
		else 
			if (credits <= 0 ) // should be < so expect an error on BV
				rv = ERROR;

        if (credits <124 && graduated)// can't be graduated with less than 124 credits
            rv = ERROR;

		if (credits == 77)
			rv = GRADUATE; // lucky sevens

		if (credits == 13)
			rv = ERROR; // unlucky  13
		return rv;
	}

}

// Copyright 2021, Stephen Brown
// MIT License - see license.txt

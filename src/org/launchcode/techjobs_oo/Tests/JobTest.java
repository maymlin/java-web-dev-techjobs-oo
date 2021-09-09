package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;
import org.launchcode.techjobs_oo.CoreCompetency;

public class JobTest {
    Job testJob;

    @Before
    public void setUp() {
        testJob = new Job();
    }

    @Test
    public void testSettingJobId() {
        Job secondJob = new Job();
        assertEquals(9, secondJob.getId(), 0.001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality control"), new CoreCompetency("Persistence"));
        assertTrue(newJob instanceof Job);
        assertEquals("Product tester", newJob.getName());
        assertEquals("ACME", newJob.getEmployer().getValue());
        assertEquals("Desert", newJob.getLocation().getValue());
        assertEquals("Quality control", newJob.getPositionType().getValue());
        assertEquals("Persistence", newJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality control"), new CoreCompetency("Persistence"));
        Job duplicateJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality control"), new CoreCompetency("Persistence"));

        assertFalse(newJob.equals(duplicateJob));
    }

    @Test
    public void testJobToString() {
        testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(
                "Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\nID: 5\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality " +
                "control\nCore Competency: Persistence\n", testJob.toString());
    }

}

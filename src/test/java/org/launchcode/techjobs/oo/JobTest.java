package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId(){
        Job j1 = new Job();
        Job j2 = new Job();
        assertNotEquals(j1.getId(), j2.getId(),.001);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(job.getName(), "Product tester");
        assertEquals(job.getEmployer().getValue(), "ACME");
        assertEquals(job.getLocation().getValue(), "Desert");
        assertEquals(job.getPositionType().getValue(), "Quality control");
        assertEquals(job.getCoreCompetency().getValue(), "Persistence");

    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertEquals(job1.equals(job2), false);
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        String result = job.toString();
        assertEquals(String.valueOf(result.charAt(result.length() - 1)), System.lineSeparator());
        assertEquals(String.valueOf(result.charAt(0)), System.lineSeparator());
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertEquals(job.toString(),System.lineSeparator() + "ID: " + job.getId() + System.lineSeparator() +
                "Name: " + job.getName() +  System.lineSeparator() +
                "Employer: " + job.getEmployer().getValue() + System.lineSeparator() +
                "Location: "+ job.getLocation().getValue() + System.lineSeparator() +
                "Position Type: " + job.getPositionType().getValue() + System.lineSeparator() +
                "Core Competency: " + job.getCoreCompetency().getValue() + System.lineSeparator());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("", new Employer(""),
                new Location(""), new PositionType(""),
                new CoreCompetency(""));

        assertEquals(job.toString(),System.lineSeparator() + "ID: " + job.getId() + System.lineSeparator() +
                "Name: " + "Data not available" +  System.lineSeparator() +
                "Employer: " + "Data not available" + System.lineSeparator() +
                "Location: "+ "Data not available" + System.lineSeparator() +
                "Position Type: " + "Data not available" + System.lineSeparator() +
                "Core Competency: " + "Data not available" + System.lineSeparator());
    }
}

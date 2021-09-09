package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    // Lin 9/8/2021
    public Job() {
        this.id = nextId;
        nextId++;
    }

    // Lin 9/8/2021
    public Job(String name, Employer employer, Location location, PositionType positionType,
               CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // Lin 9/8/2021
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    // Lin 9/8/2021
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    // Lin 9/8/2021
    public int getId() {
        return id;
    }

    // Lin 9/8/2021
    public String getName() {
        return name;
    }

    // Lin 9/8/2021
    public void setName(String name) {
        this.name = name;
    }

    // Lin 9/8/2021
    public Employer getEmployer() {
        return employer;
    }

    // Lin 9/8/2021
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    // Lin 9/8/2021
    public Location getLocation() {
        return location;
    }

    // Lin 9/8/2021
    public void setLocation(Location location) {
        this.location = location;
    }

    // Lin 9/8/2021
    public PositionType getPositionType() {
        return positionType;
    }

    // Lin 9/8/2021
    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    // Lin 9/8/2021
    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    // Lin 9/8/2021
    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    // Lin 9/8/2021

    @Override
    public String toString() {
        String emptyField = "Data not available";
        String idOnly = "This job does not seem to exist.";

        if (!checkNotEmpty(this.getName()) && !checkNotEmpty(this.getEmployer().getValue())
        && !checkNotEmpty(this.getLocation().getValue()) && !checkNotEmpty(this.getPositionType().getValue())
        && !checkNotEmpty(this.getCoreCompetency().getValue())) {
            return idOnly;
        } else {
            return "\nID: " + this.getId() +
                    "\nName: " + (checkNotEmpty(this.getName()) ? this.getName() : emptyField) +
                    "\nEmployer: " +
                    (checkNotEmpty(this.getEmployer().getValue()) ? this.getEmployer().getValue() : emptyField) +
                    "\nLocation: " +
                    (checkNotEmpty(this.getLocation().getValue()) ? this.getLocation().getValue() : emptyField) +
                    "\nPosition Type: " +
                    (checkNotEmpty(this.getPositionType().getValue()) ? this.getPositionType().getValue() :
                            emptyField) +
                    "\nCore Competency: " +
                            (checkNotEmpty(this.getCoreCompetency().getValue()) ?
                                    this.getCoreCompetency().getValue() : emptyField) + "\n";
        }
    }

    private boolean checkNotEmpty(String field) {
        return field.length() != 0;
    }
}

package devo.melodia.icare;

import java.util.UUID;

public class UsersData {

    public String username, ageRange, eyeDefect, geneticEyeDefect;

    public UsersData() {
    }

    public UsersData( String username, String ageRange, String eyeDefect, String geneticEyeDefect) {
        this.username = username;
        this.ageRange = ageRange;
        this.eyeDefect = eyeDefect;
        this.geneticEyeDefect = geneticEyeDefect;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public String getEyeDefect() {
        return eyeDefect;
    }

    public void setEyeDefect(String eyeDefect) {
        this.eyeDefect = eyeDefect;
    }

    public String getGeneticEyeDefect() {
        return geneticEyeDefect;
    }

    public void setGeneticEyeDefect(String geneticEyeDefect) {
        this.geneticEyeDefect = geneticEyeDefect;
    }
}

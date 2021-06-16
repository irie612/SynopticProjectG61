package org.synoptic;

import java.util.HashMap;
import java.time.LocalTime;

/**
 * DirectoryEntry class for storing various locations
 *
 * @author Harry Whitelam, Darcey Gardiner
 */
public class DirectoryEntry {
    /**
     * Enum to specify the type of location
     *
     * @author Harry Whitelam
     * @see java.lang.Enum
     */
    public enum Type {
        SHOP,
        RESTAURANT,
    }

    private String name;
    private String address;
    private String phoneNumber;
    private String description;
    private HashMap<Integer, LocalTime[]> openingHours;
    private DirectoryEntry.Type type;
    private String announcement;

    /**
     * Default constructor for DirectoryEntry
     *
     * @author Harry Whitelam
     */
    public DirectoryEntry() {
        this.type = null;
    }

    /**
     * Parameterised constructor for DirectoryEntry, used for shops, restaurants or attractions
     *
     * @param typeVar parameter to specify the type
     * @param phoneNumberVar parameter to specify phone number
     * @param nameVar parameter to specify name
     * @param addressVar parameter to specify address
     * @param descriptionVar parameter to specify description
     * @param openingHoursVar parameter to specify opening hours
     * @param announcementVar parameter to specify announcement
     * @author Harry Whitelam, Darcey Gardiner
     */
    public DirectoryEntry(DirectoryEntry.Type typeVar, String phoneNumberVar, String nameVar, String addressVar, String descriptionVar, HashMap<Integer, LocalTime[]> openingHoursVar, String announcementVar) {
        this.type = typeVar;
        this.name = nameVar;
        this.phoneNumber = phoneNumberVar;
        this.address = addressVar;
        this.description = descriptionVar;
        this.openingHours = openingHoursVar;
        this.announcement = announcementVar;
    }

    /**
     * Getters for all attributes of the DirectoryEntry class
     *
     * @return the requested attribute
     * @author Harry Whitelam, Darcey Gardiner
     */
    public String getName() {
        return this.name;
    }
    public String getAddress() {
        return this.address;
    }
    public String getDescription() {
        return this.description;
    }
    public HashMap<Integer, LocalTime[]> getOpeningHours() {
        return this.openingHours;
    }
    public String getAnnouncement() {
        return this.announcement;
    }
    public DirectoryEntry.Type getType() {
        return this.type;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setters for all attributes of the DirectoryEntry class
     *
     * @author Harry Whitelam, Darcey Gardiner
     */
    public void setName(String nameVar) {
        this.name = nameVar;
    }
    public void setAddress(String addressVar) {
        this.address = addressVar;
    }
    public void setDescription(String descriptionVar) {
        this.description = descriptionVar;
    }
    public void setOpeningHours(HashMap<Integer, LocalTime[]> openingHoursVar) {
        this.openingHours = openingHoursVar;
    }
    public void setAnnouncement(String announcementVar) {
        this.announcement = announcementVar;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setType(DirectoryEntry.Type type) {
        this.type = type;
    }

    /**
     * Method to print the opening hours hashmap as a legible string
     *
     * @return string of the opening hours in a readable format
     * @author Harry Whitelam
     */
    public String printOpeningHours() {
        StringBuilder hoursString = new StringBuilder();
        for (int i : this.openingHours.keySet()) {
            switch(i) {
                case(1):
                    hoursString.append("Monday: ");
                    break;
                case(2):
                    hoursString.append("Tuesday: ");
                    break;
                case(3):
                    hoursString.append("Wednesday: ");
                    break;
                case(4):
                    hoursString.append("Thursday: ");
                    break;
                case(5):
                    hoursString.append("Friday: ");
                    break;
                case(6):
                    hoursString.append("Saturday: ");
                    break;
                case(7):
                    hoursString.append("Sunday: ");
                    break;
            }
            LocalTime[] hours = openingHours.get(i);
            hoursString.append(hours[0]).append(" - ").append(hours[1]).append("\n");
        }
        return hoursString.toString();
    }

    /**
     * Method override of toString, adapted for the DirectoryEntry class
     *
     * @return string of all DirectoryEntry attributes
     * @author Harry Whitelam, Darcey Gardiner
     */
    @Override
    public String toString() {
        return "DirectoryEntry{" +
            "name='" + name + '\'' +
            ", address='" + address + '\'' +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", description='" + description + '\'' +
            ", openingHours=" + openingHours +
            ", type=" + type + '\'' +
            ", announcement=" + announcement +
            '}';
    }
}

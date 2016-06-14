package ch.ethz.coss.nervousnet.vm.storage;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END
/**
 * Entity mapped to table "AUTHENTICATION".
 */
public class Authentication {

    private String AppName;
    private Byte Authorized;
    private String AccessRights;
    private Long LastVerifiedTime;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public Authentication() {
    }

    public Authentication(String AppName, Byte Authorized, String AccessRights, Long LastVerifiedTime) {
        this.AppName = AppName;
        this.Authorized = Authorized;
        this.AccessRights = AccessRights;
        this.LastVerifiedTime = LastVerifiedTime;
    }

    public String getAppName() {
        return AppName;
    }

    public void setAppName(String AppName) {
        this.AppName = AppName;
    }

    public Byte getAuthorized() {
        return Authorized;
    }

    public void setAuthorized(Byte Authorized) {
        this.Authorized = Authorized;
    }

    public String getAccessRights() {
        return AccessRights;
    }

    public void setAccessRights(String AccessRights) {
        this.AccessRights = AccessRights;
    }

    public Long getLastVerifiedTime() {
        return LastVerifiedTime;
    }

    public void setLastVerifiedTime(Long LastVerifiedTime) {
        this.LastVerifiedTime = LastVerifiedTime;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
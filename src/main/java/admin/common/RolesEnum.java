package admin.common;

public enum RolesEnum {

    ADMIN("admin"),

    AGENT_LEVEL("agent"),

    USER("user");

    private final String role;

    public String getRole() {
        return role;
    }

    RolesEnum(String role) {
        this.role = role;
    }
}

class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? "" : firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName == null ? "" : lastName;
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        if (!this.firstName.isEmpty()) {
            sb.append(this.firstName);

            if (!this.lastName.isEmpty()) {
                sb.append(' ');
            }
        }
        if (!this.lastName.isEmpty()) {
            sb.append(this.lastName);
        }

        final String fullName = sb.toString();

        if (fullName.isEmpty()) {
            return "Unknown";
        }

        return fullName;
    }
}
public class FullName {
    String lastName;
    String firstName;
    String patronymic;

    public FullName(String lastName, String firstName, String patronymic) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        String result = null;

        if (lastName != null) {
            result = lastName;
        }
        if (firstName != null) {
            result = result == null ? firstName : result + " " + firstName;
        }
        if (patronymic != null) {
            result = result == null ? patronymic : result + " " + patronymic;
        }

        return result == null ? "" : result;
    }
}

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
        String result = "";

        if (lastName != null) {
            result = result + lastName;
        }
        if (firstName != null) {
            if (result.length() > 0) {
                result = result + " ";
            }
            result = result + firstName;
        }
        if (patronymic != null) {
            if (result.length() > 0) {
                result = result + " ";
            }
            result = result + patronymic;
        }

        return result;
    }
}
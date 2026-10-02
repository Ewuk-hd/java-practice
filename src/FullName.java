public class FullName {
    private final String lastName;
    private final String firstName;
    private final String patronymic;

    public FullName(String lastName, String firstName, String patronymic) {
        if ( isNullOrEmpty(firstName) && isNullOrEmpty(lastName) && isNullOrEmpty(patronymic)) {
            throw new IllegalArgumentException("Хотя бы одна часть имени должна быть заполнена");
        }
        this.lastName = isNullOrEmpty(lastName) ? null : lastName;          //пустую строку храним как null,
        this.firstName = isNullOrEmpty(firstName) ? null : firstName;       //чтобы toString её пропускал
        this.patronymic = isNullOrEmpty(patronymic) ? null : patronymic;
    }

    public FullName(String firstName) {
        this(null, firstName, null);
    }

    public FullName(String firstName, String lastName) {
        this(lastName, firstName, null);
    }

    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
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

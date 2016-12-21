A Better Builder Pattern
===============================

The Builder pattern came up during a recent PR while looking at the standard Getter/Setter POJO
pattern. I usually avoided the classic Builder pattern based on the necessity to duplicate the
member variables in the static inner Builder class.

After some Googling and discussion we decided to use a slightly different Builder pattern. In
this version the base object is instantiated in the Builder constructor and simply returned
(and discarded) from the `build()` function. This pattern allows for efficiently creating an
immutable object while eliminating one of my pet peeves of duplicate code!

The only downside I see is that the Builder must maintain state in a member variable. Fortunately
this is not an issue given the typical short-lived usage of the Builder pattern.

Here&apos;s an implementation where the Builder pattern is encapsulated in a BaseBuilder class.

**BaseBuilder.java**
```java
public abstract class BaseBuilder<T> {
    protected T data;

    /**
     * Constructor that allows for data object in creating using parameters passed into
     * the base class constructor
     * @param data
     */
    public BaseBuilder(T data) {
        this.data = data;
    }

    /**
     * Pass back the created object and prevent class from modifying it further
     * @return
     */
    public T build() {
        T value = data;
        // discard built user object
        data = null;
        return value;
    }
}
```

**User.java**
```java
public class User {
    private final String firstName;
    private final String lastName;

    private String state;
    private String country;

    private User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public static class Builder extends BaseBuilder<User> {

        public Builder(final String firstName, final String lastName) {
            super(new User(firstName, lastName));
        }

        public Builder state(String state) {
            this.data.state = state;
            return this;
        }

        public Builder country(String country) {
            this.data.country = country;
            return this;
        }
    }
}
```

**MainApplication.java**
```java
public class MainApplication {
    public static void main(String[] args) {
        User user = new User.Builder("Justin", "Riffhard")
                .state("CA")
                .country("USA")
                .build();

        Log.d(user.getState());
        Log.d(user.getCountry());
    }
}
```
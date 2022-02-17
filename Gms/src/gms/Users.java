package gms;

/**
 *
 * @author Asunet
 */
public abstract class Users {

    String email;
    String password;

    public Users(String email, String password) {

        this.email = email;
        this.password = password;
    }

    public abstract int add();

    public abstract void edit();

    public abstract void delete();

    public abstract void view_members_in_specific_class();

    public abstract void view_membership_type();

    public abstract void view_all_members();
}

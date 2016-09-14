package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Registration extends Model {

	public static Finder<Long, Registration> find = new Finder(Long.class, Registration.class);

	@Id
	public Long id;

	@Required
	private String firstName;

	@Required
	public String lastName;

	@Required
	public String email;

	@Required
	public String phone;

	public static List<Registration> all() {
		return find.all();
	}

	public static void save(Registration registration) {
		if (registration.id != null) {
			registration.update();
		} else {
			registration.save();
		}
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}

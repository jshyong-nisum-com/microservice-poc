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
	public String firstName;

	@Required
	public String lastName;

	@Required
	public String email;

	@Required
	public String phone;

	public static List<Registration> all() {
		return find.all();
	}

	public static void create(Registration registration) {
		registration.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

}

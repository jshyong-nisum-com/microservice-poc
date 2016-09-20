package models.com.nisum.poc.play;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Registration extends Model {

	public static Finder<Long, Registration> find = new Finder(Long.class, Registration.class);

	@Id
	private Long id;

	@Required
	private String firstName;

	@Required
	private String lastName;

	@Required
	private String email;

	@Required
	private String phone;

	public static List<Registration> all() {
		return find.all();
	}

	public static Registration byId(Long id) {
		return find.byId(id);
	}

	public static void save(Registration registration) {
		if (registration.getId() != null) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}

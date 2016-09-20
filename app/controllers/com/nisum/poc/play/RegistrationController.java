package controllers.com.nisum.poc.play;

import java.util.List;
import java.util.Map;

import models.com.nisum.poc.play.Registration;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class RegistrationController extends Controller {

	static Form<Registration> registrationForm = Form.form(Registration.class);

	public static Result index() {
		return redirect(routes.RegistrationController.registrations());
	}

	public static Result registrations() {
		List<Registration> registrations = Registration.all();
		return ok(index.render(registrations, registrationForm));
	}

	public static Result updateRegistration(Long id) {
		List<Registration> registrations = Registration.all();
		Registration registration = getRegistrationById(registrations, id);

		Form<Registration> editForm = registrationForm.bindFromRequest();
		editForm = editForm.fill(registration);
		
		Map<String, String> data = editForm.data();
		data.put("id", String.valueOf(registration.getId()));
		return ok(index.render(registrations, editForm));
	}

	public static Result saveRegistration() {
		Form<Registration> filledForm = registrationForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(index.render(Registration.all(), filledForm));
		}

		Registration registration = filledForm.get();
		Registration.save(registration);
		return redirect(routes.RegistrationController.registrations());
	}

	public static Result deleteRegistration(Long id) {
		Registration.delete(id);
		return redirect(routes.RegistrationController.registrations());
	}

	private static Registration getRegistrationById(List<Registration> registrations, Long id) {
		if (!registrations.isEmpty()) {
			for (Registration registration : registrations) {
				if (registration.getId() == id) {
					return registration;
				}
			}
		}
		return null;
	}
}

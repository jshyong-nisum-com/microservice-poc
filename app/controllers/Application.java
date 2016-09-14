package controllers;

import java.util.List;
import java.util.Map;

import models.Registration;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	static Form<Registration> registrationForm = Form.form(Registration.class);

	public static Result index() {
		return redirect(routes.Application.registrations());
	}

	public static Result registrations() {
		List<Registration> registrations = Registration.all();
		return ok(views.html.index.render(registrations, registrationForm));
	}

	public static Result updateRegistration(Long id) {
		List<Registration> registrations = Registration.all();
		Registration registration = getRegistrationById(registrations, id);

		Form<Registration> editForm = registrationForm.bindFromRequest();
		editForm = editForm.fill(registration);
		
		Map<String, String> data = editForm.data();
		data.put("id", String.valueOf(registration.id));
		return ok(views.html.index.render(registrations, editForm));
	}

	public static Result saveRegistration() {
		Form<Registration> filledForm = registrationForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Registration.all(), filledForm));
		}

		Registration registration = filledForm.get();
		Registration.save(registration);
		return redirect(routes.Application.registrations());
	}

	public static Result deleteRegistration(Long id) {
		Registration.delete(id);
		return redirect(routes.Application.registrations());
	}

	private static Registration getRegistrationById(List<Registration> registrations, Long id) {
		if (!registrations.isEmpty()) {
			for (Registration registration : registrations) {
				if (registration.id == id) {
					return registration;
				}
			}
		}
		return null;
	}
}

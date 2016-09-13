package controllers;

import java.util.List;

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

	public static Result newRegistration() {
		Form<Registration> filledForm = registrationForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Registration.all(), filledForm));
		} else {
			Registration.create(filledForm.get());
			return redirect(routes.Application.registrations());
		}
	}

	public static Result deleteRegistration(Long id) {
		// return TODO;
		Registration.delete(id);
		return redirect(routes.Application.registrations());
	}

}

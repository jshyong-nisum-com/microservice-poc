package controllers.com.nisum.poc.play;

import java.util.Map;

import models.com.nisum.poc.play.Registration;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import servics.com.nisum.poc.play.RegistrationService;
import views.html.index;

public class RegistrationController extends Controller {

	static Form<Registration> registrationForm = Form.form(Registration.class);

	private static RegistrationService registrationService = new RegistrationService();
	
	public static Result index() {
		return redirect(routes.RegistrationController.registrations());
	}

	public static Result registrations() {
		return ok(index.render(registrationService.getRegistrations(), registrationForm));
	}

	public static Result updateRegistration(Long id) {
		return ok(index.render(registrationService.getRegistrations(), setupUpdateRegistrationForm(id)));
	}

	public static Result deleteRegistration(Long id) {
		registrationService.deleteRegistration(id);
		return redirect(routes.RegistrationController.registrations());
	}

	public static Result saveRegistration() {
		Form<Registration> filledForm = registrationForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(index.render(Registration.all(), filledForm));
		}

		registrationService.addOrUpdateRegistration(filledForm.get());
		return redirect(routes.RegistrationController.registrations());
	}

	private static Form<Registration> setupUpdateRegistrationForm(Long id) {
		Registration registration = registrationService.getRegistrationById(id);
		Form<Registration> editForm = registrationForm.bindFromRequest();
		editForm = editForm.fill(registration);
		
		Map<String, String> data = editForm.data();
		data.put("id", String.valueOf(registration.getId()));
		return editForm;
	}

}

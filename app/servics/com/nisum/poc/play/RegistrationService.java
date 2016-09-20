package servics.com.nisum.poc.play;

import java.util.List;

import models.com.nisum.poc.play.Registration;

public class RegistrationService {

	public List<Registration> getRegistrations() {
		return Registration.all();
	}
	
	public Registration getRegistrationById(Long id) {
		return Registration.byId(id);
	}
			
	public void deleteRegistration(Long id) {
		Registration.delete(id);
	}
	
	public void addOrUpdateRegistration(Registration registration) {
		Registration.save(registration);
	}
	
}

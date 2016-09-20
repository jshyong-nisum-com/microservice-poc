import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import java.util.ArrayList;

import org.junit.Test;

import models.com.nisum.poc.play.Registration;
import play.data.Form;
import play.mvc.Content;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a).isEqualTo(2);
    }

    @Test
    public void renderTemplate() {
//        Content html = views.html.index.render("Your new application is ready.");
    	Form<Registration> registrationForm = Form.form(Registration.class);
        Content html = views.html.index.render(new ArrayList<Registration>(), registrationForm);
        assertThat(contentType(html)).isEqualTo("text/html");
//        assertThat(contentAsString(html)).contains("Your new application is ready.");
    }

}

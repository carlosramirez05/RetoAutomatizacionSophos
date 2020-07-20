package pe.promart.www.questions;

import pe.promart.www.model.User;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;

/**
 *Esta clase valida que el usuario que se crea inicialmente con una petición POST
 * en Gorest API corresponda a los datos mandados desde gorest_api.feature
 */

public class CheckTheCorrectApiConsume implements Question<Boolean> {

    private User userExpected;
    private User userResult = Serenity.sessionVariableCalled("userResultApi");

    public CheckTheCorrectApiConsume(User userExpected) {
        this.userExpected = userExpected;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(userResult.getFirstName()).isEqualToIgnoringCase(userExpected.getFirstName()),
                Ensure.that(userResult.getLastName()).isEqualToIgnoringCase(userExpected.getLastName()),
                Ensure.that(userResult.getEmail()).isEqualToIgnoringCase(userExpected.getEmail()),
                Ensure.that(userResult.getGender()).isEqualToIgnoringCase(userExpected.getGender()),
                Ensure.that(userResult.getStatus()).isEqualToIgnoringCase(userExpected.getStatus())
        );
        return true;
    }

    public static CheckTheCorrectApiConsume theCorrectApiConsume(User userExpected) {
        return new CheckTheCorrectApiConsume(userExpected);
    }
}

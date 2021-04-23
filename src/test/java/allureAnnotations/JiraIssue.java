package allureAnnotations;

import io.qameta.allure.LabelAnnotation;

import java.lang.annotation.*;

/**
 * @author eroshenkoam (Artem Eroshenko).
 */

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@LabelAnnotation(name = "jiraIssue")
public @interface JiraIssue {

    String value();

}
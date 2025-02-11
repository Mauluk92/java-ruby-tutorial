package it.mauluk92.ruby.testutils.extension;

import it.mauluk92.ruby.testutils.RubyFacade;
import it.mauluk92.ruby.testutils.extension.annotation.ExecuteRubyProgram;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class RubyRunnerExtension implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(Integer.class) && parameterContext.isAnnotated(ExecuteRubyProgram.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        try {
            if (parameterContext.isAnnotated(ExecuteRubyProgram.class)) {
                ExecuteRubyProgram annotation = parameterContext.getParameter().getAnnotation(ExecuteRubyProgram.class);
                Resource resource = new ClassPathResource(annotation.sourcePath());
                String classPath = resource.getFile().getPath();
                return RubyFacade.interpret(classPath, annotation.file());
            }
        } catch (
                IOException e) {
            throw new ParameterResolutionException("Could not locate a path", e);
        }
        return -1;
    }
}

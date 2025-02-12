package it.mauluk92.ruby.c1;

import it.mauluk92.ruby.testutils.extension.RubyRunnerExtension;
import it.mauluk92.ruby.testutils.extension.annotation.ExecuteRubyProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Class containing tests about the lexical rules of Ruby programming
 * language
 */
@ExtendWith(RubyRunnerExtension.class)
public class LexicalStructureTest {

    /**
     * This test ensures that lines of comments
     * starting with # are ignored by Ruby execution
     */
    @Test
    @DisplayName("Inline comments are prefixed with # at the start")
    public void inlineComment(
            @ExecuteRubyProgram(file = "inline_comment.rb", sourcePath = "c1/lexical_structure")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * This test ensures embedded docs
     * starting with =begin  and ending with =end
     * are ignored by Ruby execution
     */
    @Test
    @DisplayName("Embedded document comments span multiple lines")
    public void embeddedDocumentComments(
            @ExecuteRubyProgram(file = "embedded_document.rb", sourcePath = "c1/lexical_structure")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * This test illustrates the use
     * of various literals (integer, floats...)
     */
    @Test
    @DisplayName("Literals can be used to put value directly in Ruby's code")
    public void literalSyntax(
            @ExecuteRubyProgram(file = "literal_syntax.rb", sourcePath = "c1/lexical_structure")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * An identifier is simply a name. Ruby uses identifiers to name
     * variables, methods, classes, and so forth. Ruby identifiers
     * consist of letters, numbers, and underscore characters, but
     * they may not begin with a number. An identifier may not include
     * whitespaces. Ruby is also case-sensitive.
     */
    @Test
    @DisplayName("General identifiers rules")
    public void identifiersRules(
            @ExecuteRubyProgram(file = "identifiers_rules.rb", sourcePath = "c1/lexical_structure")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputExecution);
    }

    /**
     * Punctuation in Ruby identifiers may be placed
     * at the start or at the end of an identifier.
     * Each punctuation carries a meaning
     */
    @Test
    @DisplayName("Punctuation is used to carry different meaning")
    public void punctuationLiteralSyntax(
            @ExecuteRubyProgram(file = "punctuation_literal_syntax.rb", sourcePath = "c1/lexical_structure")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputExecution);
    }
}

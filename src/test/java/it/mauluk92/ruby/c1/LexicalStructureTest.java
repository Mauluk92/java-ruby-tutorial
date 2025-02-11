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
            @ExecuteRubyProgram(file = "inline_comment.rb", sourcePath = "c1/ruby_comment")
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
            @ExecuteRubyProgram(file = "embedded_document.rb", sourcePath = "c1/ruby_comment")
            Integer outputExecution
    ){
        Assertions.assertEquals(0, outputExecution);
    }
}

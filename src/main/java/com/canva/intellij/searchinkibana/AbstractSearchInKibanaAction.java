package com.canva.intellij.searchinkibana;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import org.apache.commons.lang3.CharSequenceUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Pattern;

public abstract class AbstractSearchInKibanaAction extends AnAction {
  private final String baseUrl;

  public AbstractSearchInKibanaAction(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
    var query = new StringBuilder();

    var editor = e.getRequiredData(CommonDataKeys.EDITOR);

    // Extracting the name of the logger
    var documentText = editor.getDocument().getText();
    var prefix = "LoggerFactory.getLogger(";
    var index = documentText.indexOf(prefix);
    if (index > -1) {
      var loggerName = new StringBuilder();
      index += prefix.length();
      while (index < documentText.length()
          && documentText.charAt(index) != '.'
          && documentText.charAt(index) != ')') {
        loggerName.append(documentText.charAt(index));
        index++;
      }
      query.append(String.format("logger: \"%s\"", loggerName));
    }

    // Extracting the log message
    var selectedText = editor.getCaretModel().getCurrentCaret().getSelectedText();
    if (selectedText != null && !selectedText.isBlank()) {

      // Merge strings joined with " + "
      selectedText = selectedText.replaceAll("\"\\s+\\+\\s+\"", "");

      // Split string around {}
      // Filter out blank/empty strings
      // Sort by length in descending order
      // Limit to 2 search strings
      var queryStrings = Arrays.stream(selectedText.split("\\{}"))
          .map(String::trim)
          .filter(s -> !s.isEmpty())
          .sorted(Comparator.comparingInt(String::length).reversed())
          .limit(2)
          .toList();

      queryStrings.forEach( s -> {
        if (!query.isEmpty()) {
          query.append(" AND ");
        }
        query.append(String.format("log: \"%s\"", s));
      });
    }

    BrowserUtil.browse(String.format(baseUrl, query));
  }
}

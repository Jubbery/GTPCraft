import com.openai.api.Client;
import com.openai.api.GPT3;
import com.openai.api.GPT3.Completions;
import com.openai.api.GPT3.Completions.Completion;

public class GPT3 {
    private static final String API_KEY = "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";
    private static final GPT3 gpt3 = new GPT3(new Client(API_KEY));

    public static String generateText(String prompt) {
        Completions completions = gpt3.completions(
            GPT3.Completions.builder()
                .prompt(prompt)
                .maxTokens(2048)
                .build()
        );
        Completion completion = completions.getChoices().get(0);
        return completion.getText();
    }
}

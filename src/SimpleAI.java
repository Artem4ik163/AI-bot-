import java.util.Scanner;
import java.util.Random;

public class SimpleAI {
    // База знаний: вопросы и соответствующие ответы
    private static final String[][] KNOWLEDGE_BASE = {
            {"привет", "Привет! Как твои дела?"},
            {"как дела", "У меня все отлично! А у тебя?"},
            {"что ты умеешь", "Я могу отвечать на простые вопросы. Попробуй спросить что-нибудь!"},
            {"пока", "До свидания! Было приятно пообщаться."},
            {"как тебя зовут", "Я - простой чат-бот. У меня пока нет имени."}
    };

    // Ответы, если вопрос не распознан
    private static final String[] DEFAULT_RESPONSES = {
            "Интересный вопрос... Я не уверен, что понимаю его полностью.",
            "Моя база знаний пока ограничена, я не могу ответить на этот вопрос.",
            "Попробуй задать вопрос по-другому.",
            "Я еще учусь. Может, поговорим о чем-то другом?"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Привет! Я простой чат-бот. Задай мне вопрос или скажи 'пока' для выхода.");

        while (true) {
            System.out.print("Ты: ");
            String input = scanner.nextLine().toLowerCase();

            // Проверка на выход
            if (input.contains("пока")) {
                System.out.println("Бот: " + getResponse("пока"));
                break;
            }

            // Поиск подходящего ответа в базе знаний
            String response = null;
            for (String[] pair : KNOWLEDGE_BASE) {
                if (input.contains(pair[0])) {
                    response = pair[1];
                    break;
                }
            }

            // Если ответ не найден, используем случайный ответ по умолчанию
            if (response == null) {
                response = DEFAULT_RESPONSES[random.nextInt(DEFAULT_RESPONSES.length)];
            }

            System.out.println("Бот: " + response);
        }

        scanner.close();
    }

    // Метод для получения ответа по ключевому слову
    private static String getResponse(String keyword) {
        for (String[] pair : KNOWLEDGE_BASE) {
            if (keyword.equals(pair[0])) {
                return pair[1];
            }
        }
        return DEFAULT_RESPONSES[0];
    }
}

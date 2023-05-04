$(document).ready(function() {
    $('.ajax-link').on('click', function(event) {
        if ($(this).hasClass('no-ajax')) {
            return; // Якщо посилання має клас "no-ajax", не обробляти клік
        }

        event.preventDefault(); // Зупинити перехід по посиланню
        const url = $(this).attr('href'); // Отримати URL з атрибута href посилання

        // Завантажити контент з файлу .ftl та вставити його в блок #content
        $('#content').load(url, function(response, status, xhr) {
            if (status === "error") {
                $('#content').html("<p>Помилка завантаження контенту. Будь ласка, спробуйте пізніше.</p>");
            }
        });
    });
});
$(document).ready(function() {
    var maxQuestions = 10; // Максимальна кількість питань
    var questionNumber = $('input[name^="questions["]').length + 1; // Початковий номер питання
    var $questionsContainer = $('#questions-container'); // Контейнер для питань
    var $questionsData = $('#questions-data'); // Прихований input для зберігання питань у вигляді масиву

    function updateQuestionsData() {
        var questions = [];
        $('input[name^="questions["]').each(function() {
            questions.push($(this).val());
        });
        $questionsData.val(questions.join('\n'));

    }

    // Оновити прихований input з масивом питань при завантаженні сторінки
    updateQuestionsData();

    $('input[name^="questions["]').on('input', function() {
        updateQuestionsData();
    });

    $('#add-question').click(function(e) {
        e.preventDefault();

        // Перевірка, чи не досягнуто максимальну кількість питань
        if (questionNumber > maxQuestions) {
            return;
        }
        // Створення нового поля для питання
        var $questionField = $('<div class="question-field">' +
            '<label for="questions[' + (questionNumber - 1) + ']">Питання ' + questionNumber + ':</label>' +
            '<input type="text" id="questions[' + (questionNumber - 1) + ']" name="questions[' + (questionNumber - 1) + ']" required>' +
            '</div>');

        // Додавання поля для питання до контейнера
        $questionsContainer.append($questionField);

        // Збільшення номеру питання
        questionNumber++;

        // Оновити прихований input з масивом питань після додавання нового питання
        updateQuestionsData();

        // Відслідковування змін у новому полі питання
        $questionField.find('input').on('input', function() {
            updateQuestionsData();
        });
    });
});




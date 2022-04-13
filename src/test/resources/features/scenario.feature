#Gherkin
Feature: SkillFactory ui-tests on lms.skillfactory.ru
  # Позитивный сценарий: вводим название курса в поиске, получаем найденный курс
  Scenario: find course by typing course name in search field
    Given url of school 'https://lms.skillfactory.ru/'
    Then type course item 'Data science'
    And assert that first course is named 'DS Акселератор'
  # Негативный сценарий: вводим несуществующее название курса в поиске, получаем сообщение о ненайденных результатах
  Scenario: not found course by typing course name in search field
    Given url of school 'https://lms.skillfactory.ru/'
    Then type course item 'unknown'
    And assert that appears message 'Нет результатов для «unknown».'
  # Позитивный сценарий: применяем фильтр организации, получаем курсы по запрошенной органицзации
  Scenario: apply filters for searching course
    Given url of school 'https://lms.skillfactory.ru/courses'
    Then click filter 3
    And assert that course organization is 'Internetcollege'
  # Позитивный сценарий: нажимаем на ссылки и иконки в футере, получаем открытие нужных страниц
  Scenario: click urls and icons in footer
    Given url of school 'https://lms.skillfactory.ru/'
    Then click footer list items
    Then click icon items


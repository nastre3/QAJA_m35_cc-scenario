#Gherkin
Feature: SkillFactory ui-tests
  # Негативный сценарий: отправляется пустая форма регистрации
  Scenario: send empty registration form
    Given url of school 'https://lms.skillfactory.ru/register'
    Then fill registration form incorrectly with email '', fullName '', login '', password '', country ''
    Then click button create account
    And assert that empty error notifications appear
  # Негативный сценарий: отправляется некорректно заполненная форма регистрации
  Scenario: fill registration form incorrectly
    Given url of school 'https://lms.skillfactory.ru/register'
    Then fill registration form incorrectly with email 'n123123', fullName '', login 'test', password 'n123123', country ''
    Then click button create account
    And assert that wrong error notifications appear: wrong email 'n123123', wrong login 'test'
  # Негативный сценарий: отправляется пустая форма логина
  Scenario: send empty login form
    Given url of school 'https://lms.skillfactory.ru/login'
    Then fill login form incorrectly with email '', password ''
    Then click button login
    And assert that empty login error notifications appear 'Пожалуйста, заполните поле Электронная почта.'
  # Негативный сценарий: отправляется неверно заполненная форма логина
  Scenario: send wrong filled login form
    Given url of school 'https://lms.skillfactory.ru/login'
    Then fill login form incorrectly with email 'unknownemail10000@mail.com', password 'unknownemail10000'
    Then click button login
    And assert that empty login error notifications appear 'Неверный адрес электронной почты или пароль.'
  # Позитивный сценарий: заполняется корректно форма логина, получаем открытие дашборада
  Scenario: fill login form correctly
    Given url of school 'https://lms.skillfactory.ru/login'
    Then fill login form incorrectly with email 'user1648976275183@mail.ru', password 'password183'
    Then click button login
    And assert that correct login is shown 'login1648976275183'
  # Позитивный сценарий: функциональности в дашборде: кнопка "Посмотреть Курсы"
  Scenario: search courses button in dashboard
    Given url of school 'https://lms.skillfactory.ru/dashboard'
    Then click button search courses
    And assert that correct page is opened 'https://lms.skillfactory.ru/courses'
  # Негативный сценарий: функциональности в дашборде: "Поиск по вашим курсам"
  Scenario: search words in bought courses in dashboard
    Given url of school 'https://lms.skillfactory.ru/dashboard'
    Then fill search input 's'
    And assert that no results were found
  # Позитивный сценарий: изменение фото в профиле
  Scenario: change photo in profile
    Given url of school 'https://lms.skillfactory.ru/dashboard'
    Then click button Profile
    Then change photo
  # Позитивный сценарий: изменение основных настроек аккаунта
  Scenario: change main settings in profile
    Given url of school 'https://lms.skillfactory.ru/dashboard'
    Then open rightMenuPanel
    Then click accountSettings
    Then change full name 'user1648976275183'
    Then select country 'Азербайджан'
    Then change timezone 'America/Bahia (-03, UTC-0300)'
  # Позитивный сценарий: добавление дополнительных настроек аккаунта
  Scenario: change additional settings in profile
    Given url of school 'https://lms.skillfactory.ru/dashboard'
    Then open rightMenuPanel
    Then click accountSettings
    Then select education 'Бакалавриат'
    Then select gender 'Женский'
    Then select birthday '1992'
    Then select language 'Aragonese'
  # Позитивный сценарий: добавление ссылок социальных сетей в настройках аккаунта
  Scenario: add social links in profile
    Given url of school 'https://lms.skillfactory.ru/dashboard'
    Then open rightMenuPanel
    Then click accountSettings
    Then add twitter link 'https://www.twitter.com/test'
    Then add facebook link 'https://www.facebook.com/test'
    Then add linkedin link 'www.linkedin.com/in/test'
#Gherkin
Feature: Add pizza in shopping cart on site
  #Негативный сценарий ДЗ: выбираем недоступную зону для доставки
  Scenario: add unavailable delivery city
    Given url of restaurant 'https://dodopizza.ru/vladivostok/contacts'
    Then  add city 'Новый мир'
    And assert that appears notification text 'Найдено 0 пиццерий из 2'
  #Позитивный сценарий ДЗ: выбираем целую пиццу с добавкой, получаем добавление в корзину
  Scenario: add whole pizza item with supplement in shopping cart
    Given url of restaurant 'https://dodopizza.ru/vladivostok'
    Then  chose pizza item 'Овощи гриль'
    Then  chose pizza supplement
    Then  click add button in shopping cart
    Then click shopping cart button
    And assert cart has pizza_name 'Овощи гриль'

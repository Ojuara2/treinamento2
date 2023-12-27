Feature: Adicionar produto

  Scenario Outline: Adicionar mochila no carrinho
    Given que acesso a tela de login
    When preencho os campos "<usuario>" e "<senha>"
    And adiciono mochila
    Then devo ver a mochila no carrinho
    Examples:
      | usuario       | senha        |
      | standard_user | secret_sauce |
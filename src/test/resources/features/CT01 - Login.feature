Feature: Logar no site Swag Labs

  Scenario Outline: Login no site com usuario valido
    Given que acesso a tela de login
    When preencho os campos "<usuario>" e "<senha>"
    Then devo ver a tela de dashboard
    Examples:
      | usuario       | senha        |
      | standard_user | secret_sauce |
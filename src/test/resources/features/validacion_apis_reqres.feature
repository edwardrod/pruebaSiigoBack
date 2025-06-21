Feature: Verificación de servicios en ReqRes

  Scenario: Crear un nuevo usuario
    When el usuario envía una solicitud POST al endpoint "https://reqres.in/api/users"
      | name   | job       |
      | Pedro  | Tester    |
    Then la respuesta debería tener el código 201

  Scenario: Consultar información de un usuario
    When el usuario envía una solicitud GET al endpoint "https://reqres.in/api/users/2"
    Then la respuesta debería tener el código 200

  Scenario: Actualizar un usuario
    When el usuario envía una solicitud PUT al endpoint "https://reqres.in/api/users/2"
      | name   | job     |
      | Maria  | Manager |
    Then la respuesta debería tener el código 200

  Scenario: Eliminar un usuario
    When el usuario envía una solicitud DELETE al endpoint "https://reqres.in/api/users/2"
    Then la respuesta debería tener el código 204
